package com.thunderteam.logico.entities;

import lombok.Data;
import javax.persistence.*;


@Data
@Entity
@Table(name = "Cuentas_Bancarias")
public class CuentaBancaria {

    @Id
    private int numero_Cuenta;

/*    @Column(nullable = false)
    private String nombre_Banco;*/

    @Column(nullable = false)
    private String tipo_Cuenta;

    //relacion con banco
    @ManyToOne
    @JoinColumn(name = "nombre_Banco", nullable = false)
    private Banco banco;

    //relacion con empleado
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_Empleado", referencedColumnName = "ID_Empleado")
    private Empleado empleado;


}
