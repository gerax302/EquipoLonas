/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cotizacion;

/**
 *
 * @author Ana Karen
 */
import java.awt.Color;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Element;

import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.PdfPTable;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import Conexion.Conexion;
import com.mysql.jdbc.*;
import java.sql.DriverManager;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;

import java.io.FileOutputStream;

public class ExportarPDF {

    private static Font fuenteNegrita = new Font(Font.TIMES_ROMAN, 16, Font.BOLD, Color.BLACK);
    private static Font fuenteNegrita2 = new Font(Font.TIMES_ROMAN, 12, Font.BOLD, Color.BLACK);
    private static Font fuenteNormal = new Font(Font.TIMES_ROMAN, 12, Font.NORMAL, Color.BLACK);
    private static Font fuenteChiquita = new Font(Font.TIMES_ROMAN, 8, Font.NORMAL, Color.BLACK);

    public static JFileChooser chooser = new JFileChooser(".");

    public static int numeroC;

    public static Statement stm = null;
    public static String bd = Conexion.nombreBD;
    public static String login = Conexion.usuarioBD;//"root";
    public static String password = Conexion.contrasena;//"280592ssmaylo";
    public static String url = "jdbc:mysql://" + Conexion.nombreServidor + ":" + Conexion.puerto + "/" + Conexion.nombreBD;

    public static String nombrePDF;

    //variables para el metodo acomodarDatosDerecha
    public static String telefonoNegocio, numeroCelular, correoNegocio;
    public static String domicilioNegocio, RFC, leyendaCotizacion;
    public static String colonia, ciudad;

    //variables para el metodo acomodarDatosDerecha2
    public static String fecha, ubicacion, asunto;

    //variables para el metodo acomodarDatosNormal
    public static String nombreCliente, anexo;

    //variables para el metodo acomodarDatosTablaProductos
    public static int numeroFilas;
    public static String cantidadTabla[];
    public static String productoTabla[];
    public static String precioTabla[];
    public static String totalTabla[];
    public static String descripcionTabla[];

    //variables para el metodo acomodarDatosPreciosTotales
    public static String subtotal, iva, descuento, total;

    //variabels para el metodo acomodarDatosEspecificaciones
    public static String especificacionTrabajo, especificacionDiseno;
    public static int idCotiza;
    public static double precio1, precio2;

    //variables para el metodo acomodarATTE
    public static String ate, nombre;
    
    //variables para el metodo acomodarNota
    public static String nota1, leyenda;

