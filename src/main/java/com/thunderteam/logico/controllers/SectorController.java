package com.thunderteam.logico.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.thunderteam.logico.entities.Sector;
import com.thunderteam.logico.repositorios.SectorRepo;

@RestController
@RequestMapping("/sectores")
public class SectorController {
	@Autowired
    SectorRepo sectorRepo;
	
	@GetMapping("/")
    public List<Sector> getAllSectores(){
        return sectorRepo.findAll();
    }
	
	@GetMapping("/sectoresenmunicipio")
	public List<Sector> getSectoresEnMunicipio(@RequestParam String nombreMunicipio){
		return sectorRepo.findAllByNombreMunicipioNombreMunicipio(nombreMunicipio);
	}
}
