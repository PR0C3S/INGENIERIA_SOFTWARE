package com.thunderteam.logico.repositorios;
import com.thunderteam.logico.entities.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MunicipioRepo extends JpaRepository<Municipio, Integer> {
    boolean existsByNombre(String nombreMunicipio);
    Municipio findByNombre(String nombreMunicipio);
}
