package RespaldarRestaurar;

import java.io.File;
import java.sql.Connection;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
    
public class Ventana extends javax.swing.JFrame 
{

    //EDITAR LOS VALORES DE LAS CONEXIONES DE MANERA MANUAL
    //SI SE TRATA DE HACER INSTANCIANDO LA CLASE CONEXION DEL PAQUETE CONEXION NO FUNCIONA, PORQUE, NO LO SE, PERO DEBE SER MANUALMENTE
    
    ProcessBuilder constructorProceso;
    Connection con = null;
    Process proc;
    //Asignamos el nombre de la base de datos que se desea respaldar
    private final String bd = "todolonas";

    public Ventana() 
    {
        initComponents();
        try 
        {
            con = Conecta.conectar();//Conecta ao banco de dados 
            JFC_Salvar_Backup.setVisible(false);
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error !", 2);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBase = new javax.swing.JPanel();
        panelRespaldar = new javax.swing.JPanel();
        cajaRespaldar = new javax.swing.JTextField();
        btnRespaldar = new javax.swing.JButton();
        JFC_Salvar_Backup = new javax.swing.JFileChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Respaldar y Restaurar Base de Datos");

        panelBase.setBackground(new java.awt.Color(255, 255, 255));

        panelRespaldar.setBackground(new java.awt.Color(255, 255, 255));
        panelRespaldar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Respaldar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        btnRespaldar.setText("Respaldar");
        btnRespaldar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRespaldarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRespaldarLayout = new javax.swing.GroupLayout(panelRespaldar);
        panelRespaldar.setLayout(panelRespaldarLayout);
        panelRespaldarLayout.setHorizontalGroup(
            panelRespaldarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRespaldarLayout.createSequentialGroup()
                .addComponent(cajaRespaldar, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRespaldar)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        panelRespaldarLayout.setVerticalGroup(
            panelRespaldarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRespaldarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelRespaldarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cajaRespaldar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRespaldar))
                .addContainerGap())
        );

        JFC_Salvar_Backup.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);

        javax.swing.GroupLayout panelBaseLayout = new javax.swing.GroupLayout(panelBase);
        panelBase.setLayout(panelBaseLayout);
        panelBaseLayout.setHorizontalGroup(
            panelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBaseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JFC_Salvar_Backup, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(216, Short.MAX_VALUE))
            .addGroup(panelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelBaseLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelRespaldar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        panelBaseLayout.setVerticalGroup(
            panelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBaseLayout.createSequentialGroup()
                .addContainerGap(98, Short.MAX_VALUE)
                .addComponent(JFC_Salvar_Backup, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(panelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelBaseLayout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(panelRespaldar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(53, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRespaldarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRespaldarActionPerformed
        try 
        {
            String archivo = null;
            JFC_Salvar_Backup.setVisible(true);
            int result = JFC_Salvar_Backup.showSaveDialog(null);
            if (result == JFileChooser.APPROVE_OPTION)
            {
                cajaRespaldar.setText(JFC_Salvar_Backup.getSelectedFile().getAbsolutePath());
                archivo = JFC_Salvar_Backup.getSelectedFile().toString().concat(".sql");
                cajaRespaldar.setText(archivo);
                File file = new File(archivo);
                if (file.exists()) 
                {
                    Object[] options = {"Si", "No"};
                    int opcion = JOptionPane.showOptionDialog(null, "Este archivo ya existe. Desea sobreescribirlo?", "Atención !!!",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                    if (opcion == JOptionPane.YES_OPTION) 
                    {
                        Runtime bck = Runtime.getRuntime();
                        bck.exec("C:/Program Files/MySQL/MySQL Server 5.6/bin/mysqldump.exe -v -v -v --host=localhost --user=root --password=root --port=3306 --protocol=tcp --force --allow-keywords --compress  --add-drop-table --default-character-set=utf8 --hex-blob  --result-file=" + archivo + " --databases "+bd);
                        JOptionPane.showMessageDialog(null, "Respaldo realizado exitosamente.", "Mensaje:", 1);
                    } 
                    else 
                    {
                        System.out.println("Ups, algo no salió bien");
                    }
                }
                else 
                {
                    Runtime bck = Runtime.getRuntime();
                    bck.exec("C:/Program Files/MySQL/MySQL Server 5.6/bin/mysqldump.exe -v -v -v --host=localhost --user=root --password=root --port=3306 --protocol=tcp --force --allow-keywords --compress  --add-drop-table --default-character-set=utf8 --hex-blob  --result-file=" + archivo + " --databases "+bd);
                    JOptionPane.showMessageDialog(null, "Respaldo realizado exitosamente.", "Mensaje:", 1);
                }
            }
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error !", 2);
        }

    }//GEN-LAST:event_btnRespaldarActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } 
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser JFC_Salvar_Backup;
    private javax.swing.JButton btnRespaldar;
    private javax.swing.JTextField cajaRespaldar;
    private javax.swing.JPanel panelBase;
    private javax.swing.JPanel panelRespaldar;
    // End of variables declaration//GEN-END:variables
}
