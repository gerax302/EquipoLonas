package Cotizacion;

/**
 *
 * @author Ana Karen
 */
import java.awt.Color;
import java.io.FileOutputStream;
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

public class ExportarPDF {
//    private static String strNombreDelPDF = "MiPrimerPDF.pdf";

//    private static Font fuenteMagenta36 = new Font(Font.TIMES_ROMAN, 36, Font.BOLD, Color.MAGENTA);
//    private static Font fuenteNegra12 = new Font(Font.TIMES_ROMAN, 12, Font.BOLD, Color.BLACK);
//    private static Font fuenteVerde12 = new Font(Font.TIMES_ROMAN, 12, Font.NORMAL, Color.GREEN);
    private static Font fuenteNegrita = new Font(Font.TIMES_ROMAN, 16, Font.BOLD, Color.BLACK);
    private static Font fuenteNegrita2 = new Font(Font.TIMES_ROMAN, 12, Font.BOLD, Color.BLACK);
    private static Font fuenteNormal = new Font(Font.TIMES_ROMAN, 12, Font.NORMAL, Color.BLACK);
    private static Font fuenteChiquita = new Font(Font.TIMES_ROMAN, 10, Font.NORMAL, Color.BLACK);

    public static JFileChooser chooser = new JFileChooser(".");
    public static int numero;
    public static String productoTabla[];
    public static String precioTabla[];
    public static String cantidadTabla[];
    public static String totalTabla[];
    public static String descripcionTabla[];
    public static String asunto, ubicacion, telefono, correo, domicilio;
    public static String rfc, fecha, ciudad, nota1, iva, obtenerCelular;
    public static String descuento, ate, nombre, total;
    public static String obtenerTelefono, obtenerCorreo, obtenerDomicilio, obtenerColonia, obtenerRFC;
    public static String obtenerFecha, obtenerAsunto, obtenerUbicacion, obtenerDescuento, obtenerIVA;
    public static String obtenerTotal, obtenerCliente, obtenerLeyenda;
    public static String subtotal, obtenerSubtotal, anexo, hora;
    public static int numeroC;
    
    public static Statement stm = null;
    public static String bd = Conexion.nombreBD;
    public static String login = Conexion.usuarioBD;//"root";
    public static String password = Conexion.contrasena;//"280592ssmaylo";
    public static String url = "jdbc:mysql://" + Conexion.nombreServidor + ":" + Conexion.puerto + "/" + Conexion.nombreBD;

    public static String nombrePDF;

