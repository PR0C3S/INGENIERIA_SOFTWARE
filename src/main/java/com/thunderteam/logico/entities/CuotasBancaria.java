package com.thunderteam.logico.entities;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "Cuotas_Bancarias")

public class CuotasBancaria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID_Cuotas;

    @Column(nullable = false)
    private float intereses;

    @Column(nullable = false)
    private int cuotas;

    //relacion con banco
    @ManyToOne
    @JoinColumn(name = "nombre_Banco", nullable = false)
    private Banco banco;

}
