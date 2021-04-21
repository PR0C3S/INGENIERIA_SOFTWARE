package com.thunderteam.logico.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
public class Formulario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int ID_Form;

    @Column(nullable = false)
    protected String nombre;

    @Column(nullable = false)
    protected String correo;

    @Column(nullable = false)
    protected String celular;

    @Column(nullable = false)
    protected Date fecha = new Date();

    @Column(nullable = false)
    protected String comentario;


    //relacion con vehiculo unidireccional
    @ManyToOne
    @JoinColumn(name="vehiculo", referencedColumnName="ID_Vehiculo")
    protected Vehiculo vehiculo;


}
