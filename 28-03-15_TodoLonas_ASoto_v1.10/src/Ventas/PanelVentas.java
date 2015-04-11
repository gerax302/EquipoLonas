package Ventas;

import Productos.PanelProductos;
import java.sql.*;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import java.awt.CardLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import Conexion.Conexion;

public class PanelVentas extends javax.swing.JPanel {

    DefaultTableModel modelo = new DefaultTableModel();
    PanelProductos producto = new PanelProductos();

    //REALIZAR CONSULTAS PARA EL GUARDADO DE VENTAS 
    public String url = "jdbc:mysql://localhost:"+Conexion.numPuerto+"/todolonas";
    public Connection con;
    public PreparedStatement pps;
    public ResultSet rs;

    //NOMBRE DE COLUMNAS
    public static String[] nombreColumnas = {"Clave", "Nombre", "Descripción", "Precio Unitario"};
    public static int numeroCabezeras = nombreColumnas.length;

    //ENVIA LA FECHA A LA VENTANA DE VENTAS 
    public static Calendar cal = Calendar.getInstance();
    public static SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    public static String varFechaReg = cal.get(cal.DATE) + "-" + (cal.get(cal.MONTH) + 1) + "-" + cal.get(cal.YEAR);
    public static String horaActual = cal.get(Calendar.HOUR) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND);

    //Guardar datos para utilizarlos en cobrar      
    public static Double importeFinal = 0.0;

    // CONSULTAS EN LA BASE DE DATOS
    public static String sqlClientes = "select nombreCliente from cliente";
    public static String sqlDescuento = "";
    public static String sqlProductos = "select idProducto, nombreProducto, descripcion, precioUnitario from producto";

    //VARIABLES PATA LA OPERACION DE VENTAS 
    public String buscarCategoriaCliente;
    public double totalFilasTablaPedidos, sumaFilas, importe;
    public static double descuentoInicial = 0.0, subtotalInicial = 0.0, importeInicial = 0.0;
    public double subtotalFinal = 0.0, totalFinal = 0.0, descuentoFinal = 0.0;
    public static double importeFinalCobrar, descuentoAMedida = 0.0;
    public static double descuentoActual = 0.0;

    //VARIABLES  
    public static String obtieneCategoriaProductoCombo = "";
    public String valorComboCliente = "", nombreCliente;

    //VARIABLE PARA GUARDAR LOS PRODUCTOS DE LA VENTA CORRESPONDIENTES A LA VENTA 
    public int idVenta = 0, idProducto = 0, idVentasInicial = 0, idVentaMax = 0;
    public String nombreProducto = "", precioUnitarioProducto = "", cantidadProducto = "", importeProducto = "";

    public PanelVentas() throws SQLException {
        try {
            conecta();
            initComponents();
            UpdateJTable();
            if (comboCliente.getSelectedItem().toString()=="Todos") {
                UpdateJTable();               
            }
            agregarCliente();
            descuentoInicial = obtenerDescuento(comboCliente.getSelectedItem().toString());
            System.out.println(" inicial " + descuentoInicial);
            subtotalInicial = 0.0;
            fechaSistema.setText(varFechaReg);
        }
        catch (SQLException ex) 
        {
            System.out.println("Error al conectar");
        }
    }

    //FUNCIONAL----- METODO QUE CONECTA A LA BASE DE DATOS 
    public void conecta() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //con = DriverManager.getConnection(url,"tu usuario en la base de datos","tu contraseña");
            con = DriverManager.getConnection(url, Conexion.usuarioBD, Conexion.contrasena);
            if (con != null) 
            {
                System.out.println("VENTAS----> listo");
            }
        } catch (Exception e) {
            System.out.println("Problema: " + e);
        }
    }

    //FUNCIONAL---- AGREGA CLIENTE AL COMBO BOX 
    public void agregarCliente() throws SQLException {
        pps = con.prepareStatement(sqlClientes);
        rs = pps.executeQuery();
        while (rs.next()) {
            comboCliente.addItem(rs.getString(1));
        }
    }
    
    //ACTUALIZA LA TABLA DE LOS PRODUCTOS SI ES QUE SE HA AGREGADO UNO NUEVO 
    public void UpdateJTable() {
        try {
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        etiquetaCategoria = new javax.swing.JLabel();
        etiquetaCategoria1 = new javax.swing.JLabel();
        cajaBusqueda = new javax.swing.JTextField();
        comboCategoriaPro = new javax.swing.JComboBox();
        panelMostrarProductos = new javax.swing.JPanel();
        agregarProductoVenta = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaMostrarProductos = new javax.swing.JTable();
        agregarProducto = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        ventas = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        comboTipoVenta = new javax.swing.JComboBox();
        etiNombreCliente = new javax.swing.JLabel();
        fechaEntrega = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        fechaSistema = new javax.swing.JLabel();
        panelVentas = new javax.swing.JPanel();
        Subtotal = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        realizarVenta1 = new javax.swing.JButton();
        descuentoEtiqueta = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPedidos = new javax.swing.JTable();
        cancelarVenta = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cajaSubtotal = new java.awt.TextField();
        cajaDescuento = new java.awt.TextField();
        cajaTotal = new java.awt.TextField();
        jLabel9 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        comboCliente = new javax.swing.JComboBox();

        setBackground(new java.awt.Color(62, 64, 149));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Agregar Producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        etiquetaCategoria.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        etiquetaCategoria.setText("Categoría:");

        etiquetaCategoria1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        etiquetaCategoria1.setText("Nombre:");

        cajaBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cajaBusquedaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaBusquedaKeyTyped(evt);
            }
        });

        comboCategoriaPro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "Gran Formato", "Vinil", "Alta Resolución", "Offset", "Impresión Digital", "Rigidos", "Rotulación", "Estructuras", "Lonas", "Anuncios", "Diseño Grafico", "Toldos", "Articulos Promocionales", "Otros" }));
        comboCategoriaPro.setPreferredSize(new java.awt.Dimension(200, 20));
        comboCategoriaPro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboCategoriaProItemStateChanged(evt);
            }
        });

        panelMostrarProductos.setBackground(new java.awt.Color(255, 255, 255));

        agregarProductoVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/addVent.png"))); // NOI18N
        agregarProductoVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                agregarProductoVentaMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Agregar a la Venta ");

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
        jScrollPane3.setViewportView(tablaMostrarProductos);
        if (tablaMostrarProductos.getColumnModel().getColumnCount() > 0) {
            tablaMostrarProductos.getColumnModel().getColumn(0).setResizable(false);
            tablaMostrarProductos.getColumnModel().getColumn(1).setResizable(false);
            tablaMostrarProductos.getColumnModel().getColumn(2).setResizable(false);
        }

        agregarProducto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        agregarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/addProd.png"))); // NOI18N
        agregarProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                agregarProductoMouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Agregar Producto");

        javax.swing.GroupLayout panelMostrarProductosLayout = new javax.swing.GroupLayout(panelMostrarProductos);
        panelMostrarProductos.setLayout(panelMostrarProductosLayout);
        panelMostrarProductosLayout.setHorizontalGroup(
            panelMostrarProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMostrarProductosLayout.createSequentialGroup()
                .addGroup(panelMostrarProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMostrarProductosLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel11)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel5))
                    .addGroup(panelMostrarProductosLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(agregarProducto)
                        .addGap(93, 93, 93)
                        .addComponent(agregarProductoVenta)))
                .addContainerGap(13, Short.MAX_VALUE))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        panelMostrarProductosLayout.setVerticalGroup(
            panelMostrarProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMostrarProductosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(panelMostrarProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(agregarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(agregarProductoVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMostrarProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel11)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelMostrarProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etiquetaCategoria)
                            .addComponent(etiquetaCategoria1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboCategoriaPro, 0, 1, Short.MAX_VALUE)
                            .addComponent(cajaBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaCategoria)
                    .addComponent(comboCategoriaPro, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaCategoria1)
                    .addComponent(cajaBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelMostrarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        ventas.setBackground(new java.awt.Color(255, 255, 255));
        ventas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ventas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/order.png"))); // NOI18N

        comboTipoVenta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        comboTipoVenta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Venta", "Pedido" }));

        etiNombreCliente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        etiNombreCliente.setText("Cliente: ");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Fecha de entrega:");

        fechaSistema.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        panelVentas.setBackground(new java.awt.Color(255, 255, 255));

        Subtotal.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Subtotal.setText("SubTotal");

        total.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        total.setText("Total");

        realizarVenta1.setBackground(new java.awt.Color(255, 255, 255));
        realizarVenta1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        realizarVenta1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/venderProd.png"))); // NOI18N
        realizarVenta1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                realizarVenta1MouseClicked(evt);
            }
        });

        descuentoEtiqueta.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        descuentoEtiqueta.setText("Descuento");

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
        jScrollPane1.setViewportView(tablaPedidos);
        if (tablaPedidos.getColumnModel().getColumnCount() > 0) {
            tablaPedidos.getColumnModel().getColumn(3).setResizable(false);
            tablaPedidos.getColumnModel().getColumn(4).setResizable(false);
        }

        cancelarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancelarVenta.png"))); // NOI18N
        cancelarVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelarVentaMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Cancelar");

        cajaSubtotal.setEditable(false);
        cajaSubtotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        cajaDescuento.setEditable(false);
        cajaDescuento.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        cajaTotal.setEditable(false);
        cajaTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Realizar Venta");

        javax.swing.GroupLayout panelVentasLayout = new javax.swing.GroupLayout(panelVentas);
        panelVentas.setLayout(panelVentasLayout);
        panelVentasLayout.setHorizontalGroup(
            panelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVentasLayout.createSequentialGroup()
                .addGroup(panelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelVentasLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(panelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cancelarVenta)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(realizarVenta1)
                            .addComponent(jLabel9))
                        .addGap(28, 28, 28)
                        .addGroup(panelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelVentasLayout.createSequentialGroup()
                                .addGroup(panelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelVentasLayout.createSequentialGroup()
                                        .addComponent(total)
                                        .addGap(51, 51, 51))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelVentasLayout.createSequentialGroup()
                                        .addComponent(descuentoEtiqueta)
                                        .addGap(18, 18, 18))
                                    .addGroup(panelVentasLayout.createSequentialGroup()
                                        .addComponent(Subtotal)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(panelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cajaSubtotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cajaDescuento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(cajaTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelVentasLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        panelVentasLayout.setVerticalGroup(
            panelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVentasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelVentasLayout.createSequentialGroup()
                        .addGroup(panelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelVentasLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Subtotal)
                                    .addComponent(cajaSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(descuentoEtiqueta)
                                    .addComponent(cajaDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(total)
                                    .addComponent(cajaTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelVentasLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(cancelarVenta)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)))
                        .addContainerGap(31, Short.MAX_VALUE))
                    .addGroup(panelVentasLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(realizarVenta1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addGap(37, 37, 37))))
        );

        comboCliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        comboCliente.setForeground(new java.awt.Color(102, 102, 102));
        comboCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar..." }));
        comboCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ventasLayout = new javax.swing.GroupLayout(ventas);
        ventas.setLayout(ventasLayout);
        ventasLayout.setHorizontalGroup(
            ventasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ventasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(ventasLayout.createSequentialGroup()
                .addGroup(ventasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ventasLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ventasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboTipoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(ventasLayout.createSequentialGroup()
                                .addComponent(etiNombreCliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(48, 48, 48)
                        .addGroup(ventasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(ventasLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(fechaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(fechaSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(panelVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        ventasLayout.setVerticalGroup(
            ventasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ventasLayout.createSequentialGroup()
                .addGroup(ventasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ventasLayout.createSequentialGroup()
                        .addGroup(ventasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fechaSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(ventasLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(comboTipoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ventasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fechaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(ventasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(etiNombreCliente)
                                .addComponent(comboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8))))
                .addGap(19, 19, 19)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ventas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ventas, javax.swing.GroupLayout.PREFERRED_SIZE, 570, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    //FUNCIONAL---- MOSTAR LOS PRODUCTO  DE ACUERDO A LAS COINCIDENCIAS DE LA CAJA DE TEXTO Y CATEGORIA DEL COMBO BOX 
    private void cajaBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaBusquedaKeyReleased
        try {
            conecta();
            obtieneCategoriaProductoCombo = "";
            obtieneCategoriaProductoCombo = comboCategoriaPro.getSelectedItem().toString();
            System.out.println(" cate " + obtieneCategoriaProductoCombo);
            String sqlProductosCategoria = "select nombreProducto, descripcion, precioUnitario from producto where nombreProducto like ? and categoriaProducto='" + obtieneCategoriaProductoCombo + "'";
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
    
    //FUNCIONAL---- MOSTAR LOS PRODUCTO DE ACUERDO A LA CATEGORIA DEL COMBO BOX 
    private void comboCategoriaProItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboCategoriaProItemStateChanged
        try {
            String sql="";
            obtieneCategoriaProductoCombo = "";
            obtieneCategoriaProductoCombo = comboCategoriaPro.getSelectedItem().toString();
            if (obtieneCategoriaProductoCombo=="Todos") {
                 sql = "select nombreProducto, descripcion, precioUnitario from producto";
            }else
            {
                 sql = "select nombreProducto, descripcion, precioUnitario from producto where categoriaProducto='" + obtieneCategoriaProductoCombo + "'";
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
    }//GEN-LAST:event_comboCategoriaProItemStateChanged
  
    @SuppressWarnings("empty-statement")
    //FUNCIONAL---- AGREGA PRODUCTOS A LA VENTA, ADEMAS DE QUE INGRESA EL SUBTOTAL, DESCUENTO INCICIAL(GENERAL) Y TOTAL A COBRAR
    private void agregarProductoVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarProductoVentaMouseClicked
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
                importeFinal= importeInicial;

            }
//            operacionesVenta();
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Error del producto", "Error", JOptionPane.ERROR);
        }
    }//GEN-LAST:event_agregarProductoVentaMouseClicked
 
    //HACER EL ENLACE A LA INTERFAZ DE PRODUCTOS
    private void agregarProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarProductoMouseClicked
//        PanelProductos pp = new PanelProductos();
//        cardLayout.show(jPanel1, "producto");

    }//GEN-LAST:event_agregarProductoMouseClicked

    //CANCELAR LA VENTA SEGUN LA OPCION DESEADA 
    private void cancelarVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelarVentaMouseClicked
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
    }//GEN-LAST:event_cancelarVentaMouseClicked
  
    //FUNCIONAL---> HACE EL ENLACE A LA VENTA DE COBRAR
    private void realizarVenta1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_realizarVenta1MouseClicked
        Double var = 0.0;
        try{         
            var = Double.parseDouble(tablaPedidos.getValueAt(0, 3)+"");
            Cobrar cobrar = new Cobrar();
            cobrar.setVisible(true);
            JOptionPane.showMessageDialog(null, "La cantidad de producto es: "+var);
        } 
        catch (SQLException ex) {
            Logger.getLogger(PanelVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_realizarVenta1MouseClicked

    // FUNCIONAL -----> TOMA EL CLIENTE Y HACE EL DESCUENTO SEGUN CORRESPONDA LA CATEGORIA 
    private void comboClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboClienteActionPerformed
        System.out.println("tipo de cliente");
        try {
            buscarCategoriaCliente = "";
            valorComboCliente = "";
            valorComboCliente = comboCliente.getSelectedItem().toString();
            System.out.println("comboCLIENTEACTUAL   :" + valorComboCliente);

            if (valorComboCliente.equals("Seleccionar...")) {
                buscarCategoriaCliente = "General";
            } else {
                String sqlCategoria = "SELECT categoriaCliente FROM cliente WHERE nombreCliente='" + valorComboCliente + "'";
                pps = con.prepareStatement(sqlCategoria);
                rs = pps.executeQuery();
                while (rs.next()) {
                    buscarCategoriaCliente = rs.getString(1);
                    System.out.println("TIPO DE CATEGORIA " + buscarCategoriaCliente);
                }
                descuentoAMedida = obtenerDescuento(buscarCategoriaCliente);
                System.out.println("de" + descuentoAMedida);
                operacionesVenta(descuentoAMedida);
                descuentoActual = descuentoAMedida;

            }

        } catch (SQLException ex) {
            System.out.println("Error al buscar cliente:" + ex);
            Logger.getLogger(PanelVentas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_comboClienteActionPerformed
   
    // FUNCIONAL---> VALIDA LOS VALORES DE LA CAJA 
    private void cajaBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaBusquedaKeyTyped
        char caracter = evt.getKeyChar();
        if (cajaBusqueda.getText().length() >= 45) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaBusquedaKeyTyped

    //FUNCIONAL---> VALIDAR NUMEROS ENTEROS 
    private static boolean isNumber(String n) {
        try {
            Integer.parseInt(n);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    //FUNCIONAL---> RECIBE EL VALOR DEL COMBO CLIENTE Y OBTIENE EL DESCUENTO SEGUN CORRESPONDA 
    public Double obtenerDescuento(String valorComboActual) throws SQLException {
        String tipoCliente = "";
        tipoCliente = valorComboActual;
        Double descuento = 0.0;

        //CODE PARA OBTENER LA CATEGORIA Y RESLIZAR MEDIANTE ESTA EL DESCUENTO 
        if (tipoCliente.equals("General") || tipoCliente.equals("Seleccionar...")) {
            sqlDescuento = "SELECT descuentoClienteGeneral FROM ajustes";
            System.out.println("DESC GENERAL");
        } else if (tipoCliente.equals("Instituciones Públicas")) {
            sqlDescuento = "SELECT descuentoInstitucionesPublicas FROM ajustes";
            System.out.println("DESC Instituciones");
        } else if (tipoCliente == "Empresas") {
            sqlDescuento = "SELECT descuentoEmpresa FROM ajustes";
            System.out.println("DESC Empresas");
        } else if (tipoCliente == "Personas Físicas") {
            sqlDescuento = "SELECT descuentoPersonasFisicas FROM ajustes";
            System.out.println("DESC Personas");
        }

        pps = con.prepareStatement(sqlDescuento);
        rs = pps.executeQuery();
        while (rs.next()) {
            descuento = Double.parseDouble(rs.getString(1));
            System.out.println("IDESCUENTO: " + descuento);
        }
        return descuento / 100;
    }

    //FUNCIONAL---> HACE LAS OPERACIONES DE ACUERDO AL CLIENTE Y SU CATEGORIA
    public void operacionesVenta(Double descuentoAMedida) throws SQLException {
        int total = tablaPedidos.getRowCount();
        cajaSubtotal.setText("");
        cajaDescuento.setText("");
        cajaTotal.setText("");
        total -= 1;
        for (int i = 0; i <= (total); i++) {
            sumaFilas = Double.parseDouble(String.valueOf(tablaPedidos.getValueAt(i, 4)));
            importe += sumaFilas;
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
  
    public void limpiarVariables() throws SQLException {
        descuentoInicial = obtenerDescuento("General");

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel Subtotal;
    public static javax.swing.JLabel agregarProducto;
    public static javax.swing.JLabel agregarProductoVenta;
    public javax.swing.JTextField cajaBusqueda;
    public java.awt.TextField cajaDescuento;
    public static java.awt.TextField cajaSubtotal;
    public java.awt.TextField cajaTotal;
    public javax.swing.JLabel cancelarVenta;
    public javax.swing.JComboBox comboCategoriaPro;
    public static javax.swing.JComboBox comboCliente;
    public static javax.swing.JComboBox comboTipoVenta;
    public javax.swing.JLabel descuentoEtiqueta;
    private javax.swing.JLabel etiNombreCliente;
    public static javax.swing.JLabel etiquetaCategoria;
    public static javax.swing.JLabel etiquetaCategoria1;
    public static com.toedter.calendar.JDateChooser fechaEntrega;
    public javax.swing.JLabel fechaSistema;
    private static javax.swing.JLabel jLabel11;
    public javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPanel panelMostrarProductos;
    private javax.swing.JPanel panelVentas;
    public javax.swing.JButton realizarVenta1;
    public javax.swing.JTable tablaMostrarProductos;
    public static javax.swing.JTable tablaPedidos;
    public javax.swing.JLabel total;
    public static javax.swing.JPanel ventas;
    // End of variables declaration//GEN-END:variables
}
