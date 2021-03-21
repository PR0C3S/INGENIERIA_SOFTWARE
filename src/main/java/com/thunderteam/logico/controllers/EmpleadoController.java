package com.thunderteam.logico.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.thunderteam.logico.entities.*;
import com.thunderteam.logico.repositorios.EmpleadoRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {
	
	@Autowired
	EmpleadoRepo empleadoRepo;

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

	@PostMapping("/empleado")
	public ResponseEntity postEmpleado(@RequestParam String email, @RequestParam String password,
									   @RequestParam Empleado.Tipo tipo, @RequestParam String nombre_Completo,
									   @RequestParam String telefono, @RequestParam String cedula,
									   @RequestParam String celular, @RequestParam Empleado.Sexo sexo,
									   @RequestParam Ubicacion ubicacion, @RequestParam CuentaBancaria cuentaBancaria

	){

		Empleado nuevoEmpleado = new Empleado();
		nuevoEmpleado.setEmail(email);
		nuevoEmpleado.setPassword(password);
		nuevoEmpleado.setTipo(tipo);
		nuevoEmpleado.setNombreCompleto(nombre_Completo);
		nuevoEmpleado.setTelefono(telefono);
		nuevoEmpleado.setCedula(cedula);
		nuevoEmpleado.setCelular(celular);
		nuevoEmpleado.setSexo(sexo);
		nuevoEmpleado.setUbicacion(ubicacion);
		nuevoEmpleado.setCuentaBancaria(cuentaBancaria);

		empleadoRepo.save(nuevoEmpleado);
		return  ResponseEntity.ok().body(nuevoEmpleado);

	}

	@PutMapping("/empleado")
	public ResponseEntity putEmpleado(@RequestParam int ID, @RequestParam String email, @RequestParam String password,
									  @RequestParam Empleado.Tipo tipo, @RequestParam String nombre_Completo,
									  @RequestParam String telefono, @RequestParam String cedula,
									  @RequestParam String celular, @RequestParam Empleado.Sexo sexo,
									  @RequestParam Ubicacion ubicacion, @RequestParam CuentaBancaria cuentaBancaria

	){
		Map<String, String> response = new HashMap<>();
		Optional<Empleado> empleado = empleadoRepo.findById(ID);

		if (empleado.isEmpty()){
			response.put("found", "false");
			response.put("message", "empleado no encontrado");
			return ResponseEntity.badRequest().body(response);
		}

		Empleado oldEmpleado = new Empleado();
		oldEmpleado.setEmail(email);
		oldEmpleado.setID_Empleado(ID);
		oldEmpleado.setFecha_Creacion(empleado.get().getFecha_Creacion());
		oldEmpleado.setPassword(password);
		oldEmpleado.setTipo(tipo);
		oldEmpleado.setNombreCompleto(nombre_Completo);
		oldEmpleado.setTelefono(telefono);
		oldEmpleado.setCedula(cedula);
		oldEmpleado.setCelular(celular);
		oldEmpleado.setSexo(sexo);
		oldEmpleado.setUbicacion(ubicacion);
		oldEmpleado.setCuentaBancaria(cuentaBancaria);

		empleadoRepo.save(oldEmpleado);
		return  ResponseEntity.ok().body(oldEmpleado);
	}

	@DeleteMapping("/empleado")
	public ResponseEntity deleteEmpleado(@RequestParam int ID) {

		Map<String, String> response = new HashMap<>();
		Optional<Empleado> empleado = empleadoRepo.findById(ID);

		if (empleado.isEmpty()) {
			response.put("deleted", "false");
			response.put("message", "empleado no encontrada");
			return ResponseEntity.badRequest().body(response);
		} else {
			empleadoRepo.delete(empleado.get());
			response.put("deleted", "true");
			response.put("message", "empleado " + ID + " eliminado");
			return ResponseEntity.ok().body(response);
		}
	}

}
