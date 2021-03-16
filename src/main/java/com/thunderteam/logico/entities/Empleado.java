package com.thunderteam.logico.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data 
@AllArgsConstructor 
@NoArgsConstructor
@Entity
@Table
public class Empleado {

    public enum Sexo{
        M, F
    }

    public enum Tipo{
        Gerente, Vendedor, Secretaria
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID_Empleado;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('Gerente','Vendedor','Secretaria')")
    private Tipo tipo; //Gerente, Vendedor o Secretaria

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

    @Column(nullable = true)
    private String cedula;

    @Column(nullable = true)
    private String celular;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('M','F')")
    private Sexo sexo;

    @Column(nullable = true)
    private Date fecha_Creacion;


    //relacion con ubicacion
/*    @ManyToOne
    @JoinColumn(name="ubicacion", referencedColumnName="ID_Ubicacion")
    private Ubicacion ubicacion;*/


    //relacion con Cuenta Bancaria
    @OneToOne(mappedBy = "empleado")
    private CuentaBancaria cuentaBancaria;

    //relacion con contrato
    @OneToMany(mappedBy = "empleado")
    private List<Contrato> contrato;



}