package com.thunderteam.logico.entities;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Formularios_de_oferta")

public class FormOferta extends Formulario{

    public enum Financiado{
        Si, No
    }

    @Column(nullable = false)
    private float monto_Ofrecido;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('Si','No')")
    private Financiado financiado;

}
