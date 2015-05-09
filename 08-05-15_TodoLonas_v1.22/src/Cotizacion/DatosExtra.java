package Cotizacion;

/**
 *
 * @author Ana Karen
 */
public class DatosExtra extends javax.swing.JFrame {

    public static double precio1=0, precio2=0, subtotal, resultado;
    public static String espeTrabajo="NA", espeDiseno="NA";

    public DatosExtra() {
        initComponents();
        this.setLocationRelativeTo(null);
//        if (!cajaEspecificacionTrabajo.getText().isEmpty()) {
//            espeTrabajo = areaEspecificacionTrabajo.getText();
//        }
//        if (!cajaEspecificacionDiseno.getText().isEmpty()) {
//            espeDiseno = areaEspecificacionDiseno.getText();
//        }
        cajaEspecificacionTrabajo.setText(precio1+"");
        cajaEspecificacionDiseno.setText(precio2+"");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        areaEspecificacionTrabajo = new java.awt.TextArea();
        jLabel6 = new javax.swing.JLabel();
        cajaEspecificacionTrabajo = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        areaEspecificacionDiseno = new java.awt.TextArea();
        jLabel7 = new javax.swing.JLabel();
        cajaEspecificacionDiseno = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        btnAgregarPrecioExtra = new javax.swing.JButton();
        btnCancelarPrecioExtra = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(62, 64, 149));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel18.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel18.setText("Especificación del Trabajo:");

        areaEspecificacionTrabajo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        areaEspecificacionTrabajo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                areaEspecificacionTrabajoKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Precio Extra:");

        cajaEspecificacionTrabajo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cajaEspecificacionTrabajo.setText("0");
        cajaEspecificacionTrabajo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaEspecificacionTrabajoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(areaEspecificacionTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cajaEspecificacionTrabajo))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(areaEspecificacionTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cajaEspecificacionTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel19.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel19.setText("Especificación del Diseño:");

        areaEspecificacionDiseno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                areaEspecificacionDisenoKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("Precio Extra:");

        cajaEspecificacionDiseno.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cajaEspecificacionDiseno.setText("0");
        cajaEspecificacionDiseno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaEspecificacionDisenoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(areaEspecificacionDiseno, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cajaEspecificacionDiseno))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(areaEspecificacionDiseno, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cajaEspecificacionDiseno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnAgregarPrecioExtra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imgAgregar.png"))); // NOI18N
        btnAgregarPrecioExtra.setText("Agregar Precio Extra");
        btnAgregarPrecioExtra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPrecioExtraActionPerformed(evt);
            }
        });

        btnCancelarPrecioExtra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancel.png"))); // NOI18N
        btnCancelarPrecioExtra.setText("Cancelar Precio Extra");
        btnCancelarPrecioExtra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarPrecioExtraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(btnAgregarPrecioExtra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelarPrecioExtra)
                .addGap(84, 84, 84))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarPrecioExtra)
                    .addComponent(btnCancelarPrecioExtra))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarPrecioExtraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPrecioExtraActionPerformed
        // TODO add your handling code here:
        if (!areaEspecificacionTrabajo.getText().isEmpty()) {
            espeTrabajo = areaEspecificacionTrabajo.getText();
        }
        else{
            espeTrabajo = "NA";
        }
        if (!areaEspecificacionDiseno.getText().isEmpty()) {
            espeDiseno = areaEspecificacionDiseno.getText();
        }
        else{
            espeDiseno = "NA";
        }
        precio1 = Double.parseDouble(cajaEspecificacionTrabajo.getText());
        precio2 = Double.parseDouble(cajaEspecificacionDiseno.getText());
        
        cajaEspecificacionDiseno.setText(espeDiseno);
        cajaEspecificacionTrabajo.setText(espeTrabajo);
        
        subtotal = Double.parseDouble(PanelCotizacion.cajaSubtotal.getText());
        resultado = subtotal + precio1 + precio2;
        PanelCotizacion.cajaSubtotal.setText(""+resultado);
        dispose();
    }//GEN-LAST:event_btnAgregarPrecioExtraActionPerformed

    private void btnCancelarPrecioExtraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarPrecioExtraActionPerformed
        cajaEspecificacionTrabajo.setText(precio1+"");
        cajaEspecificacionDiseno.setText(precio2+"");        
        
        precio1 = Double.parseDouble(cajaEspecificacionTrabajo.getText());
        precio2 = Double.parseDouble(cajaEspecificacionDiseno.getText());        
        
        subtotal = Double.parseDouble(PanelCotizacion.cajaSubtotal.getText());
        resultado = subtotal -(precio1 + precio2);
        
        PanelCotizacion.cajaSubtotal.setText(""+resultado);
        dispose();
    }//GEN-LAST:event_btnCancelarPrecioExtraActionPerformed

    private void cajaEspecificacionTrabajoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaEspecificacionTrabajoKeyTyped
        // TODO add your handling code here:
        char caracter = evt.getKeyChar();
        if (((caracter < '0') || (caracter > '9')) && (caracter != evt.VK_BACK_SPACE) && (caracter != '.')) {
            evt.consume();
        }
        if (cajaEspecificacionTrabajo.getText().length() >= 7) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaEspecificacionTrabajoKeyTyped

    private void cajaEspecificacionDisenoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaEspecificacionDisenoKeyTyped
        // TODO add your handling code here:
        char caracter = evt.getKeyChar();
        if (((caracter < '0') || (caracter > '9')) && (caracter != evt.VK_BACK_SPACE) && (caracter != '.')) {
            evt.consume();
        }
        if (cajaEspecificacionDiseno.getText().length() >= 7) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaEspecificacionDisenoKeyTyped

    private void areaEspecificacionTrabajoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_areaEspecificacionTrabajoKeyTyped
        // TODO add your handling code here:
        char caracter = evt.getKeyChar();
        if (areaEspecificacionTrabajo.getText().length() >= 250) {
            evt.consume();
        }
    }//GEN-LAST:event_areaEspecificacionTrabajoKeyTyped

    private void areaEspecificacionDisenoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_areaEspecificacionDisenoKeyTyped
        // TODO add your handling code here:
        char caracter = evt.getKeyChar();
        if (areaEspecificacionDiseno.getText().length() >= 250) {
            evt.consume();
        }
    }//GEN-LAST:event_areaEspecificacionDisenoKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static java.awt.TextArea areaEspecificacionDiseno;
    public static java.awt.TextArea areaEspecificacionTrabajo;
    private javax.swing.JButton btnAgregarPrecioExtra;
    private javax.swing.JButton btnCancelarPrecioExtra;
    private javax.swing.JTextField cajaEspecificacionDiseno;
    private javax.swing.JTextField cajaEspecificacionTrabajo;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
