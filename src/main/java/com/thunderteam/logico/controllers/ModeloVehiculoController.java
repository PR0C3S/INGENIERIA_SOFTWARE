package com.thunderteam.logico.controllers;

import com.thunderteam.logico.entities.Modelo_Vehiculo;
import com.thunderteam.logico.services.ModeloVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modelos")
public class ModeloVehiculoController {

    @Autowired
    ModeloVehiculoService modeloService;

    @GetMapping("/")
    public List<Modelo_Vehiculo> getAllModelos(){return modeloService.getAll();}
    @GetMapping("/marca")
    public ResponseEntity getAllByMarca(String marca){
        return  modeloService.getAllByMarca(marca);
    }
    @GetMapping("/tipo")
    public ResponseEntity getAllByTipo(String tipo){
        return modeloService.getAllByTipo(tipo);
    }
    @GetMapping("/tipomarca")
    public ResponseEntity getAllByTipoAndMarca(String tipo, String marca){
        return modeloService.getAllByTipoAndMarca(tipo, marca);
    }
    @GetMapping("/modelo")
    public ResponseEntity getModelo(String nombreModelo){
        return modeloService.getModelo(nombreModelo);
    }
    @PostMapping("/modelo")
    public ResponseEntity postModelo(String nombre_Modelo, int year,
                                     String tipo, String marca){
        return modeloService.postModelo(nombre_Modelo,year,tipo,marca);
    }
    @DeleteMapping("/modelo")
    public ResponseEntity deleteModelo(String nombreModelo){
       return modeloService.deleteModelo(nombreModelo);
    }


}
