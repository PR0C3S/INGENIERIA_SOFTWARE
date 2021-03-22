package com.thunderteam.logico.repositorios;

import com.thunderteam.logico.entities.Provincia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProvinciaRepo extends JpaRepository<Provincia, Integer> {

    boolean existsByNombre(String nombreProvincia);
}
