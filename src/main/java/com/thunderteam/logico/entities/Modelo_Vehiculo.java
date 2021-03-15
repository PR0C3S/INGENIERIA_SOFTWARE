package com.thunderteam.logico.entities;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Modelos_de_vehiculos")
@RequiredArgsConstructor
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

    //relacion con marca_Vehiculo
    @ManyToOne
    @JoinColumn(name = "ID_Marca", nullable = false)
    private Marca_Vehiculo marca_vehiculo;

    //relacion con version_vehiculo
    @OneToMany(mappedBy = "modelo_vehiculo")
    private List<Version_Vehiculo> version_vehiculo;

    public Modelo_Vehiculo(String nombre_Modelo, int ano, Tipo_Vehiculo tipo_vehiculo, Marca_Vehiculo marca_vehiculo) {
        this.nombre_Modelo = nombre_Modelo;
        this.ano = ano;
        this.tipo_vehiculo = tipo_vehiculo;
        this.marca_vehiculo = marca_vehiculo;
    }
}
