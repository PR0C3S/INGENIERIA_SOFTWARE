package com.thunderteam.logico.entities;
import lombok.Data;
import org.hibernate.annotations.Table;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Sectores")
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
    private List<Ubicacion> ubicacion;

}
