package com.thunderteam.logico.services;

import com.thunderteam.logico.entities.Version_Vehiculo;
import com.thunderteam.logico.repositorios.ModeloVehiculoRepo;
import com.thunderteam.logico.repositorios.VersionVehiculoRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VersionVehiculoService {

    private final VersionVehiculoRepo versionRepo;
    private final ModeloVehiculoRepo modeloRepo;

    // Buscar todas las versiones
    public List<Version_Vehiculo> getAll(){
        return versionRepo.findAll();
    }

    // Buscar todas las versiones de un modelo
    public List<Version_Vehiculo> getAllByModelo(String nombreModelo){
        return versionRepo.findAllByModeloVehiculo_NombreModelo(nombreModelo);
    }

    // Buscar una version por nombre
    public Version_Vehiculo getVersion(String nombreVersion){
        return versionRepo.findByNombreVersion(nombreVersion);
    }

    // Guardar una version
    public ResponseEntity<Version_Vehiculo> saveVersion(Version_Vehiculo version){
        Version_Vehiculo obj = versionRepo.save(version);
        return new ResponseEntity<Version_Vehiculo>(obj, HttpStatus.OK);
    }

    // Eliminar una version
    public ResponseEntity<Version_Vehiculo> deleteVersion(int id){
        Optional<Version_Vehiculo> version = versionRepo.findById(id);
        if (version.isPresent()){
            versionRepo.delete(version.get());
        }else{
            return new ResponseEntity<Version_Vehiculo>(version.orElse(null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Version_Vehiculo>(version.get(), HttpStatus.OK);
    }

}