    public static void obtenerNumeroCotizacion(){
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
    public static void guardarPDF() {
        nombrePDF = PanelCotizacion.labelObtenerNombreCliente.getText();
        fecha = PanelCotizacion.labelObtenerFecha.getText();
        System.out.println("hora=====     "+hora);
        try {
            Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(numeroC+" "+nombrePDF +" "+fecha+".pdf"));
            document.open();

            agregarMetaDatos(document);
            agregarContenido(document);

            document.close();

            JOptionPane.showMessageDialog(null, "Se ha generado el archivo PDF "+nombrePDF, "Atención:", JOptionPane.WARNING_MESSAGE);
            System.out.println("Se ha generado el PDF: " + nombrePDF + ".pdf");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void agregarMetaDatos(Document document) {
        document.addTitle("PDF Cliente");
        document.addSubject("Usando iText");
        document.addKeywords("Java, PDF, iText");
        document.addAuthor("Ana Karen Soto");
        document.addCreator("Ana Karen Soto");
    }

    private static void agregarContenido(Document document) throws DocumentException {
        asunto = PanelCotizacion.labelAsunto.getText();
        ubicacion = PanelCotizacion.labelUbicacion.getText();
        telefono = PanelCotizacion.labelTelefono.getText();
        correo = PanelCotizacion.labelCorreo.getText();
        domicilio = PanelCotizacion.labelDomicilio.getText();
        rfc = PanelCotizacion.labelRFC.getText();
        fecha = PanelCotizacion.labelFecha.getText();
        ciudad = PanelCotizacion.labelCiudad.getText();
        nota1 = PanelCotizacion.labelNota1.getText();
        iva = PanelCotizacion.labelIVA.getText();
        subtotal = PanelCotizacion.labelSubTotal.getText();
        descuento = PanelCotizacion.labelDescuento.getText();
        ate = PanelCotizacion.labelATE.getText();
        nombre = PanelCotizacion.labelNombre.getText();
        obtenerTelefono = PanelCotizacion.labelObtenerTelefono.getText();
        obtenerCorreo = PanelCotizacion.labelObtenerCorreo.getText();
        obtenerDomicilio = PanelCotizacion.labelObtenerDomicilio.getText();
        obtenerColonia = PanelCotizacion.labelObtenerColonia.getText();
        obtenerRFC = PanelCotizacion.labelObtenerRFC.getText();
        obtenerFecha = PanelCotizacion.labelObtenerFecha.getText();
        obtenerAsunto = PanelCotizacion.cajaAsunto.getText();
        obtenerUbicacion = PanelCotizacion.cajaUbicacion.getText();
        obtenerDescuento = PanelCotizacion.cajaDescuento.getText();
        obtenerIVA = PanelCotizacion.cajaIVA.getText();
        obtenerTotal = PanelCotizacion.cajaTotal.getText();
        obtenerCliente = PanelCotizacion.labelObtenerNombreCliente.getText();
        obtenerLeyenda = PanelCotizacion.areaLeyenda.getText();
        obtenerSubtotal = PanelCotizacion.cajaSubTotal.getText();
        obtenerCelular = PanelCotizacion.labelObtenerCelular.getText();
        anexo = PanelCotizacion.labelLeyenda.getText();
        total = PanelCotizacion.labelTotal.getText();

        Paragraph parrafoNormal = new Paragraph();
        Paragraph parrafoNormal2 = new Paragraph();
        Paragraph parrafoNormal3 = new Paragraph();
        Paragraph parrafoNormal4 = new Paragraph();
        Paragraph parrafoNormal5 = new Paragraph();

        imagen1(parrafoNormal);
        imagen2(parrafoNormal);
        datosDerecha1(parrafoNormal);
        datosNormal1(parrafoNormal2);
        crearTabla(parrafoNormal2);
        datosDerecha2(parrafoNormal3);
        imagen4(parrafoNormal4);
        datosCentro(parrafoNormal4);
        datosNormal2(parrafoNormal5);
        imagen3(parrafoNormal5);
        
        
        document.add(parrafoNormal);
        document.add(parrafoNormal2);
        document.add(parrafoNormal3);
        document.add(parrafoNormal4);
        document.add(parrafoNormal5);
    }

    private static void datosDerecha1(Paragraph datosDerecha) throws BadElementException {
        datosDerecha.add(new Paragraph(obtenerTelefono, fuenteNormal));
        datosDerecha.add(new Paragraph(obtenerCelular, fuenteNormal));
        datosDerecha.add(new Paragraph(obtenerCorreo, fuenteNormal));
        datosDerecha.add(new Paragraph(obtenerDomicilio, fuenteNormal));
        datosDerecha.add(new Paragraph(obtenerColonia, fuenteNormal));
        datosDerecha.add(new Paragraph(ciudad, fuenteNormal));
        datosDerecha.add(new Paragraph(obtenerRFC, fuenteNormal));
        datosDerecha.add(new Paragraph(fecha + "                         " + obtenerFecha, fuenteNegrita2));
        datosDerecha.add(new Paragraph(asunto + "                        " + obtenerAsunto, fuenteNegrita2));
        datosDerecha.add(new Paragraph(ubicacion + "                        " + obtenerUbicacion, fuenteNegrita2));
        datosDerecha.setAlignment(2);
    }

    private static void datosCentro(Paragraph datosCentro) throws BadElementException {
        datosCentro.add(new Paragraph(ate, fuenteNegrita2));
        datosCentro.add(new Paragraph(nombre, fuenteNegrita2));
        datosCentro.setAlignment(1);
    }
    private static void datosDerecha2(Paragraph datosDerecha2) throws BadElementException {
        PdfPTable tabla2 = new PdfPTable(2);
        tabla2.setWidthPercentage(100);
        tabla2.addCell(subtotal);
        tabla2.addCell(obtenerSubtotal);
        tabla2.addCell(descuento);
        tabla2.addCell(obtenerDescuento);
        tabla2.addCell(iva);
        tabla2.addCell(obtenerIVA);
        tabla2.addCell(total);
        tabla2.addCell(obtenerTotal);
//        datosDerecha2.add(new Paragraph(subtotal + "                    " + obtenerSubtotal, fuenteNegrita2));
//        datosDerecha2.add(new Paragraph(descuento + "                    " + obtenerDescuento, fuenteNegrita2));
//        datosDerecha2.add(new Paragraph(iva + "                    " + obtenerIVA, fuenteNegrita2));
//        datosDerecha2.add(new Paragraph(total + "                    " + obtenerTotal, fuenteNegrita2));
        datosDerecha2.setAlignment(2);
//        agregarLineasEnBlanco(datosDerecha2, 3); 
        datosDerecha2.add(tabla2);
    }

    private static void datosNormal1(Paragraph datosNormal) throws BadElementException {
        datosNormal.add(new Paragraph(obtenerCliente, fuenteNegrita));
        agregarLineasEnBlanco(datosNormal, 1);
        datosNormal.add(new Paragraph(anexo, fuenteNormal));
//        agregarLineasEnBlanco(datosNormal, 1);
        datosNormal.setAlignment(0);
    }

    private static void datosNormal2(Paragraph datosNormal2) throws BadElementException {
        agregarLineasEnBlanco(datosNormal2, 5);
        datosNormal2.add(new Paragraph(nota1, fuenteChiquita));
        datosNormal2.add(new Paragraph(obtenerLeyenda, fuenteChiquita));
        datosNormal2.setAlignment(0);
    }

    private static void imagen1(Paragraph imagen) throws BadElementException {
        try {
            Image im = Image.getInstance("src/Imagenes/arriba.png");
            im.setAlignment(Image.ALIGN_CENTER | Image.TEXTWRAP);
            imagen.add(im);
//            agregarLineasEnBlanco(parrafoNormal, 5);

        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    private static void imagen2(Paragraph imagen) throws BadElementException {
        try {
            Image im = Image.getInstance("src/Imagenes/todo Lonas.png");
            im.setAlignment(Image.ALIGN_LEFT | Image.TEXTWRAP);
            imagen.add(im);
//            agregarLineasEnBlanco(parrafoNormal, 3);

        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    private static void imagen4(Paragraph imagen) throws BadElementException {
        try {
            Image im = Image.getInstance("src/Imagenes/firma3.png");
            im.setAlignment(Image.ALIGN_CENTER | Image.TEXTWRAP);
            imagen.add(im);
//            agregarLineasEnBlanco(parrafoNormal, 3);

        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
    private static void imagen3(Paragraph imagen) throws BadElementException {
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

    private static void crearTabla(Paragraph subCatPart) throws BadElementException {
        numero = LogicaCotizacion.numero;
        cantidadTabla = new String[numero];
        productoTabla = new String[numero];
        precioTabla = new String[numero];
        totalTabla = new String[numero];
        descripcionTabla = new String[numero];

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
        celda = new PdfPCell(new Paragraph("P/U"));
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

        for (int i = 0; i < numero; i++) {
            productoTabla[i] = "" + Cotizacion.PanelCotizacion.tablaProductos.getValueAt(i, 0);
            tabla.addCell("" + productoTabla[i]);
            descripcionTabla[i] = "" + Cotizacion.PanelCotizacion.tablaProductos.getValueAt(i, 1);
            tabla.addCell("" + descripcionTabla[i]);
            precioTabla[i] = "" + Cotizacion.PanelCotizacion.tablaProductos.getValueAt(i, 2);
            tabla.addCell("                 " + precioTabla[i]);
            cantidadTabla[i] = "" + Cotizacion.PanelCotizacion.tablaProductos.getValueAt(i, 3);
            tabla.addCell("                 " + cantidadTabla[i]);
            totalTabla[i] = "" + Cotizacion.PanelCotizacion.tablaProductos.getValueAt(i, 4);
            tabla.addCell("                 " + totalTabla[i]);
        }
        subCatPart.add(tabla);
    }

    private static void agregarLineasEnBlanco(Paragraph parrafo, int nLineas) {
        for (int i = 0; i < nLineas; i++) {
            parrafo.add(new Paragraph(" "));
        }
    }

}
