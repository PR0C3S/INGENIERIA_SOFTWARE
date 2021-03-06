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
    private Date fecha;

    @Column(nullable = false)
    private String comentario;


    //relacion con anuncio unidireccional
    @ManyToOne
    @JoinColumn(name="anuncio", referencedColumnName="ID_Anuncio")
    private Anuncio anuncio;


}
