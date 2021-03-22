package com.thunderteam.logico.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Municipios")

public class Municipio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID_Municipio;

    @Column(nullable = false)
    private String nombre;


    //relacion con provincia
    @ManyToOne
    @JoinColumn(name = "ID_Provincia", nullable = false)
    private Provincia provincia;

    //relacion con sector
    @OneToMany(mappedBy = "municipio")
    @JsonIgnore
    private List<Sector> sector;



}
