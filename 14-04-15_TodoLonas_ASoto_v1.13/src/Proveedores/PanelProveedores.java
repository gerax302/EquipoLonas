package Proveedores;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import Validaciones.Correo;
import static Validaciones.Correo.verifica;

public class PanelProveedores extends javax.swing.JPanel {

    public String id;
    private Controlador cc;
    private Proveedores.Modelo cl;
    Correo correo = new Correo();
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    String varFechaReg = cal.get(cal.DATE) + "/" + (cal.get(cal.MONTH) + 1) + "/" + cal.get(cal.YEAR);
    String cadena = "";
    Boolean badera;

    public PanelProveedores() {
        initComponents();
        cc = new Controlador();
        tablaDatosProv.setModel(new TableModelProveedores(cc.getProv()));
        tablaDatosProv.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                
                if (tablaDatosProv.getSelectedRow() != -1) {
                    
                    int fila = tablaDatosProv.getSelectedRow();
                    
                    cl = ((TableModelProveedores) tablaDatosProv.getModel()).getFila(fila);
                    id = tablaDatosProv.getValueAt(fila, 0).toString();
                    cajaNombreProv.setText(cl.getNombre());
                    cajaDomicilio.setText(cl.getDomicilio());
                    cajaColonia.setText(cl.getColonia());
                    cajaCodigoPostal.setText(cl.getCodigoPostal());
                    cajaCiudad.setText(cl.getCiudad());
                    cajaTelFijo.setText(cl.getTelFijo());
                    cajaTelMovil.setText(cl.getTelMovil());
                    cajaCorreo.setText(cl.getCorreo());
                    cajaRazonSocial.setText(cl.getRazonSocial());
                    cajaRFC.setText(cl.getRFC());
                    comboBanco.setSelectedItem(cl.getBanco());
                    cajaNumeroCuenta.setText(cl.getNumeroCuenta());
                    comboTipoCuenta.setSelectedItem(cl.getTipoCuenta());
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGeneral = new javax.swing.JDesktopPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDatosProv = new javax.swing.JTable();
        panDatosProd = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cajaNombreProv = new javax.swing.JTextField();
        cajaTelFijo = new javax.swing.JTextField();
        cajaTelMovil = new javax.swing.JTextField();
        comboBanco = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        labelEst1 = new javax.swing.JLabel();
        labelEst2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        labelEst3 = new javax.swing.JLabel();
        labelEst4 = new javax.swing.JLabel();
        labelEst5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cajaDomicilio = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cajaCorreo = new javax.swing.JTextField();
        cajaCodigoPostal = new javax.swing.JTextField();
        cajaCiudad = new javax.swing.JTextField();
        cajaNumeroCuenta = new javax.swing.JTextField();
        cajaRazonSocial = new javax.swing.JTextField();
        cajaColonia = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        cajaRFC = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        labelEst6 = new javax.swing.JLabel();
        comboTipoCuenta = new javax.swing.JComboBox();
        panBotonesProducto = new javax.swing.JPanel();
        bntNuevo = new javax.swing.JButton();
        bntActualizar = new javax.swing.JButton();
        bntGrabar = new javax.swing.JButton();
        bntEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        panelGeneral.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(62, 64, 149));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(375, 200));

