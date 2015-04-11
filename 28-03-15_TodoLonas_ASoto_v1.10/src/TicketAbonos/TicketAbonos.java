package TicketAbonos;

import static TicketAbonos.Personalizar.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TicketAbonos {

    static ArrayList<String> CabezaLineas = new ArrayList<String>();
    static ArrayList<String> subCabezaLineas = new ArrayList<String>();
    static ArrayList<String> items = new ArrayList<String>();
    static ArrayList<String> totales = new ArrayList<String>();
    static ArrayList<String> LineasPie = new ArrayList<String>();

    public static JFileChooser fileChooser;
    public static FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagen", "jpg", "gif", "png");
    public static FileInputStream fileInputStream = null;

    public static void AddCabecera(String line) {
        CabezaLineas.add(line);
    }

    public static void AddSubCabecera(String line) {
        subCabezaLineas.add(line);
    }

    public static void AddItem(String cantidad, String item, String price) {
        OrderItem newItem = new OrderItem(' ');
        items.add(newItem.GeneraItem(cantidad, item, price));
    }

    public static void AddTotal(String name, String price) {
        OrderTotal newTotal = new OrderTotal(' ');
        totales.add(newTotal.GeneraTotal(name, price));
    }

    public static void AddPieLinea(String line) {
        LineasPie.add(line);
    }

    public static String DibujarLinea(int valor) {
        String raya = "";
        for (int x = 0; x < valor; x++) {
            raya += "=";
        }
        return raya;
    }

    public static String DarEspacio() {
        return "\n";
    }

    public static void ImprimirDocumento() throws PrintException, IOException {
        imprime_imagen();
        String cadena = "";
        for (int cabecera = 0; cabecera < CabezaLineas.size(); cabecera++) {
            cadena += CabezaLineas.get(cabecera);
        }
        for (int subcabecera = 0; subcabecera < subCabezaLineas.size(); subcabecera++) {
            cadena += subCabezaLineas.get(subcabecera);
        }
        for (int ITEM = 0; ITEM < items.size(); ITEM++) {
            cadena += items.get(ITEM);
        }
        for (int total = 0; total < totales.size(); total++) {
            cadena += totales.get(total);
        }
        for (int pie = 0; pie < LineasPie.size(); pie++) {
            cadena += LineasPie.get(pie);
        }
        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
        PrintService service = PrintServiceLookup.lookupDefaultPrintService();
        DocPrintJob pj = service.createPrintJob();
        byte[] bytes = cadena.getBytes();
        Doc doc = new SimpleDoc(bytes, flavor, null);
        try {
            System.out.println("IMPRIMIENDO");
            pj.print(doc, null);
        } catch (Exception e) {
            System.out.println("ERROR!!");
            JOptionPane.showMessageDialog(null, "NO FUE POSIBLE IMPRIMIR EL TICKET");
            e.printStackTrace();
        }
    }

    public static void limpia() {
        CabezaLineas.clear();
        subCabezaLineas.clear();
        items.clear();
        totales.clear();
        LineasPie.clear();
    }

    public static void imprime_imagen() {
        PrinterJob pj = PrinterJob.getPrinterJob();

        PageFormat pf = pj.defaultPage();
        Paper paper = new Paper();
        double margin = 0; // half inch
        paper.setImageableArea(margin, margin, paper.getWidth() - margin * 0, paper.getHeight() - margin * 0);
        pf.setPaper(paper);

        pj.setPrintable(new MyPrintable(), pf);
        try {
            pj.print();
        } catch (PrinterException e) {
            System.out.println(e);
        }
    }    
}

class MyPrintable implements Printable {

    private BufferedImage img = null;

    public int print(Graphics g, PageFormat pf, int pageIndex) {
        if (pageIndex != 0) {
            return NO_SUCH_PAGE;
        }
        Graphics2D g2 = (Graphics2D) g;
        try {
            img = ImageIO.read(ClassLoader.getSystemResource("TicketAbonos/logo ticket.png"));
            
        } catch (IOException ex) {
            System.out.println("No se pudo leer la imagen");
        }
        g2.drawImage(img, 0, 0, null);
        return PAGE_EXISTS;
    }
}
