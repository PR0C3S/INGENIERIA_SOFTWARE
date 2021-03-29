package com.thunderteam.logico.services;

import com.thunderteam.logico.entities.Marca_Vehiculo;
import com.thunderteam.logico.repositorios.MarcaVehiculoRepo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MarcaVehiculoService {

    private final MarcaVehiculoRepo marcaRepo;

    // Buscar todas las marcas
    public List<Marca_Vehiculo> getAll() {
        return marcaRepo.findAll();
    }

    // Buscar una marca por su nombre
    public ResponseEntity getMarca(String nombreMarca) {
        Map<String, String> response = new HashMap<>();
        Optional<Marca_Vehiculo> marca = marcaRepo.findByNombreMarca(nombreMarca);

        if (!marca.isPresent()){
            response.put("found", "false");
            response.put("message", "Marca no encontrada");
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.ok().body(marca);
    }

    // Guardar una marca
    public ResponseEntity postMarca(String nombreMarca){
        Map<String, String> response = new HashMap<>();
        Optional<Marca_Vehiculo> marca = marcaRepo.findByNombreMarca(nombreMarca);

        if (marca.isPresent()){
            response.put("Created", "false");
            response.put("message", "Esta marca ya existe");
            return ResponseEntity.badRequest().body(response);
        }
        Marca_Vehiculo nuevaMarca = new Marca_Vehiculo(nombreMarca);
        marcaRepo.save(nuevaMarca);
        return  ResponseEntity.ok().body(nuevaMarca);
    }

    // Eliminar una marca
    public ResponseEntity eliminarMarca(String nombreMarca){
        Map<String, String> response = new HashMap<>();
        Optional<Marca_Vehiculo> marca = marcaRepo.findByNombreMarca(nombreMarca);

        if(!marca.isPresent()){
            response.put("deleted", "false");
            response.put("message", "Marca no encontrada");
            return ResponseEntity.badRequest().body(response);
        }else{
            marcaRepo.delete(marca.get());
            response.put("deleted", "true");
            response.put("message", "Marca "+nombreMarca+" eliminada");
            return ResponseEntity.ok().body(response);
        }


    }

}
