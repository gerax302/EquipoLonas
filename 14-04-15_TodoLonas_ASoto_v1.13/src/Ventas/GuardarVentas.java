/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventas;

import java.util.Calendar;
import Conexion.Conexion;
import com.mysql.jdbc.*;
import java.sql.DriverManager;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;

/**
 *
 * @author Ana Karen
 */
public class GuardarVentas {

    public static Calendar cal = Calendar.getInstance();

    public static Statement stm = null;
    public static String bd = Conexion.nombreBD;
    public static String login = Conexion.usuarioBD;
    public static String password = Conexion.contrasena;
    public static String url = "jdbc:mysql://" + Conexion.nombreServidor + ":" + Conexion.puerto + "/" + Conexion.nombreBD;

    public static int numeroVenta, idDetalle, numeroVenta2, numeroFila;
    public static String nombreUsuario, fechaSistema, horaSistema;
    public static String formaPago, total, subtotal;
    public static String descuento, nombreCliente;
    public static String producto[];
    public static String cantidad[];
    public static String importe[];
    public static int idProducto[];
    public static String horaActual = cal.get(Calendar.HOUR) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND);

    public static void venta() {
        nombreUsuario = TodoLonas.Principal.usuarioActivo;
        fechaSistema = Ventas.PanelVentas.fechaSistema.getText();
        horaSistema = horaActual;
        formaPago = Ventas.Cobrar.comboFormaDePago.getSelectedItem().toString();
        total = Ventas.PanelVentas.cajaTotal.getText();
        descuento = Ventas.PanelVentas.cajaDescuento.getText();
        nombreCliente = Ventas.PanelVentas.comboCliente.getSelectedItem().toString();

        if (nombreCliente.equals("Seleccionar...")) {
            nombreCliente = "";
        }

        Connection conexion = null;
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            conexion = (Connection) DriverManager.getConnection(url, login, password);
            stm = (Statement) conexion.createStatement();
            stm.executeUpdate("INSERT INTO `todolonas`.`venta`"
                    + "(`numeroVenta`,`nombreUsuario`,`fechaSistema`,`horaSistema`,`formaPago`,`total`,`subtotal`,`descuento`,`nombreCliente`)"
                    + "VALUES("
                    + "'" + numeroVenta + "',"
                    + "'" + nombreUsuario + "',"
                    + "'" + fechaSistema + "',"
                    + "'" + horaSistema + "',"
                    + "'" + formaPago + "',"
                    + "'" + total + "',"
                    + "'" + subtotal + "',"
                    + "'" + descuento + "',"
                    + "'" + nombreCliente + "'"
                    + ");");

            conexion.close();
        } catch (Exception e) {
            System.out.println("error en guardar ventas     " + e);
        }
        detalleProductoVenta();
    }

    public static void detalleProductoVenta() {
        numeroFila = Ventas.PanelVentas.tablaPedidos.getRowCount();
        System.out.println("numeroFila    "+numeroFila);

        producto = new String[numeroFila];
        cantidad = new String[numeroFila];
        importe = new String[numeroFila];
        idProducto = new int[numeroFila];

        for (int i = 0; i < numeroFila; i++) {
            producto[i] = "" + Ventas.PanelVentas.tablaPedidos.getValueAt(i, 0);
            System.out.println("producto    "+producto[i]);
            cantidad[i] = "" + Ventas.PanelVentas.tablaPedidos.getValueAt(i, 3);
            System.out.println("cantidad    "+cantidad[i]);
            importe[i] = "" + Ventas.PanelVentas.tablaPedidos.getValueAt(i, 4);
            System.out.println("importe    "+importe[i]);
        }

        Connection conexion = null;
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            conexion = (Connection) DriverManager.getConnection(url, login, password);
            stm = (Statement) conexion.createStatement();
            for (int i = 0; i < numeroFila; i++) {
                ResultSet rs = stm.executeQuery("Select idProducto from todolonas.producto where nombreProducto ='" + producto[i] + "';");

                while (rs.next()) {
                    idProducto[i] = rs.getInt("idProducto");
                }
            }

            conexion.close();
        } catch (Exception e) {
            System.out.println("error obtener idProducto: " + e);
        }
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            conexion = (Connection) DriverManager.getConnection(url, login, password);
            stm = (Statement) conexion.createStatement();
            ResultSet rs = stm.executeQuery("select max(numeroVenta) as numero from todolonas.venta;");

            while (rs.next()) {
                numeroVenta2 = rs.getInt("numero");
            }
            conexion.close();
        } catch (Exception e) {
            System.out.println("error obtener max numeroVenta: " + e);
        }
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            conexion = (Connection) DriverManager.getConnection(url, login, password);
            stm = (Statement) conexion.createStatement();
            for (int i = 0; i < numeroFila; i++) {
                stm.executeUpdate("INSERT INTO `todolonas`.`detalleproductoventa`" 
                        +"(`iddetalleProductoVenta`,`numeroVenta`,`idProducto`,`cantidad`,`importe`)"
                        + "VALUES("
                        + "'" + idDetalle + "',"
                        + "'" + numeroVenta2 + "',"
                        + "'" + idProducto[i] + "',"
                        + "'" + cantidad[i] + "',"
                        + "'" + importe[i] + "'"
                        + ");");
            }
            conexion.close();
        } catch (Exception e) {
            System.out.println("error en guardar detalle    " + e);
        }
    }
}
