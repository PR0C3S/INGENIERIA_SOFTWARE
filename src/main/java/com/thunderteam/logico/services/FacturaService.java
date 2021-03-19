package com.thunderteam.logico.services;

import com.thunderteam.logico.entities.Contrato;
import com.thunderteam.logico.entities.Factura;
import com.thunderteam.logico.repositorios.FacturaRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class FacturaService {

    private final FacturaRepo facturaRepo;

    // Buscar todas las facturas
    public List<Factura> getAll() {
        return (List<Factura>) facturaRepo.findAll();
    }

    // Buscar una factura por su id
    public ResponseEntity getFactura(int ID_Factura) {
        Map<String, String> response = new HashMap<>();
        Optional<Factura> factura = facturaRepo.findById(ID_Factura);

        if (factura.isPresent()){
            response.put("found", "false");
            response.put("message", "Factura no encontrada");
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.ok().body(ID_Factura);
    }

    // Guardar una factura
    public ResponseEntity postFactura(String nombre_Persona_Pago, Contrato contrato, Float monto){
        Map<String, String> response = new HashMap<>();

        Factura nuevaFactura = new Factura();
        nuevaFactura.setContrato(contrato);
        nuevaFactura.setNombre_Persona_Pago(nombre_Persona_Pago);
        nuevaFactura.setMonto(monto);
        facturaRepo.save(nuevaFactura);
        return  ResponseEntity.ok().body(nuevaFactura);
    }

    // Actualizar una factura
    public ResponseEntity updateFactura(int ID_Factura, String nombre_Persona_Pago, Contrato contrato, Float monto){
        Map<String, String> response = new HashMap<>();
        Optional<Factura> factura = facturaRepo.findById(ID_Factura);

        if (factura.isEmpty()){
            response.put("found", "false");
            response.put("message", "Factura no encontrada");
            return ResponseEntity.badRequest().body(response);
        }

        Factura oldFactura = new Factura();
        oldFactura.setID_Factura(ID_Factura);
        oldFactura.setFecha(factura.get().getFecha());
        oldFactura.setContrato(contrato);
        oldFactura.setNombre_Persona_Pago(nombre_Persona_Pago);
        oldFactura.setMonto(monto);
        facturaRepo.save(oldFactura);
        return  ResponseEntity.ok().body(oldFactura);
    }

    // Eliminar una factura
    public ResponseEntity deleteFactura(int ID){
        Map<String, String> response = new HashMap<>();
        Optional<Factura> factura = facturaRepo.findById(ID);

        if(!factura.isPresent()){
            response.put("deleted", "false");
            response.put("message", "factura no encontrada");
            return ResponseEntity.badRequest().body(response);
        }else{
            facturaRepo.delete(factura.get());
            response.put("deleted", "true");
            response.put("message", "factura "+ID+" eliminada");
            return ResponseEntity.ok().body(response);
        }
    }

    public ResponseEntity deleteAllFacturaByContrato(Contrato contrato){
        Map<String, String> response = new HashMap<>();
        List<Factura> factura = facturaRepo.findFacturaByContrato(contrato);

        if(factura.isEmpty()){
            response.put("deleted", "false");
            response.put("message", "contrato no encontrado");
            return ResponseEntity.badRequest().body(response);
        }else{
            facturaRepo.deleteAll(factura);
            response.put("deleted", "true");
            response.put("message", "factura relacionada con el "+contrato.getID_Contrato()+" eliminadas");
            return ResponseEntity.ok().body(response);
        }
    }

    public List<Factura> getAllByContrato(Contrato contrato) {
        return(facturaRepo.findFacturaByContrato(contrato));
    }

    public  List<Factura> findFacturaByFacturaAndContrato(Contrato contrato, int ID) {
        return(facturaRepo.findFacturaByFacturaAndContrato(contrato,ID));
    }
}

