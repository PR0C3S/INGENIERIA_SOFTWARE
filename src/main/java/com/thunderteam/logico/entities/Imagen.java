package com.thunderteam.logico.entities;
import lombok.Data;
import org.hibernate.annotations.Table;

import javax.persistence.*;
import java.awt.*;
import java.util.List;

@Data
@Entity
@Table(name = "Imagenes_de_vehiculos")

public class Imagen {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID_Imagen;

    @Column(nullable = false)
    private Image foto;

    //relacion con vehiculo
    @ManyToOne
    @JoinColumn(name = "ID_Vehiculo", nullable = false)
    Vehiculo vehiculo;

}