        tablaDatosProv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaDatosProv);

        panDatosProd.setBackground(new java.awt.Color(255, 255, 255));
        panDatosProd.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Razón Social:");
        panDatosProd.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, -1, -1));

        cajaNombreProv.setPreferredSize(new java.awt.Dimension(100, 20));
        cajaNombreProv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaNombreProvKeyTyped(evt);
            }
        });
        panDatosProd.add(cajaNombreProv, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 190, -1));

        cajaTelFijo.setPreferredSize(new java.awt.Dimension(200, 20));
        cajaTelFijo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaTelFijoKeyTyped(evt);
            }
        });
        panDatosProd.add(cajaTelFijo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 190, -1));

        cajaTelMovil.setPreferredSize(new java.awt.Dimension(200, 20));
        cajaTelMovil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaTelMovilKeyTyped(evt);
            }
        });
        panDatosProd.add(cajaTelMovil, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, 190, -1));

        comboBanco.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Banorte", "HSBC", "Bancomer", "Santander", "Scotiabanck", "IXE" }));
        comboBanco.setPreferredSize(new java.awt.Dimension(200, 20));
        panDatosProd.add(comboBanco, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 140, 190, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Teléfono Fijo:");
        panDatosProd.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        labelEst1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        labelEst1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/star.png"))); // NOI18N
        panDatosProd.add(labelEst1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        labelEst2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        labelEst2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/star.png"))); // NOI18N
        panDatosProd.add(labelEst2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Nombre del Proveedor:");
        panDatosProd.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        labelEst3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        labelEst3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/star.png"))); // NOI18N
        panDatosProd.add(labelEst3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        labelEst4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        labelEst4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/star.png"))); // NOI18N
        panDatosProd.add(labelEst4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, -1, -1));

        labelEst5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        labelEst5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/star.png"))); // NOI18N
        panDatosProd.add(labelEst5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Teléfono Móvil:");
        panDatosProd.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        cajaDomicilio.setPreferredSize(new java.awt.Dimension(200, 20));
        cajaDomicilio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaDomicilioKeyTyped(evt);
            }
        });
        panDatosProd.add(cajaDomicilio, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 190, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Correo:");
        panDatosProd.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Domicilio:");
        panDatosProd.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Código Postal:");
        panDatosProd.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Ciudad:");
        panDatosProd.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Tipo de Cuenta:");
        panDatosProd.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 230, -1, -1));

        cajaCorreo.setPreferredSize(new java.awt.Dimension(200, 20));
        cajaCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaCorreoKeyTyped(evt);
            }
        });
        panDatosProd.add(cajaCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, 190, -1));

        cajaCodigoPostal.setPreferredSize(new java.awt.Dimension(200, 20));
        cajaCodigoPostal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaCodigoPostalKeyTyped(evt);
            }
        });
        panDatosProd.add(cajaCodigoPostal, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 190, -1));

        cajaCiudad.setPreferredSize(new java.awt.Dimension(200, 20));
        cajaCiudad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaCiudadKeyTyped(evt);
            }
        });
        panDatosProd.add(cajaCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 190, -1));

        cajaNumeroCuenta.setPreferredSize(new java.awt.Dimension(200, 20));
        cajaNumeroCuenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaNumeroCuentaKeyTyped(evt);
            }
        });
        panDatosProd.add(cajaNumeroCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 180, 190, -1));

        cajaRazonSocial.setPreferredSize(new java.awt.Dimension(200, 20));
        cajaRazonSocial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaRazonSocialKeyTyped(evt);
            }
        });
        panDatosProd.add(cajaRazonSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 60, 190, -1));

        cajaColonia.setPreferredSize(new java.awt.Dimension(200, 20));
        cajaColonia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaColoniaKeyTyped(evt);
            }
        });
        panDatosProd.add(cajaColonia, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 190, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Colonia:");
        panDatosProd.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("RFC:");
        panDatosProd.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, -1, -1));

        cajaRFC.setPreferredSize(new java.awt.Dimension(200, 20));
        cajaRFC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaRFCKeyTyped(evt);
            }
        });
        panDatosProd.add(cajaRFC, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 100, 190, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Banco: ");
        panDatosProd.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 150, -1, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Número de Cuenta:");
        panDatosProd.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 190, -1, -1));

        labelEst6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        labelEst6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/star.png"))); // NOI18N
        panDatosProd.add(labelEst6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, -1, -1));

        comboTipoCuenta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Crédito", "Débito" }));
        comboTipoCuenta.setPreferredSize(new java.awt.Dimension(200, 20));
        panDatosProd.add(comboTipoCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 220, 190, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panDatosProd, javax.swing.GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panDatosProd, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panBotonesProducto.setBackground(new java.awt.Color(62, 64, 149));

        bntNuevo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bntNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add.png"))); // NOI18N
        bntNuevo.setText("Nuevo");
        bntNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntNuevoActionPerformed(evt);
            }
        });

        bntActualizar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bntActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/upd.png"))); // NOI18N
        bntActualizar.setText("Actualizar");
        bntActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntActualizarActionPerformed(evt);
            }
        });

        bntGrabar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bntGrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ok.png"))); // NOI18N
        bntGrabar.setText("Guardar");
        bntGrabar.setEnabled(false);
        bntGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntGrabarActionPerformed(evt);
            }
        });

        bntEliminar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bntEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/delete.png"))); // NOI18N
        bntEliminar.setText("Eliminar");
        bntEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntEliminarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancel.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panBotonesProductoLayout = new javax.swing.GroupLayout(panBotonesProducto);
        panBotonesProducto.setLayout(panBotonesProductoLayout);
        panBotonesProductoLayout.setHorizontalGroup(
            panBotonesProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panBotonesProductoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panBotonesProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bntActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panBotonesProductoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bntGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panBotonesProductoLayout.createSequentialGroup()
                        .addComponent(bntNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(bntEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panBotonesProductoLayout.setVerticalGroup(
            panBotonesProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panBotonesProductoLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(bntNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bntGrabar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bntActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bntEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelGeneralLayout = new javax.swing.GroupLayout(panelGeneral);
        panelGeneral.setLayout(panelGeneralLayout);
        panelGeneralLayout.setHorizontalGroup(
            panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panBotonesProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelGeneralLayout.setVerticalGroup(
            panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panBotonesProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelGeneral.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelGeneral.setLayer(panBotonesProducto, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGeneral, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGeneral)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bntNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntNuevoActionPerformed
        this.cajaNombreProv.setText("");
        this.cajaDomicilio.setText("");
        this.cajaColonia.setText("");
        this.cajaCodigoPostal.setText("");
        this.cajaCiudad.setText("");
        this.cajaTelFijo.setText("");
        this.cajaTelMovil.setText("");
        this.cajaCorreo.setText("");
        this.cajaRazonSocial.setText("");
        this.cajaRFC.setText("");
        this.comboBanco.setSelectedIndex(0);
        this.cajaNumeroCuenta.setText("");
        this.comboTipoCuenta.setSelectedIndex(0);

        this.tablaDatosProv.setEnabled(false);
        this.bntGrabar.setEnabled(true);
        bntNuevo.setEnabled(false);
        this.bntActualizar.setEnabled(false);
        this.bntEliminar.setEnabled(false);
        cl = null;
        this.tablaDatosProv.clearSelection();
    }//GEN-LAST:event_bntNuevoActionPerformed

    private void bntActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntActualizarActionPerformed
        int opcion;
        
        if (!cajaNombreProv.getText().isEmpty() && !cajaDomicilio.getText().isEmpty() && !cajaCiudad.getText().isEmpty() 
                && !cajaTelMovil.getText().isEmpty() && !cajaRazonSocial.getText().isEmpty() && !cajaRFC.getText().isEmpty())
        {
            if (cl != null) {
                
                cl.setNombre(cajaNombreProv.getText());
                cl.setDomicilio(cajaDomicilio.getText());
                cl.setColonia(cajaColonia.getText());
                cl.setCodigoPostal(cajaCodigoPostal.getText());
                cl.setCiudad(cajaCiudad.getText());
                cl.setTelFijo(cajaTelFijo.getText());
                cl.setTelMovil(cajaTelMovil.getText());
                
                if (!cajaCorreo.getText().isEmpty()) {
                    cadena = cajaCorreo.getText();
                    badera = verifica(cadena);

                    if (badera == true) {
                        
                        cl.setCorreo(cajaCorreo.getText());
                        cl.setRazonSocial(cajaRazonSocial.getText());
                        cl.setRFC(cajaRFC.getText());
                        cl.setBanco(comboBanco.getSelectedItem().toString());
                        cl.setNumeroCuenta(cajaNumeroCuenta.getText());
                        cl.setTipoCuenta(comboTipoCuenta.getSelectedItem().toString());

                        opcion = cc.actualizar(cl);
                        if (opcion != 0) {
                            
                            try {
                                
                                JOptionPane.showMessageDialog(this, "Operación Exitosa", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                                tablaDatosProv.setModel(new TableModelProveedores(cc.getProv()));
                                this.bntGrabar.setEnabled(false);
                                bntNuevo.setEnabled(true);
                                this.bntActualizar.setEnabled(true);
                                this.bntEliminar.setEnabled(true);
                                
                            } catch (Exception ex) {
                                
                                System.out.println("Error al registrar el Proveedor");
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Revise el campo coreo", "Atención:", JOptionPane.WARNING_MESSAGE);
                    }//termian 
                } else {
                    
                    cl.setCorreo(cajaCorreo.getText());
                    cl.setRazonSocial(cajaRazonSocial.getText());
                    cl.setRFC(cajaRFC.getText());
                    cl.setBanco(comboBanco.getSelectedItem().toString());
                    cl.setNumeroCuenta(cajaNumeroCuenta.getText());
                    cl.setTipoCuenta(comboTipoCuenta.getSelectedItem().toString());
                   
                    opcion = cc.actualizar(cl);
                    
                    if (opcion != 0) {
                        
                        try {
                            
                            JOptionPane.showMessageDialog(this, "Operación Exitosa", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                            tablaDatosProv.setModel(new TableModelProveedores(cc.getProv()));
                            this.bntGrabar.setEnabled(false);
                            bntNuevo.setEnabled(true);
                            this.tablaDatosProv.setEnabled(true);
                            this.bntActualizar.setEnabled(true);
                            this.bntEliminar.setEnabled(true);
                            
                        } catch (Exception ex) {
                            
                            System.out.println("Error al registrar el proveedor");
                        }
                    }
                }
            }
        } else {
            
            JOptionPane.showMessageDialog(null, "Debe proporcionar los datos obligatorios", "Atención:", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_bntActualizarActionPerformed

    private void bntGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntGrabarActionPerformed
        Proveedores.Modelo cl = new Proveedores.Modelo();
        int opcion;

        if (!cajaNombreProv.getText().isEmpty() && !cajaDomicilio.getText().isEmpty() && !cajaCiudad.getText().isEmpty()
            && !cajaTelMovil.getText().isEmpty() && !cajaRazonSocial.getText().isEmpty() && !cajaRFC.getText().isEmpty())
        {
            cl.setNombre(cajaNombreProv.getText());
            cl.setDomicilio(cajaDomicilio.getText());
            cl.setColonia(cajaColonia.getText());
            cl.setCodigoPostal(cajaCodigoPostal.getText());
            cl.setCiudad(cajaCiudad.getText());
            cl.setTelFijo(cajaTelFijo.getText());
            cl.setTelMovil(cajaTelMovil.getText());

            if (!cajaCorreo.getText().isEmpty()) {
                
                cadena = cajaCorreo.getText();
                badera = verifica(cadena);

                if (badera == true) {
                    
                    cl.setCorreo(cajaCorreo.getText());
                    cl.setRazonSocial(cajaRazonSocial.getText());
                    cl.setRFC(cajaRFC.getText());
                    cl.setBanco(comboBanco.getSelectedItem().toString());
                    cl.setNumeroCuenta(cajaNumeroCuenta.getText());            
                    cl.setTipoCuenta(comboTipoCuenta.getSelectedItem().toString());

                    opcion = cc.insertarProv(cl);
                    
                    if (opcion != 0) {
                        
                        try {
                            
                            JOptionPane.showMessageDialog(this, "Operación Exitosa", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                            tablaDatosProv.setModel(new TableModelProveedores(cc.getProv()));
                            this.bntGrabar.setEnabled(false);
                            bntNuevo.setEnabled(true);
                            this.tablaDatosProv.setEnabled(true);
                            this.bntActualizar.setEnabled(true);
                            this.bntEliminar.setEnabled(true);
                        } catch (Exception ex) {
                            
                            System.out.println("Error al registrar el proveedor");
                        }
                    }
                } else {
                    
                    JOptionPane.showMessageDialog(null, "Revise el campo coreo", "Atención:", JOptionPane.WARNING_MESSAGE);
                }//termian 
            } else {
                
                cl.setCorreo(cajaCorreo.getText());
                cl.setRazonSocial(cajaRazonSocial.getText());
                cl.setRFC(cajaRFC.getText());
                cl.setBanco(comboBanco.getSelectedItem().toString());
                cl.setNumeroCuenta(cajaNumeroCuenta.getText());            
                cl.setTipoCuenta(comboTipoCuenta.getSelectedItem().toString());

                opcion = cc.insertarProv(cl);
                
                if (opcion != 0) {
                    
                    try {
                        
                        JOptionPane.showMessageDialog(this, "Operación Exitosa", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        tablaDatosProv.setModel(new TableModelProveedores(cc.getProv()));
                        this.bntGrabar.setEnabled(false);
                        bntNuevo.setEnabled(true);
                        this.tablaDatosProv.setEnabled(false);
                        this.bntActualizar.setEnabled(true);
                        this.bntEliminar.setEnabled(true);
                        
                    } catch (Exception ex) {
                        
                        System.out.println("Error al registrar el proveedor");
                    }
                }
            }
        } else {
            
            JOptionPane.showMessageDialog(null, "Debe proporcionar los datos obligatorios", "Atención:", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_bntGrabarActionPerformed

    private void bntEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntEliminarActionPerformed
        int op = JOptionPane.showConfirmDialog(null, "¿Realmente desea eliminar el proveedor?", "Advertencia", JOptionPane.YES_NO_OPTION);
        
        if (op == JOptionPane.NO_OPTION) {
        }
        if (op == JOptionPane.YES_OPTION) {
            
            if (cl != null) {
                
                int eliminarProveedor = cc.eliminarProv(cl.getPrimaryKey());
                
                if (eliminarProveedor != 0) {
                    
                    JOptionPane.showMessageDialog(this, "Operación Exitosa", "Mensaje: ", JOptionPane.INFORMATION_MESSAGE);
                    tablaDatosProv.setModel(new TableModelProveedores(cc.getProv()));
                }
            } else {
                
                JOptionPane.showMessageDialog(this, "Primero debe seleccionar un proveedor", "Mensaje: ", JOptionPane.WARNING_MESSAGE);
            }
        }
        this.tablaDatosProv.setEnabled(true);
    }//GEN-LAST:event_bntEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.cajaNombreProv.setText("");
        this.cajaDomicilio.setText("");
        this.cajaColonia.setText("");
        this.cajaCodigoPostal.setText("");
        this.cajaCiudad.setText("");
        this.cajaTelFijo.setText("");
        this.cajaTelMovil.setText("");
        this.cajaCorreo.setText("");
        this.cajaRazonSocial.setText("");        
        this.cajaRFC.setText("");
        this.comboBanco.setSelectedIndex(0);
        this.cajaNumeroCuenta.setText("");
        this.comboTipoCuenta.setSelectedIndex(0);

        cl = null;
        
        this.bntGrabar.setEnabled(false);
        bntNuevo.setEnabled(true);
        this.tablaDatosProv.setEnabled(true);
        this.tablaDatosProv.clearSelection();
        this.bntActualizar.setEnabled(true);
        this.bntEliminar.setEnabled(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cajaTelFijoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaTelFijoKeyTyped
        char caracter = evt.getKeyChar();
        if (((caracter < '0') || (caracter > '9')) && (caracter != evt.VK_BACK_SPACE)) {
            evt.consume();
        }
        if (cajaTelFijo.getText().length() >= 10) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaTelFijoKeyTyped

    private void cajaTelMovilKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaTelMovilKeyTyped
        char caracter = evt.getKeyChar();
        if (((caracter < '0') || (caracter > '9')) && (caracter != evt.VK_BACK_SPACE)) {
            evt.consume();
        }
        if (cajaTelMovil.getText().length() >= 13) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaTelMovilKeyTyped

    private void cajaDomicilioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaDomicilioKeyTyped
        char caracter = evt.getKeyChar();
        if (cajaDomicilio.getText().length() >= 45) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaDomicilioKeyTyped

    private void cajaNombreProvKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaNombreProvKeyTyped
        char caracter = evt.getKeyChar();
        if (cajaNombreProv.getText().length() >= 45) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaNombreProvKeyTyped

    private void cajaCorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaCorreoKeyTyped
        char caracter = evt.getKeyChar();
        if (cajaCorreo.getText().length() >= 45) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaCorreoKeyTyped

    private void cajaCodigoPostalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaCodigoPostalKeyTyped
        char caracter = evt.getKeyChar();
        if (((caracter < '0') || (caracter > '9')) && (caracter != evt.VK_BACK_SPACE)) {
            evt.consume();
        }
        if (cajaCodigoPostal.getText().length() >= 5) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaCodigoPostalKeyTyped

    private void cajaCiudadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaCiudadKeyTyped
        char caracter = evt.getKeyChar();
        if (cajaCiudad.getText().length() >= 45) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaCiudadKeyTyped

    private void cajaNumeroCuentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaNumeroCuentaKeyTyped
        char caracter = evt.getKeyChar();
        if (((caracter < '0') || (caracter > '9')) && (caracter != evt.VK_BACK_SPACE)) {
            evt.consume();
        }
        if (cajaNumeroCuenta.getText().length() >= 20) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaNumeroCuentaKeyTyped

    private void cajaRazonSocialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaRazonSocialKeyTyped
        char caracter = evt.getKeyChar();
        if (cajaRazonSocial.getText().length() >= 45) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaRazonSocialKeyTyped

    private void cajaColoniaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaColoniaKeyTyped
        char caracter = evt.getKeyChar();
        if (cajaColonia.getText().length() >= 45) {
            evt.consume();
        } 
    }//GEN-LAST:event_cajaColoniaKeyTyped

    private void cajaRFCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaRFCKeyTyped
        char caracter = evt.getKeyChar();
        if (cajaRFC.getText().length() >= 20 ) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaRFCKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntActualizar;
    private javax.swing.JButton bntEliminar;
    private javax.swing.JButton bntGrabar;
    private javax.swing.JButton bntNuevo;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JTextField cajaCiudad;
    private javax.swing.JTextField cajaCodigoPostal;
    private javax.swing.JTextField cajaColonia;
    private javax.swing.JTextField cajaCorreo;
    private javax.swing.JTextField cajaDomicilio;
    private javax.swing.JTextField cajaNombreProv;
    private javax.swing.JTextField cajaNumeroCuenta;
    private javax.swing.JTextField cajaRFC;
    private javax.swing.JTextField cajaRazonSocial;
    private javax.swing.JTextField cajaTelFijo;
    private javax.swing.JTextField cajaTelMovil;
    private javax.swing.JComboBox comboBanco;
    private javax.swing.JComboBox comboTipoCuenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelEst1;
    private javax.swing.JLabel labelEst2;
    private javax.swing.JLabel labelEst3;
    private javax.swing.JLabel labelEst4;
    private javax.swing.JLabel labelEst5;
    private javax.swing.JLabel labelEst6;
    private javax.swing.JPanel panBotonesProducto;
    private javax.swing.JPanel panDatosProd;
    private javax.swing.JDesktopPane panelGeneral;
    private javax.swing.JTable tablaDatosProv;
    // End of variables declaration//GEN-END:variables
}
