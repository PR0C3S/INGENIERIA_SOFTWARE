package com.thunderteam.mvcdemo.entities;

import com.sun.istack.NotNull;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@Table(name = "Clients")
public class Client {

    public enum Sexo{
        M, F
    }

    @Id
    @NotNull
    private String ID_Cliente;

    @Column(nullable = false)
    private String primer_Nombre;

    @Column
    private String segundo_Nombre;

    @Column(nullable = false)
    private String primer_Apellido;

    @Column
    private String segundo_Apellido;

    @Column
    private String telefono;

    @Column(nullable = false)
    private String celular;

    @Column(nullable = false)
    private String cedula;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('M','F')")
    private Sexo sexo;

    @Column(nullable = false)
    private Date fecha_Nacimiento;


}
