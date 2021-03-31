package com.thunderteam.logico.controllers;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.thunderteam.logico.entities.*;
import com.thunderteam.logico.repositorios.ClienteRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	ClienteRepo clienteRepo;

	@GetMapping("/")
	public List<Cliente> getAllClientes(){
		return clienteRepo.findAll();
	} 

	/* @GetMapping("/")
	public String getAllClientes(Model model){
		model.addAttribute("listaEmpleados", clienteRepo.findAll());
		return "Cliente";
	} */

	@GetMapping("/nombre")
	public List<Cliente> getClienteLikeName(@RequestParam String nombre){
		return clienteRepo.findByNombreCompletoContains(nombre);
	}

	@GetMapping("/id")
	public Optional<Cliente> getCliente(@RequestParam int ID){
		return clienteRepo.findById(ID);
	}


	@PostMapping("/save")
	public ResponseEntity postCliente(@RequestParam String email,
									   @RequestParam String nombre_Completo,
									  @RequestParam String fecha_Nacimiento,
									   @RequestParam String telefono, @RequestParam String cedula,
									   @RequestParam String celular, @RequestParam String sexo){

		Date date1= null;
		try {
			date1 = new SimpleDateFormat("dd/MM/yyyy").parse(fecha_Nacimiento);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Cliente nuevoCliente = new Cliente();
		nuevoCliente.setFecha_Nacimiento(date1);
		nuevoCliente.setEmail(email);
		nuevoCliente.setNombreCompleto(nombre_Completo);
		nuevoCliente.setTelefono(telefono);
		nuevoCliente.setCedula(cedula);
		nuevoCliente.setCelular(celular);
		nuevoCliente.setSexo(EnumSexo.valueOf(sexo));
		//nuevoCliente.setUbicacion(ubicacion);


		clienteRepo.save(nuevoCliente);
		return  ResponseEntity.ok().body(nuevoCliente);
	}

	/* @PostMapping(value = "/save")
	public ResponseEntity<Cliente> save(@RequestBody Cliente cliente){
		Cliente obj = clienteRepo.save(cliente);
		return new ResponseEntity<Cliente>(obj, HttpStatus.OK);
	} */


	@PutMapping("/edit")
	public ResponseEntity putCliente(@RequestParam String email, @RequestParam int ID,
									  @RequestParam String nombre_Completo,
									  @RequestParam String fecha_Nacimiento,
									  @RequestParam String telefono, @RequestParam String cedula,
									  @RequestParam String celular, @RequestParam String sexo


	){
		Map<String, String> response = new HashMap<>();
		Optional<Cliente> cliente = clienteRepo.findById(ID);

		if (!cliente.isPresent()){
			response.put("found", "false");
			response.put("message", "Cliente no encontrado");
			return ResponseEntity.badRequest().body(response);
		}

		Date date1= null;
		try {
			date1 = new SimpleDateFormat("dd/MM/yyyy").parse(fecha_Nacimiento);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Cliente oldCliente = new Cliente();
		oldCliente.setEmail(email);
		oldCliente.setID_Cliente(ID);
		oldCliente.setFecha_Nacimiento(date1);
		oldCliente.setNombreCompleto(nombre_Completo);
		oldCliente.setTelefono(telefono);
		oldCliente.setCedula(cedula);
		oldCliente.setCelular(celular);
		oldCliente.setSexo(EnumSexo.valueOf(sexo));
		//oldCliente.setUbicacion(ubicacion);

		clienteRepo.save(oldCliente);
		return  ResponseEntity.ok().body(oldCliente);
	}

	@DeleteMapping("/delete")
	public ResponseEntity deleteCliente(@RequestParam int ID) {

		Map<String, String> response = new HashMap<>();
		Optional<Cliente> cliente = clienteRepo.findById(ID);

		if (!cliente.isPresent()) {
			response.put("deleted", "false");
			response.put("message", "Cliente no encontrada");
			return ResponseEntity.badRequest().body(response);
		} else {
			clienteRepo.delete(cliente.get());
			response.put("deleted", "true");
			response.put("message", "Cliente " + ID + " eliminado");
			return ResponseEntity.ok().body(response);
		}
	}
	
}
