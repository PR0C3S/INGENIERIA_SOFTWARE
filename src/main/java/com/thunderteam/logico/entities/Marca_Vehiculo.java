package com.thunderteam.logico.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table
@RequiredArgsConstructor
public class Marca_Vehiculo {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    //private int ID_Marca;
    private String nombreMarca;

    //@Column(nullable = false)

    //relacion con modelo_Vehiculo
    @OneToMany(mappedBy = "nombreModelo")
    @JsonIgnore
    private List<Modelo_Vehiculo> modelo_vehiculo;

    public Marca_Vehiculo(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }
}