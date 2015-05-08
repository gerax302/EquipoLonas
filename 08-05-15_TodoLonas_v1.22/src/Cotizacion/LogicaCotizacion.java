/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cotizacion;

//import Ajustes.PanelAjustes;
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
public class LogicaCotizacion {

    public static Statement stm = null;
    public static String bd = Conexion.nombreBD;
    public static String login = Conexion.usuarioBD;//"root";
    public static String password = Conexion.contrasena;//"280592ssmaylo";
    public static String url = "jdbc:mysql://" + Conexion.nombreServidor + ":" + Conexion.puerto + "/" + Conexion.nombreBD;
    public static DefaultListModel cliente = new DefaultListModel();
    public static int numero;
    public static String producto[];
    public static String precio[];
    public static String cantidad[];
    public static String total[];
    public static String descripcion[];
    public static String nombre, correo, rfc, domicilio;
    public static String telefono, celular, leyenda;
    public static double totalVentas, subtotalVentas;
    public static String var = "", cat = "";
    public static String descGene, descInst, descEm, descFisi, iva;
    public static String lista, colonia, fecha;

    public static void buscarCliente() {
        cliente.removeAllElements();
        PanelCotizacion.listaCliente.setModel(cliente);
        Connection conexion = null;
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            conexion = (Connection) DriverManager.getConnection(url, login, password);

            stm = (Statement) conexion.createStatement();

            var = PanelCotizacion.cajaBuscarCliente.getText();
            lista = "" + PanelCotizacion.listaCliente.getModel();
            ResultSet rs = stm.executeQuery("select * from cliente" + " where nombreCliente like '" + var + "%'");
            if (!rs.equals(var)) {
                PanelCotizacion.botonNuevoCliente.setEnabled(true);
                PanelCotizacion.botonNuevoCliente.setEnabled(true);
            }
            while (rs.next()) {
                cliente.addElement(rs.getString("nombreCliente"));
                cat = rs.getString("categoriaCliente");
                System.out.println("cat---->    " + cat);
                System.out.println("cliente---->    " + cliente);
//                PanelCotizacion.botonNuevoCliente.setEnabled(true);
            }
            conexion.close();
        } catch (Exception e) {
            System.out.println("error: " + e);
        }
        PanelCotizacion.listaCliente.setModel(cliente);
    }

    public static void mostrarClientes() {
        cliente.removeAllElements();
        PanelCotizacion.listaCliente.setModel(cliente);
        Connection conexion = null;
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            conexion = (Connection) DriverManager.getConnection(url, login, password);

            stm = (Statement) conexion.createStatement();

            var = PanelCotizacion.cajaBuscarCliente.getText();
            lista = "" + PanelCotizacion.listaCliente.getModel();
            ResultSet rs = stm.executeQuery("select nombreCliente from todolonas.cliente;");
            if (!rs.equals(var)) {
                PanelCotizacion.botonNuevoCliente.setEnabled(true);
                PanelCotizacion.botonNuevoCliente.setEnabled(true);
            }
            while (rs.next()) {
                cliente.addElement(rs.getString("nombreCliente"));
                System.out.println("cliente---->    " + cliente);
            }
            conexion.close();
        } catch (Exception e) {
            System.out.println("error: " + e);
        }
        PanelCotizacion.listaCliente.setModel(cliente);
    }

    public static void metodoObtenerInformacionAjustes() {
        java.sql.Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://" + Conexion.nombreServidor + ":" + Conexion.puerto + "/" + Conexion.nombreBD;
            con = DriverManager.getConnection(url, Conexion.usuarioBD, Conexion.contrasena);
            java.sql.Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from ajustes");
            while (rs.next()) {
                //Para poner en cajas editables
                nombre = rs.getString("nombre");
                leyenda = rs.getString("leyendaCotizacion");
                rfc = rs.getString("RFC");
                domicilio = rs.getString("domicilioNegocio");
                correo = rs.getString("correoNegocio");
                celular = rs.getString("numeroCelular");
                telefono = rs.getString("telefonoNegocio");
                iva = rs.getString("iva");
                colonia = rs.getString("colonia");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void metodoMostrarInformacionAjustes() {
        String ley = "";
        PanelCotizacion.labelObtenerCelular.setText(celular);
        PanelCotizacion.labelObtenerTelefono.setText(telefono);
        PanelCotizacion.labelObtenerCorreo.setText(correo);
        PanelCotizacion.labelObtenerDomicilio.setText(domicilio);
        PanelCotizacion.labelObtenerColonia.setText(colonia);
        PanelCotizacion.labelObtenerRFC.setText(rfc);
        PanelCotizacion.labelObtenerATTE.setText(nombre);
//        ley = PanelCotizacion.areaLeyenda.getText();
//        if (ley.equals("")) {
        PanelCotizacion.areaLeyenda.setText(leyenda);
//        }
    }

    public static void obtenerDatosVentas() {
        if (Ventas.PanelVentas.tablaPedidos.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "No Hay Productos Para Cotizar", "Atención:", JOptionPane.WARNING_MESSAGE);
            PanelCotizacion.listaCliente.setEnabled(false);
            PanelCotizacion.cajaBuscarCliente.setEditable(false);
            PanelCotizacion.botonPDF.setEnabled(false);
            PanelCotizacion.botonNuevoCliente.setEnabled(false);
            PanelCotizacion.cajaAsunto.setEnabled(false);
            PanelCotizacion.cajaUbicacion.setEnabled(false);
            PanelCotizacion.botonPrecioExtra.setEnabled(false);
            PanelCotizacion.cajaDescuento.setEnabled(false);
        } else {
            DefaultTableModel temp = (DefaultTableModel) PanelCotizacion.tablaProductos.getModel();
            while (temp.getRowCount() > 0) {
                temp.removeRow(0);
            }
            anadirFilas();
            obtenerDatosProducto();
            obtenerDatosPrecio();
            obtenerDatosCantidad();
            obtenerDatosDescripcion();
            obtenerDatosTotal();
            PanelCotizacion.listaCliente.setEnabled(true);
            PanelCotizacion.cajaBuscarCliente.setEditable(true);
            PanelCotizacion.botonPDF.setEnabled(false);
            PanelCotizacion.botonNuevoCliente.setEnabled(true);
            PanelCotizacion.cajaAsunto.setEnabled(true);
            PanelCotizacion.cajaUbicacion.setEnabled(true);
            PanelCotizacion.botonPrecioExtra.setEnabled(true);
            PanelCotizacion.cajaDescuento.setEnabled(false);
        }
    }

    public static void anadirFilas() {
        numero = Ventas.PanelVentas.tablaPedidos.getRowCount();
        System.out.println("numero anadir filas     " + numero);
        DefaultTableModel temp = (DefaultTableModel) PanelCotizacion.tablaProductos.getModel();
//        if (PanelCotizacion.tablaProductos.getRowCount() == 0) {
        for (int i = 0; i < numero; i++) {
            Object nuevo[] = {"", "", ""};
            temp.addRow(nuevo);
        }
    }

    public static void obtenerDatosProducto() {
        numero = Ventas.PanelVentas.tablaPedidos.getRowCount();
        System.out.println("numero productos     " + numero);
        producto = new String[numero];
        for (int i = 0; i < numero; i++) {
            producto[i] = "" + Ventas.PanelVentas.tablaPedidos.getValueAt(i, 1);
            Cotizacion.PanelCotizacion.tablaProductos.setValueAt(producto[i], i, 0);
        }
    }

    public static void obtenerDatosPrecio() {
        numero = Ventas.PanelVentas.tablaPedidos.getRowCount();
        precio = new String[numero];
        for (int i = 0; i < numero; i++) {
            precio[i] = "" + Ventas.PanelVentas.tablaPedidos.getValueAt(i, 3);
            Cotizacion.PanelCotizacion.tablaProductos.setValueAt(precio[i], i, 2);
        }
    }

    public static void obtenerDatosCantidad() {
        numero = Ventas.PanelVentas.tablaPedidos.getRowCount();
        cantidad = new String[numero];
        for (int i = 0; i < numero; i++) {
            cantidad[i] = "" + Ventas.PanelVentas.tablaPedidos.getValueAt(i, 4);
            Cotizacion.PanelCotizacion.tablaProductos.setValueAt(cantidad[i], i, 3);
        }
    }

    public static void obtenerDatosDescripcion() {
        numero = Ventas.PanelVentas.tablaPedidos.getRowCount();
        descripcion = new String[numero];
        for (int i = 0; i < numero; i++) {
            descripcion[i] = "" + Ventas.PanelVentas.tablaPedidos.getValueAt(i, 2);
            Cotizacion.PanelCotizacion.tablaProductos.setValueAt(descripcion[i], i, 1);
        }
    }

    public static void obtenerDatosTotal() {
        numero = Ventas.PanelVentas.tablaPedidos.getRowCount();
        total = new String[numero];
        for (int i = 0; i < numero; i++) {
            total[i] = "" + Ventas.PanelVentas.tablaPedidos.getValueAt(i, 7);
            Cotizacion.PanelCotizacion.tablaProductos.setValueAt(total[i], i, 4);
        }
    }

    public static void obtenerDatosOperaciones() {
        double resultado2, descuento = 0, res;
        subtotalVentas = Double.parseDouble(Ventas.PanelVentas.cajaSubtotal.getText());
        PanelCotizacion.cajaSubtotal.setText("" + subtotalVentas);
        double iva2 = Double.parseDouble(iva) / 100;
        resultado2 = subtotalVentas * iva2;
        Cotizacion.PanelCotizacion.cajaIVA.setText("" + Math.rint(resultado2 * 100) / 100);

        res = (subtotalVentas - (subtotalVentas * descuento)) + resultado2;
        Cotizacion.PanelCotizacion.cajaTotal.setText("" + Math.rint(res * 100) / 100);
//        importeFinal = totalConDescuentoExtra;
    }
}
