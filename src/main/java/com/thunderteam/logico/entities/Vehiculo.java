package com.thunderteam.logico.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Vehiculos")
@NoArgsConstructor
@AllArgsConstructor
public class Vehiculo {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID_Vehiculo;

    @Column(nullable = false)
    private int kilometraje;

    @Column(nullable = false)
    private String accesorios;
    
    @Column(nullable = false)
    private int ano;

    @Enumerated(EnumType.STRING)
    //@Column(columnDefinition = "ENUM('Nuevo','Usado')")
    private EnumCondicionVehiculo condicion;
    
    @Column(nullable = false)
    private String color_Exterior;

    @Column(nullable = false)
    private String color_Interior;
    
    @Column(nullable = false)
    private float precio;
    
    @Enumerated(EnumType.STRING)
    //@Column(columnDefinition = "ENUM('Disponible','Agotado','Espera')")
    private EnumEstadoVehiculo estado; //Agotado/Disponible//En Espera
    

    @Column(nullable = false)
    private String descripcion;

    //relacion con fotos
	/*
	 * @OneToMany(mappedBy = "vehiculo") private List<Imagen> imagen;
	 */
    
    //relacion con version vehiculo
    @ManyToOne
    @JoinColumn(name = "ID_Version", nullable = false)
    private Version_Vehiculo versionVehiculo;
    
    //@Lob
    //@Column(columnDefinition = "MEDIUMBLOB")
    //private String imagen;
	/*
	 * //relacion con form_intercambio
	 * 
	 * @OneToOne
	 * 
	 * @MapsId
	 * 
	 * @JoinColumn(name = "ID_TIPO") private FormIntercambio formIntercambio;
	 * 
	 */
    
    @Column(nullable = false)
    private Date fecha = new Date();

    




}
