package Ventas;

import Conexion.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Cobrar extends javax.swing.JFrame {

    public static int filas2;
    DefaultTableModel modelo = new DefaultTableModel();

    //VARIABLES DEL COBRO
    public String total;
    public Double totalCobro, abono, efectivo;
    public Double cambio, cobrar, restaAPagar;
    public String nombreCliente = "", idCliente = "" ;
    
   //DATOS PARA LA TABLA
    public int filas = 0;

    //DATOS PARA LA CONEXION DEL LA BASE DE DATOS 
    private final String url = "jdbc:mysql://localhost:" + Conexion.numPuerto + "/todolonas";
    Connection con;
    PreparedStatement pps;
    ResultSet rs;

    public Cobrar() throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        setVisible(true);
        total = "" + PanelVentas.importeFinal;
        totalCobrar.setText("$" + total);
        cobrar = Double.parseDouble(total);
    }

    public void operacionSinAbono() {
        efectivo = Double.parseDouble(cajaPagoCon.getText());
        totalCobro = efectivo - cobrar;
        cajaCambio.setText("" + totalCobro);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        comboFormaDePago = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        etiquetaCambio = new javax.swing.JLabel();
        cajaPagoCon = new javax.swing.JTextField();
        botonCobrar = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        restaPagar = new javax.swing.JLabel();
        cajaCambio = new java.awt.TextField();
        totalCobrar = new java.awt.Label();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Realizar Venta");
        setName("ventanaCobro "); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Realizar Venta", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(62, 64, 149))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/todo lonas.png"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, new javax.swing.border.LineBorder(new java.awt.Color(0, 175, 239), 2, true)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Total a Cobrar:");

        comboFormaDePago.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        comboFormaDePago.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Al Contado", "Cheques", "Vales" }));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Forma de Pago:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Pagó con:");

        etiquetaCambio.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        etiquetaCambio.setText("Cambio:");

        cajaPagoCon.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cajaPagoCon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cajaPagoConKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaPagoConKeyTyped(evt);
            }
        });

        botonCobrar.setBackground(new java.awt.Color(255, 255, 255));
        botonCobrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonCobrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cobrar.png"))); // NOI18N
        botonCobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCobrarActionPerformed(evt);
            }
        });

        botonSalir.setBackground(new java.awt.Color(255, 255, 255));
        botonSalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salir.png"))); // NOI18N
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        cajaCambio.setEditable(false);
        cajaCambio.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        totalCobrar.setAlignment(java.awt.Label.CENTER);
        totalCobrar.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        totalCobrar.setForeground(new java.awt.Color(62, 64, 149));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(botonCobrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(etiquetaCambio))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cajaPagoCon)
                                    .addComponent(cajaCambio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(restaPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(totalCobrar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboFormaDePago, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboFormaDePago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalCobrar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(restaPagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(etiquetaCambio))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cajaPagoCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cajaCambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonCobrar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(62, 64, 149));

        jLabel6.setBackground(new java.awt.Color(62, 64, 149));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Monto a Cobrar");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(28, 28, 28)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonCobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCobrarActionPerformed
        if( Double.parseDouble(cajaPagoCon.getText()) - Double.parseDouble(total) < 0 )
            JOptionPane.showMessageDialog(this, "La cantidad de pago es insuficiente", "Mensaje: ", JOptionPane.INFORMATION_MESSAGE);
        else
        {
            operacionSinAbono();
            GuardarVentas.venta();
            JOptionPane.showMessageDialog(this, "Operación Exitosa", "Mensaje: ", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_botonCobrarActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        dispose();
    }//GEN-LAST:event_botonSalirActionPerformed

    private void cajaPagoConKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaPagoConKeyTyped
        char caracter = evt.getKeyChar();
        if (((caracter < '0') || (caracter > '9')) && (caracter != evt.VK_BACK_SPACE)) {
            evt.consume();
        }
        if (cajaPagoCon.getText().length() >= 5) {
            evt.consume();
        }
        //Realizar cambio automatico
//        if(!cajaPagoCon.getText().isEmpty())
//        {
//            //double cam = Double.parseDouble(cajaPagoCon.getText()) - cobrar;
//            //cajaCambio.setText( cam+"" );
//            
//            efectivo = Double.parseDouble(cajaPagoCon.getText());
//            totalCobro = efectivo - cobrar;
//            cajaCambio.setText("" + totalCobro);
//            
//        }
//        else
//            cajaCambio.setText("");        

    }//GEN-LAST:event_cajaPagoConKeyTyped

    private void cajaPagoConKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaPagoConKeyReleased
        if(!cajaPagoCon.getText().isEmpty())
        {
            //double cam = Double.parseDouble(cajaPagoCon.getText()) - cobrar;
            //cajaCambio.setText( cam+"" );
            
            efectivo = Double.parseDouble(cajaPagoCon.getText());
            totalCobro = efectivo - cobrar;
            cajaCambio.setText("" + totalCobro);
            
        }
        else
            cajaCambio.setText("");
    }//GEN-LAST:event_cajaPagoConKeyReleased

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCobrar;
    public javax.swing.JButton botonSalir;
    public java.awt.TextField cajaCambio;
    public static javax.swing.JTextField cajaPagoCon;
    public static javax.swing.JComboBox comboFormaDePago;
    private javax.swing.JLabel etiquetaCambio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel restaPagar;
    public java.awt.Label totalCobrar;
    // End of variables declaration//GEN-END:variables
}
