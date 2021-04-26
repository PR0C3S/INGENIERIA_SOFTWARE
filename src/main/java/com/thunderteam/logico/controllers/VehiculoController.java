package com.thunderteam.logico.controllers;

import java.io.IOException;
import java.util.*;

import com.thunderteam.logico.entities.*;
import com.thunderteam.logico.repositorios.MarcaVehiculoRepo;
import com.thunderteam.logico.repositorios.ModeloVehiculoRepo;
import com.thunderteam.logico.repositorios.VehiculoRepo;

import com.thunderteam.logico.services.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {
	
	@Autowired
	VehiculoService vehiculoService;
	
	@Autowired
	ModeloVehiculoRepo modeloVehiculoRepo;
	

	@GetMapping("/")
	public List<Vehiculo> getAll(){
		return vehiculoService.getAll();
	}

	@GetMapping("/marca{marca}")
	public List<Vehiculo> getAllByMarca(@PathVariable String marca){
		return vehiculoService.getAllByMarca(marca);
	}

	@GetMapping("/modelo{modelo}")
	public List<Vehiculo> getAllByModelo(@PathVariable String modelo){
		return vehiculoService.getAllByModelo(modelo);
	}

	@GetMapping("/year{year}")
	public List<Vehiculo> getAllByYear(@PathVariable int year){
		return vehiculoService.getAllByYear(year);
	}

	@GetMapping("/id")
	public Vehiculo getVehiculo(@RequestParam int id){
		return vehiculoService.getVehiculo(id);
	}
	
	/*
	 * @GetMapping("/vehiculo/{tipo}") public List<Vehiculo> getAllByTipo(String
	 * tipo){ return vehiculoService.getAllByTipo(tipo); }
	 */

	@GetMapping("/count")
	public Long countVehiculos(){
		return vehiculoService.countVehiculosDisponibles();
	}

	
	 @PostMapping(value = "/save", consumes={"application/json;charset=utf-8"}) //MediaType.MULTIPART_FORM_DATA_VALUE   o   {"multipart/mixed"} , consumes = { "multipart/form-data" }
	 public ResponseEntity<Vehiculo> postVehiculo(@RequestBody VehiculoSaveBody json) throws IOException{ 
		 	Vehiculo vehiculo = json.getVehiculo(); 
		 	Version_Vehiculo version = json.getVersion();
		 	System.out.printf(version.getNombreVersion());
		 	System.out.printf("%d", vehiculo.getPrecio());
		 	
		 	//String modelo = json.getModelo();
		 	//MultipartFile file = json.getFile();
		 	//System.out.printf(file.getResource().getFilename()); 
		 	return vehiculoService.postVehiculo(vehiculo, version);
	 }
	 
	
	/*
	 * @RequestMapping(value = "/save", method = RequestMethod.POST, consumes =
	 * {"multipart/form-data"}) public ResponseEntity<Vehiculo>
	 * postVehiculo(@RequestBody VehiculoSaveBody json){ Vehiculo vehiculo =
	 * json.getVehiculo(); Version_Vehiculo version = json.getVersion();
	 * Optional<Modelo_Vehiculo> modelo=
	 * modeloVehiculoRepo.findByNombreModelo(json.getModelo());
	 * 
	 * MultipartFile file = json.getFile(); return
	 * vehiculoServicePrueba.postVehiculo(file, vehiculo, version, modelo); }
	 */
	
	@ModelAttribute("cmd")
	public VehiculoSaveBody getWrapper() {
	  return new VehiculoSaveBody();
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Vehiculo> deleteVehiculo(@RequestParam int ID){
		return vehiculoService.deleteVehiculo(ID);
	}
	
	//put
}
