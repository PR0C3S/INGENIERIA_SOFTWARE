package com.thunderteam.logico.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Provincias")
public class Provincia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID_Provincia;


    @Column(nullable = false)
    private String nombre;

    //relacion con municipio
    @OneToMany(mappedBy = "provincia")
    @JsonIgnore
    private List<Municipio> municipio;


}
