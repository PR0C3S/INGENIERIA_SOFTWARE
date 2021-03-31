package com.thunderteam.logico.entities;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@Table(name = "formularios_prueba_de_manejo")
public class FormPruebaManejo extends Formulario{

    @Column(nullable = false)
    private Date fechaHora;


}