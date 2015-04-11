package Clientes;

import Clientes.ConexionCliente;
import java.util.ArrayList;

public class Controlador {
    
     public ArrayList<Modelo> getCli()
     {
         return ConexionCliente.getClientes(Modelo.SELECT_ALL_NO_FOTO);
     }
     
     public int insertarCli(Modelo cl)
     {
        return ConexionCliente.grabarCliente(cl);
     }
     
     public int actualizar(Modelo cl)
     {
        return ConexionCliente.actualizarCliente(cl);
     }
     
     public int eliminarCli(Integer pk)
     {
        return ConexionCliente.eliimnarCliente(pk) ;
     }
}
