package com.thunderteam.logico.repositorios;

import com.thunderteam.logico.entities.Tipo_Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TipoVehiculoRepo extends JpaRepository<Tipo_Vehiculo, Integer> {

    Optional<Tipo_Vehiculo> findTipo_VehiculoByNombreTipo(String tipo);
    boolean existsByNombreTipo(String tipo);
}
