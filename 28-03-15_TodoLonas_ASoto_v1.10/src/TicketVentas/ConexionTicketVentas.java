package TicketVentas;

import Conexion.Conexion;
import java.sql.Connection;
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

public class ConexionTicketVentas {
    
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
        ConexionTicketVentas.nombreBD = nombreBD;
    }

    public static String getUsuario() {
        return usuario;
    }
    public static void setUsuario(String usuario) {
        ConexionTicketVentas.usuario = usuario;
    }

    public static String getClave() {
        return clave;
    }
    public static void setClave(String clave) {
        ConexionTicketVentas.clave = clave;
    }
  
    String url = "jdbc:mysql://"+servidor+":"+Conexion.puerto+"/"+nombreBD;


    public Connection conectar()
    {
        Connection link = null;
        try{
            try{
                Class.forName("com.mysql.jdbc.Driver");
            }catch(ClassNotFoundException ex){
                
            }
                link = (Connection) DriverManager.getConnection(this.url, this.usuario, this.clave);

        }catch(SQLException ex){
        
            clave=clave;
            try{
            link = (Connection) DriverManager.getConnection(this.url, this.usuario, this.clave);
            }catch(SQLException e){
            }
        } 
        return link;
    }        
}
