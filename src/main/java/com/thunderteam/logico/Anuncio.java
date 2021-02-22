package com.thunderteam.logico;

import lombok.Data;

import java.util.Date;


@Data
public class Anuncio {

    private String id_Anuncio;
    private Vehiculo miVehiculo;
    private Date fecha;
    private float costo_Estimado;
    private String estado; //Agotado/Disponible//En Espera
    private String descripcion;


}
