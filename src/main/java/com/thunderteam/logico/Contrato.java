package com.thunderteam.logico;
import lombok.Data;
import java.util.Date;

@Data
public class Banco{
    enum tipoContrato{ //does this work?
        TRADE,
        VENTA
    }

    private String ID_contrato;
    private Empleado vendedor; //solo se necesita el nombre
    private Cliente miCliente;
    private Banco miBanco;
    private Vehiculo vehiculoDealer;// vehiculo vendido
    private Vehiculo vehiculoCliente; //vehiculo intercambo

    private Date fecha;
    private Date plazoPago;
    private Date fechaEntrega;

    private String status; //Activo, Culminado
    private String matriculaExhibicion;
    private String placa;
    private tipoContrato tipo;
    
    
    private float precioVehiculo;
    private float diferencia;
}