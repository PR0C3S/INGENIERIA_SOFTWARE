package com.thunderteam.logico.entities;
import lombok.Data;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Data
@Entity
@Table(name = "Formularios_prueba_de_manejo")
public class FormPruebaManejo extends Formulario{

    @Column(nullable = false)
    private Date fechaHora;


}