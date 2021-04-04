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
@CrossOrigin(origins = "http://localhost:8080")
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
	public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) {
		Cliente obj = clienteRepo.save(cliente);
		return new ResponseEntity<Cliente>(obj, HttpStatus.OK);
	}

	/* @PostMapping(value = "/save")
	public ResponseEntity<Cliente> save(@RequestBody Cliente cliente){
		Cliente obj = clienteRepo.save(cliente);
		return new ResponseEntity<Cliente>(obj, HttpStatus.OK);
	} */


	@PutMapping("/edit")


	public ResponseEntity putCliente(  @RequestParam int ID, @RequestBody Cliente clienteV)
	{
		Map<String, String> response = new HashMap<>();
		//Optional<Cliente> cliente = clienteRepo.findById(ClieteID);

		if (clienteV == null){
			response.put("found", "false");
			response.put("message", "Cliente no encontrado");
			return ResponseEntity.badRequest().body(response);
		}

		clienteRepo.save(clienteV);
		return  ResponseEntity.ok().body(clienteV);
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
