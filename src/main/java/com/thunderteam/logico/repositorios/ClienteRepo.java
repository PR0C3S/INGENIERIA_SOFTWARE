package com.thunderteam.logico.repositorios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.thunderteam.logico.entities.Cliente;

import java.util.List;

import static org.hibernate.loader.Loader.SELECT;
import static org.hibernate.sql.ast.Clause.FROM;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente,Integer>{

    List<Cliente> findByNombreCompletoContains(String Nombre);
}
