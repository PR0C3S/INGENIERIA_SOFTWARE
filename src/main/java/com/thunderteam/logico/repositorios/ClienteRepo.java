package com.thunderteam.logico.repositorios;
import org.springframework.data.repository.CrudRepository;
import com.thunderteam.logico.entities.Cliente;

public interface ClienteRepo extends CrudRepository<Cliente,Integer>{

}
