package com.thunderteam.logico.entities;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Tipos_de_vehiculos")

public class Tipo_Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID_Tipo;

    @Column(nullable = false)
    private String nombre_Tipo;

    //relacion con marca_Vehiculo
    @ManyToOne
    @JoinColumn(name = "ID_Marca", nullable = false)
    private Marca_Vehiculo marca_vehiculo;

    //relacion con modelo_Vehiculo
    @OneToMany(mappedBy = "tipo_vehiculo")
    private List<Modelo_Vehiculo> modelo_vehiculo;


}
