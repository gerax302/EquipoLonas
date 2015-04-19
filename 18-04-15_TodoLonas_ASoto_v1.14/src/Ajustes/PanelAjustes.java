package Ajustes;

import Conexion.Conexion;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import Validaciones.Correo;
import static Validaciones.Correo.verifica;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import Respaldar.*;

/**
 * @author Gerardo
 */
public class PanelAjustes extends javax.swing.JPanel 
{
    String cadena = "";
    Boolean bandera;
    Ventana backup = new Ventana();

    public PanelAjustes() 
    {
        initComponents();
        cargarAjustes();
    }
    
    public void cargarAjustes()
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
                //Para poner en cajas editables
                cajaNombreDueno.setText(rs.getString("nombre"));
                cajaCotizacion.setText(rs.getString("leyendaCotizacion"));
                cajaRFC.setText(rs.getString("RFC"));
                cajaDomicilioNeg.setText(rs.getString("domicilioNegocio"));
                cajaCorreo.setText(rs.getString("correoNegocio"));
                cajaCelular.setText(rs.getString("numeroCelular"));
                cajaTelefono.setText(rs.getString("telefonoNegocio"));
                cajaDescGral.setText(rs.getString("descuentoClienteGeneral"));
                cajaDescEmp.setText(rs.getString("descuentoEmpresa"));
                cajaDescInstitPub.setText(rs.getString("descuentoInstitucionesPublicas"));
                cajaDescPersFis.setText(rs.getString("descuentoPersonasFisicas"));
                cajaIVA.setText(rs.getString("iva"));
                cajaColonia.setText(rs.getString("colonia"));
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
            String query = "UPDATE  ajustes SET "+
            "nombre = ? ,           leyendaCotizacion = ?,          RFC = ?, "+
            "domicilioNegocio = ?,  correoNegocio = ?,              numeroCelular = ?, "+
            "telefonoNegocio = ?,   descuentoPersonasFisicas = ?,   descuentoInstitucionesPublicas = ?, "+
            "descuentoEmpresa = ?,  descuentoClienteGeneral = ?, iva = ?, colonia=? where pk =1";
            PreparedStatement ps;
            ps = con.prepareStatement(query);
            ps.setString(1, cajaNombreDueno.getText());
            ps.setString(2, cajaCotizacion.getText());
            ps.setString(3, cajaRFC.getText());
            ps.setString(4, cajaDomicilioNeg.getText()); 
            ps.setString(5, cajaCorreo.getText()); 
            ps.setString(6, cajaCelular.getText());
            ps.setString(7, cajaTelefono.getText()); 
            ps.setString(8, cajaDescPersFis.getText()); 
            ps.setString(9, cajaDescInstitPub.getText()); 
            ps.setString(10,cajaDescEmp.getText());  
            ps.setString(11,cajaDescGral.getText()); 
            ps.setString(12,cajaIVA.getText());
            ps.setString(13, cajaColonia.getText());
            ps.executeUpdate();            
            //rsu=ps.executeUpdate();            
            if(ps.executeUpdate() == 1)
                JOptionPane.showMessageDialog(null, "Operación Exitosa", "Mensaje:", JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(null, "Operación Fallida", "Mensaje:", JOptionPane.ERROR_MESSAGE);
            cargarAjustes();
            con.close();
        } 
        catch (ClassNotFoundException | SQLException e) 
        {
            System.out.println("Error: "+e.getMessage());
        }        
}
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelEst14 = new javax.swing.JLabel();
        Base = new javax.swing.JPanel();
        panelGeneral = new javax.swing.JDesktopPane();
        panelAjustes = new javax.swing.JPanel();
        PanelDatosAjustes = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        cajaNombreDueno = new javax.swing.JTextField();
        cajaCorreo = new javax.swing.JTextField();
        cajaRFC = new javax.swing.JTextField();
        cajaDomicilioNeg = new javax.swing.JTextField();
        cajaTelefono = new javax.swing.JTextField();
        cajaCelular = new javax.swing.JTextField();
        cajaLeyendaCot = new javax.swing.JScrollPane();
        cajaCotizacion = new javax.swing.JTextArea();
        labelEst4 = new javax.swing.JLabel();
        labelEst8 = new javax.swing.JLabel();
        labelEst6 = new javax.swing.JLabel();
        labelEst7 = new javax.swing.JLabel();
        labelEst9 = new javax.swing.JLabel();
        labelEst10 = new javax.swing.JLabel();
        labelEst5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        labelEst15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        cajaIVA = new javax.swing.JTextField();
        labelEst16 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        cajaColonia = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        panelDescuentos = new javax.swing.JPanel();
        cajaDescGral = new javax.swing.JTextField();
        labelEst11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        labelEst12 = new javax.swing.JLabel();
        labelEst13 = new javax.swing.JLabel();
        labelEst3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cajaDescEmp = new javax.swing.JTextField();
        cajaDescInstitPub = new javax.swing.JTextField();
        cajaDescPersFis = new javax.swing.JTextField();
        panelBotonesAjustes = new javax.swing.JPanel();
        bntActualizar = new javax.swing.JButton();

        labelEst14.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        labelEst14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/star.png"))); // NOI18N

        panelGeneral.setBackground(new java.awt.Color(255, 255, 255));

        panelAjustes.setBackground(new java.awt.Color(62, 64, 149));

        PanelDatosAjustes.setBackground(new java.awt.Color(255, 255, 255));
        PanelDatosAjustes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Generales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cajaNombreDueno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaNombreDuenoKeyTyped(evt);
            }
        });
        jPanel1.add(cajaNombreDueno, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 190, -1));

        cajaCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaCorreoKeyTyped(evt);
            }
        });
        jPanel1.add(cajaCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 190, -1));

        cajaRFC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaRFCKeyTyped(evt);
            }
        });
        jPanel1.add(cajaRFC, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 190, -1));

        cajaDomicilioNeg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaDomicilioNegKeyTyped(evt);
            }
        });
        jPanel1.add(cajaDomicilioNeg, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 190, -1));

        cajaTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaTelefonoKeyTyped(evt);
            }
        });
        jPanel1.add(cajaTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 190, -1));

        cajaCelular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaCelularKeyTyped(evt);
            }
        });
        jPanel1.add(cajaCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 190, -1));

        cajaLeyendaCot.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        cajaCotizacion.setColumns(20);
        cajaCotizacion.setLineWrap(true);
        cajaCotizacion.setRows(5);
        cajaCotizacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaCotizacionKeyTyped(evt);
            }
        });
        cajaLeyendaCot.setViewportView(cajaCotizacion);

        jPanel1.add(cajaLeyendaCot, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 190, 40));

        labelEst4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        labelEst4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/star.png"))); // NOI18N
        jPanel1.add(labelEst4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        labelEst8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        labelEst8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/star.png"))); // NOI18N
        jPanel1.add(labelEst8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        labelEst6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        labelEst6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/star.png"))); // NOI18N
        jPanel1.add(labelEst6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        labelEst7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        labelEst7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/star.png"))); // NOI18N
        jPanel1.add(labelEst7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        labelEst9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        labelEst9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/star.png"))); // NOI18N
        jPanel1.add(labelEst9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        labelEst10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        labelEst10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/star.png"))); // NOI18N
        jPanel1.add(labelEst10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        labelEst5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        labelEst5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/star.png"))); // NOI18N
        jPanel1.add(labelEst5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Nombre del Propietario:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 150, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Correo:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 150, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("RFC:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 150, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Domicilio:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 150, 20));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Teléfono Fijo:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 150, 20));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Teléfono Móvil:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 150, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Leyenda Cotización:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 140, -1));

        labelEst15.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        labelEst15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/star.png"))); // NOI18N
        jPanel1.add(labelEst15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("Respaldar información:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 30, 150, 20));

        cajaIVA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaIVAKeyTyped(evt);
            }
        });
        jPanel1.add(cajaIVA, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 190, -1));

        labelEst16.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        labelEst16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/star.png"))); // NOI18N
        jPanel1.add(labelEst16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("Colonia:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 150, 20));

        cajaColonia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaColoniaKeyTyped(evt);
            }
        });
        jPanel1.add(cajaColonia, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 190, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("IVA:");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 150, 20));

        jButton1.setText("Crear Respaldo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 30, -1, -1));

        PanelDatosAjustes.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 880, 330));
        jPanel1.getAccessibleContext().setAccessibleName("Datos Generales");

        PanelDatosAjustes.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 374, -1, 20));

        panelDescuentos.setBackground(new java.awt.Color(255, 255, 255));
        panelDescuentos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descuentos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        panelDescuentos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cajaDescGral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaDescGralKeyTyped(evt);
            }
        });
        panelDescuentos.add(cajaDescGral, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 60, -1));

        labelEst11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        labelEst11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/star.png"))); // NOI18N
        panelDescuentos.add(labelEst11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Público  General:");
        panelDescuentos.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 130, -1));

        labelEst12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        labelEst12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/star.png"))); // NOI18N
        panelDescuentos.add(labelEst12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        labelEst13.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        labelEst13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/star.png"))); // NOI18N
        panelDescuentos.add(labelEst13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        labelEst3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        labelEst3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/star.png"))); // NOI18N
        panelDescuentos.add(labelEst3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Empresas:");
        panelDescuentos.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 130, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Instituciones Públicas:");
        panelDescuentos.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 130, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Personas Físicas:");
        panelDescuentos.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 130, 20));

        cajaDescEmp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaDescEmpKeyTyped(evt);
            }
        });
        panelDescuentos.add(cajaDescEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 60, -1));

        cajaDescInstitPub.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaDescInstitPubKeyTyped(evt);
            }
        });
        panelDescuentos.add(cajaDescInstitPub, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 60, -1));

        cajaDescPersFis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaDescPersFisKeyTyped(evt);
            }
        });
        panelDescuentos.add(cajaDescPersFis, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 60, -1));

        PanelDatosAjustes.add(panelDescuentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 880, 180));

        javax.swing.GroupLayout panelAjustesLayout = new javax.swing.GroupLayout(panelAjustes);
        panelAjustes.setLayout(panelAjustesLayout);
        panelAjustesLayout.setHorizontalGroup(
            panelAjustesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAjustesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelDatosAjustes, javax.swing.GroupLayout.DEFAULT_SIZE, 917, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelAjustesLayout.setVerticalGroup(
            panelAjustesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAjustesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelDatosAjustes, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelBotonesAjustes.setBackground(new java.awt.Color(62, 64, 149));

        bntActualizar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bntActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/upd.png"))); // NOI18N
        bntActualizar.setText("Actualizar");
        bntActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBotonesAjustesLayout = new javax.swing.GroupLayout(panelBotonesAjustes);
        panelBotonesAjustes.setLayout(panelBotonesAjustesLayout);
        panelBotonesAjustesLayout.setHorizontalGroup(
            panelBotonesAjustesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesAjustesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bntActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBotonesAjustesLayout.setVerticalGroup(
            panelBotonesAjustesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesAjustesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bntActualizar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelGeneralLayout = new javax.swing.GroupLayout(panelGeneral);
        panelGeneral.setLayout(panelGeneralLayout);
        panelGeneralLayout.setHorizontalGroup(
            panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBotonesAjustes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelAjustes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelGeneralLayout.setVerticalGroup(
            panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBotonesAjustes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelAjustes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelGeneral.setLayer(panelAjustes, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelGeneral.setLayer(panelBotonesAjustes, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout BaseLayout = new javax.swing.GroupLayout(Base);
        Base.setLayout(BaseLayout);
        BaseLayout.setHorizontalGroup(
            BaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGeneral, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        BaseLayout.setVerticalGroup(
            BaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BaseLayout.createSequentialGroup()
                .addComponent(panelGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1132, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Base, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 642, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Base, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bntActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntActualizarActionPerformed
                  
        if (!cajaNombreDueno.getText().isEmpty() && !cajaDomicilioNeg.getText().isEmpty() && !cajaColonia.getText().isEmpty()
                && !cajaCorreo.getText().isEmpty() && !cajaTelefono.getText().isEmpty() && !cajaCelular.getText().isEmpty()
                && !cajaRFC.getText().isEmpty() && !cajaCotizacion.getText().isEmpty() && !cajaIVA.getText().isEmpty()
                && !cajaDescGral.getText().isEmpty() && !cajaDescEmp.getText().isEmpty() && !cajaDescInstitPub.getText().isEmpty()
                && !cajaDescPersFis.getText().isEmpty()) 
        {
            actualiza();
            cargarAjustes();
        } else {
            JOptionPane.showMessageDialog(null, "Debe proporcionar los datos obligatorios", "Atención:", JOptionPane.WARNING_MESSAGE);
        }  
       
    }//GEN-LAST:event_bntActualizarActionPerformed

    private void cajaDescPersFisKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaDescPersFisKeyTyped
        char caracter = evt.getKeyChar();
        if (((caracter < '0') || (caracter > '9')) && (caracter != evt.VK_BACK_SPACE)) 
        {
            evt.consume();
        }
        if (cajaDescPersFis.getText().length() >= 3) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaDescPersFisKeyTyped

    private void cajaDescInstitPubKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaDescInstitPubKeyTyped
        char caracter = evt.getKeyChar();
        if (((caracter < '0') || (caracter > '9')) && (caracter != evt.VK_BACK_SPACE)) 
        {
            evt.consume();
        }
        if (cajaDescInstitPub.getText().length() >= 3) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaDescInstitPubKeyTyped

    private void cajaDescEmpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaDescEmpKeyTyped
        char caracter = evt.getKeyChar();
        if (((caracter < '0') || (caracter > '9')) && (caracter != evt.VK_BACK_SPACE)) 
        {
            evt.consume();
        }
        if (cajaDescEmp.getText().length() >= 3) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaDescEmpKeyTyped

    private void cajaDescGralKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaDescGralKeyTyped
        char caracter = evt.getKeyChar();
        if (((caracter < '0') || (caracter > '9')) && (caracter != evt.VK_BACK_SPACE)) 
        {
            evt.consume();
        }
        if (cajaDescGral.getText().length() >= 3) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaDescGralKeyTyped

    private void cajaIVAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaIVAKeyTyped
        char caracter = evt.getKeyChar();

        if(((caracter < '0') || (caracter > '9')) && (caracter != evt.VK_BACK_SPACE) 
                /*&& (caracter !='.')*/)
        {
            evt.consume();
        }
        /*if (caracter=='.' && cajaIVA.getText().contains(".")) 
        {
            evt.consume();            
        }*/
        if (cajaIVA.getText().length() >= 3){
            evt.consume();
        }
    }//GEN-LAST:event_cajaIVAKeyTyped

    private void cajaColoniaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaColoniaKeyTyped
        char caracter = evt.getKeyChar();
        if ((caracter < 'a' || caracter > 'z') && (caracter < 'A' || caracter > 'Z')
                && (caracter != (char) KeyEvent.VK_SPACE) ) {
            evt.consume();
        }
        if (cajaColonia.getText().length() >= 45) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaColoniaKeyTyped

    private void cajaNombreDuenoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaNombreDuenoKeyTyped
        char caracter = evt.getKeyChar();
        if ((caracter < 'a' || caracter > 'z') && (caracter < 'A' || caracter > 'Z')
          && (caracter < 'ñ') && (caracter != (char) KeyEvent.VK_SPACE) ) {
            evt.consume();
        }
        if (cajaNombreDueno.getText().length() >= 45) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaNombreDuenoKeyTyped

    private void cajaDomicilioNegKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaDomicilioNegKeyTyped
        char caracter = evt.getKeyChar();
        if (cajaDomicilioNeg.getText().length() >= 45) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaDomicilioNegKeyTyped

    private void cajaTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaTelefonoKeyTyped
        char caracter = evt.getKeyChar();

        if(((caracter < '0') || (caracter > '9')) && (caracter != evt.VK_BACK_SPACE) 
                && (caracter !='(') && (caracter !=')') && (caracter !=' '))
        {
            evt.consume();
        }
        if ((caracter=='(' && cajaTelefono.getText().contains("("))) 
        {
            evt.consume();            
        }
        if ((caracter==')' && cajaTelefono.getText().contains(")"))) 
        {
            evt.consume();            
        }
        if (cajaTelefono.getText().length() >= 14){
            evt.consume();
        }
    }//GEN-LAST:event_cajaTelefonoKeyTyped

    private void cajaCelularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaCelularKeyTyped
        char caracter = evt.getKeyChar();

        if(((caracter < '0') || (caracter > '9')) && (caracter != evt.VK_BACK_SPACE) 
                && (caracter !='(') && (caracter !=')') && (caracter !=' '))
        {
            evt.consume();
        }
        if ((caracter=='(' && cajaCelular.getText().contains("("))) 
        {
            evt.consume();            
        }
        if ((caracter==')' && cajaCelular.getText().contains(")"))) 
        {
            evt.consume();            
        }
        if (cajaCelular.getText().length() >= 18){
            evt.consume();
        }
        
    }//GEN-LAST:event_cajaCelularKeyTyped

    private void cajaCotizacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaCotizacionKeyTyped
        char caracter = evt.getKeyChar();
        if (cajaCotizacion.getText().length() >= 45) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaCotizacionKeyTyped

    private void cajaRFCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaRFCKeyTyped
        char caracter = evt.getKeyChar();
        if (cajaRFC.getText().length() >= 20 ) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaRFCKeyTyped

    private void cajaCorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaCorreoKeyTyped
        char caracter = evt.getKeyChar();
        
//        if(((caracter < '0') || (caracter > '9')) && ((caracter < 'a') || (caracter > 'z')) &&  
//                ((caracter < 'A') || (caracter > 'Z')) && (caracter != evt.VK_BACK_SPACE) 
//                && (caracter !='(') && (caracter !=')') && (caracter !=' '))
//        {
//            evt.consume();
//        }
        if (cajaCorreo.getText().length() >= 45) {
            cadena = cajaCorreo.getText();
            bandera = verifica(cadena);
            
            evt.consume();
        }
    }//GEN-LAST:event_cajaCorreoKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        backup.generarRespaldo();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Base;
    private javax.swing.JPanel PanelDatosAjustes;
    private javax.swing.JButton bntActualizar;
    public static javax.swing.JTextField cajaCelular;
    public static javax.swing.JTextField cajaColonia;
    public static javax.swing.JTextField cajaCorreo;
    public static javax.swing.JTextArea cajaCotizacion;
    public static javax.swing.JTextField cajaDescEmp;
    public static javax.swing.JTextField cajaDescGral;
    public static javax.swing.JTextField cajaDescInstitPub;
    public static javax.swing.JTextField cajaDescPersFis;
    public static javax.swing.JTextField cajaDomicilioNeg;
    public static javax.swing.JTextField cajaIVA;
    private javax.swing.JScrollPane cajaLeyendaCot;
    public static javax.swing.JTextField cajaNombreDueno;
    public static javax.swing.JTextField cajaRFC;
    public static javax.swing.JTextField cajaTelefono;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelEst10;
    private javax.swing.JLabel labelEst11;
    private javax.swing.JLabel labelEst12;
    private javax.swing.JLabel labelEst13;
    private javax.swing.JLabel labelEst14;
    private javax.swing.JLabel labelEst15;
    private javax.swing.JLabel labelEst16;
    private javax.swing.JLabel labelEst3;
    private javax.swing.JLabel labelEst4;
    private javax.swing.JLabel labelEst5;
    private javax.swing.JLabel labelEst6;
    private javax.swing.JLabel labelEst7;
    private javax.swing.JLabel labelEst8;
    private javax.swing.JLabel labelEst9;
    private javax.swing.JPanel panelAjustes;
    private javax.swing.JPanel panelBotonesAjustes;
    private javax.swing.JPanel panelDescuentos;
    private javax.swing.JDesktopPane panelGeneral;
    // End of variables declaration//GEN-END:variables
}
