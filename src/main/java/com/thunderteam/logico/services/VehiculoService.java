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
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

@Service
@AllArgsConstructor
public class VehiculoService {

    //private final MarcaVehiculoRepo marcaRepo;
    //private final ModeloVehiculoRepo modeloRepo;
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
	/*
	 * public List<Vehiculo> getAllByTipo(String tipo){ return
	 * vehiculoRepo.findAllByTipo(tipo); }
	 */

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
    public ResponseEntity<Vehiculo> postVehiculo(Vehiculo vehiculo, Version_Vehiculo vv, MultipartFile file) throws IOException{
    	
    	Vehiculo v = new Vehiculo();
    	
    	String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		
		if(fileName.contains("..")){
			System.out.println("archivo no valido");
		}
		vehiculo.setImagen(fileName);
		
		/*
		 * try{ //v.setImagen(Base64.getEncoder().encodeToString(file.getBytes()));
		 * System.out.printf("algo"); }catch(IOException e){ e.printStackTrace(); }
		 */
		 
		/*
		 * v.setKilometraje(vehiculo.getKilometraje());
		 * v.setAccesorios(vehiculo.getAccesorios()); v.setAno(vehiculo.getAno());
		 * v.setCondicion(vehiculo.getCondicion());
		 * v.setColor_Exterior(vehiculo.getColor_Exterior());
		 * v.setColor_Interior(vehiculo.getColor_Interior());
		 * v.setPrecio(vehiculo.getPrecio());
		 * v.setColor_Interior(vehiculo.getColor_Interior());
		 * v.setEstado(vehiculo.getEstado());
		 * v.setDescripcion(vehiculo.getDescripcion());
		 * v.setEstado(vehiculo.getEstado());
		 */
    	
    	Version_Vehiculo versionDB = versionRepo.findById(vv.getNombreVersion()).orElseThrow(() -> new EntityNotFoundException("version no encontrada"));

    	//vv.setModeloVehiculo(versionDB);
    	
    	vehiculo.setVersionVehiculo(versionDB); //v
    	//vv.setVehiculo(v);
    	Vehiculo obj = vehiculoRepo.save(v);
    	
    	String uploadDir = "./imagenes/" + obj.getID_Vehiculo();
    	
    	Path uploadPath = Paths.get(uploadDir);
    	
    	if (!Files.exists(uploadPath)) {
    		try {
				Files.createDirectories(uploadPath);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	
    	try(InputStream inputStream = file.getInputStream()){
    	Path filePath = uploadPath.resolve(fileName);
    	Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
    	}catch(IOException e){
    		throw new IOException("No se puedo guardar");
    	}
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
