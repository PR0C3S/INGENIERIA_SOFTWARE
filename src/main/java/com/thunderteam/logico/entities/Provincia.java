package com.thunderteam.logico.entities;
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
    private int nombre;

    //relacion con municipio
    @OneToMany(mappedBy = "provincia")
    private List<Municipio> municipio;


}
