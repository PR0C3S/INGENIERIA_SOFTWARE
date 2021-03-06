package com.thunderteam.logico.entities;
import lombok.Data;
import org.hibernate.annotations.Table;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Accesorios_Vehiculos")

public class Accesorio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID_Accesorio;

    @Column(nullable = false)
    private String nombre;

    //relacion con vehiculo
    @ManyToOne
    @JoinColumn(name = "ID_Vehiculo", nullable = false)
    Vehiculo vehiculo;
}
