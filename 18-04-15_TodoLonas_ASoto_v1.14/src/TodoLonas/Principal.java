package TodoLonas;

import Proveedores.PanelProveedores;
import Usuarios.PanelUsuarios;
import Productos.PanelProductos;
import Ventas.PanelVentas;
import Cotizacion.PanelCotizacion;
import Ajustes.PanelAjustes;
import Clientes.PanelClientes;
import Consultas.PanelConsultas;
import CorteCaja.PanelCorteCaja; 

import java.awt.CardLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;

public class Principal extends javax.swing.JFrame {

    public static CardLayout cardLayout;
    public static String usuarioActivo = "";
    
    PanelProductos producto = new PanelProductos();
    PanelClientes cliente = new PanelClientes();
    PanelProveedores proveedores = new PanelProveedores();
    PanelVentas ventas = new PanelVentas();
    PanelUsuarios usuarios = new PanelUsuarios();
    PanelAjustes ajustes = new PanelAjustes();
    PanelCotizacion cotiza = new PanelCotizacion();
    PanelConsultas consultas = new PanelConsultas();
    PanelCorteCaja corte = new PanelCorteCaja();
    
    
    Logo logo = new Logo();

    public Principal() throws ParseException, SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        mostrarDatos();
        cardLayout.show(panelContenedor, "logo");
    }

    public void mostrarDatos() {
        cardLayout = (CardLayout) panelContenedor.getLayout();
        panelContenedor.add(logo, "logo");
        panelContenedor.add(producto, "producto");
        panelContenedor.add(cliente, "cliente");
        panelContenedor.add(proveedores, "proveedores");
        panelContenedor.add(ventas, "ventas");
        panelContenedor.add(usuarios, "usuarios");
        panelContenedor.add(ajustes, "ajustes");
        panelContenedor.add(cotiza, "cotiza");
        panelContenedor.add(consultas,"consultas");
        panelContenedor.add(corte,"corte");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        labelLogotipo = new javax.swing.JLabel();
        btnVentas = new javax.swing.JButton();
        btnProductos = new javax.swing.JButton();
        btnClientes = new javax.swing.JButton();
        btnProveedores = new javax.swing.JButton();
        btnUsuarios = new javax.swing.JButton();
        botonCotizacion = new javax.swing.JButton();
        botonAjustes = new javax.swing.JButton();
        botonConsultas = new javax.swing.JButton();
        panelContenedor = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Punto de Venta: Todo Lonas");
        setIconImage(getIconImage());
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(62, 64, 149));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 700));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        labelLogotipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/todo lonas.png"))); // NOI18N
        labelLogotipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelLogotipoMouseClicked(evt);
            }
        });

        btnVentas.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ventas.png"))); // NOI18N
        btnVentas.setText("Ventas");
        btnVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasActionPerformed(evt);
            }
        });

        btnProductos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/productos.png"))); // NOI18N
        btnProductos.setText("Productos");
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });

        btnClientes.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/clientes.png"))); // NOI18N
        btnClientes.setText("Clientes");
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });

        btnProveedores.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Proveedor.png"))); // NOI18N
        btnProveedores.setText("Proveedores");
        btnProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedoresActionPerformed(evt);
            }
        });

        btnUsuarios.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/proveedores.png"))); // NOI18N
        btnUsuarios.setText("Usuarios");
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });

        botonCotizacion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonCotizacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/modificar.png"))); // NOI18N
        botonCotizacion.setText("Cotización");
        botonCotizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCotizacionActionPerformed(evt);
            }
        });

        botonAjustes.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonAjustes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Ajustes.png"))); // NOI18N
        botonAjustes.setText("Ajustes");
        botonAjustes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAjustesActionPerformed(evt);
            }
        });

        botonConsultas.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonConsultas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/consultar.png"))); // NOI18N
        botonConsultas.setText("Consultas");
        botonConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConsultasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(labelLogotipo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVentas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProductos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProveedores)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUsuarios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonCotizacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonAjustes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonConsultas)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelLogotipo)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnProductos)
                        .addComponent(btnVentas)
                        .addComponent(btnClientes)
                        .addComponent(btnProveedores)
                        .addComponent(btnUsuarios)
                        .addComponent(botonCotizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botonAjustes)
                        .addComponent(botonConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelContenedor.setBackground(new java.awt.Color(255, 255, 255));
        panelContenedor.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1156, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        cardLayout.show(panelContenedor, "producto");
        Productos.PanelProductos.labelRegresarProductos.setVisible(false);
    }//GEN-LAST:event_btnProductosActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        PanelClientes pc = new PanelClientes();
        cardLayout.show(panelContenedor, "cliente");
        Clientes.PanelClientes.labelRegresarClientes.setVisible(false);
    }//GEN-LAST:event_btnClientesActionPerformed

    private void labelLogotipoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelLogotipoMouseClicked
        Logo log = new Logo();
        cardLayout.show(panelContenedor, "logo");
    }//GEN-LAST:event_labelLogotipoMouseClicked

    private void btnVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasActionPerformed
        cardLayout.show(panelContenedor, "ventas");
    }//GEN-LAST:event_btnVentasActionPerformed

    private void btnProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedoresActionPerformed
        PanelProveedores proveedores = new PanelProveedores();
        cardLayout.show(panelContenedor, "proveedores");
    }//GEN-LAST:event_btnProveedoresActionPerformed

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
        PanelUsuarios usuarios = new PanelUsuarios();
        cardLayout.show(panelContenedor, "usuarios");
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void botonCotizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCotizacionActionPerformed
        // TODO add your handling code here:
        cardLayout.show(panelContenedor, "cotiza");
        Cotizacion.LogicaCotizacion.metodoObtenerInformacionAjustes();
        Cotizacion.LogicaCotizacion.metodoMostrarInformacionAjustes();
        Cotizacion.LogicaCotizacion.obtenerDatosVentas();
        Clientes.PanelClientes.labelRegresarClientes.setVisible(false);
    }//GEN-LAST:event_botonCotizacionActionPerformed

    private void botonAjustesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAjustesActionPerformed
        // TODO add your handling code here:
        cardLayout.show(panelContenedor, "ajustes");
    }//GEN-LAST:event_botonAjustesActionPerformed

    private void botonConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConsultasActionPerformed
        // TODO add your handling code here:
        cardLayout.show(panelContenedor, "consultas");
    }//GEN-LAST:event_botonConsultasActionPerformed

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("Imagenes/main.png"));
        return retValue;
    }

   public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    try {
                        new Principal().setVisible(true);
                    } catch (SQLException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAjustes;
    private javax.swing.JButton botonConsultas;
    private javax.swing.JButton botonCotizacion;
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton btnProveedores;
    private javax.swing.JButton btnUsuarios;
    private javax.swing.JButton btnVentas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelLogotipo;
    public static javax.swing.JPanel panelContenedor;
    // End of variables declaration//GEN-END:variables
}
