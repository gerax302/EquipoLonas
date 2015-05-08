package TicketAbonos;

import Consultas.PanelConsultas.*;
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
import Ajustes.PanelAjustes.*;
import TodoLonas.*;

public class EstructuraTicket {

    public static String mensaje = Ajustes.PanelAjustes.mensajeTicket; 
    public static String cajero = Principal.usuarioActivo, folio = "";
    public static String fechaPedido = "", fechaEntrega = "", estatus = "";
    public static String formaPago = "", total = "", anticipo = "";
    
    public static void imprime(int num) throws PrintException, IOException {
        Date date = new Date();
        TicketAbonos ticket = new TicketAbonos();

        ticket.AddCabecera("RFC:     CAAO84090943A");
        ticket.AddCabecera(ticket.DarEspacio());
        ticket.AddCabecera(ticket.DarEspacio());
        
        SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy  ");
        SimpleDateFormat hora = new SimpleDateFormat("   hh:mm:ss aa");
        ticket.AddCabecera("" + fecha.format(date) + "     " + hora.format(date));
        ticket.AddCabecera(ticket.DarEspacio());
        ticket.AddCabecera("Atendido por: " + cajero);
        ticket.AddCabecera(ticket.DarEspacio());
        ticket.AddCabecera(ticket.DarEspacio());

        
        for (int i = 0; i < num; i++){
            fechaPedido = "" + Consultas.PanelConsultas.tablaMostrarConsulta.getValueAt(Consultas.PanelConsultas.seleccion, 5);
            System.out.println("fecha pedido " + fechaPedido);
            fechaEntrega = "" + Consultas.PanelConsultas.tablaMostrarConsulta.getValueAt(Consultas.PanelConsultas.seleccion, 6);
            estatus = "" + Consultas.PanelConsultas.tablaMostrarConsulta.getValueAt(Consultas.PanelConsultas.seleccion, 8);
            formaPago = "" + Consultas.PanelConsultas.tablaMostrarConsulta.getValueAt(Consultas.PanelConsultas.seleccion, 9);
            total = "" + Consultas.PanelConsultas.tablaMostrarConsulta.getValueAt(Consultas.PanelConsultas.seleccion, 10);
            anticipo = "" + Consultas.PanelConsultas.tablaMostrarConsulta.getValueAt(Consultas.PanelConsultas.seleccion, 11);
            folio = "" + Consultas.PanelConsultas.tablaMostrarConsulta.getValueAt(Consultas.PanelConsultas.seleccion, 0);
        }
       
        ticket.AddCabecera("Pedido No. " + folio);
        ticket.AddCabecera(ticket.DarEspacio());
        ticket.AddCabecera(ticket.DibujarLinea(32));
        ticket.AddCabecera(ticket.DarEspacio());
        
        //CONSIDERAR COMO CALCULA EL IVA SU CONTADOR
        ticket.AddPieLinea("Fecha Pedido :\t" + fechaPedido);
        ticket.AddPieLinea(ticket.DarEspacio());
        
        ticket.AddPieLinea("Fecha Entrega:\t" + fechaEntrega);
        ticket.AddPieLinea(ticket.DarEspacio());
        
        ticket.AddPieLinea("Estatus      :\t" + estatus);
        ticket.AddPieLinea(ticket.DarEspacio());
        
        ticket.AddPieLinea("Forma de Pago:\t" + formaPago);
        ticket.AddPieLinea(ticket.DarEspacio());
        
        ticket.AddPieLinea(ticket.DarEspacio());
        ticket.AddPieLinea(ticket.DibujarLinea(32));
        ticket.AddPieLinea(ticket.DarEspacio());
        
        ticket.AddPieLinea("\tTotal   :\t$" + total);
        ticket.AddPieLinea(ticket.DarEspacio());
        
        ticket.AddPieLinea("\tAnticipo:\t$" + anticipo);
        ticket.AddPieLinea(ticket.DarEspacio());
        
        ticket.AddPieLinea(ticket.DarEspacio());
        ticket.AddPieLinea(ticket.DarEspacio());       
        ticket.AddPieLinea(ticket.DarEspacio());
        ticket.AddPieLinea(ticket.DarEspacio());
        
        //ESPACIO PARA NOMBRE Y FIRMA
        ticket.AddPieLinea("_______________________________\t");
        ticket.AddPieLinea(ticket.DarEspacio());
        ticket.AddPieLinea("\tNombre y Firma\t");
        
        //ESPACIOS PARA EL NUEVO TICKET
        ticket.AddPieLinea(ticket.DarEspacio());
        ticket.AddPieLinea(ticket.DarEspacio());
        ticket.AddPieLinea(ticket.DarEspacio());
        ticket.AddPieLinea(ticket.DarEspacio());
        ticket.AddPieLinea(ticket.DarEspacio());
        ticket.ImprimirDocumento();
        TicketAbonos.limpia();
    }
}