    //metodo para el numero de folio y se guarde con el numero
    public static void obtenerNumeroCotizacion() {
        Connection conexion = null;
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            conexion = (Connection) DriverManager.getConnection(url, login, password);
            stm = (Statement) conexion.createStatement();
            ResultSet rs = stm.executeQuery("select max(numero) as numero from todolonas.cotizacion;");

            while (rs.next()) {
                numeroC = rs.getInt("numero");
            }
            conexion.close();
        } catch (Exception e) {
            System.out.println("error obtener max numeroVenta: " + e);
        }
    }

    //guarda el pdf con el nombre del cliente, numero de folio y fecha
    public static void guardarPDF() {
        obtenerNumeroCotizacion();
        nombrePDF = PanelCotizacion.labelObtenerNombreCliente.getText();
        fecha = PanelCotizacion.labelObtenerFecha.getText();
        try {

            Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(numeroC + " " + nombrePDF + " " + fecha + ".pdf"));
            document.open();

            agregarMetaDatos(document);

            agregarContenido(document);

            document.close();

            JOptionPane.showMessageDialog(null, "Se ha generado el archivo PDF " + nombrePDF, "Atención:", JOptionPane.WARNING_MESSAGE);
            System.out.println("Se ha generado el PDF: " + nombrePDF + ".pdf");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //datos necesarios para que se guarde el pdf
    private static void agregarMetaDatos(Document document) {
        document.addTitle("PDF Cliente");
        document.addSubject("Usando iText");
        document.addKeywords("Java, PDF, iText");
        document.addAuthor("Ana Karen Soto");
        document.addCreator("Ana Karen Soto");
    }

    // agrega el contenido por partes el pdf
    private static void agregarContenido(Document document) throws DocumentException, Exception {

        Paragraph parrafoNormal1 = new Paragraph();
        Paragraph parrafoNormal2 = new Paragraph();
        Paragraph parrafoNormal3 = new Paragraph();
        Paragraph parrafoNormal4 = new Paragraph();
        Paragraph parrafoNormal5 = new Paragraph();
        Paragraph parrafoNormal6 = new Paragraph();
        Paragraph parrafoNormal7 = new Paragraph();
        Paragraph parrafoNormal8 = new Paragraph();
        Paragraph parrafoNormal9 = new Paragraph();
        Paragraph parrafoNormal10 = new Paragraph();

        // llama todos los metodos
        acomodarImagenCabecera(parrafoNormal1);
        acomodarImagenLogo(parrafoNormal1);
        acomodarDatosDerecha(parrafoNormal1);
        acomodarDatosDerecha2(parrafoNormal2);
        acomodarDatosNormal(parrafoNormal3);
        acomodarDatosTablaProductos(parrafoNormal4);
        acomodarDatosEspecificaciones(parrafoNormal5);
        acomodarDatosPreciosTotales(parrafoNormal6);
        acomodarImagenFirma(parrafoNormal7);
        acomodarATTE(parrafoNormal8);
        acomodarDatosNota(parrafoNormal9);
        acomodarImagenPie(parrafoNormal10);

        // se anade al documento
        document.add(parrafoNormal1);
        document.add(parrafoNormal2);
        document.add(parrafoNormal3);
        document.add(parrafoNormal4);
        document.add(parrafoNormal5);
        document.add(parrafoNormal6);
        document.add(parrafoNormal7);
        document.add(parrafoNormal8);
        document.add(parrafoNormal9);
        document.add(parrafoNormal10);
    }

    // es para la imagen de cabecera
    private static void acomodarImagenCabecera(Paragraph imagen) {

        try {
            Image im;
            im = Image.getInstance("src/Imagenes/arriba.png");
            im.setAlignment(Image.ALIGN_CENTER | Image.TEXTWRAP);
            imagen.add(im);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    // acomoda el logo 
    private static void acomodarImagenLogo(Paragraph imagen) throws BadElementException {
        try {
            Image im = Image.getInstance("src/Imagenes/todo Lonas.png");
            im.setAlignment(Image.ALIGN_LEFT | Image.TEXTWRAP);
            imagen.add(im);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    // acomoda los datos que estan a la derecha
    private static void acomodarDatosDerecha(Paragraph datosDerecha) throws Exception {
        ciudad = Cotizacion.PanelCotizacion.labelCiudad.getText();
        Connection conexion = null;
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            conexion = (Connection) DriverManager.getConnection(url, login, password);

            stm = (Statement) conexion.createStatement();

            ResultSet rs = stm.executeQuery("SELECT * FROM todolonas.ajustes;");
            while (rs.next()) {
                telefonoNegocio = rs.getString("telefonoNegocio");
                numeroCelular = rs.getString("numeroCelular");
                correoNegocio = rs.getString("correoNegocio");
                domicilioNegocio = rs.getString("domicilioNegocio");
                RFC = rs.getString("RFC");
                leyendaCotizacion = rs.getString("leyendaCotizacion");
                colonia = rs.getString("colonia");
            }
            conexion.close();
        } catch (Exception e) {
            System.out.println("error: " + e);
        }
        PdfPTable table = new PdfPTable(2);
        table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
        table.addCell("");
        table.addCell(telefonoNegocio);
        table.addCell("");
        table.addCell(numeroCelular);
        table.addCell("");
        table.addCell(correoNegocio);
        table.addCell("");
        table.addCell(domicilioNegocio);
        table.addCell("");
        table.addCell(colonia);
        table.addCell("");
        table.addCell(RFC);
        table.addCell("");
        table.addCell(ciudad);
        table.setWidthPercentage(100);
        table.setHorizontalAlignment(Element.ALIGN_RIGHT);
        datosDerecha.add(table);

    }

    // acomoda los datos a la derecha que son fecha, ubicacion asunto
    private static void acomodarDatosDerecha2(Paragraph datosDerecha2) {
        fecha = PanelCotizacion.labelObtenerFecha.getText();
        asunto = PanelCotizacion.cajaAsunto.getText();
        ubicacion = PanelCotizacion.cajaUbicacion.getText();
        PdfPTable table2 = new PdfPTable(2);
        table2.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
        table2.addCell("Fecha");
        table2.addCell(fecha);
        table2.addCell("Ubicación");
        table2.addCell(ubicacion);
        table2.addCell("Asunto");
        table2.addCell(asunto);
        table2.setWidthPercentage(50);
        table2.setHorizontalAlignment(350);
        table2.setHorizontalAlignment(Element.ALIGN_RIGHT);
        datosDerecha2.add(table2);
    }

    // acomoda los datos que van en texto normal que es el nombre del cliente y el anexo
    private static void acomodarDatosNormal(Paragraph datosNormal) throws BadElementException {
        nombreCliente = Cotizacion.PanelCotizacion.labelObtenerNombreCliente.getText();
        anexo = Cotizacion.PanelCotizacion.labelAnexo.getText();
        datosNormal.add(new Paragraph(nombreCliente, fuenteNegrita));
        datosNormal.add(new Paragraph(anexo, fuenteNormal));
        agregarLineasEnBlanco(datosNormal, 1);
        datosNormal.setAlignment(0);
    }

    // acomoda los datos de especificacion de trabajo y diseno
    private static void acomodarDatosEspecificaciones(Paragraph datosNormal) throws BadElementException {
        Connection conexion = null;
        agregarLineasEnBlanco(datosNormal, 1);
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
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            conexion = (Connection) DriverManager.getConnection(url, login, password);

            stm = (Statement) conexion.createStatement();
            ResultSet rs = stm.executeQuery("SELECT especificacionTrabajo FROM todolonas.cotizacion where numero = '" + idCotiza + "';");
            while (rs.next()) {
                especificacionTrabajo = rs.getString("especificacionTrabajo");
            }
            conexion.close();
        } catch (Exception e) {
            System.out.println("error: " + e);
        }
        if (especificacionTrabajo.equals("NA")) {
            System.out.println("no hay especificacion trabajo");
            precio1 = DatosExtra.precio1;
            PdfPTable table2 = new PdfPTable(4);
            table2.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
            table2.addCell("Especificación Trabjo");
            table2.addCell("");
            table2.addCell("Precio Especificación");
            table2.addCell("$   "+precio1);
            table2.setWidthPercentage(100);
            table2.setHorizontalAlignment(Element.ALIGN_LEFT);
////            agregarLineasEnBlanco(datosNormal, 1);
            datosNormal.add(table2);
        } else {
            precio1 = DatosExtra.precio1;
            PdfPTable table2 = new PdfPTable(4);
            table2.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
            table2.addCell("Especificación Trabajo");
            table2.addCell(especificacionTrabajo);
            table2.addCell("Precio Especificación");
            table2.addCell("$   "+precio1);
            table2.setWidthPercentage(100);
            table2.setHorizontalAlignment(Element.ALIGN_LEFT);
//            agregarLineasEnBlanco(datosNormal, 1);
            datosNormal.add(table2);
        }
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            conexion = (Connection) DriverManager.getConnection(url, login, password);

            stm = (Statement) conexion.createStatement();

            ResultSet rs = stm.executeQuery("SELECT especificacionDiseno FROM todolonas.cotizacion where numero = '" + idCotiza + "';");
            while (rs.next()) {
                especificacionDiseno = rs.getString("especificacionDiseno");
            }
            conexion.close();
        } catch (Exception e) {
            System.out.println("error: " + e);
        }
        if (especificacionDiseno.equals("NA")) {
            System.out.println("no hay especificacion trabajo");
            precio2 = DatosExtra.precio2;
            PdfPTable table2 = new PdfPTable(4);
            table2.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
            table2.addCell("Especificación Diseño");
            table2.addCell("");
            table2.addCell("Precio Especificación");
            table2.addCell("$   "+precio2);
            table2.setWidthPercentage(100);
            table2.setHorizontalAlignment(Element.ALIGN_LEFT);
////            agregarLineasEnBlanco(datosNormal, 1);
            datosNormal.add(table2);
        } else {
            precio2 = DatosExtra.precio2;
            PdfPTable table2 = new PdfPTable(4);
            table2.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
            table2.addCell("Especificación Diseño");
            table2.addCell(especificacionDiseno);
            table2.addCell("Precio Especificación");
            table2.addCell("$   "+precio2);
            table2.setWidthPercentage(100);
            table2.setHorizontalAlignment(Element.ALIGN_LEFT);
////            agregarLineasEnBlanco(datosNormal, 1);
            datosNormal.add(table2);
        }
    }

    // crea la tabla de productos
    private static void acomodarDatosTablaProductos(Paragraph subCatPart) throws BadElementException {
        numeroFilas = LogicaCotizacion.numero;
        cantidadTabla = new String[numeroFilas];
        productoTabla = new String[numeroFilas];
        precioTabla = new String[numeroFilas];
        totalTabla = new String[numeroFilas];
        descripcionTabla = new String[numeroFilas];

        PdfPTable tabla = new PdfPTable(5);
        tabla.setWidthPercentage(100);

        PdfPCell celda = new PdfPCell(new Paragraph("Producto"));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setBackgroundColor(new Color(0, 175, 239));
        tabla.addCell(celda);
        celda = new PdfPCell(new Paragraph("Descripción"));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setBackgroundColor(new Color(0, 175, 239));
        tabla.addCell(celda);
        celda = new PdfPCell(new Paragraph("Precio Unitario"));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setBackgroundColor(new Color(0, 175, 239));
        tabla.addCell(celda);
        celda = new PdfPCell(new Paragraph("Cantidad"));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setBackgroundColor(new Color(0, 175, 239));
        tabla.addCell(celda);
        celda = new PdfPCell(new Paragraph("Total"));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setBackgroundColor(new Color(0, 175, 239));
        tabla.addCell(celda);
        for (int i = 0; i < numeroFilas; i++) {
            productoTabla[i] = "" + Cotizacion.PanelCotizacion.tablaProductos.getValueAt(i, 0);
            tabla.addCell("   " + productoTabla[i]);
            descripcionTabla[i] = "" + Cotizacion.PanelCotizacion.tablaProductos.getValueAt(i, 1);
            tabla.addCell("" + descripcionTabla[i]);
            precioTabla[i] = "" + Cotizacion.PanelCotizacion.tablaProductos.getValueAt(i, 2);
            tabla.addCell("$  " + precioTabla[i]);
            cantidadTabla[i] = "" + Cotizacion.PanelCotizacion.tablaProductos.getValueAt(i, 3);
            tabla.addCell("   " + cantidadTabla[i]);
            totalTabla[i] = "" + Cotizacion.PanelCotizacion.tablaProductos.getValueAt(i, 6);
            tabla.addCell("$  " + totalTabla[i]);
        }
        agregarLineasEnBlanco(subCatPart, 1);
        subCatPart.add(tabla);
    }

    // acomoda el attentamente
    private static void acomodarATTE(Paragraph datosCentro) throws BadElementException {
        ate = PanelCotizacion.labelATE.getText();
        nombre = PanelCotizacion.labelObtenerATTE.getText();
        datosCentro.add(new Paragraph(ate, fuenteNegrita2));
        datosCentro.add(new Paragraph(nombre, fuenteNegrita2));
        datosCentro.setAlignment(1);
    }

    // acomoda el subtotal total descuento e iva
    private static void acomodarDatosPreciosTotales(Paragraph datosDerecha2) throws BadElementException {
        subtotal = PanelCotizacion.cajaSubtotal.getText();
        iva = PanelCotizacion.cajaIVA.getText();
        descuento = PanelCotizacion.cajaDescuento.getText();
        total = PanelCotizacion.cajaTotal.getText();

        PdfPTable table2 = new PdfPTable(2);
        table2.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
        table2.addCell("Subtotal");
        table2.addCell("$  " + subtotal);
        table2.addCell("IVA");
        table2.addCell("%  "+iva);
        table2.addCell("Descuento");
        table2.addCell("%  "+descuento);
        table2.addCell("Total");
        table2.addCell("$  " + total);
        table2.setWidthPercentage(30);
        table2.setHorizontalAlignment(350);
        table2.setHorizontalAlignment(Element.ALIGN_RIGHT);
        agregarLineasEnBlanco(datosDerecha2, 1);
        datosDerecha2.add(table2);
    }

    // acomoda la nota que esta en la parte de abajo
    private static void acomodarDatosNota(Paragraph datosNormal2) throws BadElementException {
        nota1 = PanelCotizacion.labelNota1.getText();
        leyenda = PanelCotizacion.areaLeyenda.getText();
        agregarLineasEnBlanco(datosNormal2, 5);
        datosNormal2.add(new Paragraph(nota1, fuenteChiquita));
        datosNormal2.add(new Paragraph(leyenda, fuenteChiquita));
        datosNormal2.setAlignment(0);
    }

    // acomoda la firma digital del cliente
    private static void acomodarImagenFirma(Paragraph imagen) throws BadElementException {
        try {
            Image im = Image.getInstance("src/Imagenes/firma3.png");
            im.setAlignment(Image.ALIGN_CENTER | Image.TEXTWRAP);
            imagen.add(im);
//            agregarLineasEnBlanco(parrafoNormal, 3);

        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    // acomoda la imagen que va en el pie de pagina
    private static void acomodarImagenPie(Paragraph imagen) throws BadElementException {
        try {
            Image im = Image.getInstance("src/Imagenes/abajo.png");
            im.setAbsolutePosition(0, 0);
            im.setAlignment(Image.ALIGN_CENTER);
            im.scalePercent(60f);
            imagen.add(im);

        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    // agrega el salto de linea
    private static void agregarLineasEnBlanco(Paragraph parrafo, int nLineas) {
        for (int i = 0; i < nLineas; i++) {
            parrafo.add(new Paragraph(" "));
        }
    }

}
