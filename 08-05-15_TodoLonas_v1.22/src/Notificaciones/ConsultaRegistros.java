package Notificaciones;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Gerardo
 */
public class ConsultaRegistros 
{
    public static void buscaUrgentes()
    {
        Connection con = null;
        try 
        {
            int conteo = 0;
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://"+Conexion.nombreServidor+":"+Conexion.puerto+"/"+Conexion.nombreBD;
            con = DriverManager.getConnection(url, Conexion.usuarioBD, Conexion.contrasena);
            Statement st = con.createStatement();
            String est = "Urgente";
            String consulta = "select estatus from todolonas.pedidos where estatus ='" + est + "';";
            ResultSet rs = st.executeQuery(consulta);
            while(rs.next())
            {
                //System.out.println("NumeroPedido: " + rs.getInt("numeroPedido") +  rs.getString("estatus") +"   " );
                conteo++;
            }            
            if (conteo>0) {
                GeneraNotificaciones.porEstatus();
            }
        } 
        catch (ClassNotFoundException | SQLException e) 
        {
            System.out.println("Error al buscar pedidos urgentes: "+e.getMessage());
        }        
    }
    
    public static void buscaPedidosProximos()
    {
        Connection con = null;
        try 
        {
            int conteo = 0;
            boolean MenosDeTresDias = false;
            boolean yaPasoSuFecha = false;
            boolean todoBien = false;
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://"+Conexion.nombreServidor+":"+Conexion.puerto+"/"+Conexion.nombreBD;
            con = DriverManager.getConnection(url, Conexion.usuarioBD, Conexion.contrasena);
            Statement st = con.createStatement();
            String est = "Urgente";
            String consulta = "select numeroPedido, fechaEntrega from todolonas.pedidos ";
            ResultSet rs = st.executeQuery(consulta);
            //Recorremos el resultset obtenid
            while(rs.next())
            {
                System.out.println("NumeroPedido: " + rs.getInt("numeroPedido") +"   "+  rs.getString("fechaEntrega") +"   " );
                if ( ComparaFechas.diasDiferencia(rs.getString("fechaEntrega")) < 0)
                    yaPasoSuFecha=true;
                if ( ComparaFechas.diasDiferencia(rs.getString("fechaEntrega")) >1 &&  ComparaFechas.diasDiferencia(rs.getString("fechaEntrega")) <3)                   
                    MenosDeTresDias=true;
            }   
            if ( yaPasoSuFecha==false && MenosDeTresDias==false )
            {
                todoBien=true;
                GeneraNotificaciones.bien();
            }
            else
            {
                if (yaPasoSuFecha==true) 
                {
                    GeneraNotificaciones.retrasados();
                }
                if (MenosDeTresDias==true) 
                {
                    GeneraNotificaciones.porFecha();
                }
            }
        } 
        catch (ClassNotFoundException | SQLException e) 
        {
            System.out.println("Error al comparar fechas en pedidos: "+e.getMessage());
        }        
    }    
}
