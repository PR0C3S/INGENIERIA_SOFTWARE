package com.thunderteam.logico.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thunderteam.logico.entities.Contrato;

import java.util.Date;
import java.util.List;

public interface ContratoRepo extends JpaRepository<Contrato,Integer>
{
    List<Contrato> findContratoByFechaContains(Date fecha);
}
