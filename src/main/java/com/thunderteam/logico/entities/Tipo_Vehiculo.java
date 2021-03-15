package com.thunderteam.logico.entities;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Tipos_de_vehiculos")
@RequiredArgsConstructor
public class Tipo_Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID_Tipo;

    @Column(nullable = false)
    private String nombre_Tipo;

    //relacion con modelo_Vehiculo
    @OneToMany(mappedBy = "tipo_vehiculo")
    private List<Modelo_Vehiculo> modelo_vehiculo;

    public Tipo_Vehiculo(String nombre_Tipo) {
        this.nombre_Tipo = nombre_Tipo;
    }
}
