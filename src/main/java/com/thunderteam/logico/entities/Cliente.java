package com.thunderteam.logico.entities;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Data
@Entity
@Table(name = "Clientes")
public class Cliente {

    public enum Sexo{
        M, F
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID_Cliente;

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

    //relacion con ubicacion
    @ManyToOne
    @JoinColumn(name="ubicacion", referencedColumnName="ID_Ubicacion")
    private Ubicacion ubicacion;


    //relacion con contrato
    @OneToMany(mappedBy = "cliente")
    private List<Contrato> contrato;

}
