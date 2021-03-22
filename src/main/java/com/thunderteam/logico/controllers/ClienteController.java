package com.thunderteam.logico.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.thunderteam.logico.entities.*;
import com.thunderteam.logico.repositorios.ClienteRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	ClienteRepo clienteRepo;

	@GetMapping("/")
	public List<Cliente> getAllClientes(){return (List<Cliente>) clienteRepo.findAll();}

	@GetMapping("/nombre")
	public List<Cliente> getClienteLikeName(@RequestParam String nombre){
		return (List<Cliente>) clienteRepo.findByNombreCompletoContains(nombre);
	}

	@GetMapping("/cliente")
	public Optional<Cliente> getCliente(@RequestParam int ID){
		return clienteRepo.findById(ID);
	}

	@PostMapping("/cliente")
	public ResponseEntity postCliente(@RequestParam String email,
									   @RequestParam String nombre_Completo,
									  @RequestParam String fecha_Nacimiento,
									   @RequestParam String telefono, @RequestParam String cedula,
									   @RequestParam String celular, @RequestParam String sexo

	){


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
		nuevoCliente.setSexo(Cliente.Sexo.valueOf(sexo));
		//nuevoCliente.setUbicacion(ubicacion);


		clienteRepo.save(nuevoCliente);
		return  ResponseEntity.ok().body(nuevoCliente);

	}

	@PutMapping("/cliente")
	public ResponseEntity putCliente(@RequestParam String email, @RequestParam int ID,
									  @RequestParam String nombre_Completo,
									  @RequestParam String fecha_Nacimiento,
									  @RequestParam String telefono, @RequestParam String cedula,
									  @RequestParam String celular, @RequestParam String sexo


	){
		Map<String, String> response = new HashMap<>();
		Optional<Cliente> cliente = clienteRepo.findById(ID);

		if (cliente.isEmpty()){
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
		oldCliente.setSexo(Cliente.Sexo.valueOf(sexo));
		//oldCliente.setUbicacion(ubicacion);

		clienteRepo.save(oldCliente);
		return  ResponseEntity.ok().body(oldCliente);
	}

	@DeleteMapping("/cliente")
	public ResponseEntity deleteCliente(@RequestParam int ID) {

		Map<String, String> response = new HashMap<>();
		Optional<Cliente> cliente = clienteRepo.findById(ID);

		if (cliente.isEmpty()) {
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
