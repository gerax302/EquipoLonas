package Usuarios;

import java.util.ArrayList;

public class Controlador {
    
     public ArrayList<Modelo> getAll()
     {
         return ConexionUsuarios.getUsuarios(Modelo.SELECT_ALL_NO_FOTO);
     }
     
     public int insertar(Modelo cl)
     {
        return ConexionUsuarios.grabarUsuario(cl);
     }
     
     public int actualizar(Modelo cl)
     {
        return ConexionUsuarios.actualizar(cl);
     }
     
     public int eliminar(Integer pk)
     {
        return ConexionUsuarios.eliminar(pk) ;
     }
}
