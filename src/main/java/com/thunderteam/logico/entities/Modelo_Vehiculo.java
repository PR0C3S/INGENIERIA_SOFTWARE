package com.thunderteam.logico.entities;
import lombok.Data;
import org.hibernate.annotations.Table;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Modelos_de_vehiculos")

public class Modelo_Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID_Modelo;

    @Column(nullable = false)
    private String nombre_Modelo;

    @Column(nullable = false)
    private int ano;

    //relacion con Tipo_Vehiculo
    @ManyToOne
    @JoinColumn(name = "ID_Tipo", nullable = false)
    private Tipo_Vehiculo tipo_vehiculo;

    //relacion con version_vehiculo
    @OneToMany(mappedBy = "modelo_vehiculo")
    private List<Version_Vehiculo> version_vehiculo;


}
