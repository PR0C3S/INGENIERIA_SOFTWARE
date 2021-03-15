package com.thunderteam.logico.repositorios;

import com.thunderteam.logico.entities.Vehiculo;
import com.thunderteam.logico.entities.Version_Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VersionVehiculoRepo extends JpaRepository<Version_Vehiculo, Integer> {


}
