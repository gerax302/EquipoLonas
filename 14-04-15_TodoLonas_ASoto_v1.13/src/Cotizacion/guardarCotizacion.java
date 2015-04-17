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
    public static String url = "jdbc:mysql://" + Conexion.nombreServidor + ":" + Conexion.puerto + "/" + Conexion.nombreBD;

    public static int id, idCotiza, id2;
    public static String nombreCliente, idNombreProducto;
    public static int numero, numeroCotiza;
    public static String producto[];
    public static int idNumeroProducto[];
    public static String fecha;
    public static String cantidad[];
    public static String totalVentas, subtotalVentas, descuento, iva;
    public static String especificacionTrabajo = "", especificacionDiseno = "";
    public static int idNumeroCliente;

    public static void guardarTablaCotiza() {
        Connection conexion = null;

        especificacionTrabajo = DatosExtra.precio1+"";
        especificacionDiseno = DatosExtra.precio2+""; 
        
        nombreCliente = PanelCotizacion.labelObtenerNombreCliente.getText();
        fecha = PanelCotizacion.labelObtenerFecha.getText();
        totalVentas = PanelCotizacion.cajaTotal.getText();
        subtotalVentas = PanelCotizacion.cajaSubTotal.getText();
        descuento = PanelCotizacion.cajaDescuento.getText();
        iva = PanelCotizacion.cajaIVA.getText();        

        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            conexion = (Connection) DriverManager.getConnection(url, login, password);

            stm = (Statement) conexion.createStatement();

//            System.out.println("nombre++++---->      "+nombreCliente);
            ResultSet rs = stm.executeQuery("select idCliente from todolonas.cliente where nombreCliente='" + nombreCliente + "';");
            while (rs.next()) {
                idNumeroCliente = rs.getInt("idCliente");
//                System.out.println("id Numero Cliente----->     " + idNumeroCliente);
            }
            conexion.close();
        } catch (Exception e) {
            System.out.println("error: " + e);
        }
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            //Class.forName("com.mysql.jdbc.Driver");
            conexion = (Connection) DriverManager.getConnection(url, login, password);
            stm = (Statement) conexion.createStatement();
            stm.executeUpdate("INSERT INTO `todolonas`.`cotizacion`"
                    + "(`numero`,`fecha`,`idCliente`,`subtotal`,`descuento`,`iva`,`total`,`especificacionTrabajo`,`especificacionDiseno`)"
                    + "VALUES("
                    + "'" + id2 + "',"
                    + "'" + fecha + "',"
                    + "'" + idNumeroCliente + "',"
                    + "'" + subtotalVentas + "',"
                    + "'" + descuento + "',"
                    + "'" + iva + "',"
                    + "'" + totalVentas + "',"
                    + "'" + especificacionTrabajo + "',"
                    + "'" + especificacionDiseno + "'"
                    + ");");
            conexion.close();
        } catch (Exception e) {
            System.out.println("error al guardar tabla cotiza [x]" + e);
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
            ResultSet rs = stm.executeQuery("select max(numero) as numero from todolonas.cotizacion;");

            while (rs.next()) {
                idCotiza = rs.getInt("numero");
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

        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            conexion = (Connection) DriverManager.getConnection(url, login, password);
            stm = (Statement) conexion.createStatement();
            for (int i = 0; i < numero; i++) {
                stm.executeUpdate("INSERT INTO `todolonas`.`detallescotizacion`"
                        + "(`iddetallesCotizacion`,`idProductos`,`cantidad`,`numero`)"
                        + "VALUES("
                        + "'" + id + "',"
                        + "'" + idNumeroProducto[i] + "',"
                        + "'" + cantidad[i] + "',"
                        + "'" + idCotiza + "'"
                        + ");");
            }
            conexion.close();
        } catch (Exception e) {
            System.out.println("error gfdhd 1" + e);
        }
    }
}
