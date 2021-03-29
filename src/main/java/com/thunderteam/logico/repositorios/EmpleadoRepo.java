package com.thunderteam.logico.repositorios;
import org.springframework.data.repository.CrudRepository;
import com.thunderteam.logico.entities.Empleado;

import java.util.List;
import java.util.Optional;

public interface EmpleadoRepo extends CrudRepository<Empleado,Integer>
{
    List<Empleado> findByNombreCompletoContains(String Nombre);
    Optional<Empleado> findByEmail(String email);
}
