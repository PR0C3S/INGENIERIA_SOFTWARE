package com.thunderteam.logico.services;

import com.thunderteam.logico.entities.EnumEstadoVehiculo;
import com.thunderteam.logico.entities.Modelo_Vehiculo;
import com.thunderteam.logico.entities.Vehiculo;
import com.thunderteam.logico.entities.Version_Vehiculo;
import com.thunderteam.logico.repositorios.MarcaVehiculoRepo;
import com.thunderteam.logico.repositorios.ModeloVehiculoRepo;
import com.thunderteam.logico.repositorios.VehiculoRepo;
import com.thunderteam.logico.repositorios.VersionVehiculoRepo;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

@Service
@AllArgsConstructor
public class VehiculoService {

    private final MarcaVehiculoRepo marcaRepo;
    private final ModeloVehiculoRepo modeloRepo;
    private final VehiculoRepo vehiculoRepo;
    private final VersionVehiculoRepo versionRepo;

    // Buscar iodos los vehiculos
    public List<Vehiculo> getAll(){return vehiculoRepo.findAll();}

    // Buscar todos los Vehiculos de una marca
    public List<Vehiculo> getAllByMarca(String nombreMarca){
        return vehiculoRepo.findAllByVersionVehiculo_ModeloVehiculo_MarcaVehiculo_NombreMarca(nombreMarca);
    }

    // Buscar todos los vehiculos de un modelo
    public List<Vehiculo> getAllByModelo(String nombreModelo){
        return vehiculoRepo.findAllByVersionVehiculo_ModeloVehiculo_NombreModelo(nombreModelo);
    }

    // Buscar todos los vehiculos por Año
    public List<Vehiculo> getAllByYear(int year){
        return vehiculoRepo.findAllByAno(year);
    }
    
    //Buscar todos los vehiculos por Tipo
    public List<Vehiculo> getAllByTipo(String tipo){
    	return vehiculoRepo.findAllByTipo(tipo);
    }

    // Buscar un vehiculo por ID
    public Vehiculo getVehiculo(int ID){
        Optional<Vehiculo> vehiculo = vehiculoRepo.findById(ID);
        return vehiculo.orElse(null);
    }

    //contar vehiculos disponibles
    public Long countVehiculosDisponibles(){
        return vehiculoRepo.countByEstado(EnumEstadoVehiculo.Disponible);
    }

    // Guardar un vehiculo
    public ResponseEntity<Vehiculo> postVehiculo(Vehiculo vehiculo, Version_Vehiculo vv, String modelo, MultipartFile file){
    	
    	
    	Vehiculo v = new Vehiculo();
    	
    	String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		/*
		 * if(fileName.contains("..")) { System.out.println("archivo no valido"); }try {
		 * v.setImagen(Base64.getEncoder().encodeToString(file.getBytes()));
		 * 
		 * }catch(IOException e){ e.printStackTrace(); }
		 */
    	v.setKilometraje(vehiculo.getKilometraje());
    	v.setAccesorios(vehiculo.getAccesorios());
    	v.setAno(vehiculo.getAno());
    	v.setCondicion(vehiculo.getCondicion());
    	v.setColor_Exterior(vehiculo.getColor_Exterior());
    	v.setColor_Interior(vehiculo.getColor_Interior());
    	v.setPrecio(vehiculo.getPrecio());
    	v.setColor_Interior(vehiculo.getColor_Interior());
    	v.setEstado(vehiculo.getEstado());
    	v.setTipo(vehiculo.getTipo());
    	v.setDescripcion(vehiculo.getDescripcion());
    	v.setEstado(vehiculo.getEstado());
    	
    	//revisar vehiculo.getVersionVehiculo().getID_Version()
    	Modelo_Vehiculo modeloDB = modeloRepo.findById(modelo).orElseThrow(() -> new EntityNotFoundException("version no encontrada"));
    	//a la version que tengo que crear
    	vv.setModeloVehiculo(modeloDB);
    	v.setVersionVehiculo(vv);
    	//vv.setVehiculo(v);
    	Vehiculo obj = vehiculoRepo.save(v);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    // Eliminar un vehiculo
    public ResponseEntity<Vehiculo> deleteVehiculo(int ID){
        Optional<Vehiculo> vehiculo = vehiculoRepo.findById(ID);
        if(vehiculo.isPresent()){
            vehiculoRepo.delete(vehiculo.get());
        }else{
            return new ResponseEntity<>(vehiculo.orElse(null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(vehiculo.get(), HttpStatus.OK);
    }
    
    
}
