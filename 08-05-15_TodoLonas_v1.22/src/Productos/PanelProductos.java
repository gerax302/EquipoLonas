package Productos;

import Productos.CustomImageIcon;
import Productos.TableModelProducto;
import Productos.ConexionProducto;
import Productos.Controlador;
import java.awt.Image;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class PanelProductos extends javax.swing.JPanel {

    public String id;
    private FileInputStream fis;
    private int longitudBytes;
    private Controlador cc;
    private Productos.Modelo cl;
    private String rutaImagenPorDefault = "/Imagenes/noDisponible.gif";

    public void updateDatos()
    {
        ConexionProducto.conectar();
        cc = new Controlador();
        tablaDatosProducto.setModel(new TableModelProducto(cc.getProductos()));
    }
    
    public PanelProductos() {
        initComponents();
        //labelRegresarProductos.setVisible(false);
        cc = new Controlador();
        tablaDatosProducto.setModel(new TableModelProducto(cc.getProductos()));
        tablaDatosProducto.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (tablaDatosProducto.getSelectedRow() != -1) {
                    int fila = tablaDatosProducto.getSelectedRow();
                    cl = ((TableModelProducto) tablaDatosProducto.getModel()).getFila(fila);
                    id = tablaDatosProducto.getValueAt(fila, 0).toString();
                    comboCategoriaPro.setSelectedItem(cl.getCategoriaProducto());
                    cajaNombrePro.setText(cl.getNombreProducto());
                    cajaCantProd.setText(cl.getCantidad());
                    comboUnidadProd.setSelectedItem(cl.getUnidad());
                    cajaPrecUnit.setText(cl.getPrecioUnitario());
                    cajaStockMinProd.setText(cl.getStockMinimo() + "");
                    cajaDescripcion.setText(cl.getDescripcion());
                    CustomImageIcon foto = ConexionProducto.getFoto(Integer.parseInt(id));
                    if (foto != null) {
                        labelFotoProd.setIcon(foto);
                    } else {
                        labelFotoProd.setIcon(new CustomImageIcon(getClass().getResource(rutaImagenPorDefault)));
                    }
                    labelFotoProd.updateUI();
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
        tablaDatosProducto = new javax.swing.JTable();
        panDatosProd = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cajaNombrePro = new javax.swing.JTextField();
        cajaCantProd = new javax.swing.JTextField();
        cajaPrecUnit = new javax.swing.JTextField();
        comboCategoriaPro = new javax.swing.JComboBox();
        comboUnidadProd = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        labelFotoProd = new javax.swing.JLabel();
        labelEst1 = new javax.swing.JLabel();
        labelEst2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        labelEst3 = new javax.swing.JLabel();
        labelEst4 = new javax.swing.JLabel();
        labelEst5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cajaStockMinProd = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        cajaDescripcion = new javax.swing.JTextArea();
        labelRegresarProductos = new javax.swing.JLabel();
        panBotonesProducto = new javax.swing.JPanel();
        bntNuevo = new javax.swing.JButton();
        bntActualizar = new javax.swing.JButton();
        bntGrabar = new javax.swing.JButton();
        bntEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        panelGeneral.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(62, 64, 149));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(375, 200));

        tablaDatosProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaDatosProducto);

        panDatosProd.setBackground(new java.awt.Color(255, 255, 255));
        panDatosProd.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Cantidad:");
        panDatosProd.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        cajaNombrePro.setPreferredSize(new java.awt.Dimension(100, 20));
        cajaNombrePro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaNombreProKeyTyped(evt);
            }
        });
        panDatosProd.add(cajaNombrePro, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 190, -1));

        cajaCantProd.setPreferredSize(new java.awt.Dimension(200, 20));
        cajaCantProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaCantProdKeyTyped(evt);
            }
        });
        panDatosProd.add(cajaCantProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 190, -1));

        cajaPrecUnit.setPreferredSize(new java.awt.Dimension(200, 20));
        cajaPrecUnit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaPrecUnitKeyTyped(evt);
            }
        });
        panDatosProd.add(cajaPrecUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 190, -1));

        comboCategoriaPro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Gran Formato", "Vinil ", "Alta Resolución", "Offset", "Impresión Digital", "Rígidos", "Rotulación", "Papelería", "Estructuras", "Lonas", "Anuncios", "Diseño Gráfico", "Toldos", "Artículos Promocionales", "Otros" }));
        comboCategoriaPro.setPreferredSize(new java.awt.Dimension(200, 20));
        panDatosProd.add(comboCategoriaPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 190, -1));

        comboUnidadProd.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mt2", "Mt Lineal", "Milla", "Piezas" }));
        comboUnidadProd.setPreferredSize(new java.awt.Dimension(200, 20));
        panDatosProd.add(comboUnidadProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 190, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Unidad");
        panDatosProd.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Categoría:");
        panDatosProd.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 60, -1));

        labelFotoProd.setBackground(new java.awt.Color(0, 0, 0));
        labelFotoProd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelFotoProd.setIcon(new CustomImageIcon(getClass().getResource("/Imagenes/defaultlarge.gif")));
        labelFotoProd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        labelFotoProd.setDoubleBuffered(true);
        labelFotoProd.setPreferredSize(new java.awt.Dimension(100, 80));
        labelFotoProd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelFotoProdMouseClicked(evt);
            }
        });
        panDatosProd.add(labelFotoProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, 190, 170));

        labelEst1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        labelEst1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/star.png"))); // NOI18N
        panDatosProd.add(labelEst1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        labelEst2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        labelEst2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/star.png"))); // NOI18N
        panDatosProd.add(labelEst2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Nombre del Producto:");
        panDatosProd.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        labelEst3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        labelEst3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/star.png"))); // NOI18N
        panDatosProd.add(labelEst3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        labelEst4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        labelEst4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/star.png"))); // NOI18N
        panDatosProd.add(labelEst4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        labelEst5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        labelEst5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/star.png"))); // NOI18N
        panDatosProd.add(labelEst5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Precio Unitario:");
        panDatosProd.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Descripción:");
        panDatosProd.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        cajaStockMinProd.setPreferredSize(new java.awt.Dimension(200, 20));
        cajaStockMinProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaStockMinProdKeyTyped(evt);
            }
        });
        panDatosProd.add(cajaStockMinProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 190, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Stock Mínimo:");
        panDatosProd.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        cajaDescripcion.setColumns(20);
        cajaDescripcion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cajaDescripcion.setLineWrap(true);
        cajaDescripcion.setRows(5);
        cajaDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaDescripcionKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(cajaDescripcion);

        panDatosProd.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 190, -1));

        labelRegresarProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/regresar.png"))); // NOI18N
        labelRegresarProductos.setText("Regresar");
        labelRegresarProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelRegresarProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelRegresarProductosMouseClicked(evt);
            }
        });
        panDatosProd.add(labelRegresarProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 240, -1, 55));

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
                .addComponent(panDatosProd, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        bntActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/upd.png"))); // NOI18N
        bntActualizar.setText("Actualizar");
        bntActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntActualizarActionPerformed(evt);
            }
        });

        bntGrabar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bntGrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ok.png"))); // NOI18N
        bntGrabar.setText("Guardar");
        bntGrabar.setEnabled(false);
        bntGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntGrabarActionPerformed(evt);
            }
        });

        bntEliminar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bntEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/delete.png"))); // NOI18N
        bntEliminar.setText("Eliminar");
        bntEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntEliminarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancel.png"))); // NOI18N
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panBotonesProductoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panBotonesProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bntActualizar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panBotonesProductoLayout.createSequentialGroup()
                        .addComponent(bntNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(bntEliminar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panBotonesProductoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bntGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

    private void labelFotoProdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelFotoProdMouseClicked
        JFileChooser se = new JFileChooser();
        se.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = se.showOpenDialog(null);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                fis = new FileInputStream(se.getSelectedFile());
                this.longitudBytes = (int) se.getSelectedFile().length();

                Image icono = ImageIO.read(se.getSelectedFile()).getScaledInstance(labelFotoProd.getWidth(), labelFotoProd.getHeight(), Image.SCALE_DEFAULT);
                labelFotoProd.setIcon(new ImageIcon(icono));
                labelFotoProd.updateUI();
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_labelFotoProdMouseClicked

    private void cajaDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaDescripcionKeyTyped
        if (cajaDescripcion.getText().length() >= 100) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaDescripcionKeyTyped

    private void bntNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntNuevoActionPerformed
        this.comboCategoriaPro.setSelectedIndex(0);
        this.cajaNombrePro.setText("");
        this.cajaCantProd.setText("");
        this.comboUnidadProd.setSelectedIndex(0);
        this.cajaPrecUnit.setText("");
        this.cajaStockMinProd.setText("");
        this.cajaDescripcion.setText("");
        labelFotoProd.setIcon(new CustomImageIcon(getClass().getResource(rutaImagenPorDefault)));
        this.fis = null;
        this.longitudBytes = 0;
        this.bntGrabar.setEnabled(true);
        this.tablaDatosProducto.setEnabled(false);
        bntNuevo.setEnabled(false);
        this.bntActualizar.setEnabled(false);
        this.bntEliminar.setEnabled(false);
        cl = null;
        this.tablaDatosProducto.clearSelection();
    }//GEN-LAST:event_bntNuevoActionPerformed

    private void bntActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntActualizarActionPerformed
        if (cl != null) {
            cl.setCategoriaProducto(comboCategoriaPro.getSelectedItem().toString());
            cl.setNombreProducto(cajaNombrePro.getText());
            cl.setCantidad(cajaCantProd.getText());
            cl.setUnidad(comboUnidadProd.getSelectedItem().toString());
            cl.setPrecioUnitario(cajaPrecUnit.getText());
            cl.setStockMinimo(cajaStockMinProd.getText());
            cl.setDescripcion(cajaDescripcion.getText());
            cl.setFoto(fis);
            int opcion = cc.actualizar(cl);
            if (opcion != 0) {
                JOptionPane.showMessageDialog(this, "Operación Exitosa", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                tablaDatosProducto.setModel(new TableModelProducto(cc.getProductos()));
                this.tablaDatosProducto.setEnabled(true);
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException ex) {
                    }
                }
                fis = null;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Primero seleccione un producto");
        }
    }//GEN-LAST:event_bntActualizarActionPerformed

    private void bntGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntGrabarActionPerformed
        Productos.Modelo cl = new Productos.Modelo();
        if (!cajaNombrePro.getText().isEmpty() && !cajaCantProd.getText().isEmpty() && !cajaPrecUnit.getText().isEmpty()) {
            cl.setCategoriaProducto(comboCategoriaPro.getSelectedItem().toString());
            cl.setNombreProducto(cajaNombrePro.getText());
            cl.setCantidad(cajaCantProd.getText());
            cl.setUnidad(comboUnidadProd.getSelectedItem().toString());
            cl.setPrecioUnitario(cajaPrecUnit.getText());
            cl.setStockMinimo(cajaStockMinProd.getText() + "");
            cl.setDescripcion(cajaDescripcion.getText());
            cl.setFoto(fis);
            int opcion = cc.insertarProductos(cl);
            if (opcion != 0) {
                try {
                    JOptionPane.showMessageDialog(this, "Operación Exitosa", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    tablaDatosProducto.setModel(new TableModelProducto(cc.getProductos()));
                    this.bntGrabar.setEnabled(false);
                    bntNuevo.setEnabled(true);
                    this.tablaDatosProducto.setEnabled(true);
                    this.bntActualizar.setEnabled(true);
                    this.bntEliminar.setEnabled(true);

                    if (fis != null) {
                        fis.close();
                    }
                    fis = null;
                } catch (IOException ex) {
                    System.out.println("Error al registrar el producto");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe proporcionar los datos obligatorios", "Atención:", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_bntGrabarActionPerformed

    private void bntEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntEliminarActionPerformed
        int op = JOptionPane.showConfirmDialog(null, "¿Realmente desea eliminar el producto?", "Advertencia", JOptionPane.YES_NO_OPTION);
        if (op == JOptionPane.NO_OPTION) {
        }
        if (op == JOptionPane.YES_OPTION) {
            if (cl != null) {
                int eliminarCliente = cc.eliminarProducto(cl.getPrimaryKey());
                if (eliminarCliente != 0) {
                    JOptionPane.showMessageDialog(this, "Operación Exitosa", "Mensaje: ", JOptionPane.INFORMATION_MESSAGE);
                    tablaDatosProducto.setModel(new TableModelProducto(cc.getProductos()));
                    this.tablaDatosProducto.setEnabled(true);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Primero debe seleccionar un producto", "Mensaje: ", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_bntEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        this.comboCategoriaPro.setSelectedIndex(0);
        this.cajaNombrePro.setText("");
        this.cajaCantProd.setText("");
        this.comboUnidadProd.setSelectedIndex(0);
        this.cajaPrecUnit.setText("");
        this.cajaStockMinProd.setText("");
        this.cajaDescripcion.setText("");
        labelFotoProd.setIcon(new CustomImageIcon(getClass().getResource(rutaImagenPorDefault)));
        this.fis = null;
        this.longitudBytes = 0;
        cl = null;
        this.bntGrabar.setEnabled(false);
        bntNuevo.setEnabled(true);
        this.tablaDatosProducto.clearSelection();
        this.bntActualizar.setEnabled(true);
        this.bntEliminar.setEnabled(true);
        this.tablaDatosProducto.setEnabled(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cajaCantProdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaCantProdKeyTyped
        char caracter = evt.getKeyChar();
        if (((caracter < '0') || (caracter > '9')) && (caracter != evt.VK_BACK_SPACE) && (caracter != '.')) {
            evt.consume();
        }
        if (cajaCantProd.getText().length() >= 7) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaCantProdKeyTyped

    private void cajaPrecUnitKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaPrecUnitKeyTyped
        char caracter = evt.getKeyChar();
        if (((caracter < '0') || (caracter > '9')) && (caracter != evt.VK_BACK_SPACE) && (caracter != '.')) {
            evt.consume();
        }
        if (cajaPrecUnit.getText().length() >= 7) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaPrecUnitKeyTyped

    private void cajaStockMinProdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaStockMinProdKeyTyped
        char caracter = evt.getKeyChar();
        if (((caracter < '0') || (caracter > '9')) && (caracter != evt.VK_BACK_SPACE)) {
            evt.consume();
        }
        if (cajaStockMinProd.getText().length() >= 7) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaStockMinProdKeyTyped

    private void cajaNombreProKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaNombreProKeyTyped
        if (cajaNombrePro.getText().length() >= 45) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaNombreProKeyTyped

    private void labelRegresarProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelRegresarProductosMouseClicked
        // TODO add your handling code here:
        TodoLonas.Principal.cardLayout.show(TodoLonas.Principal.panelContenedor, "ventas");
        labelRegresarProductos.setVisible(false);
    }//GEN-LAST:event_labelRegresarProductosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntActualizar;
    private javax.swing.JButton bntEliminar;
    private javax.swing.JButton bntGrabar;
    private javax.swing.JButton bntNuevo;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JTextField cajaCantProd;
    private javax.swing.JTextArea cajaDescripcion;
    private javax.swing.JTextField cajaNombrePro;
    private javax.swing.JTextField cajaPrecUnit;
    private javax.swing.JTextField cajaStockMinProd;
    private javax.swing.JComboBox comboCategoriaPro;
    private javax.swing.JComboBox comboUnidadProd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelEst1;
    private javax.swing.JLabel labelEst2;
    private javax.swing.JLabel labelEst3;
    private javax.swing.JLabel labelEst4;
    private javax.swing.JLabel labelEst5;
    private javax.swing.JLabel labelFotoProd;
    public static javax.swing.JLabel labelRegresarProductos;
    private javax.swing.JPanel panBotonesProducto;
    private javax.swing.JPanel panDatosProd;
    private javax.swing.JDesktopPane panelGeneral;
    private javax.swing.JTable tablaDatosProducto;
    // End of variables declaration//GEN-END:variables
}
