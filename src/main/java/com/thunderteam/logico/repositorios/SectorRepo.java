package com.thunderteam.logico.repositorios;

import com.thunderteam.logico.entities.Municipio;
import com.thunderteam.logico.entities.Sector;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SectorRepo extends JpaRepository<Sector, String> {
    boolean existsByNombreSector(String nombreSector);
    Optional<Sector> findByNombreSector(String nombreSector);
    List<Sector> findAllByNombreMunicipioNombreMunicipio(final String nombreMunicipio);
}
