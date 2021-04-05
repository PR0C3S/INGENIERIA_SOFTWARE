package com.thunderteam.logico.entities;

    import lombok.Data;
    import javax.persistence.*;
    import java.util.Date;
    import java.util.List;


@Data
@Entity
@Table(name = "Clientes")
public class Cliente {

    public enum Sexo{
        M, F
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID_Cliente;

    @Column(nullable = false)
    private String nombreCompleto;

    @Column
    private String telefono;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String celular;

    @Column(nullable = false)
    private String cedula;

    @Enumerated(EnumType.STRING)
	/* @Column(columnDefinition = "ENUM('M','F')") */
    private EnumSexo sexo;

    @Column(nullable = false)
    private Date fecha_Nacimiento;

    //relacion con ubicacion
    @ManyToOne
    @JoinColumn(name="ubicacion", referencedColumnName="ID_Ubicacion")
    private Ubicacion ubicacion;


    //relacion con contrato
    @OneToMany(mappedBy = "cliente")
    private List<Contrato> contrato;

}
