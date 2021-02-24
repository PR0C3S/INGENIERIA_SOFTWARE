package com.thunderteam.logico.entities;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "CuentaBancaria")
public class CuentaBancaria {

    @Id
    private int numero_Cuenta;

    @Column(nullable = false)
    private String nombre_Banco;

    @Column(nullable = false)
    private String tipo_Cuenta;
}
