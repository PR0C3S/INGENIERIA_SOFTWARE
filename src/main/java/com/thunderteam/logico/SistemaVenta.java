package com.thunderteam.logico; //hay que importar las mismas librerias en todos los archivos o se puede generalizar de alguna manera?
import lombok.Data;
import java.util.Date;

@Data
public class SistemaVenta{
    private ArrayList<Empleado> listaEmpleados;
    private ArrayList<Formulario> formularios;
    private ArrayList<Contrato> contratos;
    private ArrayList<Factura> facturas;
    private ArrayList<Banco> bancos;
    private ArrayList<Anuncio> anuncios;
    private ArrayList<Cliente> clientes;
    private Ubicacion ubicacion;

    public void registrarUsuario(){
    }

    public void crearUsuario(){
    }
    public void modificarPublicacion(){
    }
    public void modificarUsuario(){
    }
    public void modificarCuenta(){
    }  
    public Usuario comprarPublicacion(){ //wtf is this
        //return Usuario
    }
    public void buscarDealerPor_ID(){//  ? esta funcion iria en una clase que contenga esta, habria que cambiar los nombres(esta se llamaria Dealer y la contenedora (que tiene una lista de dealers) SistemaVenta), o mejor dejar que el sistema sea un solo dealer.
        //return Dealer
    }
    public void buscarPublicacion_ID(){
        //return Publicacion
    }
    public void filtrarPublicacionVehiculo(){
        //return ArrayList<Publicacion>
    }
    public void eliminarPublicacion(){
    }

}