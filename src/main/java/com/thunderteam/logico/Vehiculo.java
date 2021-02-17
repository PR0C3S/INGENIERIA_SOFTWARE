package com.thunderteam.logico;

import lombok.Data;

import java.awt.*;

@Data
public class Vehiculo {
    private String id_Vehiculo;
    private String marca;
    private String modelo;
    private int ano;
    private String color_Exterior;
    private String color_Interior;
    private int puertas;
    private int pasajeros;
    private String motor;
    private String combustible; //GASOLINA-GLP-GASOIL-GAS NATURAL- ELECTRICIDAD
    private String transmision; //MANUAL-Automatizadas o secuenciales-Automático-CVT-Automatizada de doble embrague
    private String traccion; //FWD-RWD-AWD-4WD-4X4
    private float kilometraje;
    private Image[] fotos;
    private String [] accesorios;
}
