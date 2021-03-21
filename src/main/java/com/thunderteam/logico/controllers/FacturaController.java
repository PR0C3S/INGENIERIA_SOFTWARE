package com.thunderteam.logico.controllers;

import com.thunderteam.logico.entities.*;
import com.thunderteam.logico.services.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facturas")
public class FacturaController {

    @Autowired
    FacturaService facturaService;

    @GetMapping("/")
    public List<Factura> getAllFacturas(){return facturaService.getAll();}

    @GetMapping("/ID")
    public ResponseEntity getAllByIDContrato(@RequestParam int ID){
        return  facturaService.getFactura(ID);
    }

    @GetMapping("/contrato")
    public List<Factura> getAllByContrato(@RequestParam Contrato contrato){
        return facturaService.getAllByContrato(contrato);
    }

    @GetMapping("/IDandContrato")
    public List<Factura> getAllByFacturaAndContrato(@RequestParam Contrato contrato, @RequestParam int ID){
        return facturaService.findFacturaByFacturaAndContrato(contrato,ID);
    }

    @GetMapping("/factura")
    public ResponseEntity getFactura(@RequestParam int ID){
        return facturaService.getFactura(ID);
    }

    @PostMapping("/factura")
    public ResponseEntity postFactura(@RequestParam String nombre_Persona_Pago, @RequestParam Contrato contrato,
                                      @RequestParam Float monto){

        return facturaService.postFactura(nombre_Persona_Pago,contrato,monto);
    }

    @PutMapping("/factura")
    public ResponseEntity putFactura(@RequestParam int ID_Factura, @RequestParam String nombre_Persona_Pago,
                                     @RequestParam Contrato contrato, @RequestParam Float monto){
        return facturaService.updateFactura(ID_Factura, nombre_Persona_Pago,contrato,monto);
    }

    @DeleteMapping("/factura")
    public ResponseEntity deleteFactura(@RequestParam int ID){
        return facturaService.deleteFactura(ID);
    }

    @DeleteMapping("/facturabyContrato")
    public ResponseEntity deleteFacturaByContrato(@RequestParam Contrato contrato){
        return facturaService.deleteAllFacturaByContrato(contrato);
    }

}
