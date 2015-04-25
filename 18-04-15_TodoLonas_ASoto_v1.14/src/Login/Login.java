package Login;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {
  
    public Login() {
        this.setUndecorated(true);
        initComponents();
        cajaUsuario.setText("");
        cajaContra.setText("");        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        LogoTD = new javax.swing.JLabel();
        lbUsuario = new javax.swing.JLabel();
        cajaUsuario = new javax.swing.JTextField();
        lbContra = new javax.swing.JLabel();
        lineaAzulAbajo = new javax.swing.JPanel();
        labelRecuperar = new javax.swing.JLabel();
        lineaAzulArriba = new javax.swing.JPanel();
        cerrar = new javax.swing.JLabel();
        boton = new javax.swing.JLabel();
        cajaContra = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setIconImage(getIconImage());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        LogoTD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LogoTD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/todo lonas.png"))); // NOI18N

        lbUsuario.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        lbUsuario.setForeground(new java.awt.Color(62, 64, 129));
        lbUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbUsuario.setText("Usuario:");

        cajaUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cajaUsuario.setForeground(new java.awt.Color(62, 64, 149));
        cajaUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaUsuarioKeyTyped(evt);
            }
        });

        lbContra.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        lbContra.setForeground(new java.awt.Color(62, 64, 129));
        lbContra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbContra.setText("Contraseña:");

        lineaAzulAbajo.setBackground(new java.awt.Color(0, 153, 255));

        labelRecuperar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        labelRecuperar.setForeground(new java.awt.Color(255, 255, 255));
        labelRecuperar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRecuperar.setText("Recuperar Contraseña");
        labelRecuperar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelRecuperar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelRecuperarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout lineaAzulAbajoLayout = new javax.swing.GroupLayout(lineaAzulAbajo);
        lineaAzulAbajo.setLayout(lineaAzulAbajoLayout);
        lineaAzulAbajoLayout.setHorizontalGroup(
            lineaAzulAbajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lineaAzulAbajoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelRecuperar)
                .addContainerGap())
        );
        lineaAzulAbajoLayout.setVerticalGroup(
            lineaAzulAbajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lineaAzulAbajoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelRecuperar))
        );

        lineaAzulArriba.setBackground(new java.awt.Color(62, 64, 149));

        cerrar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        cerrar.setForeground(new java.awt.Color(255, 255, 255));
        cerrar.setText("Salir");
        cerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout lineaAzulArribaLayout = new javax.swing.GroupLayout(lineaAzulArriba);
        lineaAzulArriba.setLayout(lineaAzulArribaLayout);
        lineaAzulArribaLayout.setHorizontalGroup(
            lineaAzulArribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lineaAzulArribaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cerrar)
                .addContainerGap())
        );
        lineaAzulArribaLayout.setVerticalGroup(
            lineaAzulArribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lineaAzulArribaLayout.createSequentialGroup()
                .addComponent(cerrar)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        boton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        boton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/e1.png"))); // NOI18N
        boton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        boton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonMouseClicked(evt);
            }
        });

        cajaContra.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cajaContra.setForeground(new java.awt.Color(62, 64, 149));
        cajaContra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cajaContraKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaContraKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lineaAzulArriba, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lineaAzulAbajo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbContra)
                            .addComponent(lbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cajaUsuario)
                            .addComponent(cajaContra)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(LogoTD)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(139, Short.MAX_VALUE)
                .addComponent(boton)
                .addGap(129, 129, 129))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lineaAzulArriba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LogoTD)
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbUsuario)
                    .addComponent(cajaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbContra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cajaContra)
                        .addGap(27, 27, 27)))
                .addComponent(boton)
                .addGap(38, 38, 38)
                .addComponent(lineaAzulAbajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
   
    private void cerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_cerrarMouseClicked

    private void botonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonMouseClicked
        String usuario=cajaUsuario.getText();
        String password=cajaContra.getText();
        if((usuario.isEmpty())||(password.isEmpty()))
        {
            usuario="";
            password="";
        }
        else
        {
            this.setVisible(true);
        }

        Conecta conectar = new Conecta();
        Statement st =conectar.conectar();
        try
        {
           ResultSet rs = st.executeQuery("SELECT * FROM usuario WHERE nombreUsuario='"+usuario+"' AND passwordUsuario ='"+password+"'");
           //hay que posicionarse en el ultimo registro
           rs.last();
            int encontrado=rs.getRow();
            if(encontrado==1) // si nos devuelve un registro significa que la autenticacion es correcta y mostramos el formulario
            {
                this.setVisible(false);
                String tipo = rs.getNString("tipoUsuario");
                TodoLonas.Principal.usuarioActivo = usuario;
                TodoLonas.Principal.tipoUsuarioActivo = tipo;
                System.out.println("Usuario: "+usuario);
                System.out.println("Tipo de Usuario: "+tipo);
                TodoLonas.Principal.main(null);
            }
            else
            {
                 JOptionPane.showMessageDialog(null, "Los datos son incorrectos");
            }
           //cerramos Conecta
           rs.close();
           st.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_botonMouseClicked

    private void labelRecuperarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelRecuperarMouseClicked
        this.setVisible(false);
        RecuperarContra.Recuperar.main(null);
    }//GEN-LAST:event_labelRecuperarMouseClicked

    private void cajaUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaUsuarioKeyTyped
        char caracter = evt.getKeyChar();
        if ((caracter < 'a' || caracter > 'z') && (caracter < 'A' || caracter > 'Z')
                && (caracter != (char)java.awt.event.KeyEvent.VK_SPACE) ) {
            evt.consume();
        }
        if (cajaUsuario.getText().length() >= 45) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaUsuarioKeyTyped

    private void cajaContraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaContraKeyTyped
        if (cajaContra.getText().length() >= 45) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaContraKeyTyped

    private void cajaContraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaContraKeyPressed
        if(evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER)
        {
            String usuario=cajaUsuario.getText();
            String password=cajaContra.getText();
            if((usuario.isEmpty())||(password.isEmpty()))
            {
                usuario="";
                password="";
            }
            else
            {
                this.setVisible(true);
            }

            Conecta conectar = new Conecta();
            Statement st =conectar.conectar();
            try
            {
               ResultSet rs = st.executeQuery("SELECT * FROM usuario WHERE nombreUsuario='"+usuario+"' AND passwordUsuario ='"+password+"'");
               //hay que posicionarse en el ultimo registro
               rs.last();
                int encontrado=rs.getRow();

                if(encontrado==1) // si nos devuelve un registro significa que la autenticacion es correcta y mostramos el formulario
                {
                    this.setVisible(false);
                    TodoLonas.Principal.main(null);
                    TodoLonas.Principal.usuarioActivo = usuario;
                }
                else
                {
                     JOptionPane.showMessageDialog(null, "Los datos son incorrectos");
                }
               //cerramos Conecta
               rs.close();
               st.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_cajaContraKeyPressed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LogoTD;
    private javax.swing.JLabel boton;
    private javax.swing.JPasswordField cajaContra;
    private javax.swing.JTextField cajaUsuario;
    private javax.swing.JLabel cerrar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelRecuperar;
    private javax.swing.JLabel lbContra;
    private javax.swing.JLabel lbUsuario;
    private javax.swing.JPanel lineaAzulAbajo;
    private javax.swing.JPanel lineaAzulArriba;
    // End of variables declaration//GEN-END:variables
}
