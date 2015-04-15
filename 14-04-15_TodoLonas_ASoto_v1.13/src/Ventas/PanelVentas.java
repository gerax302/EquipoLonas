/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventas;

import java.util.Calendar;
import Conexion.Conexion;
import Pedidos.Pedidos;
import com.mysql.jdbc.*;
import java.sql.DriverManager;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Ana Karen
 */
public class PanelVentas extends javax.swing.JPanel {

    DefaultTableModel modelo = new DefaultTableModel();

    //NOMBRE DE COLUMNAS
    public static String[] nombreColumnas = {"Nombre", "Descripción", "Precio Unitario"};
    public static int numeroCabezeras = nombreColumnas.length;

    //ENVIA LA FECHA A LA VENTANA DE VENTAS 
    public static Calendar cal = Calendar.getInstance();
    public static SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    public static String varFechaReg = cal.get(cal.DATE) + "-" + (cal.get(cal.MONTH) + 1) + "-" + cal.get(cal.YEAR);
    public static String horaActual = cal.get(Calendar.HOUR) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND);

    //Guardar datos para utilizarlos en cobrar      
    public static Double importeFinal = 0.0;

    // CONSULTAS EN LA BASE DE DATOS
    public static String sqlClientes = "SELECT nombreCliente FROM cliente;";
    public static String sqlDescuento = "";
    public static String sqlProductos = "select nombreProducto, descripcion, precioUnitario from producto;";

    //VARIABLES PATA LA OPERACION DE VENTAS 
    public static String buscarCategoriaCliente;
    public double totalFilasTablaPedidos, sumaFilas, importe;
    public static double descuentoInicial = 0.0, subtotalInicial = 0.0, importeInicial = 0.0;
    public double subtotalFinal = 0.0, totalFinal = 0.0, descuentoFinal = 0.0;
    public static double importeFinalCobrar, descuentoAMedida = 0.0;
    public static double descuentoActual = 0.0;

    //VARIABLES  
    public static String obtieneCategoriaProductoCombo = "";
    public static String valorComboCliente = "", nombreCliente;

    //VARIABLE PARA GUARDAR LOS PRODUCTOS DE LA VENTA CORRESPONDIENTES A LA VENTA 
    public static int idVenta = 0, idProducto = 0, idVentasInicial = 0, idVentaMax = 0;
    public static String nombreProducto = "", precioUnitarioProducto = "", cantidadProducto = "", importeProducto = "";

    public static String aux1, aux2;

    //REALIZAR CONSULTAS PARA EL GUARDADO DE VENTAS 
    public static Statement stm = null;
    public static String bd = Conexion.nombreBD;
    public static String login = Conexion.usuarioBD;
    public static String password = Conexion.contrasena;
    public static String url = "jdbc:mysql://" + Conexion.nombreServidor + ":" + Conexion.puerto + "/" + Conexion.nombreBD;
    
    public static String nombreClientePedidos, nombreUsuarioPedidos, fechaSistemaPedidos;

    /**
     * Creates new form PanelVentas2
     */
    public PanelVentas() {
//            conecta();
        initComponents();
        UpdateJTable();
        botonPedidos.setVisible(false);
        aux1 = comboCliente.getSelectedItem().toString();
        if (aux1.equals("Todos")) {
            UpdateJTable();
        }
        agregarCliente();
        comboClienteSeleccionar();
        fechaSistema.setText(varFechaReg);
    }

    public static void UpdateJTable() {

        Connection conexion = null;
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            conexion = (Connection) DriverManager.getConnection(url, login, password);
            stm = (Statement) conexion.createStatement();
            ResultSet rs = stm.executeQuery("select nombreProducto, descripcion, precioUnitario from producto;");

            while (rs.next()) {
                tablaMostrarProductos.setModel(DbUtils.resultSetToTableModel(rs));
                for (int n = 0; n < numeroCabezeras; n++) {
                    tablaMostrarProductos.getColumnModel().getColumn(n).setHeaderValue(nombreColumnas[n]);
                }
            }
            conexion.close();
        } catch (Exception e) {
            System.out.println("error obtener max numeroVenta: " + e);
        }
    }

    //FUNCIONAL---- AGREGA CLIENTE AL COMBO BOX 
    public static void agregarCliente() {
        Connection conexion = null;
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            conexion = (Connection) DriverManager.getConnection(url, login, password);
            stm = (Statement) conexion.createStatement();
            ResultSet rs = stm.executeQuery("select nombreCliente from todolonas.cliente;");

            while (rs.next()) {
                comboCliente.addItem(rs.getString(1));
            }
            conexion.close();
        } catch (Exception e) {
            System.out.println("error obtener max numeroVenta: " + e);
        }
    }

    //FUNCIONAL---> HACE LAS OPERACIONES DE ACUERDO AL CLIENTE Y SU CATEGORIA
    public void operacionesVenta(Double descuentoAMedida) {
        int total = tablaPedidos.getRowCount();
        cajaSubtotal.setText("");
        cajaDescuento.setText("");
        cajaTotal.setText("");
        importe = 0;
        totalFinal = 0;
        for (int i = 0; i < total; i++) {
            sumaFilas = Double.parseDouble(String.valueOf(tablaPedidos.getValueAt(i, 4)));
            importe = importe + sumaFilas;
            System.out.println("IMPORTE" + importe);
        }
        cajaSubtotal.setText(String.valueOf(importe));

        double posDescuento = 0.0, descuento = 0.0;
        String subtotalCaja = cajaSubtotal.getText();

        posDescuento = descuentoAMedida;
        subtotalFinal = Double.parseDouble(subtotalCaja);
        System.out.println("subt " + subtotalFinal);
        System.out.println(" DESC " + posDescuento);
        descuento = subtotalFinal * posDescuento;
        descuentoFinal = descuento;
        totalFinal = subtotalFinal - descuentoFinal;

        cajaSubtotal.setText("" + Math.rint(subtotalFinal * 100) / 100);
        cajaDescuento.setText("" + Math.rint(descuentoFinal * 100) / 100);
        cajaTotal.setText("" + Math.rint(totalFinal * 100) / 100);
        importeFinal = totalFinal;

    }

    //FUNCIONAL---> VALIDAR NUMEROS ENTEROS 
    private static boolean isNumber(String n) {
        try {
            Integer.parseInt(n);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comboCategoriaProducto = new javax.swing.JComboBox();
        cajaBusqueda = new javax.swing.JTextField();
        labelAgregarProducto = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labelAgregarVenta = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMostrarProductos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        comboCliente = new javax.swing.JComboBox();
        fechaSistema = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaPedidos = new javax.swing.JTable();
        labelCancelar = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        labelCorteCaja = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        labelRealizarVenta = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        cajaDescuento = new javax.swing.JTextField();
        cajaSubtotal = new javax.swing.JTextField();
        cajaTotal = new javax.swing.JTextField();
        botonPedidos = new javax.swing.JButton();

        setBackground(new java.awt.Color(62, 64, 149));
        setToolTipText("");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Agregar Producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Categoría:");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Nombre:");

        comboCategoriaProducto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        comboCategoriaProducto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "Gran Formato", "Vinil", "Alta Resolución", "Offset", "Impresión Digital", "Rigidos", "Rotulación", "Estructuras", "Lonas", "Diseño Grafico", "Toldos", "Artículos Promocionales", "Otros" }));
        comboCategoriaProducto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboCategoriaProductoItemStateChanged(evt);
            }
        });

        cajaBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cajaBusquedaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaBusquedaKeyTyped(evt);
            }
        });

        labelAgregarProducto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelAgregarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/addProd.png"))); // NOI18N
        labelAgregarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelAgregarProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelAgregarProductoMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Agregar Producto");

        labelAgregarVenta.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelAgregarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/addVent.png"))); // NOI18N
        labelAgregarVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelAgregarVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelAgregarVentaMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Agregar a la Venta");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 175, 239)));

        tablaMostrarProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaMostrarProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane1.setViewportView(tablaMostrarProductos);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cajaBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboCategoriaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(77, 77, 77)
                                .addComponent(jLabel6)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(labelAgregarProducto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelAgregarVenta)
                        .addGap(60, 60, 60))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboCategoriaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cajaBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelAgregarProducto)
                    .addComponent(labelAgregarVenta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ventas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/order.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("Cliente:");

        comboCliente.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        comboCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar..." }));
        comboCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboClienteActionPerformed(evt);
            }
        });

        fechaSistema.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 175, 239)));

        tablaPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Descripción", "P/U", "Cantidad", "Importe"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaPedidos);
        if (tablaPedidos.getColumnModel().getColumnCount() > 0) {
            tablaPedidos.getColumnModel().getColumn(0).setResizable(false);
            tablaPedidos.getColumnModel().getColumn(1).setResizable(false);
            tablaPedidos.getColumnModel().getColumn(2).setResizable(false);
            tablaPedidos.getColumnModel().getColumn(3).setResizable(false);
            tablaPedidos.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        labelCancelar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancelarVenta.png"))); // NOI18N
        labelCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelCancelarMouseClicked(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setText("Cancelar");

        labelCorteCaja.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelCorteCaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/corteCaja.png"))); // NOI18N
        labelCorteCaja.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelCorteCaja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelCorteCajaMouseClicked(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel14.setText("Corte Caja");

        labelRealizarVenta.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelRealizarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/venderProd.png"))); // NOI18N
        labelRealizarVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelRealizarVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelRealizarVentaMouseClicked(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel16.setText("Realizar Venta");

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 175, 239)));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel17.setText("SubTotal:");

        jLabel18.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel18.setText("Descuento:");

        jLabel19.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel19.setText("Total:");

        cajaDescuento.setEditable(false);

        cajaSubtotal.setEditable(false);

        cajaTotal.setEditable(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel17)
                    .addComponent(jLabel19))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cajaDescuento)
                    .addComponent(cajaSubtotal)
                    .addComponent(cajaTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(cajaSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(cajaDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(cajaTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        botonPedidos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonPedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/add.png"))); // NOI18N
        botonPedidos.setText("Pedidos");
        botonPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPedidosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(botonPedidos))
                        .addGap(203, 203, 203)
                        .addComponent(fechaSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCancelar)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(labelCorteCaja))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(117, 117, 117)
                                .addComponent(jLabel16)
                                .addGap(51, 51, 51))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelRealizarVenta)
                                .addGap(72, 72, 72)))
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(comboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonPedidos))
                    .addComponent(fechaSistema, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCancelar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelCorteCaja)
                            .addComponent(labelRealizarVenta))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel14)
                            .addComponent(jLabel16))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void labelAgregarProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAgregarProductoMouseClicked
        // TODO add your handling code here:
        TodoLonas.Principal.cardLayout.show(TodoLonas.Principal.panelContenedor, "producto");
    }//GEN-LAST:event_labelAgregarProductoMouseClicked

    private void labelAgregarVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAgregarVentaMouseClicked
        // TODO add your handling code here:
        try {
            int filaSeleccionada = tablaMostrarProductos.getSelectedRow();
            String cantidadProductos;
            String nombreProductoAV, descripcionAV, precioUnitarioAV, importeAV, cantidadAV;
            double calcula = 0.0, cantidadPorPrecioU = 0.0, descuento = 0.0;

            if (filaSeleccionada == -1) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un producto", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                cantidadProductos = JOptionPane.showInputDialog(null, "Ingrese cantidad");

                while (!isNumber(cantidadProductos)) {
                    cantidadProductos = JOptionPane.showInputDialog(null, "Por favor ingrese un número");
                }
                modelo = (DefaultTableModel) tablaMostrarProductos.getModel();
                nombreProductoAV = tablaMostrarProductos.getValueAt(filaSeleccionada, 0).toString();
                descripcionAV = tablaMostrarProductos.getValueAt(filaSeleccionada, 1).toString();
                precioUnitarioAV = tablaMostrarProductos.getValueAt(filaSeleccionada, 2).toString();

                cantidadPorPrecioU = (Double.parseDouble(cantidadProductos) * Double.parseDouble(precioUnitarioAV));
                importeAV = "" + Math.rint(cantidadPorPrecioU * 100) / 100;

                cantidadAV = String.valueOf(cantidadProductos);
                modelo = (DefaultTableModel) tablaPedidos.getModel();

                String filaPasando[] = {nombreProductoAV, descripcionAV, precioUnitarioAV, cantidadAV, importeAV};
                modelo.addRow(filaPasando);

                calcula = (Double.parseDouble(cantidadProductos)) * Double.parseDouble(precioUnitarioAV);
                subtotalInicial = subtotalInicial + calcula;
                cajaSubtotal.setText("" + Math.rint(subtotalInicial * 100) / 100);
                descuento = descuentoInicial * subtotalInicial;
                importeInicial = subtotalInicial - descuento;
                cajaDescuento.setText("" + Math.rint(descuento * 100) / 100);
                cajaTotal.setText("" + Math.rint(importeInicial * 100) / 100);
                importeFinal = importeInicial;

            }
