package com.thunderteam.logico.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Marcas_de_vehiculos")
@RequiredArgsConstructor
public class Marca_Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID_Marca;

    @Column(nullable = false)
    private String nombreMarca;

    //relacion con modelo_Vehiculo
    @OneToMany(mappedBy = "marcavehiculo")
    @JsonIgnore
    private List<Modelo_Vehiculo> modelo_vehiculo;

    public Marca_Vehiculo(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }
}
