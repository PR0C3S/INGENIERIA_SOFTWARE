package com.thunderteam.logico.repositorios;

import com.thunderteam.logico.entities.Modelo_Vehiculo;
import com.thunderteam.logico.entities.Vehiculo;
import com.thunderteam.logico.entities.Version_Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VersionVehiculoRepo extends JpaRepository<Version_Vehiculo, Integer> {

    Optional<Version_Vehiculo> findByNombreVersion(String nombreVersion);
    List<Version_Vehiculo> findAllByModeloVehiculo(Modelo_Vehiculo modelo);
}
