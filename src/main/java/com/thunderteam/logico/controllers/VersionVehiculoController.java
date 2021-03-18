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
    public List<Version_Vehiculo> getAll(){
        return versionService.getAll();
    }

    @GetMapping("/modelo")
    public ResponseEntity getAllByModelo(@RequestParam String modelo){
        return versionService.getAllByModelo(modelo);
    }

    @GetMapping("/version")
    public ResponseEntity getVersion(@RequestParam String nombreVersion, @RequestParam String nombreModelo){
        return versionService.getVersion(nombreVersion,nombreModelo);
    }

    @PostMapping("/version")
    public ResponseEntity postVersion(@RequestParam String nombreVersion, @RequestParam String colorExterior, @RequestParam String colorInterior,
                                      @RequestParam int puertas, @RequestParam int pasajeros, @RequestParam String motor, @RequestParam String traccionStr,
                                      @RequestParam String combustibleStr, @RequestParam String transmisionStr, @RequestParam String nombreModelo){
        return versionService.postVersion( nombreVersion, colorExterior, colorInterior, puertas,  pasajeros,  motor,  traccionStr,
                combustibleStr, transmisionStr, nombreModelo);
    }

    @DeleteMapping("/version")
    public ResponseEntity deleteVersion(String nombreVersion, String nombreModelo){
        return versionService.deleteVersion(nombreVersion, nombreModelo);
    }
}
