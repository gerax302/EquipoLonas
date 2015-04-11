package Consultas;

import Ventas.*;
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

public class PanelConsultas extends javax.swing.JPanel {

    DefaultTableModel modelo = new DefaultTableModel();
    //REALIZAR CONSULTAS PARA EL GUARDADO DE VENTAS 
    public String url = "jdbc:mysql://localhost:" + Conexion.numPuerto + "/todolonas";
    public static Connection con;
    public static PreparedStatement pps;
    public static ResultSet rs;

    //NOMBRE DE COLUMNAS    
    public static String[] nombreColumnasVentas = {"Folio", "Usuario", "Cliente ", "Fecha", "Hora", " Forma Pago", "Total"};
    public static String[] nombreColumnasPedidos = {"Folio", "Usuario", "Cliente ", "Trabajo", "Diseño", "Fecha Pedido", "Fecha Entrega", "Hora Pedido", "Estatus", "Forma Pago", "Total", "Anticipo"};
    public static String[] nombreColumnasCotizaciones = {"Folio", "Cliente ", "Trabajo", "Fecha", "Descuento", "Subtotal", "Total"};
    public static int numeroCabezeras;//= nombreColumnasVentasCliente.length;

    // CONSULTAS EN LA BASE DE DATOS
    public static String sqlClientes = "select nombreCliente from cliente";
    public static String sqlUsuarios = "select nombreUsuario from usuario";

    //VARIABLES  
    public String obtieneCategoria = "", obtieneCliente = "", obtieneUsuario = "", obtieneFecha = "";
    public int bandera = 0;

    public PanelConsultas() throws SQLException {
        try {
            conecta();
            initComponents();
            UpdateJTable();
            comboConsultaCliente.enable(false);
            comboConsultaUsuario.enable(false);
            consultaFecha.getCalendarButton().setEnabled(false);
            agregarClienteCombo();
            agregarUsuarioCombo();
        } 
        catch (SQLException ex) {
            System.out.println("Error al conectar");
        }
    }

