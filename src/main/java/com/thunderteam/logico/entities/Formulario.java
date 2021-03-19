package com.thunderteam.logico.entities;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class Formulario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID_Form;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String correo;

    @Column(nullable = false)
    private String celular;

    @Column(nullable = false)
    private Date fecha = new Date();

    @Column(nullable = false)
    private String comentario;


    //relacion con vehiculo unidireccional
    @ManyToOne
    @JoinColumn(name="vehiculo", referencedColumnName="ID_Vehiculo")
    private Vehiculo vehiculo;


}
