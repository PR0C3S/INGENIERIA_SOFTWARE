package com.thunderteam.logico.repositorios;

import com.thunderteam.logico.entities.*;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface FacturaRepo extends CrudRepository<Factura,Integer> {

    List<Factura> findFacturaByFechaContains(Date fecha);
    List<Factura> findFacturaByContrato(Contrato contrato);
    List<Factura> findFacturaByFacturaAndContrato(Contrato contrato, int ID);

}
