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

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {
	
	@Autowired
	EmpleadoRepo empleadoRepo;
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


	@GetMapping("/count")
	public Long countEmpleadosActivos(){
		return empleadoRepo.countByEstado(EnumEstadoEmpleado.Activado);
	}


	@PostMapping(value ="/save", consumes={"application/json;charset=utf-8"})
	public ResponseEntity<Empleado> save(@RequestBody EmpleadoSaveBody json) {
		Empleado persona = json.getEmpleado();
		Ubicacion location = json.getUbicacion();
		String nSector = json.getSector();

		Sector sector = sectorRepo.findById(nSector).orElseThrow(() -> new EntityNotFoundException("sector no encontrado para este id:: " + nSector));
		location.setSector(sector);
		location.setEmpleado(persona);
		persona.setUbicacion(location);
		ubicacionRepo.save(location);
		Empleado obj = empleadoRepo.save(persona);
		return new ResponseEntity<Empleado>(obj, HttpStatus.OK);
	}


	@PutMapping(value="/edit", consumes={"application/json;charset=utf-8"})
	public ResponseEntity<Empleado> updatedEmpleado(@RequestBody EmpleadoSaveBody json){
		Empleado persona = json.getEmpleado();
		Ubicacion location= json.getUbicacion();
		String nSector = json.getSector();
		System.out.printf("%d",persona.getID_Empleado());
		Empleado empleadoDB = empleadoRepo.findById(persona.getID_Empleado()).orElseThrow(() -> new EntityNotFoundException("Empleado no encontrado para este id :: " + persona.getID_Empleado()));
		empleadoDB.setNombreCompleto(persona.getNombreCompleto());
		empleadoDB.setTelefono(persona.getTelefono());
		empleadoDB.setEmail(persona.getEmail());
		empleadoDB.setCelular(persona.getCelular());
		empleadoDB.setCedula(persona.getCedula());
		empleadoDB.setSexo(persona.getSexo());
		empleadoDB.setPassword(persona.getPassword());
		empleadoDB.setEstado(persona.getEstado());
		empleadoDB.setTipo(persona.getTipo());

		Ubicacion ubicacionDB = ubicacionRepo.findById(empleadoDB.getUbicacion().getID_Ubicacion()).orElseThrow(() -> new EntityNotFoundException("Ubicacion no encontrada"));
		ubicacionDB.setCalle(location.getCalle());
		ubicacionDB.setCasa(location.getCasa());
		Sector sector = sectorRepo.findById(nSector).orElseThrow(() -> new EntityNotFoundException("sector no encontrado para este id:: " + nSector));
		ubicacionDB.setSector(sector);
		empleadoDB.setUbicacion(ubicacionDB);

		final Empleado updatedEmpleado = empleadoRepo.save(empleadoDB);
		return ResponseEntity.ok(updatedEmpleado);
	}

	@DeleteMapping("/delete")
	public ResponseEntity deleteEmpleado(@RequestParam int ID) {
		System.out.println(ID);
		Map<String, String> response = new HashMap<>();
		Optional<Empleado> empleado = empleadoRepo.findById(ID);

		if (!empleado.isPresent()) {
			response.put("deleted", "false");
			response.put("message", "Empleado no encontrada");
			return ResponseEntity.badRequest().body(response);
		} else {
			empleadoRepo.delete(empleado.get());
			response.put("deleted", "true");
			response.put("message", "Empleado " + ID + " eliminado");
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
