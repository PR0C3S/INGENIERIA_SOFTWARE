package com.thunderteam.logico.entities;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Getter
@Setter
@Table(name = "Ubicaciones")
@NoArgsConstructor
@AllArgsConstructor
public class Ubicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID_Ubicacion;

    @Column(nullable = false)
    private String calle;

    @Column(nullable = false)
    private String casa;

    @ManyToOne
    @JoinColumn(name = "nombreSector", nullable = true)
    private Sector sector;
    
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "ubicacion")
    @JoinColumn(name = "ID_Cliente", nullable = true)
    @JsonBackReference("cl")
    private Cliente cliente;


	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "ubicacion")
	@JoinColumn(name = "ID_Empleado", nullable = true)
	@JsonBackReference("emp") 
	private Empleado empleado;
	 
    
	/*
	 * public Cliente getCliente() { return cliente; }
	 * 
	 * 
	 * public Sector getSector() { return sector; }
	 */
    

	/*
	 * public Ubicacion(String calle, String casa, String apartamento, Sector
	 * sector) { this.calle = calle; this.casa = casa; this.apartamento =
	 * apartamento; this.sector = sector; }
	 */
}
