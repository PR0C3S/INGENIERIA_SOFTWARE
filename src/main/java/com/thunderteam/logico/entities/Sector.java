package com.thunderteam.logico.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Sectores")
@NoArgsConstructor
@AllArgsConstructor
public class Sector {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID_Sector;

    @Column(nullable = false)
    private String nombre;

    //relacion con municipio
    @ManyToOne
    @JoinColumn(name = "ID_Municipio", nullable = false)
    private Municipio municipio;

    //relacion con ubicacion
    @OneToMany(mappedBy = "sector")
    @JsonIgnore
    private List<Ubicacion> ubicacion;

    public Sector(String nombre, Municipio municipio) {
        this.nombre = nombre;
        this.municipio = municipio;
    }
}
