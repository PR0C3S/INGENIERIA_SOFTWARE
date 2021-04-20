package com.thunderteam.logico.repositorios;

import com.thunderteam.logico.entities.EnumEstadoEmpleado;
import com.thunderteam.logico.entities.EnumEstadoVehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.thunderteam.logico.entities.Vehiculo;

import java.util.List;
import java.util.Optional;

public interface VehiculoRepo extends JpaRepository<Vehiculo,Integer> {

    List<Vehiculo> findAllByVersionVehiculo_ModeloVehiculo_MarcaVehiculo_NombreMarca(String nombreMarca);
    List<Vehiculo> findAllByVersionVehiculo_ModeloVehiculo_NombreModelo(String nombreModelo);
    List<Vehiculo> findAllByAno(int ano);
    List<Vehiculo> findAllByVersionVehiculo_ModeloVehiculo_MarcaVehiculo_NombreMarcaAndVersionVehiculo_ModeloVehiculo_NombreModelo(String nombreMarca, String nombreModelo);
    Long countByEstado(EnumEstadoVehiculo estadoVehiculo);
    //List<Vehiculo> findAllByTipo(String tipo);
    
    //List<Vehiculo> findAllByTipoAndVersionVehiculo_ModeloVehiculo_MarcaVehiculo_NombreMarca(String tipo, String Marca);
}
