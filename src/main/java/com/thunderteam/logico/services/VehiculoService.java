package com.thunderteam.logico.services;

import com.thunderteam.logico.entities.EnumEstadoVehiculo;
import com.thunderteam.logico.entities.Vehiculo;
import com.thunderteam.logico.repositorios.MarcaVehiculoRepo;
import com.thunderteam.logico.repositorios.ModeloVehiculoRepo;
import com.thunderteam.logico.repositorios.VehiculoRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VehiculoService {

    private final MarcaVehiculoRepo marcaRepo;
    private final ModeloVehiculoRepo modeloRepo;
    private final VehiculoRepo vehiculoRepo;

    // Buscar iodos los vehiculos
    public List<Vehiculo> getAll(){return vehiculoRepo.findAll();}

    // Buscar todos los Vehiculos de una marca
    public List<Vehiculo> getAllByMarca(String nombreMarca){
        return vehiculoRepo.findAllByVersionVehiculo_ModeloVehiculo_Marcavehiculo_NombreMarca(nombreMarca);
    }

    // Buscar todos los vehiculos de un modelo
    public List<Vehiculo> getAllByModelo(String nombreModelo){
        return vehiculoRepo.findAllByVersionVehiculo_ModeloVehiculo_NombreModelo(nombreModelo);
    }

    // Buscar todos los vehiculos por Año
    public List<Vehiculo> getAllByYear(int year){
        return vehiculoRepo.findAllByVersionVehiculo_ModeloVehiculo_Ano(year);
    }

    // Buscar un vehiculo por ID
    public Vehiculo getVehiculo(int ID){
        Optional<Vehiculo> vehiculo = vehiculoRepo.findById(ID);
        return vehiculo.orElse(null);
    }

    //contar vehiculos disponibles
    public Long countVehiculosDisponibles(){
        return vehiculoRepo.countByEstado(EnumEstadoVehiculo.Disponible);
    }

    // Guardar un vehiculo
    public ResponseEntity<Vehiculo> postVehiculo(Vehiculo vehiculo){
        Vehiculo obj = vehiculoRepo.save(vehiculo);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    // Eliminar un vehiculo
    public ResponseEntity<Vehiculo> deleteVehiculo(int ID){
        Optional<Vehiculo> vehiculo = vehiculoRepo.findById(ID);
        if(vehiculo.isPresent()){
            vehiculoRepo.delete(vehiculo.get());
        }else{
            return new ResponseEntity<>(vehiculo.orElse(null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(vehiculo.get(), HttpStatus.OK);
    }
}
