package com.thunderteam.logico.entities;
import lombok.Data;
import org.hibernate.annotations.Table;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Marcas_de_vehiculos")

public class Marca_Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID_Marca;

    @Column(nullable = false)
    private String nombre_Marca;

    //relacion con Tipo_Vehiculo
    @OneToMany(mappedBy = "marca_vehiculo")
    private List<Tipo_Vehiculo> tipo_vehiculo;
}
