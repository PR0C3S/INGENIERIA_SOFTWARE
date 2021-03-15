package com.thunderteam.logico.repositorios;

import com.thunderteam.logico.entities.Marca_Vehiculo;
import com.thunderteam.logico.entities.Modelo_Vehiculo;
import com.thunderteam.logico.entities.Tipo_Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ModeloVehiculoRepo extends JpaRepository<Modelo_Vehiculo, Integer> {
    List<Modelo_Vehiculo> findModelo_VehiculosByMarca_vehiculo(Marca_Vehiculo marca);
    List<Modelo_Vehiculo> findModelo_VehiculosByTipo_vehiculo(Tipo_Vehiculo tipo);
    List<Modelo_Vehiculo> findModelo_VehiculosByMarca_vehiculoAndTipo_vehiculo(Marca_Vehiculo marca, Tipo_Vehiculo tipo);
    Optional<Modelo_Vehiculo> findByNombre_Modelo(String nombreModelo);
}
