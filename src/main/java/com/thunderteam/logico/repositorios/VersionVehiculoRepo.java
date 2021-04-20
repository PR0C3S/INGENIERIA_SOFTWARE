package com.thunderteam.logico.repositorios;

import com.thunderteam.logico.entities.Version_Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface VersionVehiculoRepo extends JpaRepository<Version_Vehiculo, String> {

    // Encontrar version por su nombre
    Optional<Version_Vehiculo> findByNombreVersion(String nombreVersion);

    // Encontrar version por su nombre y modelo
    Optional<Version_Vehiculo> findByNombreVersionAndModeloVehiculo_NombreModelo(String nombreVersion, String modelo);

    // Encontrar todas las versiones de un mismo modelo
    List<Version_Vehiculo> findAllByModeloVehiculo_NombreModelo (String modelo);
    
    //encontrar las distintas versiones
    List<Version_Vehiculo> findAllByModeloVehiculoNombreModelo(final String nombreModelo);

    boolean existsByModeloVehiculoNombreModeloAndNombreVersion(String modelo, String version);
    boolean existsByNombreVersion(String version);

    void deleteByNombreVersionAndModeloVehiculoNombreModelo(String modelo, String version);

	Optional<Version_Vehiculo> findById(String nombreVersion);
}
