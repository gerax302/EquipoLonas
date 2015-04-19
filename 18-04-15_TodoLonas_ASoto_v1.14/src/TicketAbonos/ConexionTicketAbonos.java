package TicketAbonos;

import Conexion.Conexion;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class ConexionTicketAbonos {
    
    private static Connection cn = null;
    private static Statement st = null;
    private static PreparedStatement ps = null;    
    private static ResultSet rs = null;
    
    private static final String servidor = Conexion.nombreServidor;
    private static String nombreBD = Conexion.nombreBD;
    private static String usuario = Conexion.usuarioBD;
    private static String clave = Conexion.contrasena;

    public static String getNombreBD() {
        return nombreBD;
    }
    public static void setNombreBD(String nombreBD) {
        ConexionTicketAbonos.nombreBD = nombreBD;
    }

    public static String getUsuario() {
        return usuario;
    }
    public static void setUsuario(String usuario) {
        ConexionTicketAbonos.usuario = usuario;
    }

    public static String getClave() {
        return clave;
    }
    public static void setClave(String clave) {
        ConexionTicketAbonos.clave = clave;
    }

    public static boolean conectar()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://"+servidor+":"+Conexion.puerto+"/"+nombreBD;
            cn = DriverManager.getConnection(url, usuario, clave);
            
        }
        catch(ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }        
        catch(SQLException ex)
        {
            String msg = "";
            if(ex.getErrorCode() == 1049)
            {
                msg = "La base de datos: "+nombreBD+" no existe.";
            }
            else if(ex.getErrorCode() == 1044)
            {
                msg = "El usuario: "+usuario+" no existe.";
            }
            else if(ex.getErrorCode() == 1045)
            {
                msg = "Contraseña incorrecta.";
            }
            else if(ex.getErrorCode() == 0){
                msg = "La conexion con la base de datos no se puede realizar.\nParece que el servidor de base de datos no esta activo.";
            }
            JOptionPane.showMessageDialog(null, msg, ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(cn != null) {
             System.out.println("ticket -> Conexion Exitosa.");
             return true;
        }
        return false;  
    }
}
