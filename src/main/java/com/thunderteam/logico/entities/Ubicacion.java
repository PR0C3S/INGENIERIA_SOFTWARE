package com.thunderteam.logico.entities;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Ubicaciones")
@NoArgsConstructor
public class Ubicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID_Ubicacion;

    @Column(nullable = false)
    private String calle;

    @Column(nullable = false)
    private String casa;

    @Column
    private String apartamento;

    //relacion con sector
    @ManyToOne
    @JoinColumn(name = "ID_Sector", nullable = false)
    private Sector sector;

    public Ubicacion(String calle, String casa, String apartamento, Sector sector) {
        this.calle = calle;
        this.casa = casa;
        this.apartamento = apartamento;
        this.sector = sector;
    }
}
