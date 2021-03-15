package com.thunderteam.logico.controllers;

import com.thunderteam.logico.entities.Tipo_Vehiculo;
import com.thunderteam.logico.services.TipoVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/tipos")
public class TipoVehiculoController {

    @Autowired
    TipoVehiculoService tipoService;

    @GetMapping("/")
    public List<Tipo_Vehiculo> getAllTipos() {return tipoService.getAll();}
    @GetMapping("/tipo")
    public ResponseEntity getTipo(@RequestParam String nombreTipo){ return tipoService.getTipo(nombreTipo); }
    @PostMapping("/tipo")
    public ResponseEntity postTipo(@RequestParam String nombreTipo){ return tipoService.postTipo(nombreTipo); }
    @DeleteMapping("/tipo")
    public ResponseEntity deleteTipo(@RequestParam String nombreTipo){ return tipoService.eliminarTipo(nombreTipo); }
}
