package com.thunderteam.logico.services;

import com.thunderteam.logico.entities.*;
import com.thunderteam.logico.repositorios.MarcaVehiculoRepo;
import com.thunderteam.logico.repositorios.ModeloVehiculoRepo;
import com.thunderteam.logico.repositorios.VersionVehiculoRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.thunderteam.logico.entities.Version_Vehiculo.*;

@Service
@AllArgsConstructor
public class VersionVehiculoService {

    private final VersionVehiculoRepo versionRepo;
    private final ModeloVehiculoRepo modeloRepo;
    private final MarcaVehiculoRepo marcaRepo;
    //private final TipoVehiculoRepo tipoRepo;

    // Buscar todas las versiones
    public List<Version_Vehiculo> getAll(){
        return versionRepo.findAll();
    }

    // Buscar todas las versiones de un mismo modelo
    public ResponseEntity getAllByModelo(String modelo){
        Map<String, String> response = new HashMap<>();

        if(!modeloRepo.existsByNombreModelo(modelo)){
            response.put("found", "false");
            response.put("message", "Modelo no encontrado");
            return ResponseEntity.badRequest().body(response);
        }
        List<Version_Vehiculo> listaVersiones = versionRepo.findAllByModeloVehiculo_NombreModelo(modelo);
        return ResponseEntity.ok().body(listaVersiones);
    }

    // Buscar una version por su nombre y modelo
    public ResponseEntity getVersion(String nombreVersion, String nombreModelo){
        Map<String, String> response = new HashMap<>();
        Optional<Version_Vehiculo> version = versionRepo
                .findByNombreVersionAndModeloVehiculo_NombreModelo(nombreVersion, nombreModelo);

        if(!version.isPresent()){
            response.put("found", "false");
            response.put("message", "version no encontrada");
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.ok().body(version);
    }

    // Guardar una version
    public ResponseEntity postVersion(String nombreVersion,
                                      int puertas, int pasajeros, String motor, String traccionStr,
                                      String combustibleStr, String transmisionStr, String nombreModelo){
        Map<String, String> response = new HashMap<>();

        if(versionRepo
                .existsByModeloVehiculoNombreModeloAndNombreVersion(nombreModelo,nombreVersion)){
            response.put("Created", "false");
            response.put("message", "Esta version del modelo "+nombreModelo+" ya existe");
            return ResponseEntity.badRequest().body(response);
        }
        if(!modeloRepo.existsByNombreModelo(nombreModelo)){
            response.put("Created", "false");
            response.put("message", "Modelo no encontrado");
            return ResponseEntity.badRequest().body(response);
        }
        Optional<Modelo_Vehiculo> modelo = modeloRepo.findByNombreModelo(nombreModelo);
        
        Version_Vehiculo version = new Version_Vehiculo();
        version.setNombreVersion(nombreVersion);
        version.setPuertas(puertas);
        version.setPasajeros(pasajeros);
        version.setMotor(motor);
        version.setCombustible(EnumCombustible.valueOf(combustibleStr));
        version.setTransmision(EnumTransmision.valueOf(transmisionStr));
        version.setTraccion(EnumTraccion.valueOf(traccionStr));
        version.setModeloVehiculo(modelo.get());
        versionRepo.save(version);
        return ResponseEntity.ok().body(version);
    }

    // Eliminar una version de un modelo
    public ResponseEntity deleteVersion(String nombreVersion, String nombreModelo){
        Map<String, String> response = new HashMap<>();

        if(!versionRepo
                .existsByModeloVehiculoNombreModeloAndNombreVersion(nombreModelo,nombreVersion)){
            response.put("found", "false");
            response.put("message", "Version no encontrada");
            return ResponseEntity.badRequest().body(response);
        }else{
            versionRepo
                    .deleteByNombreVersionAndModeloVehiculoNombreModelo(nombreModelo, nombreVersion);
            response.put("delete", "true");
            response.put("message", "Version "+nombreVersion+" del modelo "+nombreModelo+" eliminada");
            return ResponseEntity.ok().body(response);
        }
    }
}
