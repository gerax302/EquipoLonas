package Productos;

import Productos.ConexionProducto;
import java.util.ArrayList;

public class Controlador {
    
     public ArrayList<Modelo> getProductos()
     {
         return ConexionProducto.getProductos(Modelo.SELECT_ALL_NO_FOTO);
     }
     
     public int insertarProductos(Modelo cl)
     {
        return ConexionProducto.grabarProducto(cl);
     }
     
     public int actualizar(Modelo cl)
     {
        return ConexionProducto.actualizar(cl);
     }
     
     public int eliminarProducto(Integer pk)
     {
        return ConexionProducto.eliminarProducto(pk) ;
     }     
}
