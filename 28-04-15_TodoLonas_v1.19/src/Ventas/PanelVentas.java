package Ventas;

import java.util.Calendar;
import Conexion.Conexion;
import Pedidos.Pedidos;
import CorteCaja.PanelCorteCaja;
import TodoLonas.Principal;
import static TodoLonas.Principal.panelContenedor;
import com.mysql.jdbc.*;
import java.sql.DriverManager;
import com.mysql.jdbc.Statement;
import java.awt.CardLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class PanelVentas extends javax.swing.JPanel {

    //MODELO DE LA TABLA 
    DefaultTableModel modelo = new DefaultTableModel();

    //NOMBRE DE COLUMNAS DE CONSULTA PRODUCTO 
    public static String[] nombreColumnas = {"Clave", "Producto", "Descripción", "Precio Unitario"};
    //CUENTA EL TAMAÑO DE LAS CABEZERAS 
    public static int numeroCabezeras = nombreColumnas.length;

    //ENVIA LA FECHA A LA VENTANA DE VENTAS 
    public static Calendar cal = Calendar.getInstance();
    public static SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    public static String varFechaReg = cal.get(cal.DATE) + "-" + (cal.get(cal.MONTH) + 1) + "-" + cal.get(cal.YEAR);
    public static String horaActual = cal.get(Calendar.HOUR) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND);

    //Guardar datos para utilizarlos en cobrar      
    public static Double importeFinal = 0.0;

    // CONSULTAS EN LA BASE DE DATOS
    public static String sqlProductos = "SELECT idProducto, nombreProducto, descripcion, precioUnitario FROM producto;";

    //VARIABLES PATA LA OPERACION DE VENTAS 
    public static String buscarCategoriaCliente;
    public static double totalFilasTablaPedidos, sumaTotalVenta, importe;
    public static double subtotalVentas = 0.0, totalConDescuentoExtra = 0.0, descuentoVentas = 0.0;
    public static double importeFinalCobrar;

    //VARIABLES  
    public static String obtieneCategoriaProductoCombo = "";
    public static String valorComboCliente = "", nombreCliente;

    //VARIABLE PARA GUARDAR LOS PRODUCTOS DE LA VENTA CORRESPONDIENTES A LA VENTA    
    public static String nombreProducto = "", precioUnitarioProducto = "", cantidadProducto = "", importeProducto = "";

    public static String aux1, aux2;

    //MOSTRADO Y SELECCION DE PRODUCTOS 
    public static java.sql.Connection con;
    public static java.sql.PreparedStatement pps;
    public static ResultSet rs;

    //CONSULTAS PARA EL GUARDADO DE VENTAS
    public static Statement stm = null;
    public static String bd = Conexion.nombreBD;
    public static String login = Conexion.usuarioBD;
    public static String password = Conexion.contrasena;
    public static String url = "jdbc:mysql://" + Conexion.nombreServidor + ":" + Conexion.puerto + "/" + Conexion.nombreBD;
    public static String nombreClientePedidos, nombreUsuarioPedidos, fechaSistemaPedidos;

    public static CardLayout cardLayout;
    PanelCorteCaja corte = new PanelCorteCaja();

    public PanelVentas() throws SQLException {
        initComponents();
        Ventas.TablaPersonalizadaVentas.tablaMostrarProductos();
        Ventas.TablaPersonalizadaVentas.tablaPedidos();
        UpdateJTable();
        botonPedidos.setVisible(false);
        fechaSistema.setText(varFechaReg);
    }

    //FUNCIONAL----- METODO QUE CONECTA A LA BASE DE DATOS 
    public static void conecta() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, Conexion.usuarioBD, Conexion.contrasena);
            if (con != null) {
                System.out.println("VENTAS----> listo");
            }
        } catch (Exception e) {
            System.out.println("Problema: " + e);
        }
    }

    //FUNCIONAL----- METODO QUE ACTUALIZA LA TABLA DE PRODUCTOS 
    public static void UpdateJTable() throws SQLException {
        try {
            conecta();
            pps = con.prepareStatement(sqlProductos);
            rs = pps.executeQuery();
            tablaMostrarProductos.setModel(DbUtils.resultSetToTableModel(rs));
            //Nombrado de las columnas
            for (int n = 0; n < numeroCabezeras; n++) {
                tablaMostrarProductos.getColumnModel().getColumn(n).setHeaderValue(nombreColumnas[n]);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //FUNCIONAL---- AGREGA CLIENTE AL COMBO BOX 
    public static void agregarCliente() {
        comboCliente.removeAllItems();
        Connection conexion = null;
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            conexion = (Connection) DriverManager.getConnection(url, login, password);
            stm = (Statement) conexion.createStatement();
            ResultSet rs = stm.executeQuery("SELECT nombreCliente FROM todolonas.cliente;");

            comboCliente.addItem("Seleccionar...");
            while (rs.next()) {
                comboCliente.addItem(rs.getString(1));
            }

            conexion.close();
        } catch (Exception e) {
            System.out.println(e.getCause().toString());
        }
    }

    //FUNCIONAL---> HACE LAS OPERACIONES DE ACUERDO AL CLIENTE Y SU CATEGORIA
    public void operacionActualizaSubtotal() {
        int numeroFilasTablaPedidos = tablaPedidos.getRowCount();
        //Limpiar Variables de subtotalVentas, descuentoVentas y totalVentaFinal
        cajaSubtotal.setText("");
        cajaDescuento.setText("");
        cajaTotal.setText("");
        importe = 0;
        sumaTotalVenta = 0;
        subtotalVentas = 0;
        importeFinal = 0.0;

        for (int i = 0; i < numeroFilasTablaPedidos; i++) {
            importe = Double.parseDouble(tablaPedidos.getValueAt(i, 7).toString());
            sumaTotalVenta += importe;
        }
        subtotalVentas = sumaTotalVenta;
        System.out.println("IMPORTE FINAL : " + sumaTotalVenta);
        cajaSubtotal.setText("" + Math.rint(subtotalVentas * 100) / 100);
        cajaDescuento.setText("0.0");
        cajaTotal.setText("" + Math.rint(subtotalVentas * 100) / 100);
        importeFinal = subtotalVentas;
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
        jLabel9 = new javax.swing.JLabel();
        botonDescuentoPorProducto = new javax.swing.JButton();
        botonEliminarPorFila = new javax.swing.JLabel();
        labelCancelarProducto = new javax.swing.JLabel();

        setBackground(new java.awt.Color(62, 64, 149));
        setToolTipText("");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Agregar Producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Categoría:");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Nombre:");

        comboCategoriaProducto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        comboCategoriaProducto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "Gran Formato", "Vinil", "Alta Resolución", "Offset", "Impresión Digital", "Rígidos", "Rotulación", "Papelería", "Estructuras", "Lonas", "Diseño Gráfico", "Toldos", "Artículos Promocionales", "Otros" }));
        comboCategoriaProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        labelAgregarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imgAnadirProducto.png"))); // NOI18N
        labelAgregarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelAgregarProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelAgregarProductoMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Agregar Producto");

        labelAgregarVenta.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelAgregarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imgAnadirVenta.png"))); // NOI18N
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
                "Clave", "Producto ", "Descripción ", "Precio Unitario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaMostrarProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane1.setViewportView(tablaMostrarProductos);
        if (tablaMostrarProductos.getColumnModel().getColumnCount() > 0) {
            tablaMostrarProductos.getColumnModel().getColumn(0).setResizable(false);
            tablaMostrarProductos.getColumnModel().getColumn(1).setResizable(false);
            tablaMostrarProductos.getColumnModel().getColumn(2).setResizable(false);
            tablaMostrarProductos.getColumnModel().getColumn(3).setResizable(false);
        }

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cajaBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboCategoriaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(labelAgregarProducto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelAgregarVenta)
                        .addGap(67, 67, 67))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(35, 35, 35))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboCategoriaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cajaBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelAgregarProducto)
                    .addComponent(labelAgregarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ventas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imgLista.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("Cliente:");

        comboCliente.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        comboCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboCliente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboClienteItemStateChanged(evt);
            }
        });

        fechaSistema.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        fechaSistema.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 175, 239)));

        tablaPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Clave", "Producto", "Descripción", "Precio Unitario", "Cantidad", "Importe", "Descuento", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
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
            tablaPedidos.getColumnModel().getColumn(5).setResizable(false);
            tablaPedidos.getColumnModel().getColumn(6).setResizable(false);
            tablaPedidos.getColumnModel().getColumn(7).setResizable(false);
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
                .addContainerGap(12, Short.MAX_VALUE))
        );

        labelCancelar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelCancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imgCancelarVenta.png"))); // NOI18N
        labelCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelCancelarMouseClicked(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setText("Cancelar Venta");

        labelCorteCaja.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelCorteCaja.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCorteCaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imgCorteCaja.png"))); // NOI18N
        labelCorteCaja.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelCorteCaja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelCorteCajaMouseClicked(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel14.setText("Corte Caja");

        labelRealizarVenta.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelRealizarVenta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRealizarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imgRealizarVenta.png"))); // NOI18N
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

        cajaDescuento.setText("0");
        cajaDescuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cajaDescuentoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaDescuentoKeyTyped(evt);
            }
        });

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
                .addContainerGap(13, Short.MAX_VALUE))
        );

        botonPedidos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonPedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imgAgregar.png"))); // NOI18N
        botonPedidos.setText("Pedidos");
        botonPedidos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPedidosActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Fecha:");

        botonDescuentoPorProducto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonDescuentoPorProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imgDescuento.png"))); // NOI18N
        botonDescuentoPorProducto.setText("Descuento");
        botonDescuentoPorProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonDescuentoPorProductoMouseClicked(evt);
            }
        });

        botonEliminarPorFila.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        botonEliminarPorFila.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imgCancelarProducto.png"))); // NOI18N
        botonEliminarPorFila.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonEliminarPorFila.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonEliminarPorFilaMouseClicked(evt);
            }
        });

        labelCancelarProducto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelCancelarProducto.setText("Cancelar Producto ");

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
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonDescuentoPorProducto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonPedidos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fechaSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(botonEliminarPorFila, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelCancelarProducto))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14)
                            .addComponent(labelCorteCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelRealizarVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(51, 51, 51)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fechaSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(botonPedidos)
                                .addComponent(comboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(botonDescuentoPorProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelCancelar)
                                    .addComponent(botonEliminarPorFila, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(labelCancelarProducto)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labelRealizarVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelCorteCaja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel16))))
                        .addGap(19, 19, 19))))
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
                .addContainerGap(21, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    //CARDLAYOUT PARA ENLACE A AGREGAR UN NUEVO PRODUCTO 
    private void labelAgregarProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAgregarProductoMouseClicked
        TodoLonas.Principal.cardLayout.show(TodoLonas.Principal.panelContenedor, "producto");
        Productos.PanelProductos.labelRegresarProductos.setVisible(true);
    }//GEN-LAST:event_labelAgregarProductoMouseClicked

    //AGREGA LOS PRODUCTOS A LA VENTA, YA TIENE LA OPERACION DE PRECIO UNITARIO POR LA CANTIDAD
    private void labelAgregarVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAgregarVentaMouseClicked
        try {
            int filaSeleccionada = tablaMostrarProductos.getSelectedRow();
            String cantidadProductos, claveProductoAV, total;
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
                claveProductoAV = tablaMostrarProductos.getValueAt(filaSeleccionada, 0).toString();
                nombreProductoAV = tablaMostrarProductos.getValueAt(filaSeleccionada, 1).toString();
                descripcionAV = tablaMostrarProductos.getValueAt(filaSeleccionada, 2).toString();
                precioUnitarioAV = tablaMostrarProductos.getValueAt(filaSeleccionada, 3).toString();

                cantidadPorPrecioU = (Double.parseDouble(cantidadProductos) * Double.parseDouble(precioUnitarioAV));
                importeAV = "" + Math.rint(cantidadPorPrecioU * 100) / 100;
                descuento = 0;
                total = importeAV;
                cantidadAV = String.valueOf(cantidadProductos);
                modelo = (DefaultTableModel) tablaPedidos.getModel();

                String filaPasando[] = {claveProductoAV, nombreProductoAV, descripcionAV, precioUnitarioAV, cantidadAV, importeAV, descuento + "", total};
                modelo.addRow(filaPasando);

                calcula = (Double.parseDouble(cantidadProductos)) * Double.parseDouble(precioUnitarioAV);
                subtotalVentas = subtotalVentas + calcula;
                cajaSubtotal.setText("" + Math.rint(subtotalVentas * 100) / 100);
                cajaTotal.setText("" + Math.rint(subtotalVentas * 100) / 100);
                importeFinal = subtotalVentas;
            }

        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Error del producto", "Error", JOptionPane.ERROR);
        }

    }//GEN-LAST:event_labelAgregarVentaMouseClicked

    // MÉTODO QUE SIRVE PARA LA CNACELACION DE LA VENTA
    private void labelCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCancelarMouseClicked
        // TODO add your handling code here:
        try {

            int filas = tablaPedidos.getRowCount();
            for (int i = 0; filas > i; i++) {
                modelo.removeRow(0);
            }
            comboCliente.setSelectedIndex(0);
            cajaDescuento.setText("");
            cajaSubtotal.setText("");
            cajaTotal.setText("");
            //JOptionPane.showMessageDialog(this, "Operación Exitosa", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println("Problema: " + e);
        }
    }//GEN-LAST:event_labelCancelarMouseClicked

    //HACE EL ENLACE A LA VENTANA DE COBRAR VENTA Y A LA IMPRESION DEL TICKET
    private void labelRealizarVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelRealizarVentaMouseClicked
        try {
            Cobrar cobrar = null;
            cobrar = new Cobrar();
            cobrar.setVisible(true);
            Ventas.ActualizaTablaProductos.tabla();
        } catch (SQLException ex) {
            Logger.getLogger(PanelVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_labelRealizarVentaMouseClicked

    //MÉTODO PARA HACER LAS CONSULTAS POR CATEGORÍA DE PRODUCTO 
    private void comboCategoriaProductoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboCategoriaProductoItemStateChanged
        try {
            conecta();
            String sql = "";
            obtieneCategoriaProductoCombo = "";
            obtieneCategoriaProductoCombo = comboCategoriaProducto.getSelectedItem().toString();
            if (obtieneCategoriaProductoCombo.equals("Todos")) {
                sql = "SELECT idProducto, nombreProducto, descripcion, precioUnitario FROM producto";
            } else {
                sql = "SELECT idProducto, nombreProducto, descripcion, precioUnitario FROM producto WHERE categoriaProducto='" + obtieneCategoriaProductoCombo + "'";
            }

            pps = con.prepareStatement(sql);
            rs = pps.executeQuery();
            tablaMostrarProductos.setModel(DbUtils.resultSetToTableModel(rs));

            //Nombrado de las columnas
            for (int n = 0; n < numeroCabezeras; n++) {
                tablaMostrarProductos.getColumnModel().getColumn(n).setHeaderValue(nombreColumnas[n]);
            }

            if (cajaBusqueda.getText().isEmpty()) {
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar [x]  " + e);
        }
    }//GEN-LAST:event_comboCategoriaProductoItemStateChanged

    //REALIZA LA BUSQUEDA DE ACUERDO A LAS CONCIDENCIAS EN LA CAJA DE TEXTO EDITABLE 
    private void cajaBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaBusquedaKeyReleased
        try {
            conecta();
            String sqlProductosCategoria;
            obtieneCategoriaProductoCombo = "";
            obtieneCategoriaProductoCombo = comboCategoriaProducto.getSelectedItem().toString();

            if (obtieneCategoriaProductoCombo.equals("Todos")) {
                sqlProductosCategoria = "select idProducto, nombreProducto, descripcion, precioUnitario from producto where nombreProducto like ?";
            } else {
                sqlProductosCategoria = "select idProducto, nombreProducto, descripcion, precioUnitario from producto where nombreProducto like ? and categoriaProducto='" + obtieneCategoriaProductoCombo + "'";
            }

            pps = con.prepareStatement(sqlProductosCategoria);
            pps.setString(1, cajaBusqueda.getText() + "%");
            rs = pps.executeQuery();
            tablaMostrarProductos.setModel(DbUtils.resultSetToTableModel(rs));

            //Nombrado de las columnas
            for (int n = 0; n < numeroCabezeras; n++) {
                tablaMostrarProductos.getColumnModel().getColumn(n).setHeaderValue(nombreColumnas[n]);
            }

            if (cajaBusqueda.getText().isEmpty()) {
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar [x]  " + e);
        }
    }//GEN-LAST:event_cajaBusquedaKeyReleased

    //VALIDACION DE LA CAJA DE BUSQUEDA
    private void cajaBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaBusquedaKeyTyped
        char caracter = evt.getKeyChar();
        if (cajaBusqueda.getText().length() >= 45) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaBusquedaKeyTyped

    //HACE EL ENLACE A LA VENTANA DE PEDIDOS 
    private void botonPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPedidosActionPerformed
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
            Pedidos.labelTotal.setText("" + cajaTotal.getText());
        }
    }//GEN-LAST:event_botonPedidosActionPerformed

    //MUESTRA EL BOTON DE PEDIDO SI ES QUE HA SELECCIONADO UN CLIENTE 
    private void comboClienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboClienteItemStateChanged
        valorComboCliente = "";
        valorComboCliente = comboCliente.getSelectedItem().toString();

        if (valorComboCliente.equals("Seleccionar...")) {
            botonPedidos.setVisible(false);
        } else {
            botonPedidos.setVisible(true);
        }
    }//GEN-LAST:event_comboClienteItemStateChanged

    //CARDLAYPUT PARA IR A LA VENTANA DE CORTE DE CAJA 
    private void labelCorteCajaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCorteCajaMouseClicked
        if (Principal.tipoUsuarioActivo.equals("Administrador") || Principal.tipoUsuarioActivo.equals("administrador")) {
            Principal.cardLayout.show(panelContenedor, "corte");
        } else {
            JOptionPane.showMessageDialog(null, "No tienes los privilegios para realizar esta operación", "Atención:", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_labelCorteCajaMouseClicked

    //BOTON QUE REALIZA EL DESCUENTO POR PRODUCTO 
    private void botonDescuentoPorProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonDescuentoPorProductoMouseClicked
        int filaSeleccionadaPedidos = tablaPedidos.getSelectedRow();
        double importe = 0, descuento = 0, importeConDescuento;

        if (filaSeleccionadaPedidos == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un producto", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            modelo = (DefaultTableModel) tablaPedidos.getModel();
            importe = Double.parseDouble(tablaPedidos.getValueAt(filaSeleccionadaPedidos, 5).toString());

            JTextField cajaDescuento = new JTextField();
            JOptionPane.showMessageDialog(null, cajaDescuento, "Ingrese descuento menor a 50%", JOptionPane.QUESTION_MESSAGE);
            descuento = Double.parseDouble(cajaDescuento.getText());

            if (descuento > 50 || descuento < 0) {

                JOptionPane.showMessageDialog(null, cajaDescuento, "Ingrese descuento válido", JOptionPane.QUESTION_MESSAGE);
                descuento = 0;
                importeConDescuento = importe * (descuento / 100);
                importeConDescuento = importe - importeConDescuento;
                tablaPedidos.setValueAt(Math.rint(descuento * 100) / 100, filaSeleccionadaPedidos, 6);
                tablaPedidos.setValueAt(Math.rint(importeConDescuento * 100) / 100, filaSeleccionadaPedidos, 7);
            } //VERIFICACION DEL ANTICIPO
            else if (descuento <= 50) {
                importeConDescuento = importe * (descuento / 100);
                importeConDescuento = importe - importeConDescuento;
                tablaPedidos.setValueAt(Math.rint(descuento * 100) / 100, filaSeleccionadaPedidos, 6);
                tablaPedidos.setValueAt(Math.rint(importeConDescuento * 100) / 100, filaSeleccionadaPedidos, 7);
            }
        }
        operacionActualizaSubtotal();
    }//GEN-LAST:event_botonDescuentoPorProductoMouseClicked

    private void cajaDescuentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaDescuentoKeyReleased
        double descuento = 0, subtotal;
        importeFinal = 0.0;

        if (!cajaDescuento.getText().isEmpty()) {
            descuento = Double.parseDouble(cajaDescuento.getText()) / 100;
            subtotal = Double.parseDouble(cajaSubtotal.getText());
            totalConDescuentoExtra = subtotal - (subtotal * descuento);
            cajaTotal.setText("" + Math.rint(totalConDescuentoExtra * 100) / 100);
            importeFinal = totalConDescuentoExtra;
        } else {
            cajaTotal.setText("");
        }
    }//GEN-LAST:event_cajaDescuentoKeyReleased

    private void botonEliminarPorFilaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEliminarPorFilaMouseClicked
        try {
            //Le damos un valor grande a la variable 'agarrado' para evitar tener seleccionado un producto
            int agarrado = 1000;
            double calcula, descuento;
            //definimos que no tenemos un producto seleccionado dentro de esta variable booleana
            boolean filaSeleccionada = false;
            //recorremos la tabla para ver si hay un producto seleccionado 
            for (int i = 0; i < tablaPedidos.getRowCount(); i++) {
                filaSeleccionada = tablaPedidos.isRowSelected(i);
                if (filaSeleccionada == true) {
                    agarrado = i;
                    break;
                }
            }
            if (filaSeleccionada == true) {
                //////////////////////////////////
                calcula = Double.parseDouble(tablaPedidos.getValueAt(agarrado, 7) + "");
                subtotalVentas = subtotalVentas - calcula;
                cajaSubtotal.setText("" + Math.rint(subtotalVentas * 100) / 100);
                cajaDescuento.setText("0.0");
                cajaTotal.setText("" + Math.rint(subtotalVentas * 100) / 100);
                importeFinal = subtotalVentas;
                DefaultTableModel temp = (DefaultTableModel) tablaPedidos.getModel();
                temp.removeRow(agarrado);
                ///////////////////////////////////
            } else {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar Un Producto", "Atención:", JOptionPane.WARNING_MESSAGE);
            }

        } catch (Exception e) {
            System.out.println("Erro al tratar de eliminar un producto de la tabla: " + e.getMessage().toString());
        }
    }//GEN-LAST:event_botonEliminarPorFilaMouseClicked

    private void cajaDescuentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaDescuentoKeyTyped
        char caracter = evt.getKeyChar();
        if (((caracter < '0') || (caracter > '9')) && (caracter != evt.VK_BACK_SPACE) && (caracter != '.')) {
            evt.consume();
        }
        if (cajaDescuento.getText().length() >= 2) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaDescuentoKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonDescuentoPorProducto;
    public static javax.swing.JLabel botonEliminarPorFila;
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
    private javax.swing.JLabel jLabel9;
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
    public static javax.swing.JLabel labelCancelarProducto;
    private javax.swing.JLabel labelCorteCaja;
    private javax.swing.JLabel labelRealizarVenta;
    public static javax.swing.JTable tablaMostrarProductos;
    public static javax.swing.JTable tablaPedidos;
    // End of variables declaration//GEN-END:variables
}
