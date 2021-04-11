package com.thunderteam.logico.controllers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thunderteam.logico.entities.Marca_Vehiculo;
import com.thunderteam.logico.entities.Provincia;
import com.thunderteam.logico.repositorios.ProvinciaRepo;


@RestController
@RequestMapping("/provincias")
public class ProvinciaController {
	
	@Autowired
    ProvinciaRepo provinciaRepo;
	
	@GetMapping("/")
    public List<Provincia> getAllMarcas(){
        return provinciaRepo.findAll();
    }
	
	@GetMapping("/id")
	public Optional<Provincia> getById(@RequestParam String id){
		return provinciaRepo.findById(id);
	}
	
    @PostMapping("save")
    public Provincia postProvincia(@RequestParam String nombreProvincia){
    	Provincia prov = new Provincia(nombreProvincia);
    	return provinciaRepo.save(prov); 
    	}
    
    @DeleteMapping("/delete")
    public ResponseEntity deleteProvincia(@RequestParam String nombreProvincia){
    	Map<String, String> response = new HashMap<>();
        Optional<Provincia> prov = provinciaRepo.findByNombreProvincia(nombreProvincia);

        if(!prov.isPresent()){
            response.put("deleted", "false");
            response.put("message", "Marca no encontrada");
            return ResponseEntity.badRequest().body(response);
        }else{
            provinciaRepo.delete(prov.get());
            response.put("deleted", "true");
            response.put("message", "Marca "+nombreProvincia+" eliminada");
            return ResponseEntity.ok().body(response);
        }
    }

}
