package com.thunderteam.logico.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.thunderteam.logico.entities.Vehiculo;

import java.util.List;

public interface VehiculoRepo extends CrudRepository<Vehiculo,Integer>{


}
