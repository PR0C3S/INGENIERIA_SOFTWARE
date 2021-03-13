package com.thunderteam.logico.entities;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Formulario_de_cotizaciones")
public class FormCotizacion extends Formulario{

    @Column(nullable = false)
    private float monto_Inicial;

    @Column(nullable = false)
    private int duracion_Prestamo;

    //relacion con cuotaBancaria
    @ManyToOne
    @JoinColumn(name="cuotasBancaria", referencedColumnName="ID_Cuotas")
    private CuotasBancaria cuotasBancaria;

}