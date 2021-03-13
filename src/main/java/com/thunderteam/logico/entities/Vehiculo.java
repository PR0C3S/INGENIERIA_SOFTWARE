package com.thunderteam.logico.entities;
import lombok.Data;
import javax.persistence.*;

/*import com.thunderteam.logico.entities.Anuncio.Estado;*/

import java.util.Date;

@Data
@Entity
@Table(name = "Vehiculos")
public class Vehiculo {

    public enum Condicion{
        Nuevo, Usado
    }
    public enum Estado{
        Disponible, Agotado, Espera
    }
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID_Vehiculo;

    @Column(nullable = false)
    private float kilometraje;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('Nuevo','Usado')")
    private Condicion condicion;

    //relacion con fotos
	/*
	 * @OneToMany(mappedBy = "vehiculo") private List<Imagen> imagen;
	 */
    
    //relacion con accesorios
	/*
	 * @OneToMany(mappedBy = "vehiculo") private List<Accesorio> accesorio;
	 */

    //relacion con version vehiculo
    @ManyToOne
    @JoinColumn(name = "ID_Version", nullable = false)
    private Version_Vehiculo version_vehiculo;

	/*
	 * @Id
	 * 
	 * @Column(name = "ID_TIPO") private int ID_TIPO;
	 * 
	 * //relacion con anuncio
	 * 
	 * @OneToOne
	 * 
	 * @MapsId
	 * 
	 * @JoinColumn(name = "ID_TIPO") private Anuncio anuncio;
	 */

	/*
	 * //relacion con form_intercambio
	 * 
	 * @OneToOne
	 * 
	 * @MapsId
	 * 
	 * @JoinColumn(name = "ID_TIPO") private FormIntercambio formIntercambio;
	 * 
	 */
    
    @Column(nullable = false)
    private Date fecha;

    @Column(nullable = false)
    private float precio;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('Disponible','Agotado','Espera')")
    private Estado estado; //Agotado/Disponible//En Espera

    @Column(nullable = false)
    private String descripcion;



}
