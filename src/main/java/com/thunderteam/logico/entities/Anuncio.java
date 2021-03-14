package com.thunderteam.logico.entities;
import lombok.Data;
import org.hibernate.annotations.Table;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Anuncios")

public class Anuncio {

    public enum Estado{
        Disponible, Agotado, Espera
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_Anuncio;

    @Column(nullable = false)
    private Date fecha;

    @Column(nullable = false)
    private float costo_Estimado;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('Disponible','Agotado','Espera')")
    private Estado estado; //Agotado/Disponible//En Espera

    @Column(nullable = false)
    private String descripcion;

    //relacion con vehiculo
    @OneToOne(mappedBy = "vehiculo", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Vehiculo vehiculo;


}
