package com.thunderteam.logico.controllers;
import java.util.*;

import javax.persistence.EntityNotFoundException;

import com.thunderteam.logico.entities.*;
import com.thunderteam.logico.repositorios.ClienteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
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

	/*public ResponseEntity<Persona> save(@RequestBody Persona persona) {
		Persona obj = personaServiceAPI.save(persona);
		return new ResponseEntity<Persona>(obj, HttpStatus.OK);
	}

	public ResponseEntity postCliente(@RequestParam(value = "nombreCompleto", required = false, defaultValue = "defaultNombreCompleto") String nombreCompleto,
									   @RequestParam(value = "cedula", required = false, defaultValue = "defaultCedula") String cedula,
									   @RequestParam(value = "email", required = false, defaultValue = "defaultEmail") String email,
									   @RequestParam(value = "fecha_Nacimiento", required = false, defaultValue = "defaultFecha_Nacimiento") String fecha_Nacimiento,
									   @RequestParam(value = "sexo", required = false) String sexo,
									   @RequestParam(value = "celular", required = false, defaultValue = "defaultCelular") String celular,
									   @RequestParam(value = "telefono", required = false, defaultValue = "defaultTelefono") String telefono)
	{
		Date date1= null;
		try {
			date1 = new SimpleDateFormat("dd/MM/yyyy").parse(fecha_Nacimiento);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Cliente nuevoCliente = new Cliente();
		nuevoCliente.setFecha_Nacimiento(date1);
		nuevoCliente.setEmail(email);
		nuevoCliente.setNombreCompleto(nombreCompleto);
		nuevoCliente.setTelefono(telefono);
		nuevoCliente.setCedula(cedula);
		nuevoCliente.setCelular(celular);
		nuevoCliente.setSexo(EnumSexo.valueOf(sexo));
		//nuevoCliente.setUbicacion(ubicacion);

		clienteRepo.save(nuevoCliente);
		return  ResponseEntity.ok().body(nuevoCliente);
	}*/
	
	/*
	 * @PutMapping("/edit") public ResponseEntity putCliente(@RequestParam int ID,
	 * 
	 * @RequestParam String nombre_Completo,
	 * 
	 * @RequestParam String cedula,
	 * 
	 * @RequestParam String email,
	 * 
	 * @RequestParam String fecha_Nacimiento,
	 * 
	 * @RequestParam String sexo,
	 * 
	 * @RequestParam String celular,
	 * 
	 * @RequestParam String telefono ) { Map<String, String> response = new
	 * HashMap<>(); Optional<Cliente> cliente = clienteRepo.findById(ID);
	 * 
	 * if (!cliente.isPresent()){ response.put("found", "false");
	 * response.put("message", "Cliente no encontrado"); return
	 * ResponseEntity.badRequest().body(response); }
	 * 
	 * Date date1= null; try { date1 = new
	 * SimpleDateFormat("dd/MM/yyyy").parse(fecha_Nacimiento); } catch
	 * (ParseException e) { e.printStackTrace(); }
	 * 
	 * Cliente oldCliente = new Cliente(); oldCliente.setEmail(email);
	 * oldCliente.setID_Cliente(ID); oldCliente.setFecha_Nacimiento(date1);
	 * oldCliente.setNombreCompleto(nombre_Completo);
	 * oldCliente.setTelefono(telefono); oldCliente.setCedula(cedula);
	 * oldCliente.setCelular(celular); oldCliente.setSexo(EnumSexo.valueOf(sexo));
	 * //oldCliente.setUbicacion(ubicacion);
	 * 
	 * clienteRepo.save(oldCliente); return ResponseEntity.ok().body(oldCliente); }
	 */
	
	@PutMapping(path="/edit")
	public ResponseEntity<Cliente> updateCliente(@Validated @RequestBody Cliente cliente) throws EntityNotFoundException {
		System.out.println(cliente.getID_Cliente());
		Cliente clienteDB = clienteRepo.findById(cliente.getID_Cliente()).orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado para este id :: " + cliente.getID_Cliente()));
		//Cliente clienteDB = clienteRepo.findById(cliente.getID_Cliente()).get();
		//Cliente clienteDB = clienteRepo.findById(cliente.getID_Cliente()).orElse(new Cliente());
		clienteDB.setNombreCompleto(cliente.getNombreCompleto());
		clienteDB.setTelefono(cliente.getTelefono());
		clienteDB.setEmail(cliente.getEmail());
		clienteDB.setCelular(cliente.getCelular());
		clienteDB.setCedula(cliente.getCedula());
		clienteDB.setSexo(cliente.getSexo());
		clienteDB.setFecha_Nacimiento(cliente.getFecha_Nacimiento());
		
		final Cliente updatedCliente = clienteRepo.save(cliente);
		return ResponseEntity.ok(updatedCliente);
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
