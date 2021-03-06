/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cotizacion;

import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ana Karen
 */
public class PanelCotizacion extends javax.swing.JPanel {

    Calendar cal = Calendar.getInstance();
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    String varFechaReg = cal.get(cal.DATE) + "-" + (cal.get(cal.MONTH) + 1) + "-" + cal.get(cal.YEAR);
    String horaActual = cal.get(Calendar.HOUR) + " : " + cal.get(Calendar.MINUTE) + " : " + cal.get(Calendar.SECOND);

    public static Statement stm = null;
    public static String bd = Conexion.nombreBD;
    public static String login = Conexion.usuarioBD;//"root";
    public static String password = Conexion.contrasena;//"280592ssmaylo";
    public static String url = "jdbc:mysql://" + Conexion.nombreServidor + ":" + Conexion.puerto + "/" + Conexion.nombreBD;

    public static int numeroC;

    /**
     * Creates new form PanelCotizacion
     */
    public PanelCotizacion() {
        initComponents();
        labelObtenerFecha.setText(varFechaReg);

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
        cajaBuscarCliente = new javax.swing.JTextField();
        botonBuscarCliente = new javax.swing.JButton();
        botonNuevoCliente = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaCliente = new javax.swing.JList();
        jPanel2 = new javax.swing.JPanel();
        labelLogo2 = new javax.swing.JLabel();
        labelCliente = new javax.swing.JLabel();
        labelAsunto = new javax.swing.JLabel();
        labelUbicacion = new javax.swing.JLabel();
        labelAnexo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        labelObtenerTelefono = new javax.swing.JLabel();
        labelObtenerCorreo = new javax.swing.JLabel();
        labelObtenerDomicilio = new javax.swing.JLabel();
        labelObtenerColonia = new javax.swing.JLabel();
        labelObtenerRFC = new javax.swing.JLabel();
        labelTelefono = new javax.swing.JLabel();
        labelCorreo = new javax.swing.JLabel();
        labelDomicilio = new javax.swing.JLabel();
        labelRFC = new javax.swing.JLabel();
        labelImagenTelefono = new javax.swing.JLabel();
        labelImagenCorreo = new javax.swing.JLabel();
        labelImagenMapa = new javax.swing.JLabel();
        labelFecha = new javax.swing.JLabel();
        labelCiudad = new javax.swing.JLabel();
        cajaAsunto = new javax.swing.JTextField();
        cajaUbicacion = new javax.swing.JTextField();
        labelNota1 = new javax.swing.JLabel();
        labelSubTotal = new javax.swing.JLabel();
        labelIVA = new javax.swing.JLabel();
        labelDescuento = new javax.swing.JLabel();
        labelATE = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        botonPDF = new javax.swing.JButton();
        labelTotal = new javax.swing.JLabel();
        cajaDescuento = new javax.swing.JTextField();
        cajaTotal = new javax.swing.JTextField();
        cajaIVA = new javax.swing.JTextField();
        cajaSubtotal = new javax.swing.JTextField();
        labelObtenerNombreCliente = new javax.swing.JLabel();
        areaLeyenda = new java.awt.TextArea();
        labelCelular = new javax.swing.JLabel();
        labelObtenerCelular = new javax.swing.JLabel();
        labelObtenerFecha = new javax.swing.JLabel();
        botonPrecioExtra = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(62, 64, 149));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Clientes ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        cajaBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaBuscarClienteActionPerformed(evt);
            }
        });
        cajaBuscarCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaBuscarClienteKeyTyped(evt);
            }
        });

        botonBuscarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imgConsultas.png"))); // NOI18N
        botonBuscarCliente.setText("Buscar");
        botonBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarClienteActionPerformed(evt);
            }
        });

        botonNuevoCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imgAgregar.png"))); // NOI18N
        botonNuevoCliente.setText("Nuevo");
        botonNuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevoClienteActionPerformed(evt);
            }
        });

        jScrollPane3.setVerifyInputWhenFocusTarget(false);

        listaCliente.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1)));
        listaCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaClienteMouseClicked(evt);
            }
        });
        listaCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                listaClienteKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(listaCliente);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cajaBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonBuscarCliente)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(botonNuevoCliente)
                .addGap(141, 141, 141))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cajaBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBuscarCliente))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                .addGap(27, 27, 27)
                .addComponent(botonNuevoCliente)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        labelLogo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/todo lonas.png"))); // NOI18N
        jPanel2.add(labelLogo2);
        labelLogo2.setBounds(10, 11, 112, 45);

        labelCliente.setText("Cliente:");
        jPanel2.add(labelCliente);
        labelCliente.setBounds(10, 70, 37, 14);

        labelAsunto.setText("Asunto:");
        jPanel2.add(labelAsunto);
        labelAsunto.setBounds(10, 94, 38, 14);

        labelUbicacion.setText("Ubicación:");
        jPanel2.add(labelUbicacion);
        labelUbicacion.setBounds(10, 120, 49, 14);

        labelAnexo.setText("Le anexo la cotización solicitada, esperando poder servirle.");
        jPanel2.add(labelAnexo);
        labelAnexo.setBounds(30, 186, 283, 14);

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Descripción", "Precio Unitario", "Cantidad", "Total"
            }
        ));
        jScrollPane2.setViewportView(tablaProductos);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(10, 206, 700, 165);

        labelObtenerTelefono.setText("01 437 95 4 0092");
        jPanel2.add(labelObtenerTelefono);
        labelObtenerTelefono.setBounds(590, 30, 130, 14);

        labelObtenerCorreo.setText("todolonas@hotmail.com");
        jPanel2.add(labelObtenerCorreo);
        labelObtenerCorreo.setBounds(590, 50, 130, 14);

        labelObtenerDomicilio.setText("Calle Fco. I Madero No. 90");
        jPanel2.add(labelObtenerDomicilio);
        labelObtenerDomicilio.setBounds(590, 70, 128, 14);

        labelObtenerColonia.setText("Colonia Centro");
        jPanel2.add(labelObtenerColonia);
        labelObtenerColonia.setBounds(590, 90, 71, 14);

        labelObtenerRFC.setText("CAA084090943A");
        jPanel2.add(labelObtenerRFC);
        labelObtenerRFC.setBounds(590, 110, 82, 14);

        labelTelefono.setText("Teléfono:");
        jPanel2.add(labelTelefono);
        labelTelefono.setBounds(530, 30, 46, 14);

        labelCorreo.setText("Correo:");
        jPanel2.add(labelCorreo);
        labelCorreo.setBounds(530, 50, 37, 14);

        labelDomicilio.setText("Domicilio:");
        jPanel2.add(labelDomicilio);
        labelDomicilio.setBounds(530, 70, 44, 14);

        labelRFC.setText("RFC:");
        jPanel2.add(labelRFC);
        labelRFC.setBounds(530, 110, 24, 14);

        labelImagenTelefono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iPhone-front-white-icon.png"))); // NOI18N
        jPanel2.add(labelImagenTelefono);
        labelImagenTelefono.setBounds(490, 10, 20, 30);

        labelImagenCorreo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Communication-gmail-icon.png"))); // NOI18N
        jPanel2.add(labelImagenCorreo);
        labelImagenCorreo.setBounds(490, 40, 24, 24);

        labelImagenMapa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Google-Maps-icon.png"))); // NOI18N
        jPanel2.add(labelImagenMapa);
        labelImagenMapa.setBounds(490, 70, 24, 24);

        labelFecha.setText("Fecha:");
        jPanel2.add(labelFecha);
        labelFecha.setBounds(530, 130, 33, 14);

        labelCiudad.setText("Tlaltenango de S. R, Zacatecas");
        jPanel2.add(labelCiudad);
        labelCiudad.setBounds(530, 170, 160, 14);

        cajaAsunto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaAsuntoKeyTyped(evt);
            }
        });
        jPanel2.add(cajaAsunto);
        cajaAsunto.setBounds(60, 90, 280, 20);

        cajaUbicacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaUbicacionKeyTyped(evt);
            }
        });
        jPanel2.add(cajaUbicacion);
        cajaUbicacion.setBounds(60, 120, 280, 20);

        labelNota1.setText("Nota: Se requiere de un 50% de anticipo para realizar su trabajo y 50% al entregarlo.");
        jPanel2.add(labelNota1);
        labelNota1.setBounds(10, 390, 414, 14);

        labelSubTotal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelSubTotal.setText("SubTotal:");
        jPanel2.add(labelSubTotal);
        labelSubTotal.setBounds(520, 390, 53, 14);

        labelIVA.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelIVA.setText("IVA:");
        jPanel2.add(labelIVA);
        labelIVA.setBounds(520, 420, 23, 14);

        labelDescuento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelDescuento.setText("Descuento:");
        jPanel2.add(labelDescuento);
        labelDescuento.setBounds(520, 450, 63, 14);

        labelATE.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelATE.setText("ATENTAMENTE");
        jPanel2.add(labelATE);
        labelATE.setBounds(320, 480, 79, 14);

        labelNombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelNombre.setText("Arq. Omar Alejandro Castañeda Alvarez");
        jPanel2.add(labelNombre);
        labelNombre.setBounds(260, 510, 224, 14);

        botonPDF.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        botonPDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Pdf-icon3.png"))); // NOI18N
        botonPDF.setText("PDF");
        botonPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPDFActionPerformed(evt);
            }
        });
        jPanel2.add(botonPDF);
        botonPDF.setBounds(330, 540, 81, 33);

        labelTotal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelTotal.setText("Total:");
        jPanel2.add(labelTotal);
        labelTotal.setBounds(520, 480, 32, 14);

        cajaDescuento.setEditable(false);
        jPanel2.add(cajaDescuento);
        cajaDescuento.setBounds(600, 440, 110, 20);

        cajaTotal.setEditable(false);
        cajaTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaTotalActionPerformed(evt);
            }
        });
        jPanel2.add(cajaTotal);
        cajaTotal.setBounds(600, 470, 110, 20);

        cajaIVA.setEditable(false);
        cajaIVA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaIVAActionPerformed(evt);
            }
        });
        jPanel2.add(cajaIVA);
        cajaIVA.setBounds(600, 410, 112, 20);

        cajaSubtotal.setEditable(false);
        jPanel2.add(cajaSubtotal);
        cajaSubtotal.setBounds(600, 380, 111, 20);
        jPanel2.add(labelObtenerNombreCliente);
        labelObtenerNombreCliente.setBounds(58, 69, 183, 14);

        areaLeyenda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                areaLeyendaKeyTyped(evt);
            }
        });
        jPanel2.add(areaLeyenda);
        areaLeyenda.setBounds(10, 410, 410, 60);

        labelCelular.setText("Celular:");
        jPanel2.add(labelCelular);
        labelCelular.setBounds(530, 10, 37, 14);

        labelObtenerCelular.setText("01 437 95 4 0092");
        jPanel2.add(labelObtenerCelular);
        labelObtenerCelular.setBounds(590, 10, 130, 14);
        jPanel2.add(labelObtenerFecha);
        labelObtenerFecha.setBounds(590, 130, 80, 14);

        botonPrecioExtra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imgAgregar.png"))); // NOI18N
        botonPrecioExtra.setText("Precio Extra");
        botonPrecioExtra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPrecioExtraActionPerformed(evt);
            }
        });
        jPanel2.add(botonPrecioExtra);
        botonPrecioExtra.setBounds(30, 490, 140, 33);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/todo lonas.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(101, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarClienteActionPerformed
        // TODO add your handling code here:
        LogicaCotizacion.buscarCliente();
    }//GEN-LAST:event_botonBuscarClienteActionPerformed

    private void botonNuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevoClienteActionPerformed
        // TODO add your handling code here:
        TodoLonas.Principal.cardLayout.show(TodoLonas.Principal.panelContenedor, "cliente");
        Clientes.PanelClientes.labelRegresarClientes.setVisible(true);
    }//GEN-LAST:event_botonNuevoClienteActionPerformed

    private void cajaTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaTotalActionPerformed

    private void cajaIVAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaIVAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaIVAActionPerformed

    private void cajaBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaBuscarClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaBuscarClienteActionPerformed

    private void listaClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaClienteMouseClicked
        String nombre = "";
        if (evt.getClickCount() == 2) {
            nombre = "" + listaCliente.getSelectedValue();
//            labelObtenerNombreCliente.setText("" + listaCliente.getSelectedValue());
            LogicaCotizacion.cliente.removeAllElements();
            listaCliente.setModel(LogicaCotizacion.cliente);
            cajaBuscarCliente.setText("");
            if (nombre.equals("null")) {
                System.out.println("se encontro cliente");
                botonPDF.setEnabled(false);
                botonNuevoCliente.setEnabled(true);
                botonPrecioExtra.setEnabled(false);
            } else {
                labelObtenerNombreCliente.setText(nombre);
                botonPDF.setEnabled(true);
                botonPrecioExtra.setEnabled(true);
                Cotizacion.LogicaCotizacion.obtenerDatosOperaciones();
            }
        }
    }//GEN-LAST:event_listaClienteMouseClicked

    private void listaClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listaClienteKeyPressed

    }//GEN-LAST:event_listaClienteKeyPressed

    private void botonPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPDFActionPerformed
        // TODO add your handling code here:
        guardarCotizacion.guardarTablaCotiza();
        guardarCotizacion.guardarDetallesCotiza();
        ExportarPDF.guardarPDF();
        limpiarCotizacion();
    }//GEN-LAST:event_botonPDFActionPerformed

    private void cajaBuscarClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaBuscarClienteKeyTyped
        // TODO add your handling code here:
        char caracter = evt.getKeyChar();
        if ((caracter < 'a' || caracter > 'z') && (caracter < 'A' || caracter > 'Z')
                && (caracter != (char) KeyEvent.VK_SPACE)) {
            evt.consume();
        }
        if (cajaBuscarCliente.getText().length() >= 45) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaBuscarClienteKeyTyped

    private void cajaAsuntoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaAsuntoKeyTyped
        // TODO add your handling code here:
        char caracter = evt.getKeyChar();
        if (cajaBuscarCliente.getText().length() >= 45) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaAsuntoKeyTyped

    private void cajaUbicacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaUbicacionKeyTyped
        // TODO add your handling code here:
        char caracter = evt.getKeyChar();

        if (cajaBuscarCliente.getText().length() >= 45) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaUbicacionKeyTyped

    private void areaLeyendaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_areaLeyendaKeyTyped
        char caracter = evt.getKeyChar();

        if (areaLeyenda.getText().length() >= 100) {
            evt.consume();
        }
    }//GEN-LAST:event_areaLeyendaKeyTyped

    private void botonPrecioExtraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPrecioExtraActionPerformed
        // TODO add your handling code here:
        new DatosExtra().setVisible(true);
    }//GEN-LAST:event_botonPrecioExtraActionPerformed

    public static void limpiarCotizacion() {
        labelObtenerNombreCliente.setText("");
        cajaAsunto.setText("");
        cajaUbicacion.setText("");
        cajaSubtotal.setText("");
        cajaTotal.setText("");
        cajaDescuento.setText("");
        cajaIVA.setText("");
        DefaultTableModel temp = (DefaultTableModel) tablaProductos.getModel();
        while (temp.getRowCount() > 0) {
            temp.removeRow(0);
        }
        botonPrecioExtra.setEnabled(false);
        botonPDF.setEnabled(false);
        TodoLonas.Principal.cardLayout.show(TodoLonas.Principal.panelContenedor, "ventas");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static java.awt.TextArea areaLeyenda;
    private javax.swing.JButton botonBuscarCliente;
    public static javax.swing.JButton botonNuevoCliente;
    public static javax.swing.JButton botonPDF;
    public static javax.swing.JButton botonPrecioExtra;
    public static javax.swing.JTextField cajaAsunto;
    public static javax.swing.JTextField cajaBuscarCliente;
    public static javax.swing.JTextField cajaDescuento;
    public static javax.swing.JTextField cajaIVA;
    public static javax.swing.JTextField cajaSubtotal;
    public static javax.swing.JTextField cajaTotal;
    public static javax.swing.JTextField cajaUbicacion;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JLabel labelATE;
    public static javax.swing.JLabel labelAnexo;
    public static javax.swing.JLabel labelAsunto;
    public static javax.swing.JLabel labelCelular;
    public static javax.swing.JLabel labelCiudad;
    public static javax.swing.JLabel labelCliente;
    public static javax.swing.JLabel labelCorreo;
    public static javax.swing.JLabel labelDescuento;
    public static javax.swing.JLabel labelDomicilio;
    public static javax.swing.JLabel labelFecha;
    public static javax.swing.JLabel labelIVA;
    private javax.swing.JLabel labelImagenCorreo;
    private javax.swing.JLabel labelImagenMapa;
    public static javax.swing.JLabel labelImagenTelefono;
    private javax.swing.JLabel labelLogo2;
    public static javax.swing.JLabel labelNombre;
    public static javax.swing.JLabel labelNota1;
    public static javax.swing.JLabel labelObtenerCelular;
    public static javax.swing.JLabel labelObtenerColonia;
    public static javax.swing.JLabel labelObtenerCorreo;
    public static javax.swing.JLabel labelObtenerDomicilio;
    public static javax.swing.JLabel labelObtenerFecha;
    public static javax.swing.JLabel labelObtenerNombreCliente;
    public static javax.swing.JLabel labelObtenerRFC;
    public static javax.swing.JLabel labelObtenerTelefono;
    public static javax.swing.JLabel labelRFC;
    public static javax.swing.JLabel labelSubTotal;
    public static javax.swing.JLabel labelTelefono;
    public static javax.swing.JLabel labelTotal;
    public static javax.swing.JLabel labelUbicacion;
    public static javax.swing.JList listaCliente;
    public static javax.swing.JTable tablaProductos;
    // End of variables declaration//GEN-END:variables
}
