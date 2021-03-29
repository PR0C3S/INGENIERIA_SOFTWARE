package com.thunderteam.logico.repositorios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.thunderteam.logico.entities.Cliente;

import java.util.List;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente,Integer>{

    List<Cliente> findByNombreCompletoContains(String Nombre);
}
