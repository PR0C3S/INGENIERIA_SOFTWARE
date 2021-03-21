package com.thunderteam.logico.repositorios;
import com.thunderteam.logico.entities.Empleado;
import org.springframework.data.repository.CrudRepository;
import com.thunderteam.logico.entities.Cliente;

import java.util.List;

public interface ClienteRepo extends CrudRepository<Cliente,Integer>{

    List<Cliente> findByNombreCompletoContains(String Nombre);
}
