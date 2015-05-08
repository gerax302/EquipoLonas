package TicketVentas;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.print.PrintException;
import javax.swing.JOptionPane;
import Ventas.*;
import TodoLonas.*;
import TodoLonas.Principal.*;
import Ajustes.PanelAjustes.*;

public class EstructuraTicket {

    public static String mensaje = Ajustes.PanelAjustes.mensajeTicket; 
    public static String cajero = Principal.usuarioActivo;

    //AQUI SE OPTIENEN LOS DATOD DEL USUARIO QUE REALIZO LA VENTA 
    public static void imprime(int num) throws PrintException, IOException {
        Date date = new Date();
        TicketVentas ticket = new TicketVentas();

        ticket.AddCabecera("RFC:     CAAO84090943A");
        ticket.AddCabecera(ticket.DarEspacio());
        ticket.AddCabecera(ticket.DarEspacio());
        
        SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy  ");
        SimpleDateFormat hora = new SimpleDateFormat("   hh:mm:ss aa");
        ticket.AddCabecera("" + fecha.format(date) + "     " + hora.format(date));
        ticket.AddCabecera(ticket.DarEspacio());
        ticket.AddCabecera(ticket.DarEspacio());
        
        ticket.AddCabecera("Atendido por: " + cajero);//SOLO CON 15 CARACTERES
        ticket.AddCabecera(ticket.DarEspacio());
        ticket.AddCabecera(ticket.DarEspacio());
        
        ticket.AddCabecera("Cant.\tProducto\tImporte");
        ticket.AddCabecera(ticket.DarEspacio());
        
        ticket.AddCabecera(ticket.DibujarLinea(32));
        ticket.AddCabecera(ticket.DarEspacio());

        String cadena = "", producto = "";
        String subtotal = "";
        int noProductos = 0;
        
        for (int i = 0; i < num; i++) {
            String cantidad = "" + Ventas.PanelVentas.tablaPedidos.getValueAt(i, 4);
            noProductos=noProductos+Integer.parseInt(cantidad);
            producto = "" + Ventas.PanelVentas.tablaPedidos.getValueAt(i, 1);
            String des = "" + Ventas.PanelVentas.cajaDescuento.getText();
            String importe = "" + Ventas.PanelVentas.tablaPedidos.getValueAt(i, 7);

            String descuentoProducto= "" + Ventas.PanelVentas.tablaPedidos.getValueAt(i, 6);

            if (producto.length() <= 8) {
                producto = producto + "     ";
            }
            if (producto.length() > 15) {
                producto = producto.substring(0, 15);
            }
            cadena = cadena + "" + cantidad + "\t" + producto + "\t" + "$" + importe + "\n";
            subtotal = "" + Ventas.PanelVentas.cajaSubtotal.getText();
        }
        //MANDA A INFORMACIÓN DEL LISTADO DE LOS PRODUCTOS QUE SE COMPRARON
        ticket.AddCabecera(cadena);
        ticket.AddPieLinea(ticket.DibujarLinea(32));
        ticket.AddPieLinea(ticket.DarEspacio());
        
        ticket.AddPieLinea("\tSubtotal:\t$" + subtotal);
        ticket.AddPieLinea(ticket.DarEspacio());

        
        String descuento = "" + Ventas.PanelVentas.cajaDescuento.getText();
        ticket.AddPieLinea("\tDescuento\t%" + descuento);
        ticket.AddPieLinea(ticket.DarEspacio());
        
        String total = "" + Ventas.PanelVentas.cajaTotal.getText();
        ticket.AddPieLinea("\tTotal\t\t$" + total);
        ticket.AddPieLinea(ticket.DarEspacio());
        ticket.AddPieLinea(ticket.DarEspacio());
        ticket.AddPieLinea(ticket.DarEspacio());
        
        //MENSAJE MODIFICABLE (LEYENDA)
        ticket.AddPieLinea(mensaje);
        
        //ESPACIOS PARA EL NUEVO TICKET
        ticket.AddPieLinea(ticket.DarEspacio());
        ticket.AddPieLinea(ticket.DarEspacio());
        ticket.AddPieLinea(ticket.DarEspacio());
        ticket.AddPieLinea(ticket.DarEspacio());
        ticket.AddPieLinea(ticket.DarEspacio());
        ticket.ImprimirDocumento();
        TicketVentas.limpia();
    }   
}
