package com.thunderteam.logico.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Versiones_de_vehiculos")
@RequiredArgsConstructor
public class Version_Vehiculo {

    @Id
    private String nombreVersion;
    //@GeneratedValue(strategy = GenerationType.AUTO)
    //private int ID_Version;

    //@Column(nullable = false)
    

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
    private EnumTraccion traccion; 
    
    @Enumerated(EnumType.STRING)
    private EnumTipoVehiculo tipo;


    //relacion con Modelo_vehiculo
    @ManyToOne
    @JoinColumn(name = "ID_Modelo", nullable = false)
    private Modelo_Vehiculo modeloVehiculo;

    //relacion con Vehiculo
    @OneToMany(mappedBy = "versionVehiculo")
    @JsonIgnore
    private List<Vehiculo> vehiculo;

}
