package com.thunderteam.logico.controllers;

import java.util.Arrays;
import java.util.List;
import com.thunderteam.logico.entities.*;
import com.thunderteam.logico.repositorios.EmpleadoRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpleadoController {
	
	@Autowired
	EmpleadoRepo repo;
	
	@RequestMapping("/empleados")
	public List<Empleado> getAllEmpleados() {
		List<Empleado> lstEmpleados = Arrays.asList(
				new Empleado()
				);
		
		return lstEmpleados;
	}
	
	@RequestMapping("/addEmpleado")
	public String addEmpleado(Empleado empleado){
		repo.save(empleado);
		return "home.jsp";
	}
}
