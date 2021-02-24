package com.thunderteam.logico.entities;

import lombok.Data;

@Data
public class Empleado {
    private String id_cuenta;
    private String email;
    private String password;
    private String tipo; //Gerente o empleado
    private String primer_Nombre;
    private String segundo_Nombre;
    private String primer_Apellido;
    private String segundo_Apellido;
    private String telefono;
    private String cedula;
    private String celular;
    private char sexo;


}
