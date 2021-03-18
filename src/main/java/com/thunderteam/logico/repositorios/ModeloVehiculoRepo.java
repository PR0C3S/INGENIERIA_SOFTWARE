package com.thunderteam.logico.repositorios;

import com.thunderteam.logico.entities.Marca_Vehiculo;
import com.thunderteam.logico.entities.Modelo_Vehiculo;
import com.thunderteam.logico.entities.Tipo_Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ModeloVehiculoRepo extends JpaRepository<Modelo_Vehiculo, Integer> {

    // Encontrar todos los modelos de una marca
    List<Modelo_Vehiculo> findAllByMarcavehiculo_NombreMarca(String marca);

    // Encontrar todos los modelos de un tipo
    List<Modelo_Vehiculo> findAllByTipovehiculo_NombreTipo(String tipo);

    // Encontrar todos los modelos de un tipo y marca
    List<Modelo_Vehiculo> findAllByMarcavehiculo_NombreMarcaAndTipovehiculo_NombreTipo(String marca, String tipo);

    // Encontrar un modelo por su nombre
    Optional<Modelo_Vehiculo> findByNombreModelo(String nombreModelo);

    boolean existsByNombreModelo(String modelo);
}
