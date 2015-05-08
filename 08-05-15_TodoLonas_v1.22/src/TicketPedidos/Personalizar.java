package TicketPedidos;

import TodoLonas.*;
import java.io.*;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Personalizar extends javax.swing.JFrame {

    public static String mensaje; 
    
    public Personalizar() {
        initComponents();
        leeMensaje();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        panelPersonalizarTicket = new javax.swing.JPanel();
        etiquetaTicket = new javax.swing.JLabel();
        botonAceptar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        cajaMensaje = new javax.swing.JTextPane();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Perzonalizar Ticket");
        setBackground(new java.awt.Color(62, 64, 149));

        panelPersonalizarTicket.setBackground(new java.awt.Color(62, 64, 149));

        etiquetaTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TicketPedidos/ticketVentas2.png"))); // NOI18N

        botonAceptar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ok.png"))); // NOI18N
        botonAceptar.setText("Aceptar");
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        botonCancelar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/delete.png"))); // NOI18N
        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        cajaMensaje.setFont(new java.awt.Font("Vani", 0, 16)); // NOI18N
        cajaMensaje.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cajaMensajeKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(cajaMensaje);

        javax.swing.GroupLayout panelPersonalizarTicketLayout = new javax.swing.GroupLayout(panelPersonalizarTicket);
        panelPersonalizarTicket.setLayout(panelPersonalizarTicketLayout);
        panelPersonalizarTicketLayout.setHorizontalGroup(
            panelPersonalizarTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPersonalizarTicketLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(botonAceptar)
                .addGap(18, 18, 18)
                .addComponent(botonCancelar)
                .addGap(0, 36, Short.MAX_VALUE))
            .addGroup(panelPersonalizarTicketLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPersonalizarTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etiquetaTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(panelPersonalizarTicketLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelPersonalizarTicketLayout.setVerticalGroup(
            panelPersonalizarTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPersonalizarTicketLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etiquetaTicket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelPersonalizarTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAceptar)
                    .addComponent(botonCancelar))
                .addGap(11, 11, 11))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPersonalizarTicket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPersonalizarTicket, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
  
    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        mensaje = cajaMensaje.getText();     
        modificarProducto(mensaje);
    }//GEN-LAST:event_botonAceptarActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void cajaMensajeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaMensajeKeyPressed
        cajaMensaje.setText("");
    }//GEN-LAST:event_cajaMensajeKeyPressed

      public static void modificarProducto(String m) {
        try (Connection conexion = new ConexionTicketPedidos().conectar()) {
            CallableStatement sentencia = conexion.prepareCall("{CALL `todolonas`.`modificarMensaje`(?)}");
            sentencia.setString(1, m);
            sentencia.execute();
            JOptionPane.showMessageDialog(null, "Operación Exitosa");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Operación Fallida");
        }
    }
     
    public static void leeMensaje()
    {
        String mensaje="";
        try (Connection conexion = new ConexionTicketPedidos().conectar()) {
            CallableStatement sentencia = conexion.prepareCall("{CALL `todolonas`.`leeMensaje`()}");
            sentencia.execute();
            while (sentencia.getResultSet().next()) {
                mensaje=(String) sentencia.getResultSet().getObject(1);
                cajaMensaje.setText(mensaje);
            }
            
        } catch (SQLException ex) {
            System.out.println(""+ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonCancelar;
    public static javax.swing.JTextPane cajaMensaje;
    private javax.swing.JLabel etiquetaTicket;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    public static javax.swing.JPanel panelPersonalizarTicket;
    // End of variables declaration//GEN-END:variables
}
