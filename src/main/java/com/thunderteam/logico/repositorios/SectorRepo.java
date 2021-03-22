package com.thunderteam.logico.repositorios;

import com.thunderteam.logico.entities.Municipio;
import com.thunderteam.logico.entities.Sector;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SectorRepo extends JpaRepository<Sector, Integer> {
    boolean existsByNombre(String nombreSector);
    Optional<Sector> findByNombre(String nombreSector);
}
