package com.thunderteam.logico.entities;

import lombok.Data;
import org.hibernate.annotations.Table;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Formulario_de_intercambios")
public class FormIntercambio extends Formulario{

    public enum YesNo{
        Si, No
    }

    @Column(nullable = false)
    private float calificacion;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('Si','No')")
    private YesNo rentado;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('Si','No')")
    private YesNo record_Reparaciones;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('Si','No')")
    private YesNo millero_Funciona;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('Si','No')")
    private YesNo funcionaAire;

    @Column(nullable = false)
    private String pregunta_Tecnica1;

    @Column(nullable = false)
    private String pregunta_Tecnica2;

    @Column(nullable = false)
    private String pregunta_Tecnica3;

    @Column(nullable = false)
    private String pregunta_Tecnica4;

    //relacion con vehiculo
    @OneToOne(mappedBy = "FormIntermcambio", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Vehiculo vehiculo;


}
