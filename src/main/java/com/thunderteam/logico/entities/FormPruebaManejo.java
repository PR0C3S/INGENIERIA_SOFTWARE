package com.thunderteam.logico.entities;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.util.Date;

@Data
@Entity
@Table(name = "Formularios_prueba_de_manejo")
public class FormPruebaManejo extends Formulario{

    @Column(nullable = false)
    private Date fechaHora;


}