package com.thunderteam.logico.controllers;

import com.thunderteam.logico.entities.*;
import com.thunderteam.logico.repositorios.FormCotizacionRepo;
import com.thunderteam.logico.repositorios.FormIntercambioRepo;
import com.thunderteam.logico.repositorios.FormOfertaRepo;
import com.thunderteam.logico.repositorios.FormPruebaManejoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/formularios")
public class FormularioController {

    @Autowired
    FormIntercambioRepo intercambioRepo;
    @Autowired
    FormOfertaRepo ofertaRepo;
    @Autowired
    FormCotizacionRepo cotizacionRepo;
    @Autowired
    FormPruebaManejoRepo pruebaManejoRepo;

    // formulario de ofertas
    @GetMapping("/ofertas")
    public List<FormOferta> getAllOfertas(){
        return ofertaRepo.findAll();
    }

    @PostMapping("/ofertas")
    public ResponseEntity<FormOferta> saveOferta(@RequestBody FormOferta form){
        FormOferta newForm = new FormOferta();

        newForm.setFinanciado(form.getFinanciado());
        newForm.setMonto_Ofrecido(form.getMonto_Ofrecido());
        newForm.setCelular(form.getCelular());
        newForm.setCorreo(form.getCorreo());
        newForm.setComentario(form.getComentario());
        newForm.setFecha(form.getFecha());
        newForm.setNombre(form.getNombre());
        //newForm.setVehiculo(form.getVehiculo());

        FormOferta obj = ofertaRepo.save(newForm);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/ofertas")
    public ResponseEntity<FormOferta> deleteOferta(@RequestParam int id){
        Optional<FormOferta> form = ofertaRepo.findById(id);
        if(form.isPresent()){
            ofertaRepo.delete(form.get());
        }else{
            return new ResponseEntity<>(form.orElse(null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(form.get(), HttpStatus.OK);
    }

    // formulario de Intercambios
    @GetMapping("/intercambios")
    public List<FormIntercambio> getAllIntercambios(){
        return intercambioRepo.findAll();
    }

    @PostMapping("/intercambios")
    public ResponseEntity<FormIntercambio> saveIntercambio(@RequestBody FormIntercambio form){
        FormIntercambio newForm = new FormIntercambio();

        newForm.setCalificacion(form.getCalificacion());
        newForm.setRentado(form.getRentado());
        newForm.setRecord_Reparaciones(form.getRecord_Reparaciones());
        newForm.setMillero_Funciona(form.getMillero_Funciona());
        newForm.setFuncionaAire(form.getFuncionaAire());
        newForm.setPregunta_Tecnica1(form.getPregunta_Tecnica1());
        newForm.setPregunta_Tecnica2(form.getPregunta_Tecnica2());
        newForm.setPregunta_Tecnica3(form.getPregunta_Tecnica3());
        newForm.setPregunta_Tecnica4(form.getPregunta_Tecnica4());

        newForm.setCelular(form.getCelular());
        newForm.setCorreo(form.getCorreo());
        newForm.setComentario(form.getComentario());
        newForm.setFecha(form.getFecha());
        newForm.setNombre(form.getNombre());
        //newForm.setVehiculo(form.getVehiculo());

        FormIntercambio obj = intercambioRepo.save(newForm);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/intercambios")
    public ResponseEntity<FormIntercambio> deleteintercambio(@RequestParam int id){
        Optional<FormIntercambio> form = intercambioRepo.findById(id);
        if(form.isPresent()){
            intercambioRepo.delete(form.get());
        }else{
            return new ResponseEntity<>(form.orElse(null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(form.get(), HttpStatus.OK);
    }

    // formulario de pruebas de manejo
    @GetMapping("/prueba")
    public List<FormPruebaManejo> GetAllPruebas(){return pruebaManejoRepo.findAll();}

    @PostMapping("/prueba")
    public ResponseEntity<FormPruebaManejo> savePrueba(@RequestBody FormPruebaManejo form){
        FormPruebaManejo newForm = new FormPruebaManejo();

        newForm.setFechaHora(form.getFechaHora());

        newForm.setCelular(form.getCelular());
        newForm.setCorreo(form.getCorreo());
        newForm.setComentario(form.getComentario());
        newForm.setFecha(form.getFecha());
        newForm.setNombre(form.getNombre());
        //newForm.setVehiculo(form.getVehiculo());

        FormPruebaManejo obj = pruebaManejoRepo.save(newForm);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/prueba")
    public ResponseEntity<FormPruebaManejo> deletePrueba(@RequestParam int id){
        Optional<FormPruebaManejo> form = pruebaManejoRepo.findById(id);
        if(form.isPresent()){
            pruebaManejoRepo.delete(form.get());
        }else{
            return new ResponseEntity<>(form.orElse(null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(form.get(), HttpStatus.OK);
    }

    // Formulario de cotizacion
    @GetMapping("/cotizacion")
    public List<FormCotizacion> GetAllCotizaciones(){return cotizacionRepo.findAll();}

    @PostMapping("/cotizacion")
    public ResponseEntity<FormCotizacion> saveCotizacion(@RequestBody FormCotizacion form){
        FormCotizacion newForm = new FormCotizacion();

        newForm.setMonto_Inicial(form.getMonto_Inicial());
        newForm.setDuracion_Prestamo(newForm.getDuracion_Prestamo());
        //newForm.setCuotasBancaria(newForm.getCuotasBancaria());

        newForm.setCelular(form.getCelular());
        newForm.setCorreo(form.getCorreo());
        newForm.setComentario(form.getComentario());
        newForm.setFecha(form.getFecha());
        newForm.setNombre(form.getNombre());
        //newForm.setVehiculo(form.getVehiculo());

        FormCotizacion obj = cotizacionRepo.save(newForm);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/cotizacion")
    public ResponseEntity<FormCotizacion> deleteCotizacion(@RequestParam int id){
        Optional<FormCotizacion> form = cotizacionRepo.findById(id);
        if(form.isPresent()){
            cotizacionRepo.delete(form.get());
        }else{
            return new ResponseEntity<>(form.orElse(null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(form.get(), HttpStatus.OK);
    }


}
