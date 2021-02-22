package com.thunderteam.logico;
import lombok.Data;

@Data
public class FormCotizacion{
    private int cuotas ;
    private Banco nombreBanco;
    private Vehiculo miVehiculo;
    private int montoInicial;
    private int duracionPrestamo;
}