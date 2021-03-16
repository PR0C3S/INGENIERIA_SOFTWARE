package com.thunderteam.logico.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String nombreTipo;

    //relacion con modelo_Vehiculo
    @OneToMany(mappedBy = "tipovehiculo")
    @JsonIgnore
    private List<Modelo_Vehiculo> modelo_vehiculo;

    public Tipo_Vehiculo(String nombre_Tipo) {
        this.nombreTipo = nombre_Tipo;
    }
}
