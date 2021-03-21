package com.thunderteam.logico.repositorios;

import com.thunderteam.logico.entities.Factura;
import org.springframework.data.repository.CrudRepository;

import com.thunderteam.logico.entities.Empleado;

import java.util.List;

public interface EmpleadoRepo extends CrudRepository<Empleado,Integer>
{
    List<Empleado> findByNombreCompletoContains(String Nombre);
}
