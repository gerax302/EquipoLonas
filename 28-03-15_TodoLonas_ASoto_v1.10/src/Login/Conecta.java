package Login;
import Conexion.Conexion;
import java.sql.*;

public class Conecta
{
    public String bd = Conexion.nombreBD;
    public String login = Conexion.usuarioBD;
    public String password = Conexion.contrasena;
    public String url = "jdbc:mysql://"+Conexion.nombreServidor+":"+Conexion.puerto+"/"+Conexion.nombreBD;

    public Statement conectar() 
    {
        Connection conn = null;
        Statement st = null;
        try 
        {
            Class.forName("org.gjt.mm.mysql.Driver");
            conn = DriverManager.getConnection(url, login, password);
            if (conn != null) 
            {
                System.out.println("Yeah, hemos conectado con  " + url + " ... Ok");
                st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            }
        }
        catch (SQLException ex) 
        {
            System.out.println("Rayos!!! Hubo un problema al conectar con la base " + url);
        } 
        catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return st;
    }
}
