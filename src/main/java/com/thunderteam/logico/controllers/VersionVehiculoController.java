package com.thunderteam.logico.controllers;

import com.thunderteam.logico.entities.Version_Vehiculo;
import com.thunderteam.logico.services.VersionVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/versiones")
public class VersionVehiculoController {

    @Autowired
    VersionVehiculoService versionService;

    @GetMapping("/")
    public List<Version_Vehiculo> getAll(){return versionService.getAll();}

    @GetMapping("/modelo")
    public  List<Version_Vehiculo> getAllByModelo(@RequestParam String nombreModelo){
        return versionService.getAllByModelo(nombreModelo);
    }

    @GetMapping("/version")
    public Version_Vehiculo getVersion(@RequestParam String nombreVersion){
        return versionService.getVersion(nombreVersion);
    }

    @PostMapping("/version")
    public ResponseEntity<Version_Vehiculo> postVersion(@RequestBody Version_Vehiculo version){
        return versionService.saveVersion(version);
    }

    @DeleteMapping("/version")
    public ResponseEntity<Version_Vehiculo> deleteVersion(@RequestParam int id){
        return versionService.deleteVersion(id);
    }


}
