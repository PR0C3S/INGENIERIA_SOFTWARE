package com.thunderteam.logico.controllers;
import java.util.*;
import javax.persistence.EntityNotFoundException;
import com.thunderteam.logico.entities.*;
import com.thunderteam.logico.repositorios.ClienteRepo;
import com.thunderteam.logico.repositorios.SectorRepo;
import com.thunderteam.logico.repositorios.UbicacionRepo;
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
	
	@Autowired
	UbicacionRepo ubicacionRepo;
	
	@Autowired
	SectorRepo sectorRepo;

	@GetMapping("/")
	public List<Cliente> getAllClientes(){
		return clienteRepo.findAll();
	} 

	@GetMapping("/nombre")
	public List<Cliente> getClienteLikeName(@RequestParam String nombre){
		return clienteRepo.findByNombreCompletoContains(nombre);
	}

	@GetMapping("/id")
	public Optional<Cliente> getCliente(@RequestParam int ID){
		return clienteRepo.findById(ID);
	}


	@PostMapping(value ="/save", consumes={"application/json;charset=utf-8"})
	public ResponseEntity<Cliente> save(@RequestBody ClienteSaveBody json) {
		Cliente persona = json.getCliente();
		Ubicacion location = json.getUbicacion();
		String nSector = json.getSector();
		
		Sector sector = sectorRepo.findById(nSector).orElseThrow(() -> new EntityNotFoundException("sector no encontrado para este id:: " + nSector));
		location.setSector(sector);
		location.setCliente(persona);
		persona.setUbicacion(location);
		//ubicacionRepo.save(location);
		Cliente obj = clienteRepo.save(persona);
		return new ResponseEntity<Cliente>(obj, HttpStatus.OK);
	}

	/*public ResponseEntity<Persona> save(@RequestBody Persona persona) {
		Persona obj = personaServiceAPI.save(persona);
		return new ResponseEntity<Persona>(obj, HttpStatus.OK);
	}

	
	}*/
	
	
	@PutMapping(value="/edit", consumes={"application/json;charset=utf-8"})
	public ResponseEntity<Cliente> updateCliente(@RequestBody ClienteSaveBody json){
		Cliente persona = json.getCliente();
		Ubicacion location= json.getUbicacion();
		String nSector = json.getSector();
		System.out.printf("%d",persona.getID_Cliente());
		Cliente clienteDB = clienteRepo.findById(persona.getID_Cliente()).orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado para este id :: " + persona.getID_Cliente()));
		clienteDB.setNombreCompleto(persona.getNombreCompleto());
		clienteDB.setTelefono(persona.getTelefono());
		clienteDB.setEmail(persona.getEmail());
		clienteDB.setCelular(persona.getCelular());
		clienteDB.setCedula(persona.getCedula());
		clienteDB.setSexo(persona.getSexo());
		clienteDB.setFecha_Nacimiento(persona.getFecha_Nacimiento());
		
		Ubicacion ubicacionDB = ubicacionRepo.findById(clienteDB.getUbicacion().getID_Ubicacion()).orElseThrow(() -> new EntityNotFoundException("Ubicacion no encontrada"));
		ubicacionDB.setCalle(location.getCalle());
		ubicacionDB.setCasa(location.getCasa());
		Sector sector = sectorRepo.findById(nSector).orElseThrow(() -> new EntityNotFoundException("sector no encontrado para este id:: " + nSector));
		ubicacionDB.setSector(sector);
		clienteDB.setUbicacion(ubicacionDB);
		
		final Cliente updatedCliente = clienteRepo.save(clienteDB);
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
