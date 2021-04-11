package com.thunderteam.logico.controllers;

import java.util.*;

import com.thunderteam.logico.entities.*;
import com.thunderteam.logico.repositorios.MarcaVehiculoRepo;
import com.thunderteam.logico.repositorios.VehiculoRepo;

import com.thunderteam.logico.services.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {
	
	@Autowired
	VehiculoService vehiculoService;

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

	@GetMapping("/vehiculo{id}")
	public Vehiculo getVehiculo(@PathVariable int id){
		return vehiculoService.getVehiculo(id);
	}

	@GetMapping("/count")
	public Long countVehiculos(){
		return vehiculoService.countVehiculosDisponibles();
	}

	@PostMapping("/vehiculo")
	public ResponseEntity<Vehiculo> postVehiculo(@RequestBody Vehiculo vehiculo){
		return vehiculoService.postVehiculo(vehiculo);
	}

	@DeleteMapping("/vehiculo")
	public ResponseEntity<Vehiculo> deleteVehiculo(@RequestParam int ID){
		return vehiculoService.deleteVehiculo(ID);
	}
}
