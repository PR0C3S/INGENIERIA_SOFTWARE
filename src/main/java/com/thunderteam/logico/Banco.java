package com.thunderteam.logico;
import lombok.Data;

@Data
public class Banco{
    private String nombre ;
    private String email;
    private String telefono;
    private ArrayList<int> cuotas;
    private ArrayList<float> intereses;
}