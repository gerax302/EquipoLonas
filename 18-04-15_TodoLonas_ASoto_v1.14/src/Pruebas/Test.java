package Pruebas;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test extends javax.swing.JFrame {
   
    public Test() {
        initComponents();
        cargaAjustes();
    }

    public void cargaAjustes()
    {
        Connection con = null;
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://"+Conexion.nombreServidor+":"+Conexion.puerto+"/"+Conexion.nombreBD;
            con = DriverManager.getConnection(url, Conexion.usuarioBD, Conexion.contrasena);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from ajustes");
            while(rs.next())
            {
                cajaNomProp.setText(rs.getString("nombre"));
                cajaDescGral.setText(rs.getString("descuentoClienteGeneral"));
                //descuentoEmpresa, descuentoInstitucionesPublicas, descuentoPersonasFisicas, telefonoNegocio, numeroCelular, correoNegocio, domicilioNegocio, RFC, leyendaCotizacion, nombre, id
                cajaDescGral.setText(rs.getString(""));
            }            
        } 
        catch (ClassNotFoundException | SQLException e) 
        {
            System.out.println("Error: "+e.getMessage());
        }        
    }
    
    public void cargaClientes()
    {
        Connection con = null;
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://"+Conexion.nombreServidor+":"+Conexion.puerto+"/"+Conexion.nombreBD;
            con = DriverManager.getConnection(url, Conexion.usuarioBD, Conexion.contrasena);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select nombreCliente  from cliente");
            combo.removeAllItems();
            while(rs.next())
            {
                combo.addItem(rs.getString(1));
            }
            
            rs = st.executeQuery("select nombreCliente  from cliente where idCliente = 1");
            while(rs.next())
            {
                cajaNomProp.setText(rs.getString(1));
            }            
            
        } 
        catch (ClassNotFoundException | SQLException e) 
        {
            System.out.println("Error: "+e.getMessage());
        }
    }  
    
    public void actualiza()
    {
        Connection con = null;
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://"+Conexion.nombreServidor+":"+Conexion.puerto+"/"+Conexion.nombreBD;
            con = DriverManager.getConnection(url, Conexion.usuarioBD, Conexion.contrasena);
            Statement st = con.createStatement();  
            String upd = "Update cliente Set nombreCliente = 'Gera' where idCliente = "+1;
            ResultSet rs;
            rs = st.executeQuery("SELECT nombre FROM ajustes");
            rs.next();
            String nom = rs.getString(1); 
            cajaNomProp.setText(nom);
            
        } 
        catch (ClassNotFoundException | SQLException e) 
        {
            System.out.println("Error: "+e.getMessage());
        }    
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        combo = new javax.swing.JComboBox();
        btnActualiza = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        cajaDescEmp2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cajaDescEmp1 = new javax.swing.JTextField();
        cajaDescEmp = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cajaDescGral = new javax.swing.JTextField();
        cajaNomProp = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cajaDescEmp3 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        cajaDescEmp4 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cajaDescEmp5 = new javax.swing.JTextField();
        cajaDescEmp6 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cajaDescGral1 = new javax.swing.JTextField();
        cajaNomProp1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        cajaDescEmp7 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bases:");

        btnActualiza.setText("Actualiza");
        btnActualiza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizaActionPerformed(evt);
            }
        });

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(cajaDescEmp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 120, 140, -1));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Desc Per Fis");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 132, -1));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nombre del Propietario:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 14, -1, -1));
        jPanel2.add(cajaDescEmp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 94, 140, -1));
        jPanel2.add(cajaDescEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 68, 140, -1));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Desc Inst Pub");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 94, 132, 20));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Desc General");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 128, -1));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Desc Empresa");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 71, 128, -1));
        jPanel2.add(cajaDescGral, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 140, -1));
        jPanel2.add(cajaNomProp, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 11, 140, -1));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Telefono Fijo");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 132, 20));
        jPanel2.add(cajaDescEmp3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 140, 20));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(cajaDescEmp4, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 120, 140, -1));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Leyenda Coti");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 132, -1));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Celular");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 14, 110, -1));
        jPanel3.add(cajaDescEmp5, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 94, 140, -1));
        jPanel3.add(cajaDescEmp6, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 68, 140, -1));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("RFC");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 94, 132, 20));

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Correo");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 128, -1));

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Domicilio");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 71, 128, -1));
        jPanel3.add(cajaDescGral1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 140, -1));
        jPanel3.add(cajaNomProp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 11, 140, -1));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Nada aqui");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 132, 20));
        jPanel3.add(cajaDescEmp7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 140, 20));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnActualiza, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(btnActualiza)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizaActionPerformed
        actualiza();
    }//GEN-LAST:event_btnActualizaActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Test().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualiza;
    private javax.swing.JTextField cajaDescEmp;
    private javax.swing.JTextField cajaDescEmp1;
    private javax.swing.JTextField cajaDescEmp2;
    private javax.swing.JTextField cajaDescEmp3;
    private javax.swing.JTextField cajaDescEmp4;
    private javax.swing.JTextField cajaDescEmp5;
    private javax.swing.JTextField cajaDescEmp6;
    private javax.swing.JTextField cajaDescEmp7;
    private javax.swing.JTextField cajaDescGral;
    private javax.swing.JTextField cajaDescGral1;
    private javax.swing.JTextField cajaNomProp;
    private javax.swing.JTextField cajaNomProp1;
    private javax.swing.JComboBox combo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
