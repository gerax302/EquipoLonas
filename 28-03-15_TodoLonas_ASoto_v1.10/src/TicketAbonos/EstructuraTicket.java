package TicketAbonos;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.print.PrintException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Ventas.*;
import TodoLonas.*;

public class EstructuraTicket {

    public static String mensaje = "ka";
    public static String cajero = "Liz Figueroa";

    public static void imprime(int num) throws PrintException, IOException {
        Date date = new Date();
        TicketAbonos ticket = new TicketAbonos();

        ticket.AddCabecera(ticket.DarEspacio());
        ticket.AddCabecera(ticket.DarEspacio());
        
        SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy  ");
        SimpleDateFormat hora = new SimpleDateFormat("   hh:mm:ss aa");
        ticket.AddCabecera("" + fecha.format(date) + "     " + hora.format(date));
        ticket.AddCabecera(ticket.DarEspacio());
        ticket.AddCabecera("Atendido por: " + cajero);//SOLO CON 15 CARACTERES
        ticket.AddCabecera(ticket.DarEspacio());
        ticket.AddCabecera(ticket.DarEspacio());
        ticket.AddCabecera("Cant.\tProducto\t\ttImporte");
        ticket.AddCabecera(ticket.DarEspacio());
        ticket.AddCabecera(ticket.DibujarLinea(32));
        ticket.AddCabecera(ticket.DarEspacio());

        String cadena = "", producto = "";
        
        double subtotal = 0;
        int noProductos = 0;
        
        for (int i = 0; i < num; i++) {
//            String cantidad = "" + Ventas.PanelVentas.tablaPedidos.getValueAt(i, 4);
//            noProductos=noProductos+Integer.parseInt(cantidad);
//            String des = "" + Ventas.PanelVentas.tablaPedidos.getValueAt(i, 2);
//            String imp = "" + Ventas.PanelVentas.tablaPedidos.getValueAt(i, 5);
//            double importe = (Double.parseDouble(cantidad) * Double.parseDouble(imp));
//            importe=redondear(importe,2);
//               
//            producto = des;
//            if (producto.length() <= 8) {
//                producto = producto + "     ";
//            }
//            if (producto.length() > 15) {
//                producto = producto.substring(0, 15);
//
//            }
//            cadena = cadena + "" + cantidad + "\t" + producto + "\t" + "$" + importe + "\n";
//            subtotal = subtotal + importe;
        }
        //MANDA A INFORMACIÓN DEL LISTADO DE LOS PRODUCTOS QUE SE COMPRARON
//        ticket.AddCabecera(cadena);
//        ticket.AddPieLinea(ticket.DibujarLinea(32));
//        ticket.AddPieLinea(ticket.DarEspacio());
//        //CONSIDERAR COMO CALCULA EL IVA SU CONTADOR
////        double total = Double.parseDouble(Ventas.RealizarVenta.totalCobrar.getText());
//        ticket.AddPieLinea("\tTotal:\t$" + total);
//        ticket.AddPieLinea(ticket.DarEspacio());
////        double abono = Double.parseDouble(Ventas.RealizarVenta.cajaAnticipo.getText());
//        ticket.AddPieLinea("\tAbono:\t$" + abono);
//        ticket.AddPieLinea(ticket.DarEspacio());
//        Double res = total - abono;
//        long resta = Math.round(res);
//        ticket.AddPieLinea("\tResta:\t$" + resta);
//        ticket.AddPieLinea(ticket.DarEspacio());
//        String formaPago = Ventas.RealizarVenta.formaDePago.getSelectedItem().toString();
//        ticket.AddPieLinea("\tForma de Pago:\t" + formaPago);
//        ticket.AddPieLinea(ticket.DarEspacio());
//        ticket.AddPieLinea(ticket.DarEspacio());
//        ticket.AddPieLinea(ticket.DarEspacio());
//        //ESPACIO PARA NOMBRE Y FIRMA
//        ticket.AddPieLinea("\t_________________________\t");
//        ticket.AddPieLinea(ticket.DarEspacio());
//        ticket.AddPieLinea("\tNombre y Firma\t");
//        //ESPACIOS PARA EL NUEVO TICKET
//        ticket.AddPieLinea(ticket.DarEspacio());
//        ticket.AddPieLinea(ticket.DarEspacio());
//        ticket.AddPieLinea(ticket.DarEspacio());
//        ticket.AddPieLinea(ticket.DarEspacio());
//        ticket.AddPieLinea(ticket.DarEspacio());
//        ticket.ImprimirDocumento();
//        TicketAbonos.limpia();
    }

    public static double redondear( double numero, int decimales ) {
        return Math.round(numero*Math.pow(10,decimales))/Math.pow(10,decimales);
    }

}
