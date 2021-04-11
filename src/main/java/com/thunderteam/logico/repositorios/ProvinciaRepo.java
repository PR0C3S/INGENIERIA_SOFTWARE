package com.thunderteam.logico.repositorios;

import com.thunderteam.logico.entities.Provincia;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProvinciaRepo extends JpaRepository<Provincia, String> {

    boolean existsByNombreProvincia(String nombreProvincia);

	Optional<Provincia> findByNombreProvincia(String nombreProvincia);
}
