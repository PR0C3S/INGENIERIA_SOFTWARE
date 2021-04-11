package com.thunderteam.logico.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Provincias")
public class Provincia {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private String nombreProvincia;


//    @Column(nullable = false)
//    private String nombre;

    //relacion con municipio
	/*
	 * @OneToMany(mappedBy = "provincia")
	 * 
	 * @JsonIgnore private List<Municipio> municipio;
	 */


}
