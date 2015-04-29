package Usuarios;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import Validaciones.Correo;
import static Validaciones.Correo.verifica;

public class PanelUsuarios extends javax.swing.JPanel {

    public String id;
    private final Controlador cc;
    private Modelo cl;
    Correo correo = new Correo();
    String cadena = "";
    Boolean badera;

    public PanelUsuarios() {
        cc = new Controlador();
        initComponents();
        tablaUsuarios.setModel(new TableModelUsuarios(cc.getAll()));
        tablaUsuarios.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (tablaUsuarios.getSelectedRow() != -1) {
                    int fila = tablaUsuarios.getSelectedRow();
                    cl = ((TableModelUsuarios) tablaUsuarios.getModel()).getFila(fila);
                    id = tablaUsuarios.getValueAt(fila, 0).toString();
                    comboTipo.setSelectedItem(cl.getTipoUsuario());
                    cajaNombre.setText(cl.getNombreUsuario());
                    cajaContra.setText(cl.getPasswordUsuario());
                    cajaCorreo.setText(cl.getCorreo());
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
        tablaUsuarios = new javax.swing.JTable();
        panDatosProd = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cajaNombre = new javax.swing.JTextField();
        comboTipo = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        labelEst2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        labelEst3 = new javax.swing.JLabel();
        labelEst4 = new javax.swing.JLabel();
        labelEst5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cajaCorreo = new javax.swing.JTextField();
        cajaContra = new javax.swing.JTextField();
        panBotonesProducto = new javax.swing.JPanel();
        bntNuevo = new javax.swing.JButton();
        bntActualizar = new javax.swing.JButton();
        bntGrabar = new javax.swing.JButton();
        bntEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        panelGeneral.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(62, 64, 149));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(375, 200));

        tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaUsuarios);

        panDatosProd.setBackground(new java.awt.Color(255, 255, 255));
        panDatosProd.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Usuarios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        panDatosProd.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Contraseña:");
        panDatosProd.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        cajaNombre.setPreferredSize(new java.awt.Dimension(100, 20));
        cajaNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaNombreKeyTyped(evt);
            }
        });
        panDatosProd.add(cajaNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 190, -1));

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrador", "Empleado" }));
        comboTipo.setPreferredSize(new java.awt.Dimension(200, 20));
        panDatosProd.add(comboTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 190, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Tipo:");
        panDatosProd.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 60, -1));

        labelEst2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        labelEst2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/star.png"))); // NOI18N
        panDatosProd.add(labelEst2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Nombre del Usuario:");
        panDatosProd.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        labelEst3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        labelEst3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/star.png"))); // NOI18N
        panDatosProd.add(labelEst3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        labelEst4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        labelEst4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/star.png"))); // NOI18N
        panDatosProd.add(labelEst4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        labelEst5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        labelEst5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/star.png"))); // NOI18N
        panDatosProd.add(labelEst5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Correo:");
        panDatosProd.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        cajaCorreo.setPreferredSize(new java.awt.Dimension(200, 20));
        cajaCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaCorreoKeyTyped(evt);
            }
        });
        panDatosProd.add(cajaCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 190, -1));

        cajaContra.setPreferredSize(new java.awt.Dimension(200, 20));
        cajaContra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaContraKeyTyped(evt);
            }
        });
        panDatosProd.add(cajaContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 190, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE)
                    .addComponent(panDatosProd, javax.swing.GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(panDatosProd, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                .addContainerGap())
        );

        panBotonesProducto.setBackground(new java.awt.Color(62, 64, 149));

        bntNuevo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bntNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imgAgregar.png"))); // NOI18N
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
            .addComponent(panelGeneral)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGeneral)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bntNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntNuevoActionPerformed
        this.comboTipo.setSelectedIndex(0);
        this.cajaNombre.setText("");
        this.cajaContra.setText("");
        this.cajaCorreo.setText("");
        this.tablaUsuarios.setEnabled(false);
        this.bntGrabar.setEnabled(true);
        bntNuevo.setEnabled(false);
        this.bntActualizar.setEnabled(false);
        this.bntEliminar.setEnabled(false);
        cl = null;
        this.tablaUsuarios.clearSelection();
    }//GEN-LAST:event_bntNuevoActionPerformed

    private void bntActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntActualizarActionPerformed
        int opcion;
        if (!cajaNombre.getText().isEmpty()  && !cajaContra.getText().isEmpty()) {
            if (cl != null) {
                cl.setTipoUsuario(comboTipo.getSelectedItem().toString());
                cl.setNombreUsuario(cajaNombre.getText());
                cl.setPasswordUsuario(cajaContra.getText());

                if (!cajaCorreo.getText().isEmpty()) {
                    cadena = cajaCorreo.getText();
                    badera = verifica(cadena);

                    if (badera == true) {
                        cl.setCorreo(cajaCorreo.getText());

                        opcion = cc.actualizar(cl);
                        if (opcion != 0) {
                            try {
                                JOptionPane.showMessageDialog(this, "Operación Exitosa", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                                tablaUsuarios.setModel(new TableModelUsuarios(cc.getAll()));
                                this.bntGrabar.setEnabled(false);
                                bntNuevo.setEnabled(true);
                                this.bntActualizar.setEnabled(true);
                                this.bntEliminar.setEnabled(true);
                            } catch (Exception ex) {
                                System.out.println("Error al registrar el usuario");
                            }
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Revise el campo correo", "Atención:", JOptionPane.WARNING_MESSAGE);
                    }//termian 
                } else {
                    cl.setCorreo(cajaCorreo.getText());

                    opcion = cc.actualizar(cl);
                    if (opcion != 0) {
                        try {
                            JOptionPane.showMessageDialog(this, "Operación Exitosa", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                            tablaUsuarios.setModel(new TableModelUsuarios(cc.getAll()));
                            this.bntGrabar.setEnabled(false);
                            bntNuevo.setEnabled(true);
                            this.tablaUsuarios.setEnabled(true);
                            this.bntActualizar.setEnabled(true);
                            this.bntEliminar.setEnabled(true);
                        } catch (Exception ex) {
                            System.out.println("Error al registrar el usuario");
                        }
                    }

                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe proporcionar los datos obligatorios", "Atención:", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_bntActualizarActionPerformed

    private void bntGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntGrabarActionPerformed
        Usuarios.Modelo cl = new Usuarios.Modelo();
        int opcion;

        if (!cajaNombre.getText().isEmpty()  && !cajaContra.getText().isEmpty()) {
            cl.setTipoUsuario(comboTipo.getSelectedItem().toString());
            
            System.out.println("hh "+comboTipo.getSelectedItem().toString());
            String cate=comboTipo.getSelectedItem().toString();
            System.out.println("cate "+ cate);
            cl.setNombreUsuario(cajaNombre.getText());
            cl.setPasswordUsuario(cajaContra.getText());

            if (!cajaCorreo.getText().isEmpty()) {
                cadena = cajaCorreo.getText();
                badera = verifica(cadena);

                if (badera == true) {
                    cl.setCorreo(cajaCorreo.getText());
                    opcion = cc.insertar(cl);
                    if (opcion != 0) {
                        try {
                            JOptionPane.showMessageDialog(this, "Operación Exitosa", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                            tablaUsuarios.setModel(new TableModelUsuarios(cc.getAll()));
                            this.bntGrabar.setEnabled(false);
                            bntNuevo.setEnabled(true);
                            this.tablaUsuarios.setEnabled(true);
                            this.bntActualizar.setEnabled(true);
                            this.bntEliminar.setEnabled(true);
                        } catch (Exception ex) {
                            System.out.println("Error al registrar el usuario");
                        }
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Revise el campo coreo", "Atención:", JOptionPane.WARNING_MESSAGE);
                }//termian 
            } else {
                cl.setCorreo(cajaCorreo.getText());
                opcion = cc.insertar(cl);
                if (opcion != 0) {
                    try {
                        JOptionPane.showMessageDialog(this, "Operación Exitosa", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        tablaUsuarios.setModel(new TableModelUsuarios(cc.getAll()));
                        this.bntGrabar.setEnabled(false);
                        bntNuevo.setEnabled(true);
                        this.tablaUsuarios.setEnabled(false);
                        this.bntActualizar.setEnabled(true);
                        this.bntEliminar.setEnabled(true);
                    } catch (Exception ex) {
                        System.out.println("Error al registrar el usuario");
                    }
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "Debe proporcionar los datos obligatorios", "Atención:", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_bntGrabarActionPerformed

    private void bntEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntEliminarActionPerformed
        int op = JOptionPane.showConfirmDialog(null, "¿Realmente desea eliminar el usuario?", "Advertencia", JOptionPane.YES_NO_OPTION);
        if (op == JOptionPane.NO_OPTION) {
        }
        if (op == JOptionPane.YES_OPTION) {
            if (cl != null) {
                int eliminarCliente = cc.eliminar(cl.getPrimaryKey());
                if (eliminarCliente != 0) {
                    JOptionPane.showMessageDialog(this, "Operación Exitosa", "Mensaje: ", JOptionPane.INFORMATION_MESSAGE);
                    tablaUsuarios.setModel(new TableModelUsuarios(cc.getAll()));
                }
            } else {
                JOptionPane.showMessageDialog(this, "Primero debe seleccionar un usuario", "Mensaje: ", JOptionPane.WARNING_MESSAGE);
            }
        }
        this.tablaUsuarios.setEnabled(true);
    }//GEN-LAST:event_bntEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.comboTipo.setSelectedIndex(0);
        this.cajaNombre.setText("");
        this.cajaContra.setText("");
        this.cajaCorreo.setText("");
        cl = null;
        this.bntGrabar.setEnabled(false);
        bntNuevo.setEnabled(true);
        this.tablaUsuarios.setEnabled(true);
        this.tablaUsuarios.clearSelection();
        this.bntActualizar.setEnabled(true);
        this.bntEliminar.setEnabled(true);
    }//GEN-LAST:event_btnCancelarActionPerformed


    private void cajaNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaNombreKeyTyped
         char caracter = evt.getKeyChar();
        if ((caracter < 'a' || caracter > 'z') && (caracter < 'A' || caracter > 'Z')
          && (caracter < 'ñ') && (caracter != (char) KeyEvent.VK_SPACE) ) {
            evt.consume();
        }
        if (cajaNombre.getText().length() >= 45) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaNombreKeyTyped

    private void cajaCorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaCorreoKeyTyped
        char caracter = evt.getKeyChar();
        if (cajaCorreo.getText().length() >= 45) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaCorreoKeyTyped

    private void cajaContraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaContraKeyTyped
        char caracter = evt.getKeyChar();
        if (cajaContra.getText().length() >= 45) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaContraKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntActualizar;
    private javax.swing.JButton bntEliminar;
    private javax.swing.JButton bntGrabar;
    private javax.swing.JButton bntNuevo;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JTextField cajaContra;
    private javax.swing.JTextField cajaCorreo;
    private javax.swing.JTextField cajaNombre;
    private javax.swing.JComboBox comboTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelEst2;
    private javax.swing.JLabel labelEst3;
    private javax.swing.JLabel labelEst4;
    private javax.swing.JLabel labelEst5;
    private javax.swing.JPanel panBotonesProducto;
    private javax.swing.JPanel panDatosProd;
    private javax.swing.JDesktopPane panelGeneral;
    private javax.swing.JTable tablaUsuarios;
    // End of variables declaration//GEN-END:variables
}
