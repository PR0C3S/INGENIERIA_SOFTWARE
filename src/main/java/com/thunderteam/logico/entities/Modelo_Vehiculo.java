package com.thunderteam.logico.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String nombreModelo;

    @Column(nullable = false)
    private int ano;

    //relacion con Tipo_Vehiculo
    @ManyToOne
    @JoinColumn(name = "ID_Tipo", nullable = false)
    private Tipo_Vehiculo tipovehiculo;

    //relacion con marca_Vehiculo
    @ManyToOne
    @JoinColumn(name = "ID_Marca", nullable = false)
    private Marca_Vehiculo marcavehiculo;

    //relacion con version_vehiculo
    @OneToMany(mappedBy = "modeloVehiculo")
    @JsonIgnore
    private List<Version_Vehiculo> version_vehiculo;

    public Modelo_Vehiculo(String nombre_Modelo, int ano, Tipo_Vehiculo tipo_vehiculo, Marca_Vehiculo marca_vehiculo) {
        this.nombreModelo = nombre_Modelo;
        this.ano = ano;
        this.tipovehiculo = tipo_vehiculo;
        this.marcavehiculo = marca_vehiculo;
    }
}
