package Notificaciones;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 * @author Gerardo
 */
public class ConsultaRegistros 
{
    public void cargarAjustes()
    {
        Connection con = null;
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://"+Conexion.nombreServidor+":"+Conexion.puerto+"/"+Conexion.nombreBD;
            con = DriverManager.getConnection(url, Conexion.usuarioBD, Conexion.contrasena);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from ajustes");
            while(rs.next())
            {
                //Para poner en cajas editables
                //cajaNombreDueno.setText(rs.getString("nombre"));
            }            
        } 
        catch (ClassNotFoundException | SQLException e) 
        {
            System.out.println("Error: "+e.getMessage());
        }        
    }
    
    public void actualiza()
    {
        Connection con = null;
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://"+Conexion.nombreServidor+":"+Conexion.puerto+"/"+Conexion.nombreBD;
            con = DriverManager.getConnection(url, Conexion.usuarioBD, Conexion.contrasena);
            String query = "UPDATE  ajustes SET "+
            "nombre = ? ,           leyendaCotizacion = ?,          RFC = ?, "+
            "domicilioNegocio = ?,  correoNegocio = ?,              numeroCelular = ?, "+
            "telefonoNegocio = ?,   descuentoPersonasFisicas = ?,   descuentoInstitucionesPublicas = ?, "+
            "descuentoEmpresa = ?,  descuentoClienteGeneral = ?, iva = ?, colonia=? where pk =1";
            PreparedStatement ps;
            ps = con.prepareStatement(query);
            //ps.setString(1, cajaNombreDueno.getText());
            //ps.setString(2, cajaCotizacion.getText());
            ps.executeUpdate();            
            //rsu=ps.executeUpdate();            
            if(ps.executeUpdate() == 1)
                JOptionPane.showMessageDialog(null, "Operación Exitosa", "Mensaje:", JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(null, "Operación Fallida", "Mensaje:", JOptionPane.ERROR_MESSAGE);
            cargarAjustes();
            con.close();
        } 
        catch (ClassNotFoundException | SQLException e) 
        {
            System.out.println("Error: "+e.getMessage());
        }        
    }    
}
