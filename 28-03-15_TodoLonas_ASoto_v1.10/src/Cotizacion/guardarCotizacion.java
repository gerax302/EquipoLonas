/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cotizacion;

import Conexion.Conexion;
import com.mysql.jdbc.*;
import java.sql.DriverManager;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;

/**
 *
 * @author Ana Karen
 */
public class guardarCotizacion {

    public static Statement stm = null;
    public static String bd = Conexion.nombreBD;
    public static String login = Conexion.usuarioBD;//"root";
    public static String password = Conexion.contrasena;//"280592ssmaylo";
    public static String url = "jdbc:mysql://"+Conexion.nombreServidor+":"+Conexion.puerto+"/"+Conexion.nombreBD;

    public static int id, idCotiza, id2;
    public static String nombreCliente, idNombreProducto;
    public static int idNumeroCliente;
    public static int numero, numeroCotiza;
    public static String producto[];
    public static int idNumeroProducto[];
    public static String fecha;
    public static String cantidad[];
    public static String totalVentas, subtotalVentas, descuento, iva;

    public static void guardarTablaCotiza() {
        Connection conexion = null;
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            conexion = (Connection) DriverManager.getConnection(url, login, password);

            stm = (Statement) conexion.createStatement();

            nombreCliente = PanelCotizacion.labelObtenerNombreCliente.getText();
//            System.out.println("nombre++++---->      "+nombreCliente);
            ResultSet rs = stm.executeQuery("select idCliente from todolonas.cliente" + " where nombreCliente='" + nombreCliente + "';");
            while (rs.next()) {
                idNumeroCliente = rs.getInt("idCliente");
//                System.out.println("id Numero Cliente----->     " + idNumeroCliente);
            }
            conexion.close();
        } catch (Exception e) {
            System.out.println("error: " + e);
        }
        
//        numeroCotiza = Integer.parseInt(PanelCotizacion.labelNumeroCotizacion.getText());
        System.out.println("numero Cotiza.....>    " + numeroCotiza);
        fecha = PanelCotizacion.labelObtenerFecha.getText();
        System.out.println("fecha.....>    " + fecha);
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            conexion = (Connection) DriverManager.getConnection(url, login, password);
            stm = (Statement) conexion.createStatement();
            stm.executeUpdate("INSERT INTO `todolonas`.`tablacotiza`"
                    + "(`numero`, `fecha`, `idCliente`)"
                    + "VALUES("
                    + "'" + id2 + "',"
                    + "'" + fecha + "',"
                    + "'" + idNumeroCliente + "'"
                    + ");");
            conexion.close();
        } catch (Exception e) {
            System.out.println("error gfdhd 1" + e);
        }
    }

    public static void guardarDetallesCotiza() {
        numero = Ventas.PanelVentas.tablaPedidos.getRowCount();
        producto = new String[numero];
        idNumeroProducto = new int[numero];
        String var = "", var2 = "";
        for (int i = 0; i < numero; i++) {
            producto[i] = LogicaCotizacion.producto[i];
            var = producto[i];
        }
        Connection conexion = null;
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            conexion = (Connection) DriverManager.getConnection(url, login, password);
            stm = (Statement) conexion.createStatement();
            for (int i = 0; i < numero; i++) {
                ResultSet rs = stm.executeQuery("Select idProducto from todolonas.producto where nombreProducto ='" + producto[i] + "';");

                while (rs.next()) {
                    idNumeroProducto[i] = rs.getInt("idProducto");
                }
            }

            conexion.close();
        } catch (Exception e) {
            System.out.println("error: " + e);
        }
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            conexion = (Connection) DriverManager.getConnection(url, login, password);
            stm = (Statement) conexion.createStatement();
            for (int i = 0; i < numero; i++) {
                ResultSet rs = stm.executeQuery("select max(numero) as numero from todolonas.tablacotiza ;");

                while (rs.next()) {
                    idCotiza = rs.getInt("numero");
                }
            }

            conexion.close();
        } catch (Exception e) {
            System.out.println("error: " + e);
        }
        System.out.println("numero Cotiza.....>    " + numeroCotiza);
        numero = Ventas.PanelVentas.tablaPedidos.getRowCount();
        cantidad = new String[numero];

        for (int i = 0; i < numero; i++) {
            cantidad[i] = LogicaCotizacion.cantidad[i];
        }
        
        totalVentas = PanelCotizacion.cajaTotal.getText();
        subtotalVentas = PanelCotizacion.cajaSubTotal.getText();
        descuento = PanelCotizacion.cajaDescuento.getText();
        iva = PanelCotizacion.cajaIVA.getText();
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            conexion = (Connection) DriverManager.getConnection(url, login, password);
            stm = (Statement) conexion.createStatement();
            for (int i = 0; i < numero; i++) {
                stm.executeUpdate("INSERT INTO `todolonas`.`detallescotizacion`"
                        + "(`idDetallesCotizacion`,`idProductos`, `cantidad`, `total`, `numero`,`subtotal`,`descuento`,`iva`)"
                        + "VALUES("
                        + "'" + id + "',"
                        + "'" + idNumeroProducto[i] + "',"
                        + "'" + cantidad[i] + "',"
                        + "'" + totalVentas + "',"
                        + "'" + idCotiza + "',"
                        + "'" + subtotalVentas + "',"
                        + "'" + descuento + "',"
                        + "'" + iva + "'"
                        + ");");
            }
            conexion.close();
        } catch (Exception e) {
            System.out.println("error gfdhd 1" + e);
        }
    }
}
