package com.thunderteam.logico.services;

import com.thunderteam.logico.entities.Marca_Vehiculo;
import com.thunderteam.logico.entities.Modelo_Vehiculo;
import com.thunderteam.logico.entities.Tipo_Vehiculo;
import com.thunderteam.logico.repositorios.MarcaVehiculoRepo;
import com.thunderteam.logico.repositorios.ModeloVehiculoRepo;
import com.thunderteam.logico.repositorios.TipoVehiculoRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ModeloVehiculoService {

    private final ModeloVehiculoRepo modeloRepo;
    private final MarcaVehiculoRepo marcaRepo;
    private final TipoVehiculoRepo tipoRepo;

    // Buscar todos los modelos
    public List<Modelo_Vehiculo> getAll(){
        return modeloRepo.findAll();
    }

    // Buscar todos los modelos de una marca
    public ResponseEntity getAllByMarca(String marca){
        Map<String, String> response = new HashMap<>();

        if (!marcaRepo.existsByNombreMarca(marca)){
            response.put("found", "false");
            response.put("message", "Marca no encontrada");
            return ResponseEntity.badRequest().body(response);
        }

        List<Modelo_Vehiculo> listaModelos = modeloRepo.findAllByMarcavehiculo_NombreMarca(marca);
        return ResponseEntity.ok().body(listaModelos);
    }

    // Buscar todos los modelos de un tipo de vehiculo
    public ResponseEntity getAllByTipo(String tipo){
        Map<String, String> response = new HashMap<>();

        if (!tipoRepo.existsByNombreTipo(tipo)){
            response.put("found", "false");
            response.put("message", "Tipo no encontrado");
            return ResponseEntity.badRequest().body(response);
        }
        List<Modelo_Vehiculo> listaModelos = modeloRepo.findAllByTipovehiculo_NombreTipo(tipo);
        return ResponseEntity.ok().body(listaModelos);
    }

    // Buscar todos los modelos de un tipo de vehiculo y marca
    public ResponseEntity getAllByTipoAndMarca(String tipo, String marca){
        Map<String, String> response = new HashMap<>();

        if (!tipoRepo.existsByNombreTipo(tipo)){
            response.put("found", "false");
            response.put("message", "Tipo no encontrado");
            return ResponseEntity.badRequest().body(response);
        }
        if (!marcaRepo.existsByNombreMarca(marca)){
            response.put("found", "false");
            response.put("message", "Marca no encontrada");
            return ResponseEntity.badRequest().body(response);
        }
        List<Modelo_Vehiculo> listaModelos = modeloRepo
                .findAllByMarcavehiculo_NombreMarcaAndTipovehiculo_NombreTipo(marca,tipo);

        return ResponseEntity.ok().body(listaModelos);
    }

    // Buscar un modelo por su nombre
    public ResponseEntity getModelo(String nombreModelo){
        Map<String, String> response = new HashMap<>();
        Optional<Modelo_Vehiculo> modelo = modeloRepo
                .findByNombreModelo(nombreModelo);

        if(modelo.isEmpty()){
            response.put("found", "false");
            response.put("message", "Modelo no encontrado");
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.ok().body(modelo);
    }

    // Guardar Un modelo
    public ResponseEntity postModelo(String nombre_Modelo, int year,
                                     String tipo, String marca){
        Optional<Tipo_Vehiculo> tipoInstance = tipoRepo.findTipo_VehiculoByNombreTipo(tipo);
        Optional<Marca_Vehiculo> marcaInstance = marcaRepo.findByNombreMarca(marca);
        Optional<Modelo_Vehiculo> modeloInstance = modeloRepo.findByNombreModelo(nombre_Modelo);
        Map<String, String> response = new HashMap<>();

        if(modeloInstance.isPresent()){
            response.put("Created", "false");
            response.put("message", "Este modelo ya existe");
            return ResponseEntity.badRequest().body(response);
        }else if (tipoInstance.isEmpty()){
            response.put("Created", "false");
            response.put("message", "Tipo no encontrado");
            return ResponseEntity.badRequest().body(response);
        }else if (marcaInstance.isEmpty()){
            response.put("Created", "false");
            response.put("message", "Marca no encontrada");
            return ResponseEntity.badRequest().body(response);
        }
        Modelo_Vehiculo modelo = new Modelo_Vehiculo(
                nombre_Modelo, year,
                tipoInstance.get(), marcaInstance.get()
        );

        modeloRepo.save(modelo);
        return ResponseEntity.ok().body(modelo);
    }

    // Eliminar un modelo
    public ResponseEntity deleteModelo(String nombreModelo){
        Map<String, String> response = new HashMap<>();
        Optional<Modelo_Vehiculo> modelo = modeloRepo.findByNombreModelo(nombreModelo);

        if(modelo.isEmpty()){
            response.put("delete", "false");
            response.put("message", "Modelo no encontrado");
            return ResponseEntity.badRequest().body(response);
        }else{
            modeloRepo.delete(modelo.get());
            response.put("delete", "true");
            response.put("message", "Modelo \""+nombreModelo+"\" encontrado");
            return ResponseEntity.ok().body(response);
        }
    }
}
