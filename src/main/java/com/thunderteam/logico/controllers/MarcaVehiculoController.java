package com.thunderteam.logico.controllers;

import com.thunderteam.logico.entities.Marca_Vehiculo;
import com.thunderteam.logico.services.MarcaVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marcas")
public class MarcaVehiculoController {

    @Autowired
    MarcaVehiculoService marcaService;

    @GetMapping("/")
    public List<Marca_Vehiculo> getAllMarcas(){
        return marcaService.getAll();
    }
    @GetMapping("/marca")
    public ResponseEntity getMarca(@RequestParam String nombreMarca){ return marcaService.getMarca(nombreMarca); }
    @PostMapping("/marca")
    public ResponseEntity postMarca(@RequestParam String nombre_Marca){ return marcaService.postMarca(nombre_Marca); }
    @DeleteMapping("/marca")
    public ResponseEntity deleteMarca(@RequestParam String nombre_Marca){ return marcaService.eliminarMarca(nombre_Marca); }
}
