/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventas;

import Conexion.Conexion;
import com.mysql.jdbc.*;
import java.sql.DriverManager;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import javax.swing.DefaultListModel;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ana Karen
 */
public class ActualizaTablaProductos {

    public static Statement stm = null;
    public static String bd = Conexion.nombreBD;
    public static String login = Conexion.usuarioBD;//"root";
    public static String password = Conexion.contrasena;//"280592ssmaylo";
    public static String url = "jdbc:mysql://" + Conexion.nombreServidor + ":" + Conexion.puerto + "/" + Conexion.nombreBD;

    public static int idProducto[];
    public static String nombre[];
    public static String categoria[];
    public static String cantidad[];
    public static String unidad[];
    public static String precioU[];
    public static String stockM[];
    public static String descripcion[];
//    public static String imagenPro[];
    public static int numero;

    public static void actualizaTabla() {
//        Connection conexion = null;
//        try {
//            Class.forName("org.gjt.mm.mysql.Driver");
//            conexion = (Connection) DriverManager.getConnection(url, login, password);
//            stm = (Statement) conexion.createStatement();
//            ResultSet rs = stm.executeQuery("select count(*) as numero from producto;");
//
//            while (rs.next()) {
//                numero = rs.getInt("numero");
//            }
//
//            conexion.close();
//        } catch (Exception e) {
//            System.out.println("error: " + e);
//        }
    }

    public static void tabla() {
//        actualizaTabla();
        numero = Productos.PanelProductos.tablaDatosProducto.getRowCount();
        
        idProducto = new int[numero];
        nombre = new String[numero];
        categoria = new String[numero];
        cantidad = new String[numero];
        unidad = new String[numero];
        precioU = new String[numero];
        stockM = new String[numero];
        descripcion = new String[numero];
        
        for (int i = 0; i < numero; i++) {
            nombre[i] = ""+Productos.PanelProductos.tablaDatosProducto.getValueAt(i, 2);
        }
        Connection conexion = null;
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            conexion = (Connection) DriverManager.getConnection(url, login, password);
            stm = (Statement) conexion.createStatement();
            for (int i = 0; i < numero; i++) {
                ResultSet rs = stm.executeQuery("Select * from todolonas.producto where nombreProducto ='" + nombre[i] + "';");
                while (rs.next()) {
                    idProducto[i] = rs.getInt("idProducto");
                    categoria[i] = rs.getString("categoriaProducto");
                    nombre[i] = rs.getString("nombreProducto");
                    cantidad[i] = rs.getString("cantidad");
                    unidad[i] = rs.getString("unidad");
                    precioU[i] = rs.getString("precioUnitario");
                    stockM[i] = rs.getString("stockMinimo");
                    descripcion[i] = rs.getString("descripcion");
                }
            }

            conexion.close();
        } catch (Exception e) {
            System.out.println("error: " + e);
        }
        obtenerDatosProductos();
    }

    public static void obtenerDatosProductos() {

        for (int i = 0; i < numero; i++) {
            
            System.out.println("idProducto        " + idProducto[i]);
            System.out.println("nombre        " + nombre[i]);
            System.out.println("categoria        " + categoria[i]);
            System.out.println("cantidad        " + cantidad[i]);
            System.out.println("unidad        " + unidad[i]);
            System.out.println("precioU        " + precioU[i]);
            System.out.println("stockM        " + stockM[i]);
            System.out.println("descripcion        " + descripcion[i]);
            
            Productos.PanelProductos.tablaDatosProducto.setValueAt(idProducto[i], i, 0);
            Productos.PanelProductos.tablaDatosProducto.setValueAt(categoria[i], i, 1);
            Productos.PanelProductos.tablaDatosProducto.setValueAt(nombre[i], i, 2);
            Productos.PanelProductos.tablaDatosProducto.setValueAt(cantidad[i], i, 3);
            Productos.PanelProductos.tablaDatosProducto.setValueAt(unidad[i], i, 4);
            Productos.PanelProductos.tablaDatosProducto.setValueAt(precioU[i], i, 5);
            Productos.PanelProductos.tablaDatosProducto.setValueAt(stockM[i], i, 6);
            Productos.PanelProductos.tablaDatosProducto.setValueAt(descripcion[i], i, 7);
        }
    }
}
