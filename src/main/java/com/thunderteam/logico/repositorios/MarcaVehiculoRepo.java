package com.thunderteam.logico.repositorios;

import com.thunderteam.logico.entities.Marca_Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MarcaVehiculoRepo extends JpaRepository<Marca_Vehiculo, Integer> {

    Optional<Marca_Vehiculo> findByNombreMarca(String nombreMarca);
    boolean existsByNombreMarca(String marca);
}
