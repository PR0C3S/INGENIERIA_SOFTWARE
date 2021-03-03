package com.thunderteam.logico.entities;

import lombok.Data;

@Data
public class Ubicacion {

    private String id_Ubicacion;
    private String calle;
    private String casa;
    private String provincia;
    private String municipio;

}
