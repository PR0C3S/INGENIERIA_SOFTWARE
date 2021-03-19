package com.thunderteam.logico.entities;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "Ubicaciones")
public class Ubicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID_Ubicacion;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String calle;

    @Column(nullable = false)
    private String casa;

    //relacion con sector
    @ManyToOne
    @JoinColumn(name = "ID_Sector", nullable = false)
    private Sector sector;

}
