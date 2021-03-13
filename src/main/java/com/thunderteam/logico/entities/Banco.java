package com.thunderteam.logico.entities;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Bancos")
public class Banco{

    @Id
    private String nombre_Banco ;

    @Column(nullable = false)
    private String email;

    //relacion con cuenta bancaria
    @OneToMany(mappedBy = "banco")
    private List<CuentaBancaria> cuentaBancaria;

    //relacion con cuotas
    @OneToMany(mappedBy = "banco")
    private List<CuentaBancaria> cuotasBancaria;
}