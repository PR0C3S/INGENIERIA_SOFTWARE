package com.thunderteam.logico.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Modelos_de_vehiculos")
@NoArgsConstructor
@AllArgsConstructor
public class Modelo_Vehiculo {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String nombreModelo;
    //private int ID_Modelo;


    //relacion con marca_Vehiculo
    @ManyToOne
    @JoinColumn(name = "ID_Marca", nullable = false)
    private Marca_Vehiculo marcaVehiculo;

    //relacion con version_vehiculo
    @OneToMany(mappedBy = "modeloVehiculo")
    @JsonIgnore
    private List<Version_Vehiculo> versionVehiculo;

}
