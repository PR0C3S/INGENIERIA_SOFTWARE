package com.thunderteam.logico.entities;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@Table(name = "Facturas")
public class Factura{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int IDFactura;

    @Column(nullable = false)
    private Date fecha= new Date();

    @Column(nullable = false)
    private String nombre_Persona_Pago;

    @Column(nullable = false)
    private float monto;


    //relacion con contrato
    @ManyToOne
    @JoinColumn(name="ID_Contrato", nullable=false)
    private Contrato contrato;



}