    //FUNCIONAL----- METODO QUE CONECTA A LA BASE DE DATOS 
    public void conecta() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //con = DriverManager.getConnection(url,"tu usuario en la base de datos","tu contraseña");
            con = DriverManager.getConnection(url, Conexion.usuarioBD, Conexion.contrasena);
            if (con != null) {
                System.out.println("VENTAS----> listo");
            }
        } catch (Exception e) {
            System.out.println("Problema: " + e);
        }
    }

    //FUNCIONAL---- AGREGA CLIENTE AL COMBO BOX 
    public static void agregarClienteCombo() throws SQLException {
        comboConsultaCliente.removeAllItems();
        pps = con.prepareStatement(sqlClientes);
        rs = pps.executeQuery();
        while (rs.next()) {
            comboConsultaCliente.addItem(rs.getString(1));
        }
    }

    //FUNCIONAL---- AGREGA USUARIO AL COMBO BOX 
    public void agregarUsuarioCombo() throws SQLException {
        comboConsultaUsuario.removeAllItems();
        pps = con.prepareStatement(sqlUsuarios);
        rs = pps.executeQuery();
        while (rs.next()) {
            comboConsultaUsuario.addItem(rs.getString(1));
        }
    }

    //ACTUALIZA LA TABLA DE LOS PRODUCTOS SI ES QUE SE HA AGREGADO UNO NUEVO 
    public void UpdateJTable() {

        try {
//            pps = con.prepareStatement();
//            rs = pps.executeQuery();
//            tablaMostrarProductos.setModel(DbUtils.resultSetToTableModel(rs));
//            //Nombrado de las columnas
//            for (int n = 0; n < numeroCabezeras; n++) {
//                tablaMostrarProductos.getColumnModel().getColumn(n).setHeaderValue(nombreColumnas[n]);
//            }
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
        comboCategoriaBusqueda = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        comboConsultaCliente = new javax.swing.JComboBox();
        comboConsultaUsuario = new javax.swing.JComboBox();
        checkBoxCliente = new javax.swing.JCheckBox();
        checkBoxUsuario = new javax.swing.JCheckBox();
        checkBoxFecha = new javax.swing.JCheckBox();
        consultaFecha = new com.toedter.calendar.JDateChooser();
        botonBusqueda = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaMostrarConsulta = new javax.swing.JTable();

        setBackground(new java.awt.Color(62, 64, 149));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consultas ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        etiquetaCategoria.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        etiquetaCategoria.setText("Categoría:");

        comboCategoriaBusqueda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar...", "Ventas", "Pedidos", "Cotizaciones" }));
        comboCategoriaBusqueda.setPreferredSize(new java.awt.Dimension(200, 20));
        comboCategoriaBusqueda.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboCategoriaBusquedaItemStateChanged(evt);
            }
        });
        comboCategoriaBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCategoriaBusquedaActionPerformed(evt);
            }
        });

        comboConsultaCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar...", " " }));

        comboConsultaUsuario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar...", " " }));

        checkBoxCliente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        checkBoxCliente.setText("Cliente");
        checkBoxCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxClienteActionPerformed(evt);
            }
        });

        checkBoxUsuario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        checkBoxUsuario.setText("Usuario");
        checkBoxUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxUsuarioActionPerformed(evt);
            }
        });

        checkBoxFecha.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        checkBoxFecha.setText("Fecha ");
        checkBoxFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxFechaActionPerformed(evt);
            }
        });

        botonBusqueda.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botonBusqueda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.png"))); // NOI18N
        botonBusqueda.setText("Buscar ");
        botonBusqueda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBusquedaActionPerformed(evt);
            }
        });

        tablaMostrarConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tablaMostrarConsulta);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(etiquetaCategoria)
                        .addGap(18, 18, 18)
                        .addComponent(comboCategoriaBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(checkBoxUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(checkBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(comboConsultaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(comboConsultaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(checkBoxFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(consultaFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addComponent(botonBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 125, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane4)
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etiquetaCategoria)
                            .addComponent(comboCategoriaBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkBoxUsuario)
                            .addComponent(checkBoxFecha)
                            .addComponent(checkBoxCliente))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(comboConsultaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboConsultaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(consultaFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(botonBusqueda))
                .addGap(10, 10, 10)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(478, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(100, 100, 100)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(72, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 62, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    //FUNCIONAL---- MOSTAR CONSULTA DE ACUERDO A LA SELECCION DEL COMBO  
    private void comboCategoriaBusquedaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboCategoriaBusquedaItemStateChanged
        try {
            String sql = "";
            String obtieneCategoriaProductoCombo = "";
            obtieneCategoriaProductoCombo = comboCategoriaBusqueda.getSelectedItem().toString();
            checkBoxUsuario.setEnabled(true);
            comboConsultaUsuario.setEnabled(false);
            if (obtieneCategoriaProductoCombo.equals("Ventas")) {
                sql = "SELECT numeroVenta, nombreUsuario, nombreCliente, fechaSistema, horaSistema, formaPago, total FROM venta";
                bandera = 1;

            } else if (obtieneCategoriaProductoCombo.equals("Pedidos")) {
                sql = "SELECT numeroPedido, nombreUsuario, nombreCliente,"
                        + "especificacionTrabajo, especificacionDiseno,fechaSistema, fechaEntrega,"
                        + "horaSistema, estatus, formaPago, total, anticipo FROM pedidos";
                bandera = 2;
            } else if (obtieneCategoriaProductoCombo.equals("Cotizaciones")) {
                checkBoxUsuario.setEnabled(false);
                comboConsultaUsuario.setEnabled(false);
                sql = "SELECT tablacotiza.numero, cliente.nombreCliente, tablacotiza.especificacionTrabajo, tablacotiza.fecha,"
                        + "tablacotiza.descuento, tablacotiza.subtotal, tablacotiza.total FROM tablacotiza, cliente"
                        + " WHERE tablacotiza.idCliente = cliente.idCliente";
                bandera = 3;
            }

            pps = con.prepareStatement(sql);
            rs = pps.executeQuery();
            tablaMostrarConsulta.setModel(DbUtils.resultSetToTableModel(rs));

            //Nombrado  de las columnas de las tablas : VENTA, PEDIDO, COTIZA
            if (bandera == 1) {
                for (int n = 0; n < nombreColumnasVentas.length; n++) {
                    tablaMostrarConsulta.getColumnModel().getColumn(n).setHeaderValue(nombreColumnasVentas[n]);
                }
            } else if (bandera == 2) {
                for (int n = 0; n < nombreColumnasPedidos.length; n++) {
                    tablaMostrarConsulta.getColumnModel().getColumn(n).setHeaderValue(nombreColumnasPedidos[n]);
                }
            } else if (bandera == 3) {
                for (int n = 0; n < nombreColumnasCotizaciones.length; n++) {
                    tablaMostrarConsulta.getColumnModel().getColumn(n).setHeaderValue(nombreColumnasCotizaciones[n]);
                }
            }
            bandera = 0;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar [x]  " + e);
        }
    }//GEN-LAST:event_comboCategoriaBusquedaItemStateChanged

    private void botonBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBusquedaActionPerformed
        try {
            String sql = "";
            obtieneCategoria = comboCategoriaBusqueda.getSelectedItem().toString();
            obtieneCliente = comboConsultaCliente.getSelectedItem().toString();
            obtieneUsuario = comboConsultaUsuario.getSelectedItem().toString();
            obtieneFecha = consultaFecha.getDateFormatString();

            //BUSQUEDA DE VENTAS 
            if (obtieneCategoria.equals("Ventas") && !obtieneCliente.equals("Seleccionar...")) 
            {
                sql = "SELECT numeroVenta, nombreUsuario, nombreCliente, fechaSistema,horaSistema, formaPago, total FROM venta "
                        + "WHERE nombreCliente='" + obtieneCliente + "'";
                numeroCabezeras = nombreColumnasVentas.length;
                bandera = 1;
            }
            else if (obtieneCategoria.equals("Ventas") && !obtieneCliente.equals("Seleccionar...") && !obtieneUsuario.equals("Seleccionar...")) 
            {
                sql = "SELECT numeroVenta, nombreUsuario, nombreCliente, fechaSistema,horaSistema,formaPago, total FROM venta"
                        + "WHERE nombreCliente='" + obtieneCliente + "' and nombreUsuario='" + obtieneUsuario + "'";
                numeroCabezeras = nombreColumnasVentas.length;
                bandera = 1;
            }
            else if (obtieneCategoria.equals("Ventas") && !obtieneCliente.equals("Seleccionar...") && !obtieneUsuario.equals("Seleccionar...") && !obtieneFecha.equals("")) 
            {
                sql = "SELECT numeroVenta, nombreUsuario, nombreCliente, fechaSistema,horaSistema,formaPago, total FROM venta"
                        + "WHERE nombreCliente='" + obtieneCliente + "' and nombreUsuario='" + obtieneUsuario + "'";
                numeroCabezeras = nombreColumnasVentas.length;
                bandera = 1;
            } 
            //BUSQUEDA DE PEDIDOS            
            else if (obtieneCategoria.equals("Pedidos") && !obtieneCliente.equals("Seleccionar..."))
            {
                sql = "SELECT numeroPedido, nombreUsuario, nombreCliente,"
                        + "especificacionTrabajo, especificacionDiseno,fechaSistema, fechaEntrega,"
                        + "horaSistema, estatus, formaPago, total, anticipo, descuento FROM pedidos"
                        + "WHERE  nombreCliente='" + obtieneCliente + "'";
                numeroCabezeras = nombreColumnasPedidos.length;
                bandera = 2;
            } 
            else if (obtieneCategoria.equals("Pedidos") && !obtieneCliente.equals("Seleccionar...")&& !obtieneUsuario.equals("Seleccionar...")) 
            {
                sql = "SELECT numeroPedido, nombreUsuario, nombreCliente,"
                        + "especificacionTrabajo, especificacionDiseno,fechaSistema, fechaEntrega,"
                        + "horaSistema, estatus, formaPago, total, anticipo, descuento FROM pedidos"
                        + "WHERE  nombreCliente='" + obtieneCliente + "' AND nombreUsuario= '"+obtieneUsuario+"'";
                numeroCabezeras = nombreColumnasPedidos.length;
                bandera = 2;
            }
            else if (obtieneCategoria.equals("Pedidos") && !obtieneCliente.equals("Seleccionar...")&& !obtieneUsuario.equals("Seleccionar...")&& !obtieneFecha.equals("")) 
            {
                sql = "SELECT numeroPedido, nombreUsuario, nombreCliente,"
                        + "especificacionTrabajo, especificacionDiseno,fechaSistema, fechaEntrega,"
                        + "horaSistema, estatus, formaPago, total, anticipo, descuento FROM pedidos"
                        + "WHERE  nombreCliente='" + obtieneCliente + "' AND nombreUsuario= '"+obtieneUsuario+"' AND  fechaSistema='"+obtieneFecha+"'";
                numeroCabezeras = nombreColumnasPedidos.length;
                bandera = 2;
            }
            //BUSQUEDA DE COTIZACIONES              
            else if (obtieneCategoria.equals("Cotizaciones") && !obtieneCliente.equals("Seleccionar...")) 
            {
                sql = "SELECT numero, idCliente, especificacionTrabajo,fecha, descuento, subtotal, total FROM tablacotiza "
                + "WHERE idCliente =(SELECT idCliente FROM cliente WHERE nombreCliente='obtieneCliente')";
                numeroCabezeras = nombreColumnasCotizaciones.length;
                bandera = 3 ;
                System.out.println("primera");
            }
            else if (obtieneCategoria.equals("Cotizaciones") && !obtieneCliente.equals("Seleccionar...")&& !obtieneFecha.equals("")) 
            {
                sql = "SELECT tablacotiza.numero, cliente.nombreCliente, tablacotiza.especificacionTrabajo, tablacotiza.fecha,"
                    + "tablacotiza.descuento, tablacotiza.subtotal, tablacotiza.total FROM tablacotiza, cliente"
                    + "WHERE tablacotiza.idCliente = cliente.idCliente";
                numeroCabezeras = nombreColumnasCotizaciones.length;
                bandera = 3;
                System.out.println("segunda");
            }

            pps = con.prepareStatement(sql);
            rs = pps.executeQuery();
            tablaMostrarConsulta.setModel(DbUtils.resultSetToTableModel(rs));
            //Nombrado de las columnas
            if (bandera == 1) {
                for (int n = 0; n < nombreColumnasVentas.length; n++) {
                    tablaMostrarConsulta.getColumnModel().getColumn(n).setHeaderValue(nombreColumnasVentas[n]);
                }
            } else if (bandera == 2) {
                for (int n = 0; n < nombreColumnasPedidos.length; n++) {
                    tablaMostrarConsulta.getColumnModel().getColumn(n).setHeaderValue(nombreColumnasPedidos[n]);
                }
            } else if (bandera == 3) {
                for (int n = 0; n < nombreColumnasCotizaciones.length; n++) {
                    tablaMostrarConsulta.getColumnModel().getColumn(n).setHeaderValue(nombreColumnasCotizaciones[n]);
                }
            }
            bandera = 0;
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar [x]  " + e.getCause().toString());
        }
    }//GEN-LAST:event_botonBusquedaActionPerformed

    private void checkBoxClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxClienteActionPerformed
        try {
            if (checkBoxCliente.isSelected()) {
                agregarClienteCombo();
                comboConsultaCliente.enable(true);
            } else {
                comboConsultaCliente.enable(false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelConsultas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_checkBoxClienteActionPerformed

    private void checkBoxUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxUsuarioActionPerformed
        try {
            if (checkBoxUsuario.isSelected()) {
                agregarUsuarioCombo();
                comboConsultaUsuario.enable(true);

            } else {
                comboConsultaUsuario.enable(false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelConsultas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_checkBoxUsuarioActionPerformed

    private void checkBoxFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxFechaActionPerformed
        if (checkBoxFecha.isSelected()) {
            consultaFecha.getCalendarButton().setEnabled(true);
        } else {
            consultaFecha.getCalendarButton().setEnabled(false);
        }
    }//GEN-LAST:event_checkBoxFechaActionPerformed

    private void comboCategoriaBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCategoriaBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboCategoriaBusquedaActionPerformed
    
    public static void ontieneIDCliente(){
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton botonBusqueda;
    public static javax.swing.JCheckBox checkBoxCliente;
    public static javax.swing.JCheckBox checkBoxFecha;
    public static javax.swing.JCheckBox checkBoxUsuario;
    public static javax.swing.JComboBox comboCategoriaBusqueda;
    public static javax.swing.JComboBox comboConsultaCliente;
    public static javax.swing.JComboBox comboConsultaUsuario;
    public static com.toedter.calendar.JDateChooser consultaFecha;
    public static javax.swing.JLabel etiquetaCategoria;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane4;
    public static javax.swing.JSeparator jSeparator1;
    public javax.swing.JTable tablaMostrarConsulta;
    // End of variables declaration//GEN-END:variables
}
