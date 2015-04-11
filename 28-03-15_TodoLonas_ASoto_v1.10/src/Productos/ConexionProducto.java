package Productos;
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

public class ConexionProducto {
    
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
        ConexionProducto.nombreBD = nombreBD;
    }

    public static String getUsuario() {
        return usuario;
    }
    public static void setUsuario(String usuario) {
        ConexionProducto.usuario = usuario;
    }

    public static String getClave() {
        return clave;
    }
    public static void setClave(String clave) {
        ConexionProducto.clave = clave;
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
             System.out.println("Productos -> Conexion Exitosa.");
             return true;
        }
        return false;  
    }
    
   public static ArrayList<Modelo> getProductos(String consulta)
    {
        ArrayList<Modelo> listadoProductos = new ArrayList<Modelo>();
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
                mod.setCategoriaProducto(rs.getString(2));
                mod.setNombreProducto(rs.getString(3));
                mod.setCantidad(rs.getString(4));
                mod.setUnidad(rs.getString(5));
                mod.setPrecioUnitario(rs.getString(6));
                mod.setStockMinimo(rs.getString(7));
                mod.setDescripcion(rs.getString(8));
                listadoProductos.add(mod);
            }
            st.close();
            rs.close();
        }
        catch(SQLException ex){}
        return listadoProductos;
    }
   
   public static int grabarProducto(Modelo cl)
    {
        int rsu = 0;
        String sql = Modelo.INSERT_CON_FOTO;
        if(cl.getFoto() == null)
        {
            sql = Modelo.INSERT_SIN_FOTO;
        }
        if(cn == null)
            conectar();
        try{
            ps = cn.prepareStatement(sql);
            ps.setString(1, cl.getCategoriaProducto());
            ps.setString(2, cl.getNombreProducto());
            ps.setString(3, cl.getCantidad());
            ps.setString(4, cl.getUnidad());
            ps.setString(5, cl.getPrecioUnitario());
            ps.setString(6, cl.getStockMinimo()+"");
            ps.setString(7, cl.getDescripcion());
            if(cl.getFoto() != null)
            {
                ps.setBinaryStream(8, cl.getFoto());
            }
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
        String sql = Modelo.UPDATE_CON_FOTO;
        if(cl.getFoto() == null)
        {            
            sql = Modelo.UPDATE_SIN_FOTO;
        }
        if(cn == null)
            conectar();
        try{
            ps = cn.prepareStatement(sql);
            ps.setString(1, cl.getCategoriaProducto());
            ps.setString(2, cl.getNombreProducto());
            ps.setString(3, cl.getCantidad());
            ps.setString(4, cl.getUnidad());
            ps.setString(5, cl.getPrecioUnitario());
            ps.setString(6, cl.getStockMinimo());
            ps.setString(7, cl.getDescripcion());            
            if(cl.getFoto() != null)
            {
                ps.setBinaryStream(8, cl.getFoto());
                ps.setInt(9, cl.getPrimaryKey());
            }
            else{
                ps.setInt(8, cl.getPrimaryKey());
            }
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
   
   public static int eliminarProducto(Integer pk)
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
   
    public static CustomImageIcon getFoto(int id)
    {
        String sql = "select imagenProducto from producto where idProducto = "+id;
        CustomImageIcon ii = null;
        InputStream is = null;
         if(cn == null)
            conectar();
       try
       {
           st = cn.createStatement();
           rs = st.executeQuery(sql); 
           if(rs.next()){
               is = rs.getBinaryStream(1);
               if(is != null)
               {
                   BufferedImage bi = ImageIO.read(is);
                   ii = new CustomImageIcon(bi);
               }
           }
       }
       catch(SQLException ex)
       {
           ex.printStackTrace();
       }
       catch(IOException ex)
       {
           ex.printStackTrace();
       }
        return ii;
    }    
}
