/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pedidos;

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
public class GuardarPedidos {

    public static String nombreUsuario, fechaSistema, horaSistema;
    public static String formaPago, total, descuento;
    public static String nombreCliente, fechaEntrega, subtotal;
    public static String producto[];
    public static String cantidad[];
    public static String importe[];
    public static int idProducto[];
    public static int numeroPedido, numeroFila, numeroPedido2, idDetalle;

    public static Calendar cal = Calendar.getInstance();
    public static String horaActual = cal.get(Calendar.HOUR) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND);

    public static Statement stm = null;
    public static String bd = Conexion.nombreBD;
    public static String login = Conexion.usuarioBD;
    public static String password = Conexion.contrasena;
    public static String url = "jdbc:mysql://" + Conexion.nombreServidor + ":" + Conexion.puerto + "/" + Conexion.nombreBD;
    public static String anticipo, especificacionTrabajo, especificacionDiseno;
    public static String estatus;

    public static void pedidos() {
        nombreUsuario = Pedidos.labelObtenerUsuario.getText();
        fechaSistema = Pedidos.labelObtenerFecha.getText();
        horaSistema = horaActual;
        formaPago = Pedidos.comboFormaPago.getSelectedItem().toString();
        total = Ventas.PanelVentas.cajaTotal.getText();
        descuento = Ventas.PanelVentas.cajaDescuento.getText();
        nombreCliente = Pedidos.labelObtenerCliente.getText();
        fechaEntrega = Pedidos.fechaEntrega.getDateFormatString();
        anticipo = Pedidos.cajaAbono.getText();
        especificacionTrabajo = Pedidos.areaEspecificacionTrabajo.getText();
        especificacionDiseno = Pedidos.areaEspecificacionDiseno.getText();
        estatus = Pedidos.comboEstatus.getSelectedItem().toString();
        subtotal = Ventas.PanelVentas.cajaSubtotal.getText();

        Connection conexion = null;
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            conexion = (Connection) DriverManager.getConnection(url, login, password);
            stm = (Statement) conexion.createStatement();
            stm.executeUpdate("INSERT INTO `todolonas`.`pedidos`"
                    + "(`numeroPedido`,`fechaSistema`,`fechaEntrega`,`horaSistema`,`formaPago`,`anticipo`,`total`,"
                    + "`especificacionTrabajo`,`nombreCliente`,`nombreUsuario`,`especificacionDiseno`,`estatus`,`subtotal`,`descuento`)"
                    + "VALUES("
                    + "'" + numeroPedido + "',"
                    + "'" + fechaSistema + "',"
                    + "'" + fechaEntrega + "',"
                    + "'" + horaSistema + "',"
                    + "'" + formaPago + "',"
                    + "'" + anticipo + "',"
                    + "'" + total + "',"
                    + "'" + especificacionTrabajo + "',"
                    + "'" + nombreCliente + "',"
                    + "'" + nombreUsuario + "',"
                    + "'" + especificacionDiseno + "',"
                    + "'" + estatus + "',"
                    + "'" + subtotal + "',"
                    + "'" + descuento + "'"
                    + ");");

            conexion.close();
        } catch (Exception e) {
            System.out.println("error en guardar pedidos     " + e);
        }
        detalleProductoVenta();
    }

    public static void detalleProductoVenta() {
        numeroFila = Ventas.PanelVentas.tablaPedidos.getRowCount();
        System.out.println("numeroFila    " + numeroFila);

        producto = new String[numeroFila];
        cantidad = new String[numeroFila];
        importe = new String[numeroFila];
        idProducto = new int[numeroFila];

        for (int i = 0; i < numeroFila; i++) {
            producto[i] = "" + Ventas.PanelVentas.tablaPedidos.getValueAt(i, 0);
            System.out.println("producto    " + producto[i]);
            cantidad[i] = "" + Ventas.PanelVentas.tablaPedidos.getValueAt(i, 3);
            System.out.println("cantidad    " + cantidad[i]);
            importe[i] = "" + Ventas.PanelVentas.tablaPedidos.getValueAt(i, 4);
            System.out.println("importe    " + importe[i]);
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
            ResultSet rs = stm.executeQuery("select max(numeroPedido) as numero from todolonas.pedidos;");

            while (rs.next()) {
                numeroPedido2 = rs.getInt("numero");
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
                stm.executeUpdate("INSERT INTO `todolonas`.`detalleproductopedido`"
                        + "(`iddetalleProductoPedido`,`idProductoPendiente`,`cantidad`,`importe`,`numeroPedidoPendiente`)"
                        + "VALUES("
                        + "'" + idDetalle + "',"             
                        + "'" + idProducto[i] + "',"
                        + "'" + cantidad[i] + "',"
                        + "'" + importe[i] + "',"
                        + "'" + numeroPedido2 + "'"
                        + ");");
            }
            conexion.close();
        } catch (Exception e) {
            System.out.println("error en guardar detalle    " + e);
        }
    }
}
