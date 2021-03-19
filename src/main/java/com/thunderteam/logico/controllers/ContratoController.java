package com.thunderteam.logico.controllers;

import java.util.*;

import com.thunderteam.logico.entities.*;
import com.thunderteam.logico.repositorios.ContratoRepo;

import com.thunderteam.logico.services.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContratoController {
	
	@Autowired
	ContratoRepo contratoRepo;
	FacturaService facturaService;

	@GetMapping("/")
	public List<Contrato> getAllContratos(){return (List<Contrato>) contratoRepo.findAll();}

	@GetMapping("/contrato")
	public Optional<Contrato> getAllByID(@RequestParam int ID){
		return  contratoRepo.findById(ID);
	}


	@GetMapping("/IDandContrato")
	public List<Contrato> getAllByFechaContrato(@RequestParam Date fecha){
		return(contratoRepo.findContratoByFechaContains(fecha));
	}

	@PostMapping("/Contrato")
	public ResponseEntity postContrato(@RequestParam Date plazo_Pago, @RequestParam Date fecha_Entrega,
								 @RequestParam Contrato.Estado status, @RequestParam Contrato.tipoContrato tipo,
								 @RequestParam float precio_Vehiculo, @RequestParam float diferencia,
								 @RequestParam Cliente cliente,
								 @RequestParam Empleado empleado, @RequestParam Vehiculo vehiculo,
								 @RequestParam Vehiculo vehiculoCliente
	){
		Contrato nuevoContrato = new Contrato();
		nuevoContrato.setCliente(cliente);
		nuevoContrato.setFecha_Entrega(fecha_Entrega);
		nuevoContrato.setPrecio_Vehiculo(precio_Vehiculo);
		nuevoContrato.setDiferencia(diferencia);
		nuevoContrato.setTipo(tipo);
		nuevoContrato.setPlazo_Pago(plazo_Pago);
		nuevoContrato.setEmpleado(empleado);
		nuevoContrato.setVehiculo(vehiculo);
		nuevoContrato.setVehiculoCliente(vehiculoCliente);
		nuevoContrato.setStatus(status);

		contratoRepo.save(nuevoContrato);
		return  ResponseEntity.ok().body(nuevoContrato);
	}

	@PutMapping ("/Contrato")
	public ResponseEntity putContrato(@RequestParam int ID, @RequestParam Date plazo_Pago, @RequestParam Date fecha_Entrega,
								 @RequestParam Contrato.Estado status, @RequestParam Contrato.tipoContrato tipo,
								 @RequestParam float precio_Vehiculo, @RequestParam float diferencia,
								 @RequestParam Cliente cliente,
								 @RequestParam Empleado empleado, @RequestParam Vehiculo vehiculo,
								 @RequestParam Vehiculo vehiculoCliente
	){

		Map<String, String> response = new HashMap<>();
		Optional <Contrato> contrato = contratoRepo.findById(ID);

		if (contrato.isEmpty()){
			response.put("found", "false");
			response.put("message", "contrato no encontrada");
			return ResponseEntity.badRequest().body(response);
		}

		Contrato oldContrato = new Contrato();
		oldContrato.setID_Contrato(ID);
		oldContrato.setFecha(contrato.get().getFecha());
		oldContrato.setCliente(cliente);
		oldContrato.setFecha_Entrega(fecha_Entrega);
		oldContrato.setPrecio_Vehiculo(precio_Vehiculo);
		oldContrato.setDiferencia(diferencia);
		oldContrato.setTipo(tipo);
		oldContrato.setPlazo_Pago(plazo_Pago);
		oldContrato.setEmpleado(empleado);
		oldContrato.setVehiculo(vehiculo);
		oldContrato.setVehiculoCliente(vehiculoCliente);
		oldContrato.setStatus(status);
		contratoRepo.save(oldContrato);
		return  ResponseEntity.ok().body(oldContrato);
	}

	@DeleteMapping("/contrato")
	public ResponseEntity deleteContrato(@RequestParam int ID){
		Map<String, String> response = new HashMap<>();
		Optional<Contrato> contrato = contratoRepo.findById(ID);

		if(contrato.isEmpty()){
			response.put("deleted", "false");
			response.put("message", "contrato no encontrada");
			return ResponseEntity.badRequest().body(response);
		}else{
			contratoRepo.delete(contrato.get());
			response.put("deleted", "true");
			response.put("message", "contrato "+ID+" eliminada");
			return ResponseEntity.ok().body(response);
		}
	}

	@DeleteMapping("/facturasContrato")
	public ResponseEntity deleteAllFacturaByContrato(@RequestParam Contrato contrato){
		return facturaService.deleteAllFacturaByContrato(contrato);
	}

}
