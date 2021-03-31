package com.thunderteam.logico.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Versiones_de_vehiculos")
@RequiredArgsConstructor
public class Version_Vehiculo {

	/*
	 * public enum Traccion{ Front_Wheel_Drive, Rear_Wheel_Drive, All_Wheel_Drive,
	 * Four_Wheel_Drive, Four_By_Four }
	 */

	/*
	 * public enum Combustible { GASOLINA, GLP, GASOIL, GAS_NATURAL, ELECTRICIDAD }
	 * 
	 * public enum Transmision{
	 * Manual,Automatizadas_Secuenciales,CVT,Automatizada_Doble_Embrague }
	 */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID_Version;

    @Column(nullable = false)
    private String nombreVersion;

    @Column(nullable = false)
    private String color_Exterior;

    @Column(nullable = false)
    private String color_Interior;

    @Column(nullable = false)
    private int puertas;

    @Column(nullable = false)
    private int pasajeros;

    @Column(nullable = false)
    private String motor;

    @Enumerated(EnumType.STRING)
    //@Column(columnDefinition = "ENUM('GASOLINA','GLP','GASOIL','GAS_NATURAL','ELECTRICIDAD')")
    private EnumCombustible combustible; //GASOLINA-GLP-GASOIL-GAS_NATURAL- ELECTRICIDAD

    @Enumerated(EnumType.STRING)
    //@Column(columnDefinition = "ENUM('Manual','Automatizadas_Secuenciales','CVT','Automatizada_Doble_Embrague')")
    private EnumTransmision transmision; //MANUAL-Automatizadas o secuenciales-Automático-CVT-Automatizada de doble embrague

    @Enumerated(EnumType.STRING)
    //@Column(columnDefinition = "ENUM('Front_Wheel_Drive','Rear_Wheel_Drive','All_Wheel_Drive','Four_Wheel_Drive','Four_By_Four')")
    private EnumTraccion traccion; //FWD-RWD-AWD-4WD-4X4


    //relacion con Modelo_vehiculo
    @ManyToOne
    @JoinColumn(name = "ID_Modelo", nullable = false)
    private Modelo_Vehiculo modeloVehiculo;

    //relacion con Vehiculo
    @OneToMany(mappedBy = "version_vehiculo")
    @JsonIgnore
    private List<Vehiculo> vehiculo;

    public Version_Vehiculo(String nombreVersion, String color_Exterior, String color_Interior,
                            int puertas, int pasajeros, String motor, EnumCombustible combustible,
                            EnumTransmision transmision, EnumTraccion traccion, Modelo_Vehiculo modeloVehiculo) {
        this.nombreVersion = nombreVersion;
        this.color_Exterior = color_Exterior;
        this.color_Interior = color_Interior;
        this.puertas = puertas;
        this.pasajeros = pasajeros;
        this.motor = motor;
        this.combustible = combustible;
        this.transmision = transmision;
        this.traccion = traccion;
        this.modeloVehiculo = modeloVehiculo;
    }
}
