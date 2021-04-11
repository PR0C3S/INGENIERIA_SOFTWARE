package com.thunderteam.logico.entities;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "Sectores")
@NoArgsConstructor
@AllArgsConstructor
public class Sector {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private String nombreSector;

//    @Column(nullable = false)
//    private String nombre;

    //relacion con municipio
    @ManyToOne
    @JoinColumn(name = "nombreMunicipio", nullable = false)
    private Municipio nombreMunicipio;

    //relacion con ubicacion
	/*
	 * @OneToMany(mappedBy = "sector")
	 * 
	 * @JsonIgnore private List<Ubicacion> ubicacion;
	 * 
	 * public Sector(String nombre, Municipio municipio) { this.nombreSector =
	 * nombre; this.municipio = municipio; }
	 */
}
