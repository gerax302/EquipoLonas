package RespaldarRestaurar;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conecta 
{

    static Connection con = null;
    private static final String usuario = Conexion.usuarioBD;
    private static final String clave = Conexion.contrasena;
    private static final String url = "jdbc:mysql://"+Conexion.nombreServidor+":"+Conexion.puerto+"/"+Conexion.nombreBD;

    public static Connection conectar() 
    {
        try 
        {
            //con = DriverManager.getConnection("jdbc:mysql://localhost/pruebas", "root", "root");
            con = DriverManager.getConnection(url, usuario, clave);
        } 
        catch (SQLException e) 
        {
            System.out.println("Error inesperado al establecer conexión:  "+e.getMessage());
        }
        return con;
    }

}
