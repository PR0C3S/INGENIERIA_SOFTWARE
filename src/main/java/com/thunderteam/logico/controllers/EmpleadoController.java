package com.thunderteam.logico.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.thunderteam.logico.entities.*;
import com.thunderteam.logico.repositorios.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {
	
	@Autowired
	EmpleadoRepo empleadoRepo;
	@Autowired
	ProvinciaRepo provinciaRepo;
	@Autowired
	MunicipioRepo municipioRepo;
	@Autowired
	SectorRepo sectorRepo;
	@Autowired
	UbicacionRepo ubicacionRepo;

	@GetMapping("/")
	public List<Empleado> getAllEmpleados(){return (List<Empleado>) empleadoRepo.findAll();}

	@GetMapping("/nombre")
	public List<Empleado> getEmpleadoLikeName(@RequestParam String nombre){
		return (List<Empleado>) empleadoRepo.findByNombreCompletoContains(nombre);
	}

	@GetMapping("/empleado")
	public Optional<Empleado> getEmpleado(@RequestParam int ID){
		return empleadoRepo.findById(ID);
	}

	/*@PostMapping("/empleado")
	public ResponseEntity postEmpleado(@RequestParam String email, @RequestParam String password,
									   @RequestParam String tipo, @RequestParam String nombre_Completo,
									   @RequestParam String telefono, @RequestParam String cedula,
									   @RequestParam String celular, @RequestParam String sexo,
									   @RequestParam String calle, @RequestParam String casa,
									   @RequestParam String sector,@RequestParam String municipio,
									   @RequestParam String provincia, @RequestParam String apartamento,
									   @RequestParam String activo

	){


		Municipio newMunicipio = municipioRepo.findByNombre(municipio);
		System.out.println(newMunicipio.getNombre());
		Optional<Sector> newSector = sectorRepo.findByNombre(sector);
		Ubicacion ubicacion = new Ubicacion();



		if(newSector.isPresent()){
			ubicacion.setApartamento(apartamento);
			ubicacion.setCasa(casa);
			ubicacion.setSector(newSector.get());
			ubicacion.setCalle(calle);
		}else{
			Sector newSector1 = new Sector(sector, newMunicipio);
			sectorRepo.save(newSector1);
			ubicacion.setApartamento(apartamento);
			ubicacion.setCasa(casa);
			ubicacion.setSector(newSector1);
			ubicacion.setCalle(calle);
		}
		ubicacionRepo.save(ubicacion);




		Empleado nuevoEmpleado = new Empleado();
		nuevoEmpleado.setEmail(email);
		nuevoEmpleado.setPassword(password);
		nuevoEmpleado.setTipo(EnumTipoEmpleado.valueOf(tipo));
		nuevoEmpleado.setNombreCompleto(nombre_Completo);
		nuevoEmpleado.setTelefono(telefono);
		nuevoEmpleado.setCedula(cedula);
		nuevoEmpleado.setCelular(celular);
		nuevoEmpleado.setSexo(EnumSexo.valueOf(sexo));
		nuevoEmpleado.setActivo(EnumSiNo.valueOf(activo));
		nuevoEmpleado.setUbicacion(ubicacion);

		empleadoRepo.save(nuevoEmpleado);
		return  ResponseEntity.ok().body(nuevoEmpleado);

	}*/

	@PostMapping("/save")
	public ResponseEntity<Empleado> save(@RequestBody Empleado empleado) {
		Empleado obj = empleadoRepo.save(empleado);
		return new ResponseEntity<Empleado>(obj, HttpStatus.OK);
	}

	@PutMapping("/empleado")
	public ResponseEntity putEmpleado(@RequestParam int ID, @RequestParam String email, @RequestParam String password,
									  @RequestParam String tipo, @RequestParam String nombre_Completo,
									  @RequestParam String telefono, @RequestParam String cedula,
									  @RequestParam String celular, @RequestParam String sexo,
									  @RequestParam String calle, @RequestParam String casa,
									  @RequestParam String sector,@RequestParam String municipio,
									  @RequestParam String provincia, @RequestParam String apartamento,
									  @RequestParam String activo

	){
		Map<String, String> response = new HashMap<>();
		Optional<Empleado> empleado = empleadoRepo.findById(ID);

		if (!empleado.isPresent()){
			response.put("found", "false");
			response.put("message", "empleado no encontrado");
			return ResponseEntity.badRequest().body(response);
		}

		sector = sector.toLowerCase();
		Municipio newMunicipio = municipioRepo.findByNombre(municipio);
		Optional<Sector> newSector = sectorRepo.findByNombre(sector);
		Ubicacion ubicacion = new Ubicacion();



		if(newSector.isPresent()){
			ubicacion.setApartamento(apartamento);
			ubicacion.setCasa(casa);
			ubicacion.setSector(newSector.get());
			ubicacion.setCalle(calle);
		}else{
			Sector newSector1 = new Sector(sector, newMunicipio);
			sectorRepo.save(newSector1);
			ubicacion.setApartamento(apartamento);
			ubicacion.setCasa(casa);
			ubicacion.setSector(newSector1);
			ubicacion.setCalle(calle);
		}
		ubicacionRepo.save(ubicacion);


		Empleado oldEmpleado = new Empleado();
		oldEmpleado.setEmail(email);
		oldEmpleado.setPassword(password);
		oldEmpleado.setTipo(EnumTipoEmpleado.valueOf(tipo));
		oldEmpleado.setNombreCompleto(nombre_Completo);
		oldEmpleado.setTelefono(telefono);
		oldEmpleado.setCedula(cedula);
		oldEmpleado.setCelular(celular);
		oldEmpleado.setSexo(EnumSexo.valueOf(sexo));
		oldEmpleado.setEstado(EnumEstadoEmpleado.valueOf(activo));
		oldEmpleado.setUbicacion(ubicacion);
		oldEmpleado.setID_Empleado(ID);

		empleadoRepo.save(oldEmpleado);
		return  ResponseEntity.ok().body(oldEmpleado);
	}

	@DeleteMapping("/empleado")
	public ResponseEntity deleteEmpleado(@RequestParam int ID) {

		Map<String, String> response = new HashMap<>();
		Optional<Empleado> empleado = empleadoRepo.findById(ID);



		if (!empleado.isPresent()) {
			response.put("deleted", "false");
			response.put("message", "empleado no encontrada");
			return ResponseEntity.badRequest().body(response);
		} else {

			empleadoRepo.delete(empleado.get());
			response.put("deleted", "true");
			response.put("message", "empleado " + ID + " eliminado");
			ubicacionRepo.delete(empleado.get().getUbicacion());
			return ResponseEntity.ok().body(response);
		}
	}

	@GetMapping("/login")
	public ResponseEntity authentication(@RequestParam String email,@RequestParam String password){
		Map<String, String> response = new HashMap<>();
		Optional<Empleado> empleado = empleadoRepo.findByEmail(email);

		if(!empleado.isPresent()){
			response.put("found", "false");
			response.put("authenticated","false");
			response.put("message", "usuario no encontrado");
			return ResponseEntity.ok().body(response);
		}else{
			String userPassword = empleado.get().getPassword();
			response.put("found", "true");
			if(password.equals(userPassword)){
				response.put("authenticated","true");
				response.put("message", "login correcto");
				return ResponseEntity.ok().body(response);
			}
			response.put("authenticated","false");
			response.put("message", "password incorrecto");
			return ResponseEntity.ok().body(response);
		}

	}

}
