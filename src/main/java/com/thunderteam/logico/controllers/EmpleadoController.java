package com.thunderteam.logico.controllers;

import java.util.Optional;

import com.thunderteam.logico.entities.*;
import com.thunderteam.logico.repositorios.EmpleadoRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpleadoController {
	
	@Autowired
	EmpleadoRepo repo;
	
	@RequestMapping("/empleados")
	public Iterable<Empleado> getAllEmpleados() {
/*		List<Empleado> lstEmpleados = Arrays.asList(
				new Empleado()
				);*/
		return repo.findAll();
	}
	
	@RequestMapping("/empleados/{id}")
	public Optional<Empleado> getEmpleado(@PathVariable int id){
		return repo.findById(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/empleados")
	public void addEmpleado(@RequestBody Empleado empleado){
		repo.save(empleado);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/empleados/{id}")
	public void updateEmpleado(@RequestBody Empleado empleado, @PathVariable int id){
		repo.save(empleado); //fix this
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/empleados/{id}")
	public void deleteEmpleado(@PathVariable int id){
		repo.deleteById(id); //hay un delete por id y otro por objeto
	}
	
}
