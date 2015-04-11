package Usuarios;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ConexionUsuarios {
    
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
        ConexionUsuarios.nombreBD = nombreBD;
    }

    public static String getUsuario() {
        return usuario;
    }
    public static void setUsuario(String usuario) {
        ConexionUsuarios.usuario = usuario;
    }

    public static String getClave() {
        return clave;
    }
    public static void setClave(String clave) {
        ConexionUsuarios.clave = clave;
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
                msg = "La coneccion con la base de datos no se puede realizar.\nParece que el servidor de base de datos no esta activo.";
            }
            JOptionPane.showMessageDialog(null, msg, ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(cn != null) {
             System.out.println("Clientes -> Conexion Exitosa.");
             return true;
        }
        return false;  
    }
    
   public static ArrayList<Modelo> getUsuarios(String consulta)
    {
        ArrayList<Modelo> listadoUsuarios = new ArrayList<Modelo>();
        Modelo mod = null;
        if(cn == null)
            conectar();
        try{
            st = cn.createStatement();
            rs = st.executeQuery(consulta);            
            while(rs.next())
            {
                mod = new Modelo();
                mod.setPrimaryKey(rs.getInt(1));
                mod.setNombreUsuario(rs.getString(2));
                mod.setPasswordUsuario(rs.getString(3));
                mod.setTipoUsuario(rs.getString(4));
                mod.setCorreo(rs.getString(5));
                listadoUsuarios.add(mod);
            }
            st.close();
            rs.close();
        }
        catch(SQLException ex){}
        return listadoUsuarios;
    }
   
   public static int grabarUsuario(Modelo cl)
    {
        int rsu = 0;
        String sql = Modelo.INSERT_SIN_FOTO;

        if(cn == null)
            conectar();
        try{
            ps = cn.prepareStatement(sql);
            ps.setString(1, cl.getNombreUsuario());
            ps.setString(2, cl.getPasswordUsuario());
            ps.setString(3, cl.getTipoUsuario());
            ps.setString(4, cl.getCorreo());
            rsu=ps.executeUpdate();
        }
        catch(SQLException ex){
            System.out.println("Error al grabar: ");
            ex.printStackTrace();
        } 
        System.out.println(sql);
        return rsu;
    }
   
   public static int actualizar(Modelo cl)
    {
        int rsu = 0;
        String sql = Modelo.UPDATE_SIN_FOTO;
        if(cn == null)
            conectar();
        try{
            ps = cn.prepareStatement(sql);
            ps.setString(1, cl.getNombreUsuario());
            ps.setString(2, cl.getPasswordUsuario());
            ps.setString(3, cl.getTipoUsuario());
            ps.setString(4, cl.getCorreo());
                ps.setInt(5, cl.getPrimaryKey());
            rsu=ps.executeUpdate();
        }
        catch(SQLException ex)
        {
            System.out.println("Error al actualizar: ");
            ex.printStackTrace();
        } 
        System.out.println(sql);
        return rsu;
    }
   
   public static int eliminar(Integer pk)
    {
        int rsu = 0;
        String sql = Modelo.DELETE;
      
        if(cn == null)
            conectar();
        try
        {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, pk);  
            rsu=ps.executeUpdate();
        }
        catch(SQLException ex)
        {
            System.out.println("Error al eliminar");
            ex.printStackTrace();
        } 
        System.out.println(sql);
        return rsu;
    }      
}
