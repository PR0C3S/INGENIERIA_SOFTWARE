package com.thunderteam.logico.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "Clientes")
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID_Cliente;

    @Column(nullable = false)
    private String nombreCompleto;

    @Column
    private String telefono;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String celular;

    @Column(nullable = false)
    private String cedula;

    @Enumerated(EnumType.STRING)
	/* @Column(columnDefinition = "ENUM('M','F')") */
    private EnumSexo sexo;

    @Column(nullable = false)
    private Date fecha_Nacimiento;

    //relacion con ubicacion
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="ID_Ubicacion", referencedColumnName="ID_Ubicacion")
    @JsonManagedReference("cl")
    private Ubicacion ubicacion;


    //relacion con contrato
    @OneToMany(mappedBy = "cliente")
    private List<Contrato> contratos;
    
    
	/*
	 * public Ubicacion getUbicacion(){ return ubicacion; }
	 * 
	 * 
	 * public List<Contrato> getContratos(){ return contratos; }
	 */

}
