package Consultas;

import Conexion.Conexion;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.PrintException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class PanelConsultas extends javax.swing.JPanel {

    //MODELO DE LA TABLA 
    public static DefaultTableModel modelo = new DefaultTableModel();
    
    //REALIZAR CONEXION A LA BASE DE DATOS 
    public static String url = "jdbc:mysql://" + Conexion.nombreServidor + ":" + Conexion.puerto + "/" + Conexion.nombreBD;
    public static Connection con;
    public static PreparedStatement pps;
    public static ResultSet rs;

    //NOMBRADO DE LAS COLUMNAS VENTAS, PEDIDOS Y COTIZACIONES 
    public static String[] nombreColumnasVentas = {"Folio", "Usuario", "Cliente ", "Fecha", "Hora", " Forma Pago", "Total"};
    public static String[] nombreColumnasPedidos = {"Folio", "Usuario", "Cliente ", "Trabajo", "Diseño", "Fecha Pedido", "Fecha Entrega", "Hora Pedido", "Estatus", "Forma Pago", "Total", "Anticipo"};
    public static String[] nombreColumnasCotizaciones = {"Folio", "Cliente ", "Trabajo", "Fecha", "Descuento", "Subtotal", "Total"};
    public static int numeroCabezeras;//= nombreColumnasVentasCliente.length;

    // CONSULTAS EN LA BASE DE DATOS
    public static String sqlClientes = "select nombreCliente from cliente order by nombreCliente asc";
    public static String sqlUsuarios = "select nombreUsuario from usuario order by nombreUsuario asc";
    public static String sqlPedidos = "SELECT numeroPedido, nombreUsuario, nombreCliente,especificacionTrabajo, especificacionDiseno, "
            + "fechaSistema, fechaEntrega,horaSistema, estatus, formaPago, total, anticipo FROM pedidos WHERE estatus not in('Pagado') order by numeroPedido desc";
    public static String sqlActualizaEstatus = "UPDATE pedidos SET estatus=? WHERE numeroPedido=?";
    public static String sqlConsultaCategoria = "", sqlConsultaEventoBoton = "", sqlClientesID = "";

    public static int bandera = 0, idClienteConsulta = 0, recibeIdCliente = 0;
    public static String mesajeConsulta = "";
    public String obtieneCategoria = "", obtieneCliente = "", obtieneUsuario = "";

    public static String sqlActualizaAnticipo = "UPDATE pedidos SET anticipo=anticipo+? WHERE numeroPedido=?";

    //VARIABLE PARA DETECTAR LA SELECCION DEL ANTICIPO Y ASI PODER IMPRIMIR ESOS DATOS
    public static int seleccion;

    public PanelConsultas() throws SQLException {
        initComponents();
        conecta();
        agregarUsuarioCombo();
        agregarClienteCombo();
        agregarPedidosTabla();
    }

    //FUNCIONAL----- METODO QUE CONECTA A LA BASE DE DATOS 
    public static void conecta() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //con = DriverManager.getConnection(url,"tu usuario en la base de datos","tu contraseÃ±a");
            con = DriverManager.getConnection(url, Conexion.usuarioBD, Conexion.contrasena);
            if (con != null) {
                System.out.println("VENTAS----> listo");
            }
        } catch (Exception e) {
            System.out.println("Problema: " + e);
        }
    }

    //FUNCIONAL---- AGREGA USUARIO AL COMBO BOX 
    public void agregarUsuarioCombo() throws SQLException {
        comboUsuario.removeAllItems();
        pps = con.prepareStatement(sqlUsuarios);
        comboUsuario.addItem("Seleccionar...");
        rs = pps.executeQuery();
        while (rs.next()) {
            comboUsuario.addItem(rs.getString(1));
        }
    }

    //FUNCIONAL---- AGREGA CLIENTE AL COMBO BOX 
    public static void agregarClienteCombo() throws SQLException {
        comboCliente.removeAllItems();
        pps = con.prepareStatement(sqlClientes);
        rs = pps.executeQuery();
        comboCliente.addItem("Seleccionar...");
        while (rs.next()) {
            comboCliente.addItem(rs.getString(1));
        }
        //con.close();
    }

    //FUNCIONAL SI AGREGA LOS PEDIDOS 
    public static void agregarPedidosTabla() throws SQLException {
        try {
            numeroCabezeras = nombreColumnasPedidos.length;
            pps = con.prepareStatement(sqlPedidos);
            rs = pps.executeQuery();
            tablaMostrarConsulta.setModel(DbUtils.resultSetToTableModel(rs));
            //Nombrado de las columnas
            for (int n = 0; n < numeroCabezeras; n++) {
                tablaMostrarConsulta.getColumnModel().getColumn(n).setHeaderValue(nombreColumnasPedidos[n]);
            }
        } catch (Exception e) {
            // JOptionPane.showMessageDialog(null, e);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelConsulta = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMostrarConsulta = new javax.swing.JTable();
        separadorTabla = new javax.swing.JSeparator();
        labelCategoria = new javax.swing.JLabel();
        comboCategoriaBusqueda = new javax.swing.JComboBox();
        comboUsuario = new javax.swing.JComboBox();
        labelUsuario = new javax.swing.JLabel();
        comboCliente = new javax.swing.JComboBox();
        labelCliente = new javax.swing.JLabel();
        botonConsultar = new javax.swing.JButton();
        botonEstatus = new javax.swing.JButton();
        botonAbonos = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        panelConsulta.setBackground(new java.awt.Color(255, 255, 255));
        panelConsulta.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consultas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        tablaMostrarConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaMostrarConsulta);

        labelCategoria.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelCategoria.setText("Categoría: ");

        comboCategoriaBusqueda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar...", "Ventas", "Pedidos", "Cotizaciones" }));
        comboCategoriaBusqueda.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboCategoriaBusquedaItemStateChanged(evt);
            }
        });

        comboUsuario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar..." }));

        labelUsuario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelUsuario.setText("Usuario: ");

        comboCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar..." }));

        labelCliente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelCliente.setText("Cliente: ");

        botonConsultar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imgConsultas.png"))); // NOI18N
        botonConsultar.setText("Consultar ");
        botonConsultar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonConsultarMouseClicked(evt);
            }
        });

        botonEstatus.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonEstatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imgModificarEstatus.png"))); // NOI18N
        botonEstatus.setText("Modificar Estatus ");
        botonEstatus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonEstatusMouseClicked(evt);
            }
        });

        botonAbonos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonAbonos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imgAnticipos.png"))); // NOI18N
        botonAbonos.setText("Anticipos");
        botonAbonos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAbonosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelConsultaLayout = new javax.swing.GroupLayout(panelConsulta);
        panelConsulta.setLayout(panelConsultaLayout);
        panelConsultaLayout.setHorizontalGroup(
            panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConsultaLayout.createSequentialGroup()
                .addGroup(panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(separadorTabla, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelConsultaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelCategoria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboCategoriaBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonConsultar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonEstatus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonAbonos, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        panelConsultaLayout.setVerticalGroup(
            panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCategoria)
                    .addComponent(comboCategoriaBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelUsuario)
                    .addComponent(comboUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCliente)
                    .addComponent(comboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonConsultar)
                    .addComponent(botonEstatus)
                    .addComponent(botonAbonos))
                .addGap(18, 18, 18)
                .addComponent(separadorTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void comboCategoriaBusquedaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboCategoriaBusquedaItemStateChanged
        try {
            conecta();
            sqlConsultaCategoria = "";
            comboUsuario.setEnabled(true);
            String obtieneCategoriaProductoCombo;
            obtieneCategoriaProductoCombo = comboCategoriaBusqueda.getSelectedItem().toString();

            if (obtieneCategoriaProductoCombo.equals("Ventas")) {
                sqlConsultaCategoria = "SELECT numeroVenta, nombreUsuario, nombreCliente, fechaSistema, horaSistema, formaPago, total FROM venta order by numeroVenta desc";
                bandera = 1;
            } else if (obtieneCategoriaProductoCombo.equals("Pedidos")) {
                sqlConsultaCategoria = "SELECT numeroPedido, nombreUsuario, nombreCliente,especificacionTrabajo, especificacionDiseno,fechaSistema, fechaEntrega, horaSistema, estatus, formaPago, total, anticipo FROM pedidos WHERE estatus not in ('Pagado') order by numeroPedido asc";
                bandera = 2;
            } else if (obtieneCategoriaProductoCombo.equals("Cotizaciones")) {
                comboUsuario.setEnabled(false);
                sqlConsultaCategoria = "SELECT cotizacion.numero, cliente.nombreCliente, cotizacion.especificacionTrabajo, cotizacion.fecha, cotizacion.descuento, cotizacion.subtotal, cotizacion.total FROM cotizacion, cliente WHERE cotizacion.idCliente = cliente.idCliente order by cotizacion.numero asc";
                bandera = 3;
            } else if (obtieneCategoriaProductoCombo.equals("Seleccionar...")) {
                JOptionPane.showMessageDialog(null, "Seleccione una categoría", "IMPORTANTE:", JOptionPane.WARNING_MESSAGE);
            }

            pps = con.prepareStatement(sqlConsultaCategoria);
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
        } catch (SQLException e) {
            //    JOptionPane.showMessageDialog(null, "Error al buscar [x]  " + e);
            System.out.println("ERROR COMBO CATE BUSQUEDA " + e);
        }
    }//GEN-LAST:event_comboCategoriaBusquedaItemStateChanged

    private void botonConsultarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonConsultarMouseClicked
        try {
            sqlConsultaEventoBoton = "";
            obtieneCategoria = comboCategoriaBusqueda.getSelectedItem().toString();
            obtieneCliente = comboCliente.getSelectedItem().toString();
            obtieneUsuario = comboUsuario.getSelectedItem().toString();
            recibeIdCliente = consultaIdCliente(obtieneCliente);
            System.out.println("rec " + recibeIdCliente);

            //BUSQUEDA DE VENTAS, CLIENTE, USUARIO
            if (obtieneCategoria.equals("Ventas") && !obtieneUsuario.equals("Seleccionar...") && !obtieneCliente.equals("Seleccionar...")) {
                sqlConsultaEventoBoton = "SELECT numeroVenta, nombreUsuario, nombreCliente, fechaSistema,horaSistema,formaPago, total FROM todolonas.venta";
                numeroCabezeras = nombreColumnasVentas.length;
                mesajeConsulta = "Categoría :" + obtieneCategoria + "   Usuario: " + obtieneUsuario + "   Cliente: " + obtieneCliente + "";
                bandera = 1;
            } //BUSQUEDA DE VENTAS Y CLIENTE
            else if (obtieneCategoria.equals("Ventas") && !obtieneCliente.equals("Seleccionar...")) {
                sqlConsultaEventoBoton = "SELECT numeroVenta, nombreUsuario, nombreCliente, fechaSistema,horaSistema, formaPago, total FROM venta WHERE nombreCliente='" + obtieneCliente + "'";
                numeroCabezeras = nombreColumnasVentas.length;
                mesajeConsulta = "Categoría :" + obtieneCategoria + "   Cliente: " + obtieneCliente + "";
                bandera = 1;
            } //BUSQUEDA DE VENTAS Y USUARIO
            else if (obtieneCategoria.equals("Ventas") && !obtieneUsuario.equals("Seleccionar...")) {
                sqlConsultaEventoBoton = "SELECT numeroVenta, nombreUsuario, nombreCliente, fechaSistema,horaSistema, formaPago, total FROM venta WHERE nombreUsuario='" + obtieneUsuario + "'";
                numeroCabezeras = nombreColumnasVentas.length;
                mesajeConsulta = "Categoría: " + obtieneCategoria + "   Usuario: " + obtieneUsuario + "";
                bandera = 1;
            } /*BUSQUEDA DE PEDIDOS*/ // BUSQUEDA PEDIDOS CLIENTE Y USUARIO 
            else if (obtieneCategoria.equals("Pedidos") && !obtieneCliente.equals("Seleccionar...") && !obtieneUsuario.equals("Seleccionar...")) {
                sqlConsultaEventoBoton = "SELECT numeroPedido, nombreUsuario, nombreCliente, especificacionTrabajo, especificacionDiseno, fechaSistema, fechaEntrega, horaSistema, estatus, formaPago, total, anticipo FROM pedidos WHERE  nombreCliente='" + obtieneCliente + "' AND nombreUsuario='" + obtieneUsuario + "'";
                numeroCabezeras = nombreColumnasPedidos.length;
                mesajeConsulta = "Categoría :" + obtieneCategoria + "   Usuario: " + obtieneUsuario + "   Cliente: " + obtieneCliente + "";
                bandera = 2;
            } // BUSQUEDA PEDIDOS Y CLIENTE 
            else if (obtieneCategoria.equals("Pedidos") && !obtieneCliente.equals("Seleccionar...")) {
                sqlConsultaEventoBoton = "SELECT numeroPedido, nombreUsuario, nombreCliente, especificacionTrabajo, especificacionDiseno,fechaSistema, fechaEntrega, horaSistema, estatus, formaPago, total, anticipo FROM pedidos WHERE  nombreCliente='" + obtieneCliente + "'";
                numeroCabezeras = nombreColumnasPedidos.length;
                bandera = 2;
            } //  BUSQUEDA PEDIDOS Y USUARIO 
            else if (obtieneCategoria.equals("Pedidos") && !obtieneUsuario.equals("Seleccionar...")) {
                sqlConsultaEventoBoton = "SELECT numeroPedido, nombreUsuario, nombreCliente, especificacionTrabajo, especificacionDiseno,fechaSistema, fechaEntrega, horaSistema, estatus, formaPago, total, anticipo FROM pedidos WHERE  nombreUsuario='" + obtieneUsuario + "'";
                numeroCabezeras = nombreColumnasPedidos.length;
                bandera = 2;
            } //BUSQUEDA DE COTIZACIONES Y CLIENTE              
            else if (obtieneCategoria.equals("Cotizaciones") && !obtieneCliente.equals("Seleccionar...")) {
                sqlConsultaEventoBoton = "SELECT numero, nombreCliente, especificacionTrabajo,fecha, descuento, subtotal, total FROM cotizacion INNER JOIN cliente  ON cotizacion.idCliente=cliente.idCliente WHERE cliente.idCliente='" + recibeIdCliente + "'";
                numeroCabezeras = nombreColumnasCotizaciones.length;
                bandera = 3;
            }
            pps = con.prepareStatement(sqlConsultaEventoBoton);
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

        } catch (SQLException e) {
            System.out.println(" ERROR " + e);
        }
        bandera = 0;
        obtieneCategoria = "";
        obtieneCliente = "";
        obtieneUsuario = "";
        //comboCategoriaBusqueda.setSelectedIndex(0);
        comboCliente.setSelectedIndex(0);
        comboUsuario.setSelectedIndex(0);
    }//GEN-LAST:event_botonConsultarMouseClicked

    private void botonEstatusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEstatusMouseClicked
        try {
            int res = 0;
            int filaSeleccionadaPedidos = tablaMostrarConsulta.getSelectedRow();
            //nombreColumnasPedidos = {"Folio", "Usuario", "Cliente ", "Trabajo", "Diseño", 
            //"Fecha Pedido", "Fecha Entrega", "Hora Pedido", "Estatus", "Forma Pago", "Total", "Anticipo"};
            String estatus, folio, estatusActual, actualizaEstatusTabla;
            int folioSeleccionado;
            double total, anticipo, importeFinal=0;

            if (filaSeleccionadaPedidos == -1) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un pedido", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                modelo = (DefaultTableModel) tablaMostrarConsulta.getModel();
                folioSeleccionado = Integer.parseInt(tablaMostrarConsulta.getValueAt(filaSeleccionadaPedidos, 0).toString());
                estatus = tablaMostrarConsulta.getValueAt(filaSeleccionadaPedidos, 8).toString();
                String[] listaEstatus = {"Diseño", "En impresión", "Urgente", "Terminado", "Entregado","Pagado"};
                JComboBox comboEstatus = new JComboBox(listaEstatus);
                JOptionPane.showMessageDialog(null, comboEstatus, "Selecciona el Estatus ", JOptionPane.QUESTION_MESSAGE);
                System.out.println(comboEstatus.getSelectedItem());
                estatusActual = (String) comboEstatus.getSelectedItem();
                
                if (estatusActual.equals("Entregado")  || estatusActual.equals("Pagado")) {
                    total=Double.parseDouble(tablaMostrarConsulta.getValueAt(filaSeleccionadaPedidos, 10).toString());
                    anticipo=Double.parseDouble(tablaMostrarConsulta.getValueAt(filaSeleccionadaPedidos, 11).toString());
                    importeFinal=total-anticipo;
                    
                    System.out.println("importe final "+importeFinal);
                    if (importeFinal==0) {
                        estatusActual="Pagado";
                    }
                    else{
                        estatusActual="Entregado";
                    }                            
                }
                
                    
                
                pps = con.prepareStatement(sqlActualizaEstatus);
                pps.setString(1, estatusActual);
                pps.setInt(2, folioSeleccionado);
                int n = pps.executeUpdate();
                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
                    agregarPedidosTabla();//l momento de agregar un nuevo registro, actualiza la tabla
                }
            }
        } catch (SQLException e) {
            System.out.println("ERROR + " + e);
        }
    }//GEN-LAST:event_botonEstatusMouseClicked

    private void botonAbonosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAbonosActionPerformed
        try {
            int filaSeleccionadaPedidos = tablaMostrarConsulta.getSelectedRow();
            seleccion = filaSeleccionadaPedidos;
            System.out.println("SELECCION: " + seleccion);
            String anticipo, agregaAnticipo, actualizaAnticipoTabla;
            int folioSeleccionado;
            //variabes para la comparacion del anticipo.
            String total;
            double totalCondicion = 0, anticipoCondicion = 0, totalAntipo = 0;

            if (filaSeleccionadaPedidos == -1) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un pedido", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                modelo = (DefaultTableModel) tablaMostrarConsulta.getModel();
                folioSeleccionado = Integer.parseInt(tablaMostrarConsulta.getValueAt(filaSeleccionadaPedidos, 0).toString());
                anticipo = tablaMostrarConsulta.getValueAt(filaSeleccionadaPedidos, 11).toString();
                total = tablaMostrarConsulta.getValueAt(filaSeleccionadaPedidos, 10).toString();
                JTextField cajaAnticipo = new JTextField();
                System.out.println("anticipo " + anticipo);
                System.out.println("folio " + folioSeleccionado);
                System.out.println("total " + total);
                JOptionPane.showMessageDialog(null, cajaAnticipo, "Ingresa anticipo", JOptionPane.QUESTION_MESSAGE);
                agregaAnticipo = cajaAnticipo.getText();

                //VERIFICACION DEL ANTICIPO
                totalCondicion = Double.parseDouble(total);
                anticipoCondicion = Double.parseDouble(anticipo);
                totalAntipo = anticipoCondicion + Double.parseDouble(agregaAnticipo);

                if (totalCondicion == totalAntipo) {
                    JOptionPane.showMessageDialog(null, "PAGADO");
                    pps = con.prepareStatement(sqlActualizaAnticipo);
                    pps.setString(1, agregaAnticipo);
                    pps.setInt(2, folioSeleccionado);
                    int n = pps.executeUpdate();
                    if (n > 0) {
                        try {
                            JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
                            agregarPedidosTabla();//l momento de agregar un nuevo registro, actualiza la tabla           
                            try {
                                TicketAbonos.EstructuraTicket.imprime(((DefaultTableModel) tablaMostrarConsulta.getModel()).getRowCount());
                            } catch (PrintException | IOException ex) {
                                Logger.getLogger(PanelConsultas.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } catch (NullPointerException ex) {
                        }
                    }
                } else if (totalCondicion > totalAntipo) {

                    pps = con.prepareStatement(sqlActualizaAnticipo);
                    pps.setString(1, agregaAnticipo);
                    pps.setInt(2, folioSeleccionado);
                    int n = pps.executeUpdate();
                    if (n > 0) {
                        try {
                            JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
                            agregarPedidosTabla();//l momento de agregar un nuevo registro, actualiza la tabla           
                            try {
                                TicketAbonos.EstructuraTicket.imprime(((DefaultTableModel) tablaMostrarConsulta.getModel()).getRowCount());
                            } catch (PrintException | IOException ex) {
                                Logger.getLogger(PanelConsultas.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } catch (NullPointerException ex) {
                        }
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("ERROR + " + e);
        }
    }//GEN-LAST:event_botonAbonosActionPerformed

    //FUNCIONAL---- RETORNA EL ID PARA LA COTIZACION 
    public static int consultaIdCliente(String nombreCliente) {
        try {
            sqlClientesID = "select idCliente from cliente where nombreCliente='" + nombreCliente + "'";
            pps = con.prepareStatement(sqlClientesID);
            rs = pps.executeQuery();
            while (rs.next()) {
                idClienteConsulta = Integer.parseInt(rs.getString(1));
            }
        } catch (Exception e) {

        }
        return idClienteConsulta;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton botonAbonos;
    public static javax.swing.JButton botonConsultar;
    public static javax.swing.JButton botonEstatus;
    public static javax.swing.JComboBox comboCategoriaBusqueda;
    public static javax.swing.JComboBox comboCliente;
    private javax.swing.JComboBox comboUsuario;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCategoria;
    private javax.swing.JLabel labelCliente;
    public static javax.swing.JLabel labelUsuario;
    public static javax.swing.JPanel panelConsulta;
    public static javax.swing.JSeparator separadorTabla;
    public static javax.swing.JTable tablaMostrarConsulta;
    // End of variables declaration//GEN-END:variables
}
