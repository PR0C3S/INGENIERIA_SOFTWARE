package com.thunderteam.logico.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Date;
import java.util.List;

@Data 
@AllArgsConstructor 
@NoArgsConstructor
@Entity
@Table
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID_Empleado;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
//    @Column(columnDefinition = "ENUM('Gerente','Vendedor','Secretaria')")
    private EnumTipoEmpleado tipo; //Gerente, Vendedor o Secretaria

    @Column(nullable = false)
    private String nombreCompleto;

    @Column
    private String telefono;

    @Column(nullable = true)
    private String cedula;

    @Column(nullable = true)
    private String celular;

    @Enumerated(EnumType.STRING)
	/* @Column(columnDefinition = "ENUM('M','F')") */
    private EnumSexo sexo;

    @Enumerated(EnumType.STRING)
    //@Column(columnDefinition = "ENUM('Activado','Desahabilitado')")
    private EnumEstadoEmpleado estado;

    @Column(nullable = true)
    private Date fecha_Creacion= new Date();

    //relacion con ubicacion
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="ubicacion", referencedColumnName="ID_Ubicacion")
    @JsonManagedReference("emp")
    private Ubicacion ubicacion;


    /*//relacion con Cuenta Bancaria
    @OneToOne(mappedBy = "empleado")
    private CuentaBancaria cuentaBancaria;*/

    //relacion con contrato
    @OneToMany(mappedBy = "empleado")
    private List<Contrato> contrato;



}
