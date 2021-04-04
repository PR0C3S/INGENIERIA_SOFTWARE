package com.thunderteam.logico.services;

import com.thunderteam.logico.entities.Marca_Vehiculo;
import com.thunderteam.logico.entities.Tipo_Vehiculo;
import com.thunderteam.logico.repositorios.TipoVehiculoRepo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TipoVehiculoService {

    private final TipoVehiculoRepo tipoRepo;

    public List<Tipo_Vehiculo> getAll(){return  tipoRepo.findAll();}

    public ResponseEntity getTipo(String nombreTipo){
        Map<String, String> response = new HashMap<>();
        Optional<Tipo_Vehiculo> tipo = tipoRepo.findTipo_VehiculoByNombreTipo(nombreTipo);

        if (!tipo.isPresent()){
            response.put("found", "false");
            response.put("message", "Tipo no encontrado");
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.ok().body(tipo);
    }

    public ResponseEntity postTipo(String nombreTipo){
        Map<String, String> response = new HashMap<>();
        Optional<Tipo_Vehiculo> tipo = tipoRepo.findTipo_VehiculoByNombreTipo(nombreTipo);

        if (tipo.isPresent()){
            response.put("Created", "false");
            response.put("message", "Esta marca ya existe");
            return ResponseEntity.badRequest().body(response);
        }
        Tipo_Vehiculo nuevoTipo = new Tipo_Vehiculo(nombreTipo);
        tipoRepo.save(nuevoTipo);
        return  ResponseEntity.ok().body(nuevoTipo);
    }

    public ResponseEntity eliminarTipo(String nombreTipo){
        Map<String, String> response = new HashMap<>();
        Optional<Tipo_Vehiculo> tipo = tipoRepo.findTipo_VehiculoByNombreTipo(nombreTipo);

        if(!tipo.isPresent()){
            response.put("deleted", "false");
            response.put("message", "Tipo no encontrado");
            return ResponseEntity.badRequest().body(response);
        }else{
            tipoRepo.delete(tipo.get());
            response.put("deleted", "true");
            response.put("message", "Tipo "+nombreTipo+" eliminado");
            return ResponseEntity.ok().body(response);
        }


    }

}