//            operacionesVenta();
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Error del producto", "Error", JOptionPane.ERROR);
        }

    }//GEN-LAST:event_labelAgregarVentaMouseClicked

    private void labelCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCancelarMouseClicked
        // TODO add your handling code here:
        try {
            int filaSelecionada = tablaPedidos.getSelectedRow();
            int filas = tablaPedidos.getRowCount();

            for (int i = 0; filas > i; i++) {
                modelo.removeRow(0);
            }
            cajaDescuento.setText("");
            cajaSubtotal.setText("");
            cajaTotal.setText("");
            JOptionPane.showMessageDialog(this, "Operación Exitosa", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println("Problema: " + e);
        }
    }//GEN-LAST:event_labelCancelarMouseClicked

    private void labelCorteCajaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCorteCajaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_labelCorteCajaMouseClicked

    private void labelRealizarVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelRealizarVentaMouseClicked
        // TODO add your handling code here:
        try {
            Cobrar cobrar = null;
            cobrar = new Cobrar();
            cobrar.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(PanelVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_labelRealizarVentaMouseClicked

    private void comboCategoriaProductoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboCategoriaProductoItemStateChanged
        // TODO add your handling code here:
        String sql = "";
        obtieneCategoriaProductoCombo = "";
        obtieneCategoriaProductoCombo = comboCategoriaProducto.getSelectedItem().toString();
        if (obtieneCategoriaProductoCombo.equals("Todos")) {
            Connection conexion = null;
            try {
                Class.forName("org.gjt.mm.mysql.Driver");
                conexion = (Connection) DriverManager.getConnection(url, login, password);
                stm = (Statement) conexion.createStatement();
                ResultSet rs = stm.executeQuery("select nombreProducto, descripcion, precioUnitario from todolonas.producto;");

                while (rs.next()) {
                    tablaMostrarProductos.setModel(DbUtils.resultSetToTableModel(rs));
                    for (int n = 0; n < numeroCabezeras; n++) {
                        tablaMostrarProductos.getColumnModel().getColumn(n).setHeaderValue(nombreColumnas[n]);
                    }
                }
                conexion.close();
            } catch (Exception e) {
                System.out.println("error obtener max numeroVenta: " + e);
            }
        } else {
            Connection conexion = null;
            try {
                Class.forName("org.gjt.mm.mysql.Driver");
                conexion = (Connection) DriverManager.getConnection(url, login, password);
                stm = (Statement) conexion.createStatement();
                ResultSet rs = stm.executeQuery("select nombreProducto, descripcion, precioUnitario from producto where categoriaProducto='" + obtieneCategoriaProductoCombo + "';");

                while (rs.next()) {
                    tablaMostrarProductos.setModel(DbUtils.resultSetToTableModel(rs));
                    for (int n = 0; n < numeroCabezeras; n++) {
                        tablaMostrarProductos.getColumnModel().getColumn(n).setHeaderValue(nombreColumnas[n]);
                    }
                }
                conexion.close();
            } catch (Exception e) {
                System.out.println("error obtener max numeroVenta: " + e);
            }
        }
    }//GEN-LAST:event_comboCategoriaProductoItemStateChanged

    public static void comboClienteSeleccionar() {
        Connection conexion = null;
        String descuentoGeneral = "";
        java.sql.Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://" + Conexion.nombreServidor + ":" + Conexion.puerto + "/" + Conexion.nombreBD;
            con = DriverManager.getConnection(url, Conexion.usuarioBD, Conexion.contrasena);
            java.sql.Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT descuentoClienteGeneral FROM todolonas.ajustes;");
            while (rs.next()) {
                descuentoGeneral = rs.getString("descuentoClienteGeneral");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        double descGene2 = Double.parseDouble(descuentoGeneral);

        if (valorComboCliente.equals("Seleccionar...")) {
            cajaDescuento.setText("" + descGene2);
            descuentoAMedida = descGene2 / 100;
        }
    }

    public static void comboClienteNoSeleccionar() {
        Connection conexion = null;
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            conexion = (Connection) DriverManager.getConnection(url, login, password);

            stm = (Statement) conexion.createStatement();

            ResultSet rs = stm.executeQuery("select * from cliente where nombreCliente like '" + valorComboCliente + "%'");
            while (rs.next()) {
                buscarCategoriaCliente = rs.getString("categoriaCliente");
                System.out.println("categoria---->    " + buscarCategoriaCliente);
            }
            conexion.close();
        } catch (Exception e) {
            System.out.println("error: " + e);
        }
        String descuentoGeneral = "", descuentoEmpresas = "", descuentoInstituciones = "", descuentoFisica = "";
        java.sql.Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://" + Conexion.nombreServidor + ":" + Conexion.puerto + "/" + Conexion.nombreBD;
            con = DriverManager.getConnection(url, Conexion.usuarioBD, Conexion.contrasena);
            java.sql.Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT descuentoClienteGeneral, descuentoEmpresa, descuentoInstitucionesPublicas, descuentoPersonasFisicas FROM todolonas.ajustes;");
            while (rs.next()) {
                descuentoGeneral = rs.getString("descuentoClienteGeneral");
                descuentoEmpresas = rs.getString("descuentoEmpresa");
                descuentoInstituciones = rs.getString("descuentoInstitucionesPublicas");
                descuentoFisica = rs.getString("descuentoPersonasFisicas");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        double descGene2 = Double.parseDouble(descuentoGeneral);
        double descInst2 = Double.parseDouble(descuentoInstituciones);
        double descEm2 = Double.parseDouble(descuentoEmpresas);
        double descFisi2 = Double.parseDouble(descuentoFisica);

        if (buscarCategoriaCliente.equals("General")) {
            cajaDescuento.setText("" + descGene2);
            descuentoAMedida = descGene2 / 100;
        }
        if (buscarCategoriaCliente.equals("Instituciones Públicas")) {
            cajaDescuento.setText("" + descInst2);
            descuentoAMedida = descInst2 / 100;
        }
        if (buscarCategoriaCliente.equals("Empresas")) {
            cajaDescuento.setText("" + descEm2);
            descuentoAMedida = descEm2 / 100;
        }
        if (buscarCategoriaCliente.equals("Personas Físicas")) {
            cajaDescuento.setText("" + descFisi2);
            descuentoAMedida = descFisi2 / 100;
        }
    }

    private void comboClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboClienteActionPerformed
        // TODO add your handling code here:
        System.out.println("tipo de cliente");
//        try {
        buscarCategoriaCliente = "";
        valorComboCliente = "";
        valorComboCliente = comboCliente.getSelectedItem().toString();
        System.out.println("comboCLIENTEACTUAL   :" + valorComboCliente);

        if (valorComboCliente.equals("Seleccionar...")) {
            botonPedidos.setVisible(false);
            comboClienteSeleccionar();
        } else {
            botonPedidos.setVisible(true);
            comboClienteNoSeleccionar();
        }
        System.out.println("de" + descuentoAMedida);
        cajaSubtotal.setText("");
        cajaTotal.setText("");
        cajaDescuento.setText("");
        operacionesVenta(descuentoAMedida);
        descuentoActual = descuentoAMedida;

    }//GEN-LAST:event_comboClienteActionPerformed


    private void cajaBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaBusquedaKeyReleased
        // TODO add your handling code here:
        obtieneCategoriaProductoCombo = "";
        obtieneCategoriaProductoCombo = comboCategoriaProducto.getSelectedItem().toString();
        System.out.println(" cate " + obtieneCategoriaProductoCombo);
        Connection conexion = null;
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            conexion = (Connection) DriverManager.getConnection(url, login, password);
            stm = (Statement) conexion.createStatement();
            ResultSet rs = stm.executeQuery("select nombreProducto, descripcion, precioUnitario from producto where nombreProducto like ? and categoriaProducto='" + obtieneCategoriaProductoCombo + "'");

            while (rs.next()) {
                tablaMostrarProductos.setModel(DbUtils.resultSetToTableModel(rs));
                for (int n = 0; n < numeroCabezeras; n++) {
                    tablaMostrarProductos.getColumnModel().getColumn(n).setHeaderValue(nombreColumnas[n]);
                }
            }
            conexion.close();
        } catch (Exception e) {
            System.out.println("error obtener max numeroVenta: " + e);
        }
    }//GEN-LAST:event_cajaBusquedaKeyReleased

    private void cajaBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaBusquedaKeyTyped
        // TODO add your handling code here:
        char caracter = evt.getKeyChar();
        if (cajaBusqueda.getText().length() >= 45) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaBusquedaKeyTyped

    
    private void botonPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPedidosActionPerformed
        // TODO add your handling code here:
        if (tablaPedidos.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "No Ha Seleccionado Productos", "Atención:", JOptionPane.WARNING_MESSAGE);
        } else {    
            new Pedidos().setVisible(true);
            nombreClientePedidos = comboCliente.getSelectedItem().toString();
            Pedidos.labelObtenerCliente.setText(nombreClientePedidos);
            nombreUsuarioPedidos = TodoLonas.Principal.usuarioActivo;
            Pedidos.labelObtenerUsuario.setText(nombreUsuarioPedidos);
            fechaSistemaPedidos = fechaSistema.getText();
            Pedidos.labelObtenerFecha.setText(fechaSistemaPedidos);
            Pedidos.labelTotal.setText(""+importeFinal);
        }
    }//GEN-LAST:event_botonPedidosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonPedidos;
    private javax.swing.JTextField cajaBusqueda;
    public static javax.swing.JTextField cajaDescuento;
    public static javax.swing.JTextField cajaSubtotal;
    public static javax.swing.JTextField cajaTotal;
    public static javax.swing.JComboBox comboCategoriaProducto;
    public static javax.swing.JComboBox comboCliente;
    public static javax.swing.JLabel fechaSistema;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelAgregarProducto;
    private javax.swing.JLabel labelAgregarVenta;
    private javax.swing.JLabel labelCancelar;
    private javax.swing.JLabel labelCorteCaja;
    private javax.swing.JLabel labelRealizarVenta;
    public static javax.swing.JTable tablaMostrarProductos;
    public static javax.swing.JTable tablaPedidos;
    // End of variables declaration//GEN-END:variables
}
