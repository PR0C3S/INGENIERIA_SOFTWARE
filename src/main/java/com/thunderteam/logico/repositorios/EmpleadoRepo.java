package com.thunderteam.logico.repositorios;
import com.thunderteam.logico.entities.EnumEstadoEmpleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import com.thunderteam.logico.entities.Empleado;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmpleadoRepo extends JpaRepository<Empleado,Integer>
{
    List<Empleado> findByNombreCompletoContains(String Nombre);
    Optional<Empleado> findByEmail(String email);
    Long countByEstado(EnumEstadoEmpleado estadoEmpleado);
}
