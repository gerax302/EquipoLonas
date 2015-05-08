package Clientes;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ConexionCliente {
    
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
        ConexionCliente.nombreBD = nombreBD;
    }

    public static String getUsuario() {
        return usuario;
    }
    public static void setUsuario(String usuario) {
        ConexionCliente.usuario = usuario;
    }

    public static String getClave() {
        return clave;
    }
    public static void setClave(String clave) {
        ConexionCliente.clave = clave;
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
    
   public static ArrayList<Modelo> getClientes(String consulta)
    {
        ArrayList<Modelo> listadoClientes = new ArrayList<Modelo>();
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
                mod.setCategoriaCliente(rs.getString(2));
                mod.setNombre(rs.getString(3));
                mod.setRef(rs.getString(4));
                mod.setTelFijo(rs.getString(5));
                mod.setTelMovil(rs.getString(6));
                mod.setCorreo(rs.getString(7));
                mod.setDomicilio(rs.getString(8));
                mod.setColonia(rs.getString(9));
                mod.setCiudad(rs.getString(10));
                mod.setRFC(rs.getString(11));
                mod.setFechaReg(rs.getString(12));
                listadoClientes.add(mod);
            }
            st.close();
            rs.close();
        }
        catch(SQLException ex){}
        return listadoClientes;
    }
   
   public static int grabarCliente(Modelo cl)
    {
        int rsu = 0;
        String sql = Modelo.INSERT_SIN_FOTO;

        if(cn == null)
            conectar();
        try{
            ps = cn.prepareStatement(sql);
            ps.setString(1, cl.getCategoriaCliente());
            ps.setString(2, cl.getNombre());
            ps.setString(3, cl.getRef());
            ps.setString(4, cl.getTelFijo());
            ps.setString(5, cl.getTelMovil());
            ps.setString(6, cl.getCorreo());
            ps.setString(7, cl.getDomicilio());
            ps.setString(8, cl.getColonia());
            ps.setString(9, cl.getCiudad());
            ps.setString(10, cl.getRFC());
            ps.setString(11, cl.getFechaReg());
            rsu=ps.executeUpdate();
        }
        catch(SQLException ex){
            System.out.println("Error al grabar: ");
            ex.printStackTrace();
        } 
        System.out.println(sql);
        return rsu;
    }
   
   public static int actualizarCliente(Modelo cl)
    {
        int rsu = 0;
        String sql = Modelo.UPDATE_SIN_FOTO;
        if(cn == null)
            conectar();
        try{
            ps = cn.prepareStatement(sql);
            ps.setString(1, cl.getCategoriaCliente());
            ps.setString(2, cl.getNombre());
            ps.setString(3, cl.getRef());
            ps.setString(4, cl.getTelFijo());
            ps.setString(5, cl.getTelMovil());
            ps.setString(6, cl.getCorreo());
            ps.setString(7, cl.getDomicilio());  
            ps.setString(8, cl.getColonia());
            ps.setString(9, cl.getCiudad());
            ps.setString(10, cl.getRFC());
            ps.setString(11, cl.getFechaReg());            

                ps.setInt(12, cl.getPrimaryKey());

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
   
   public static int eliimnarCliente(Integer pk)
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
