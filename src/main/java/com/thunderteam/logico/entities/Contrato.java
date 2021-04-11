package com.thunderteam.logico.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "Contratos")
@NoArgsConstructor
@AllArgsConstructor
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID_Contrato;

    @Column(nullable = false)
        private Date fecha = new Date();

    @Column(nullable = false)
    private Date plazo_Pago;

    @Column(nullable = false)
    private Date fecha_Entrega;

    @Enumerated(EnumType.STRING)
//    @Column(columnDefinition = "ENUM('Activo','Culminado')")
    private EnumEstadoContrato status; //Activo, Culminado


    @Enumerated(EnumType.STRING)
    //@Column(columnDefinition = "ENUM('Intercambio','Venta')")
    private EnumTipoContrato tipo; // Intercambio, Venta

    @Column(nullable = false)
    private float precio_Vehiculo;

    @Column(nullable = false)
    private float diferencia;


    //relacion con factura
    @OneToMany(mappedBy="contrato")
    private List<Factura> factura;

    //relacion con cliente
    @ManyToOne
    @JoinColumn(name="ID_Cliente", nullable=false)
    private Cliente cliente;

    //relacion con empleado
    @ManyToOne
    @JoinColumn(name="ID_Empleado", nullable=false)
    private Empleado empleado;


    //relacion con anuncio
    @ManyToOne
    @JoinColumn(name="vehiculo", referencedColumnName="ID_Vehiculo", nullable=false)
    private Vehiculo vehiculo;

    //relacion con vehiculo_cliente
    @OneToOne
    private Vehiculo vehiculoCliente;

}
