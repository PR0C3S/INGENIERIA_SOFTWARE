package com.thunderteam.logico.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.thunderteam.logico.entities.Municipio;
import com.thunderteam.logico.entities.Provincia;
import com.thunderteam.logico.repositorios.MunicipioRepo;
import com.thunderteam.logico.repositorios.ProvinciaRepo;


@RestController
@RequestMapping("/municipios")
public class MunicipioController {
	
	@Autowired
    MunicipioRepo municipioRepo;
	ProvinciaRepo provinciaRepo;
	
	@GetMapping("/")
    public List<Municipio> getAllMunicipios(){
        return municipioRepo.findAll();
    }
	
	@GetMapping("/municipiosenprovincia")
	public List<Municipio> getMunicipiosEnProvincia(@RequestParam String nombreProvincia){
		return municipioRepo.findAllByNombreProvinciaNombreProvincia(nombreProvincia);
	}
}
