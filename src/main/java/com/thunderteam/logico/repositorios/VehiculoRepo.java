package com.thunderteam.logico.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.thunderteam.logico.entities.Vehiculo;

import java.util.List;
import java.util.Optional;

public interface VehiculoRepo extends JpaRepository<Vehiculo,Integer> {

    List<Vehiculo> findAllByVersionVehiculo_ModeloVehiculo_Marcavehiculo_NombreMarca(String nombreMarca);
    List<Vehiculo> findAllByVersionVehiculo_ModeloVehiculo_NombreModelo(String nombreModelo);
    List<Vehiculo> findAllByVersionVehiculo_ModeloVehiculo_Ano(int year);
    List<Vehiculo> findAllByVersionVehiculo_ModeloVehiculo_Marcavehiculo_NombreMarcaAndVersionVehiculo_ModeloVehiculo_NombreModelo(String nombreMarca, String nombreModelo);
}
