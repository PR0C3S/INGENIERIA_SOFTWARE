package com.thunderteam.logico.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.thunderteam.logico.entities.Empleado;

public interface EmpleadoRepo extends CrudRepository<Empleado,Integer>
{
	
}
