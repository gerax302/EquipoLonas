package Proveedores;

import Proveedores.ConexionProveedor;
import java.util.ArrayList;

public class Controlador {
    
     public ArrayList<Modelo> getProv()
     {
         return ConexionProveedor.getProveedores(Modelo.SELECT_ALL_NO_FOTO);
     }
     
     public int insertarProv(Modelo cl)
     {
        return ConexionProveedor.grabarProveedor(cl);
     }
     
     public int actualizar(Modelo cl)
     {
        return ConexionProveedor.actualizarProveedor(cl);
     }
     
     public int eliminarProv(Integer pk)
     {
        return ConexionProveedor.eliimnarProveedor(pk) ;
     }
}
