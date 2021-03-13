package com.thunderteam.logico.entities;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Facturas")
public class Factura{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID_Factura;

    @Column(nullable = false)
    private Date fecha;

    @Column(nullable = false)
    private float monto;


    //relacion con contrato
    @ManyToOne
    @JoinColumn(name="ID_Contrato", nullable=false)
    private Contrato contrato;


}
