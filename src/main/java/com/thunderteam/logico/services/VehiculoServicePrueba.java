package com.thunderteam.logico.services;

import com.thunderteam.logico.entities.Modelo_Vehiculo;
import com.thunderteam.logico.entities.Vehiculo;
import com.thunderteam.logico.entities.Version_Vehiculo;
import com.thunderteam.logico.repositorios.VehiculoRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VehiculoServicePrueba {

    @Autowired
    private final VehiculoRepo vehiculoRepo;


    public ResponseEntity postVehiculo(@RequestParam MultipartFile file, @RequestParam Vehiculo vehiculo,
                                       @RequestParam Version_Vehiculo version, @RequestParam Optional<Modelo_Vehiculo> modelo) {
        Map<String, String> response = new HashMap<>();

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if (fileName.contains("..")) {
            response.put("found", "false");
            response.put("message", "tipo de archivo no valido");
            return ResponseEntity.badRequest().body(response);
        }

        try {
            vehiculo.setImagen(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //version.setModeloVehiculo(modelo.get());
        vehiculo.setVersionVehiculo(version);

        vehiculoRepo.save(vehiculo);
        return ResponseEntity.ok().body(vehiculo);
    }
}