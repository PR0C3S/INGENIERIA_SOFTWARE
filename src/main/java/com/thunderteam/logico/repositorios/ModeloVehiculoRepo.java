package com.thunderteam.logico.repositorios;

import com.thunderteam.logico.entities.Modelo_Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ModeloVehiculoRepo extends JpaRepository<Modelo_Vehiculo, String> {

    // Encontrar todos los modelos de una marca
    List<Modelo_Vehiculo> findAllByMarcaVehiculo_NombreMarca(String marca);

    // Encontrar un modelo por su nombre
    Optional<Modelo_Vehiculo> findByNombreModelo(String nombreModelo);

    boolean existsByNombreModelo(String modelo);
    
    List<Modelo_Vehiculo> findAllByMarcaVehiculoNombreMarca(final String nombreMarca);
}
