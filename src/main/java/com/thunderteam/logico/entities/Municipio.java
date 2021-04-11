package com.thunderteam.logico.entities;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Municipios")
public class Municipio {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private String nombreMunicipio;

//    @Column(nullable = false)
//    private String nombre;


    //relacion con provincia
    @ManyToOne
    @JoinColumn(name = "nombreProvincia", nullable = false)
    private Provincia nombreProvincia;

    //relacion con sector
	/*
	 * @OneToMany(mappedBy = "municipio")
	 * 
	 * @JsonIgnore private List<Sector> sector;
	 */



}
