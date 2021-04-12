package com.thunderteam.logico.repositorios;
import com.thunderteam.logico.entities.Municipio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface MunicipioRepo extends JpaRepository<Municipio, String> {
	
    boolean existsByNombreMunicipio(String nombreMunicipio);
    Municipio findByNombreMunicipio(String nombreMunicipio);
    List<Municipio> findAllByNombreProvinciaNombreProvincia(final String provincia);
}
