package CorteCaja;

//LIBRERIAS NECESARIAS
import Conexion.Conexion;
import TodoLonas.Principal;
import com.toedter.calendar.JCalendar;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Elizabeth
 */
public class PanelCorteCaja extends javax.swing.JPanel 
{ 
 //DECLARACIÓN DE VARIABLES NECESARIAS PARA EL PROCESO DE LA CLASE
    //VARIABLES PARA LA FECHA Y HORA DEL SISTEMA 
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat formato = new SimpleDateFormat ("dd/MM/yy");
    String fechaActual = cal.get(cal.DATE) + "/" + (cal.get(cal.MONTH) + 1) + "/" + cal.get(cal.YEAR);
    String horaActual = cal.get(Calendar.HOUR) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND);
  
    //VARIABLES PARA MOSTRAR EN EL PANEL LOS RESULTADOS DE LAS CONSULTAS E INGRESOS NUEVOS DEL ADMINISTRADOR
    String saldoInicial = "0.0", proveedores = "0.0", salarios = "0.0";
    String otrosGastos = "0.0",  servicios = "0.0",   usuarioCorte = "";
    String folio = "",         anticipos = "0.0",   alContado = "0.0";
    String cheques = "0.0",      vales ="0.0",        saldoFinal ;
   
    //VARIABLES AUXILIARES
    String consulta="",        fechaCalendar,     validaFecha; 
    
    //VARIABLES PARA EL CALCULO DEL CORTE DE CAJA
    double    sFinal,             sInicial,          sueldos;
    double    proveedor,          servicio,          gastos;
    double    abono,              contado,           cheque;
    double    vale;

    public PanelCorteCaja() 
    {
        initComponents();
        //LLAMA EL METODO PARA LIMPIAR TODOS LOS COMPONENTES DEL PANEL AL EJECTURARSE
        limpiarPanel();   
        calFechaConsulta.getDateEditor().setEnabled(false);

    }
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelEst14 = new javax.swing.JLabel();
        Base = new javax.swing.JPanel();
        panelGeneral = new javax.swing.JDesktopPane();
        panelAjustes = new javax.swing.JPanel();
        PanelDatosAjustes = new javax.swing.JPanel();
        panelCorteCaja = new javax.swing.JPanel();
        FolioDeCorte = new javax.swing.JLabel();
        Usuarios = new javax.swing.JLabel();
        Anticipo = new javax.swing.JLabel();
        Fecha = new javax.swing.JLabel();
        etiquetaFolio = new javax.swing.JLabel();
        Salarios = new javax.swing.JLabel();
        AlContado = new javax.swing.JLabel();
        SaldoFinal = new javax.swing.JLabel();
        Hora = new javax.swing.JLabel();
        Cheques = new javax.swing.JLabel();
        lineaDivisoria = new javax.swing.JLabel();
        Vales = new javax.swing.JLabel();
        labelVal = new javax.swing.JLabel();
        $9 = new javax.swing.JLabel();
        labelEst20 = new javax.swing.JLabel();
        labelEst21 = new javax.swing.JLabel();
        labelEst22 = new javax.swing.JLabel();
        labelEst23 = new javax.swing.JLabel();
        labelEst24 = new javax.swing.JLabel();
        $10 = new javax.swing.JLabel();
        labelSalIni = new javax.swing.JLabel();
        labelAlCont = new javax.swing.JLabel();
        labelCheq = new javax.swing.JLabel();
        labelAnt = new javax.swing.JLabel();
        labelSal = new javax.swing.JLabel();
        SaldoInicial = new javax.swing.JLabel();
        etiquetaAnticipos = new javax.swing.JLabel();
        etiquetaHora = new javax.swing.JLabel();
        lineaSumatoria = new javax.swing.JLabel();
        etiquetaUsuario = new javax.swing.JLabel();
        etiquetaSaldoFinal = new javax.swing.JLabel();
        etiquetaVales = new javax.swing.JLabel();
        etiquetaAlContado = new javax.swing.JLabel();
        etiquetaOtrosGastos = new javax.swing.JLabel();
        etiquetaCheques = new javax.swing.JLabel();
        etiquetaSaldoInicial = new javax.swing.JLabel();
        etiquetaFecha = new javax.swing.JLabel();
        labelEst32 = new javax.swing.JLabel();
        $1 = new javax.swing.JLabel();
        $2 = new javax.swing.JLabel();
        $6 = new javax.swing.JLabel();
        $7 = new javax.swing.JLabel();
        $8 = new javax.swing.JLabel();
        Proveedores = new javax.swing.JLabel();
        Servicios = new javax.swing.JLabel();
        OtrosGastos = new javax.swing.JLabel();
        $3 = new javax.swing.JLabel();
        $4 = new javax.swing.JLabel();
        $5 = new javax.swing.JLabel();
        labelOtrGas = new javax.swing.JLabel();
        labelSer = new javax.swing.JLabel();
        labelProv = new javax.swing.JLabel();
        labelEst43 = new javax.swing.JLabel();
        labelEst42 = new javax.swing.JLabel();
        labelEst41 = new javax.swing.JLabel();
        etiquetaSalarios = new javax.swing.JLabel();
        etiquetaProveedores = new javax.swing.JLabel();
        etiquetaServicios = new javax.swing.JLabel();
        labelHora1 = new javax.swing.JLabel();
        panelConsultas = new javax.swing.JPanel();
        FechaDeConsultas = new javax.swing.JLabel();
        calFechaConsulta = new com.toedter.calendar.JDateChooser();
        panelDatosIniciales = new javax.swing.JPanel();
        cajaSaldoInicial = new javax.swing.JTextField();
        DISaldoInicial = new javax.swing.JLabel();
        labelEst1 = new javax.swing.JLabel();
        DIProveedores = new javax.swing.JLabel();
        cajaSalarios = new javax.swing.JTextField();
        bntAgregar = new javax.swing.JButton();
        labelEst2 = new javax.swing.JLabel();
        $12 = new javax.swing.JLabel();
        $11 = new javax.swing.JLabel();
        DISalarios = new javax.swing.JLabel();
        DIOtrosGastos = new javax.swing.JLabel();
        DIServicios = new javax.swing.JLabel();
        cajaProveedores = new javax.swing.JTextField();
        $13 = new javax.swing.JLabel();
        cajaServicios = new javax.swing.JTextField();
        $14 = new javax.swing.JLabel();
        cajaOtrosGastos = new javax.swing.JTextField();
        $15 = new javax.swing.JLabel();
        panelBotonesAjustes = new javax.swing.JPanel();
        bntCorteCaja = new javax.swing.JButton();
        bntCancelar = new javax.swing.JButton();
        bntConsultas = new javax.swing.JButton();

        labelEst14.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        labelEst14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/star.png"))); // NOI18N

        panelGeneral.setBackground(new java.awt.Color(255, 255, 255));

        panelAjustes.setBackground(new java.awt.Color(62, 64, 149));

        PanelDatosAjustes.setBackground(new java.awt.Color(255, 255, 255));
        PanelDatosAjustes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelCorteCaja.setBackground(new java.awt.Color(255, 255, 255));
        panelCorteCaja.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Corte de Caja", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        panelCorteCaja.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        FolioDeCorte.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        FolioDeCorte.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        FolioDeCorte.setText("Folio de Corte:");
        panelCorteCaja.add(FolioDeCorte, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 110, -1));

        Usuarios.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Usuarios.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Usuarios.setText("Usuario:");
        panelCorteCaja.add(Usuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 90, -1));

        Anticipo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Anticipo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Anticipo.setText("Anticipos:");
        panelCorteCaja.add(Anticipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, 130, -1));

        Fecha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Fecha.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Fecha.setText("Fecha: ");
        panelCorteCaja.add(Fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 50, 20));

        etiquetaFolio.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        etiquetaFolio.setForeground(new java.awt.Color(0, 175, 239));
        etiquetaFolio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        panelCorteCaja.add(etiquetaFolio, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 130, 20));

        Salarios.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Salarios.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Salarios.setText("Salarios:");
        panelCorteCaja.add(Salarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 130, 20));

        AlContado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        AlContado.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        AlContado.setText("Al Contado:");
        panelCorteCaja.add(AlContado, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, 130, -1));

        SaldoFinal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        SaldoFinal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        SaldoFinal.setText("Saldo Final:");
        panelCorteCaja.add(SaldoFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 500, 120, 20));

        Hora.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Hora.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Hora.setText("Hora:");
        panelCorteCaja.add(Hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 40, 20));

        Cheques.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Cheques.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Cheques.setText("Cheques:");
        panelCorteCaja.add(Cheques, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 370, 130, 20));

        lineaDivisoria.setBackground(new java.awt.Color(0, 0, 0));
        lineaDivisoria.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lineaDivisoria.setForeground(new java.awt.Color(0, 175, 239));
        lineaDivisoria.setText("_____________________________________");
        lineaDivisoria.setAutoscrolls(true);
        panelCorteCaja.add(lineaDivisoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 490, 40));

        Vales.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Vales.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Vales.setText("Vales:");
        panelCorteCaja.add(Vales, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 400, 130, 20));

        labelVal.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelVal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/checks-icon.png"))); // NOI18N
        panelCorteCaja.add(labelVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, -1, -1));

        $9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        $9.setForeground(new java.awt.Color(224, 0, 0));
        $9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cur_dollar.png"))); // NOI18N
        panelCorteCaja.add($9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 400, -1, -1));

        labelEst20.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelEst20.setForeground(new java.awt.Color(224, 0, 1));
        labelEst20.setText("(-)");
        panelCorteCaja.add(labelEst20, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, -1, -1));

        labelEst21.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelEst21.setForeground(new java.awt.Color(0, 153, 0));
        labelEst21.setText("(+)");
        panelCorteCaja.add(labelEst21, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, -1, -1));

        labelEst22.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelEst22.setForeground(new java.awt.Color(0, 153, 0));
        labelEst22.setText("(+)");
        panelCorteCaja.add(labelEst22, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 340, -1, -1));

        labelEst23.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelEst23.setForeground(new java.awt.Color(0, 153, 0));
        labelEst23.setText("(+)");
        panelCorteCaja.add(labelEst23, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 370, -1, -1));

        labelEst24.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelEst24.setForeground(new java.awt.Color(0, 153, 0));
        labelEst24.setText("(+)");
        panelCorteCaja.add(labelEst24, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 400, -1, -1));

        $10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        $10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/49 (1).png"))); // NOI18N
        panelCorteCaja.add($10, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 490, -1, 30));

        labelSalIni.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelSalIni.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/money-icon (2).png"))); // NOI18N
        panelCorteCaja.add(labelSalIni, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        labelAlCont.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelAlCont.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cash-icon.png"))); // NOI18N
        panelCorteCaja.add(labelAlCont, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, -1, -1));

        labelCheq.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelCheq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/credit-card-icon (1).png"))); // NOI18N
        panelCorteCaja.add(labelCheq, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, -1, -1));

        labelAnt.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelAnt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Invoice-icon.png"))); // NOI18N
        panelCorteCaja.add(labelAnt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, -1));

        labelSal.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelSal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/payment-icon.png"))); // NOI18N
        panelCorteCaja.add(labelSal, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 30, 30));

        SaldoInicial.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        SaldoInicial.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        SaldoInicial.setText("Saldo Inicial:");
        panelCorteCaja.add(SaldoInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 130, 20));

        etiquetaAnticipos.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        etiquetaAnticipos.setForeground(new java.awt.Color(0, 175, 239));
        etiquetaAnticipos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        panelCorteCaja.add(etiquetaAnticipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 310, 130, 20));

        etiquetaHora.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        etiquetaHora.setForeground(new java.awt.Color(0, 175, 239));
        panelCorteCaja.add(etiquetaHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 130, 20));

        lineaSumatoria.setBackground(new java.awt.Color(0, 0, 0));
        lineaSumatoria.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lineaSumatoria.setForeground(new java.awt.Color(0, 175, 239));
        lineaSumatoria.setText("__________________________");
        lineaSumatoria.setAutoscrolls(true);
        panelCorteCaja.add(lineaSumatoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 450, 290, 20));

        etiquetaUsuario.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        etiquetaUsuario.setForeground(new java.awt.Color(0, 175, 239));
        etiquetaUsuario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        panelCorteCaja.add(etiquetaUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 130, 20));

        etiquetaSaldoFinal.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        etiquetaSaldoFinal.setForeground(new java.awt.Color(62, 64, 149));
        etiquetaSaldoFinal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        panelCorteCaja.add(etiquetaSaldoFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 490, 130, 20));

        etiquetaVales.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        etiquetaVales.setForeground(new java.awt.Color(0, 175, 239));
        etiquetaVales.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        panelCorteCaja.add(etiquetaVales, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 400, 130, 20));

        etiquetaAlContado.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        etiquetaAlContado.setForeground(new java.awt.Color(0, 175, 239));
        etiquetaAlContado.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        panelCorteCaja.add(etiquetaAlContado, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 340, 130, 20));

        etiquetaOtrosGastos.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        etiquetaOtrosGastos.setForeground(new java.awt.Color(0, 175, 239));
        etiquetaOtrosGastos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        panelCorteCaja.add(etiquetaOtrosGastos, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 280, 130, 20));

        etiquetaCheques.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        etiquetaCheques.setForeground(new java.awt.Color(0, 175, 239));
        etiquetaCheques.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        panelCorteCaja.add(etiquetaCheques, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 370, 130, 20));

        etiquetaSaldoInicial.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        etiquetaSaldoInicial.setForeground(new java.awt.Color(0, 175, 239));
        etiquetaSaldoInicial.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        panelCorteCaja.add(etiquetaSaldoInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, 130, 20));

        etiquetaFecha.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        etiquetaFecha.setForeground(new java.awt.Color(0, 175, 239));
        panelCorteCaja.add(etiquetaFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, 130, 20));

        labelEst32.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelEst32.setForeground(new java.awt.Color(224, 0, 0));
        labelEst32.setText("(-)");
        panelCorteCaja.add(labelEst32, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, -1, -1));

        $1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        $1.setForeground(new java.awt.Color(224, 0, 0));
        $1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cur_dollar.png"))); // NOI18N
        panelCorteCaja.add($1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, -1, -1));

        $2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        $2.setForeground(new java.awt.Color(224, 0, 0));
        $2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cur_dollar.png"))); // NOI18N
        panelCorteCaja.add($2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, -1, -1));

        $6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        $6.setForeground(new java.awt.Color(224, 0, 0));
        $6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cur_dollar.png"))); // NOI18N
        panelCorteCaja.add($6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 310, -1, -1));

        $7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        $7.setForeground(new java.awt.Color(224, 0, 0));
        $7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cur_dollar.png"))); // NOI18N
        panelCorteCaja.add($7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 340, -1, -1));

        $8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        $8.setForeground(new java.awt.Color(224, 0, 0));
        $8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cur_dollar.png"))); // NOI18N
        panelCorteCaja.add($8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 370, -1, -1));

        Proveedores.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Proveedores.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Proveedores.setText("Proveedores:");
        panelCorteCaja.add(Proveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 130, -1));

        Servicios.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Servicios.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Servicios.setText("Servicios:");
        panelCorteCaja.add(Servicios, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 130, -1));

        OtrosGastos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        OtrosGastos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        OtrosGastos.setText("Otros gastos:");
        panelCorteCaja.add(OtrosGastos, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 130, 20));

        $3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        $3.setForeground(new java.awt.Color(224, 0, 0));
        $3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cur_dollar.png"))); // NOI18N
        panelCorteCaja.add($3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, -1, -1));

        $4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        $4.setForeground(new java.awt.Color(224, 0, 0));
        $4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cur_dollar.png"))); // NOI18N
        panelCorteCaja.add($4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, -1, -1));

        $5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        $5.setForeground(new java.awt.Color(224, 0, 0));
        $5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cur_dollar.png"))); // NOI18N
        panelCorteCaja.add($5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, -1, -1));

        labelOtrGas.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelOtrGas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Money-icon.png"))); // NOI18N
        panelCorteCaja.add(labelOtrGas, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, -1));

        labelSer.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelSer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Bank-Check-icon.png"))); // NOI18N
        panelCorteCaja.add(labelSer, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));

        labelProv.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelProv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Proveedor.png"))); // NOI18N
        panelCorteCaja.add(labelProv, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));

        labelEst43.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelEst43.setForeground(new java.awt.Color(224, 0, 1));
        labelEst43.setText("(-)");
        panelCorteCaja.add(labelEst43, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, -1, -1));

        labelEst42.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelEst42.setForeground(new java.awt.Color(224, 0, 1));
        labelEst42.setText("(-)");
        panelCorteCaja.add(labelEst42, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, -1, -1));

        labelEst41.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelEst41.setForeground(new java.awt.Color(224, 0, 1));
        labelEst41.setText("(-)");
        panelCorteCaja.add(labelEst41, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, -1, -1));

        etiquetaSalarios.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        etiquetaSalarios.setForeground(new java.awt.Color(0, 175, 239));
        etiquetaSalarios.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        panelCorteCaja.add(etiquetaSalarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, 130, 20));

        etiquetaProveedores.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        etiquetaProveedores.setForeground(new java.awt.Color(0, 175, 239));
        etiquetaProveedores.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        panelCorteCaja.add(etiquetaProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 220, 130, 20));

        etiquetaServicios.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        etiquetaServicios.setForeground(new java.awt.Color(0, 175, 239));
        etiquetaServicios.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        panelCorteCaja.add(etiquetaServicios, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, 130, 20));
        panelCorteCaja.add(labelHora1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, 130, 20));

        PanelDatosAjustes.add(panelCorteCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 520, 560));
        panelCorteCaja.getAccessibleContext().setAccessibleName("Datos Generales");

        panelConsultas.setBackground(new java.awt.Color(255, 255, 255));
        panelConsultas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consultas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        panelConsultas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        FechaDeConsultas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        FechaDeConsultas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        FechaDeConsultas.setText("Fecha de Consulta:");
        panelConsultas.add(FechaDeConsultas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 130, -1));
        panelConsultas.add(calFechaConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 180, -1));

        PanelDatosAjustes.add(panelConsultas, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 330, 330, 250));

        panelDatosIniciales.setBackground(new java.awt.Color(255, 255, 255));
        panelDatosIniciales.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Iniciales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        panelDatosIniciales.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cajaSaldoInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaSaldoInicialKeyTyped(evt);
            }
        });
        panelDatosIniciales.add(cajaSaldoInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, 60, -1));

        DISaldoInicial.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        DISaldoInicial.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        DISaldoInicial.setText("Saldo Inicial:");
        panelDatosIniciales.add(DISaldoInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 130, -1));

        labelEst1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        labelEst1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/star.png"))); // NOI18N
        panelDatosIniciales.add(labelEst1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        DIProveedores.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        DIProveedores.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        DIProveedores.setText("Proveedores:");
        panelDatosIniciales.add(DIProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 130, -1));

        cajaSalarios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaSalariosKeyTyped(evt);
            }
        });
        panelDatosIniciales.add(cajaSalarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 60, -1));

        bntAgregar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bntAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/coin-add-icon (1).png"))); // NOI18N
        bntAgregar.setText("Agregar");
        bntAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntAgregarActionPerformed(evt);
            }
        });
        panelDatosIniciales.add(bntAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 110, -1));

        labelEst2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        labelEst2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/star.png"))); // NOI18N
        panelDatosIniciales.add(labelEst2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        $12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        $12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/49 (1).png"))); // NOI18N
        panelDatosIniciales.add($12, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, -1, -1));

        $11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        $11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/49 (1).png"))); // NOI18N
        panelDatosIniciales.add($11, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, -1, -1));

        DISalarios.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        DISalarios.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        DISalarios.setText("Salarios:             ");
        panelDatosIniciales.add(DISalarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 130, -1));

        DIOtrosGastos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        DIOtrosGastos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        DIOtrosGastos.setText("Otros gastos:");
        panelDatosIniciales.add(DIOtrosGastos, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 130, -1));

        DIServicios.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        DIServicios.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        DIServicios.setText("Servicios:");
        panelDatosIniciales.add(DIServicios, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 130, -1));

        cajaProveedores.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaProveedoresKeyTyped(evt);
            }
        });
        panelDatosIniciales.add(cajaProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 60, -1));

        $13.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        $13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/49 (1).png"))); // NOI18N
        panelDatosIniciales.add($13, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, -1, -1));

        cajaServicios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaServiciosKeyTyped(evt);
            }
        });
        panelDatosIniciales.add(cajaServicios, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 60, -1));

        $14.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        $14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/49 (1).png"))); // NOI18N
        panelDatosIniciales.add($14, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, -1, -1));

        cajaOtrosGastos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaOtrosGastosKeyTyped(evt);
            }
        });
        panelDatosIniciales.add(cajaOtrosGastos, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 60, -1));

        $15.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        $15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/49 (1).png"))); // NOI18N
        panelDatosIniciales.add($15, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, -1, -1));

        PanelDatosAjustes.add(panelDatosIniciales, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, 330, 290));

        javax.swing.GroupLayout panelAjustesLayout = new javax.swing.GroupLayout(panelAjustes);
        panelAjustes.setLayout(panelAjustesLayout);
        panelAjustesLayout.setHorizontalGroup(
            panelAjustesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAjustesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelDatosAjustes, javax.swing.GroupLayout.DEFAULT_SIZE, 916, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelAjustesLayout.setVerticalGroup(
            panelAjustesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAjustesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelDatosAjustes, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelBotonesAjustes.setBackground(new java.awt.Color(62, 64, 149));

        bntCorteCaja.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bntCorteCaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cash-register-icon.png"))); // NOI18N
        bntCorteCaja.setText("Corte Caja");
        bntCorteCaja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bntCorteCajaMouseClicked(evt);
            }
        });

        bntCancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bntCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancel.png"))); // NOI18N
        bntCancelar.setText("Cancelar");
        bntCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCancelarActionPerformed(evt);
            }
        });

        bntConsultas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bntConsultas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Sales-by-payment-method-icon.png"))); // NOI18N
        bntConsultas.setText("Consulta");
        bntConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntConsultasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBotonesAjustesLayout = new javax.swing.GroupLayout(panelBotonesAjustes);
        panelBotonesAjustes.setLayout(panelBotonesAjustesLayout);
        panelBotonesAjustesLayout.setHorizontalGroup(
            panelBotonesAjustesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesAjustesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBotonesAjustesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bntCorteCaja, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                    .addComponent(bntCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(panelBotonesAjustesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelBotonesAjustesLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(bntConsultas, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        panelBotonesAjustesLayout.setVerticalGroup(
            panelBotonesAjustesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesAjustesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bntCorteCaja)
                .addGap(76, 76, 76)
                .addComponent(bntCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelBotonesAjustesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelBotonesAjustesLayout.createSequentialGroup()
                    .addGap(65, 65, 65)
                    .addComponent(bntConsultas)
                    .addContainerGap(511, Short.MAX_VALUE)))
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
            .addGroup(BaseLayout.createSequentialGroup()
                .addComponent(panelGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        BaseLayout.setVerticalGroup(
            BaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGeneral)
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
            .addGap(0, 650, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Base, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void corte()
    {
//ESTE MÉTODO OBTIENE TODOS LOS VALORES NECESARIAS PARA HACER LA INSERCION EN LA BASE DE DATOS 
        Connection con = null;
        try 
        {
            //DATOS NECESARIOS PARA LA CONECCION DE LA BD
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://"+Conexion.nombreServidor+":"+Conexion.puerto+"/"+Conexion.nombreBD;
            con = DriverManager.getConnection(url, Conexion.usuarioBD, Conexion.contrasena);
            //CONSULTA DE INSERCION EN LA TABLA CORTECAJA
            String query =  "INSERT INTO corteCaja "
                          + "(usuario,       fechaCorte,   horaCorte, "
                          + " saldoInicial,  salarios,     proveedores, "
                          + " servicios,     otrosGastos,  anticipos, "
                          + " alContado,     cheques,      vales, "
                          + " saldoFinal)    VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
           //OBTENCION DE LOS VALORES DEL PANEL
            PreparedStatement ps;
            ps = con.prepareStatement(query);
            ps.setString(1, etiquetaUsuario.getText());
            ps.setString(2, etiquetaFecha.getText());
            ps.setString(3, etiquetaHora.getText());
            ps.setString(4, etiquetaSaldoInicial.getText()); 
            ps.setString(5, etiquetaSalarios.getText()); 
            ps.setString(6, etiquetaProveedores.getText());
            ps.setString(7, etiquetaServicios.getText()); 
            ps.setString(8, etiquetaOtrosGastos.getText()); 
            ps.setString(9, etiquetaAnticipos.getText());
            ps.setString(10,etiquetaAlContado.getText());
            ps.setString(11,etiquetaCheques.getText());
            ps.setString(12,etiquetaVales.getText());
            ps.setString(13, etiquetaSaldoFinal.getText()); 
                       
            if(ps.executeUpdate()== 1)
            {
                JOptionPane.showMessageDialog(null, "Operación Exitosa", "Mensaje:", JOptionPane.INFORMATION_MESSAGE);
                limpiarPanel();
            }
            else
                JOptionPane.showMessageDialog(null, "Operación Fallida", "Mensaje:", JOptionPane.ERROR_MESSAGE);
            con.close();
        } 
        catch (ClassNotFoundException | SQLException e) 
        {
            System.out.println("Error: "+e.getMessage());
        }
    }
    
    public void limpiarPanel()
    {
//METODO QUE LIMPIA TODOS LOS COMPONENTES
        this.etiquetaFolio.setText("");
        this.etiquetaUsuario.setText("");
        this.etiquetaFecha.setText("");
        this.etiquetaHora.setText("");
        this.etiquetaSaldoInicial.setText("");
        this.etiquetaSalarios.setText("");
        this.etiquetaProveedores.setText("");
        this.etiquetaServicios.setText("");
        this.etiquetaOtrosGastos.setText("");
        
        this.etiquetaAnticipos.setText("");
        this.etiquetaAlContado.setText("");
        this.etiquetaCheques.setText("");
        this.etiquetaVales.setText("");        
        
        this.etiquetaSaldoFinal.setText("");
        
        this.cajaSaldoInicial.setText("");
        this.cajaSalarios.setText("");
        this.cajaProveedores.setText("");
        this.cajaServicios.setText("");
        this.cajaOtrosGastos.setText("");
        
        this.bntCorteCaja.setEnabled(false);
        this.bntAgregar.setEnabled(true);
        this.bntConsultas.setEnabled(true);
        this.bntCancelar.setEnabled(true);
        this.calFechaConsulta.setEnabled(true);
    }
    
    private void bntCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCancelarActionPerformed
//CANCELARA LAS OPERACIONES Y LIMPIARA EL PANEL
        this.etiquetaFolio.setText("");
        this.etiquetaUsuario.setText("");
        this.etiquetaFecha.setText("");
        this.etiquetaHora.setText("");
        this.etiquetaSaldoInicial.setText("");
        this.etiquetaSalarios.setText("");
        this.etiquetaProveedores.setText("");
        this.etiquetaServicios.setText("");
        this.etiquetaOtrosGastos.setText("");
        
        this.etiquetaAnticipos.setText("");
        this.etiquetaAlContado.setText("");
        this.etiquetaCheques.setText("");
        this.etiquetaVales.setText("");        
        
        this.etiquetaSaldoFinal.setText("");
        
        this.cajaSaldoInicial.setText("");
        this.cajaSalarios.setText("");
        this.cajaProveedores.setText("");
        this.cajaServicios.setText("");
        this.cajaOtrosGastos.setText("");
        
        this.bntCorteCaja.setEnabled(false);
        this.bntAgregar.setEnabled(true);
        this.bntConsultas.setEnabled(true);
        this.bntCancelar.setEnabled(true);
        this.calFechaConsulta.setEnabled(true);
    }//GEN-LAST:event_bntCancelarActionPerformed

    private void bntConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntConsultasActionPerformed
//METODO PARA HACER LA CONSULTA POR FECHA DEL CORTE DE CAJA 
        
        //AQUI SE OBTIENEN EL DIA, MES Y AÑO DEL JCALENDAR DE LA INTERFAZ, GUARDANDOLOS EN SUS VARIABLES 
        int dia = calFechaConsulta.getJCalendar().getDate().getDate();
        int mes = calFechaConsulta.getJCalendar().getDate().getMonth()+1;
        int año = calFechaConsulta.getJCalendar().getDate().getYear()+1900;
        
        fechaCalendar = dia + "/" + mes + "/" + año;
        
        //SI HAY ALGUA SELECCIÓN EN EL CALENDARIO SE EJECUTARA LA CONSULTA
        Connection con = null;
        if( !fechaCalendar.isEmpty())
            {
            try 
            {
                //DATOS PARA LA CONEXION DE LA BASE DE DATOS
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://"+Conexion.nombreServidor+":"+Conexion.puerto+"/"+Conexion.nombreBD;
                con = DriverManager.getConnection(url, Conexion.usuarioBD, Conexion.contrasena);
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from corteCaja where fechaCorte = '" + fechaCalendar + "' ;");
    
                //SI LA CONSULTA ARROJA DATOS ENTONCES SE RECORRE COLOCANDO EN CAJA COMPONENTE UN DATO DE LA TABLA CONSULTADA
                while (rs.next())
                {
                    etiquetaFolio.setText(rs.getString("folioCorteCaja"));
                    etiquetaUsuario.setText(rs.getString("usuario"));
                    etiquetaFecha.setText(rs.getString("fechaCorte"));
                    etiquetaHora.setText(rs.getString("horaCorte"));
                    etiquetaSaldoInicial.setText(rs.getString("saldoInicial"));
                    etiquetaSalarios.setText(rs.getString("salarios"));
                    etiquetaProveedores.setText(rs.getString("proveedores"));
                    etiquetaServicios.setText(rs.getString("servicios"));
                    etiquetaOtrosGastos.setText(rs.getString("otrosGastos"));
                    etiquetaAnticipos.setText(rs.getString("anticipos"));
                    etiquetaAlContado.setText(rs.getString("alContado"));
                    etiquetaCheques.setText(rs.getString("cheques"));
                    etiquetaVales.setText(rs.getString("vales"));
                    etiquetaSaldoFinal.setText(rs.getString("saldoFinal"));       
                }
            } 
            catch (ClassNotFoundException | SQLException e) 
            {
                System.out.println("Error: "+e.getMessage());
            }        
        }        
    }//GEN-LAST:event_bntConsultasActionPerformed

    private void cajaSaldoInicialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaSaldoInicialKeyTyped
      //VALIDACIONES PARA LA CASA SALDO INICLA
        char caracter = evt.getKeyChar();
        if(((caracter < '0') || (caracter > '9')) && (caracter != evt.VK_BACK_SPACE) && (caracter !='.'))
        {
            evt.consume();
        }
        if (caracter=='.' && cajaSaldoInicial.getText().contains(".")) 
        {
            evt.consume();            
        }
        if (cajaSaldoInicial.getText().length() >= 10){
            evt.consume();
        }        
    }//GEN-LAST:event_cajaSaldoInicialKeyTyped

    private void cajaSalariosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaSalariosKeyTyped
       //VALIDACIONES PARA LA CASA SALDO INICLA
        char caracter = evt.getKeyChar();
        if(((caracter < '0') || (caracter > '9')) && (caracter != evt.VK_BACK_SPACE) && (caracter !='.'))
        {
            evt.consume();
        }
        if (caracter=='.' && cajaSalarios.getText().contains(".")) 
        {
            evt.consume();            
        }
        if (cajaSalarios.getText().length() >= 10){
            evt.consume();
        }  
    }//GEN-LAST:event_cajaSalariosKeyTyped

    private void bntAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntAgregarActionPerformed
        //EJECUTAMOS EL EVENTO DEL BOTON AGREGAR
        mostrarIniciales();
    }//GEN-LAST:event_bntAgregarActionPerformed

    public void calculoCorte()
    {       
        //METODO EN EL CUAL SE CALCULA EL CORTE DE CAJA CON LOS DATOS NECESARIOS
        double ganancia =0, perdida =0;
        //SE HACE EL CAST PARA CONVERTIR LOS DATOS STRING EN ENTEROS
        sFinal = 0;
        sInicial=Double.parseDouble(saldoInicial);
        sueldos = Double.parseDouble(salarios);
        proveedor = Double.parseDouble(proveedores);
        servicio = Double.parseDouble(servicios);
        gastos = Double.parseDouble(otrosGastos);
        
        abono = Double.parseDouble(anticipos);
        contado = Double.parseDouble(alContado);
        cheque = Double.parseDouble(cheques);
        vale = Double.parseDouble(vales);
        
        //SE SACA UN VALOR INDEPENDIENTE PARA LOS SALDOS A FAVOR Y OTRO PARA LOS SALDOS NEGATIVOS
        //Y ASI SE PUEDE SACAR LA DIFERENCIA YA SEA POSITIVA O NEGATIVA.
        ganancia = abono + contado + cheque + vale;
        perdida =  sInicial + sueldos + proveedor + servicio + gastos;
        sFinal= ganancia - perdida;
        
        saldoFinal = sFinal+"";//CAST PARA CONVERTIR DE INT A STRING
    }
    
    public void mostrarIniciales()
    {
    //METODO DONDE OBTENEMOS LOS DATOS INICALES DEL PANEL 
    Connection con = null;
    //SI HAY DATOS OBLIGATORIOS VACIOS, SERA NOTIFICADO PARA QUE SEAN LLENADOS. 
        if( !cajaSaldoInicial.getText().isEmpty() && !cajaOtrosGastos.getText().isEmpty() )
            {
                //CONDICIONES PARA SIEMPRE TENER UN VALOR ENTERO QUE EVALUAR EN EL CORTE DE CAJA
                if(cajaSalarios.getText().isEmpty())
                {
                    salarios = "0.0";
                }
                else
                {
                    salarios = cajaSalarios.getText();
                }
                if(cajaProveedores.getText().isEmpty() )
                {
                    proveedores = "0.0";
                }
                else
                {
                    proveedores = cajaProveedores.getText();
                }
                if(cajaServicios.getText().isEmpty())
                {
                    servicios = "0.0";
                }
                else
                {
                    servicios = cajaServicios.getText();
                }
                    try 
                    {
                        //CONEXION CON LA BD
                        Class.forName("com.mysql.jdbc.Driver");
                        String url = "jdbc:mysql://"+Conexion.nombreServidor+":"+Conexion.puerto+"/"+Conexion.nombreBD;
                        con = DriverManager.getConnection(url, Conexion.usuarioBD, Conexion.contrasena);
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery("select ifnull(max(folioCorteCaja), 0) + 1 as folio from corteCaja;");
                        //OBTENCION DE LA CONSULTA
                        while(rs.next())
                        { 
                            folio = rs.getString("folio");
                        }
                    } 
                    catch (ClassNotFoundException | SQLException e) 
                    {
                        System.out.println("Error: "+e.getMessage());
                    }        
        
                    //OBTENCION Y COLOCACION DE LOS DATOS INCIALES
                    saldoInicial = cajaSaldoInicial.getText();

                    otrosGastos = cajaOtrosGastos.getText();
                    usuarioCorte = Principal.usuarioActivo;
        
                    this.etiquetaFolio.setText(folio);
                    this.etiquetaUsuario.setText(usuarioCorte);
                    this.etiquetaFecha.setText(fechaActual);
                    this.etiquetaHora.setText(horaActual);       
                    this.etiquetaSaldoInicial.setText(saldoInicial);
                    this.etiquetaSalarios.setText(salarios);
                    this.etiquetaProveedores.setText(proveedores);
                    this.etiquetaServicios.setText(servicios);
                    this.etiquetaOtrosGastos.setText(otrosGastos);
        
                    //EJECUTAMOS EL METODO PARA HACER CONSULTAS EN LA BASE DE DATOS Y SEGUIR OBTENIENDO DATOS IMPORTANTES PARA EL CORTE
                    datosConsultados();

                    this.bntCancelar.setEnabled(true);
                    this.bntConsultas.setEnabled(false);
                    this.bntAgregar.setEnabled(false);
                    this.bntCorteCaja.setEnabled(true);
                    this.calFechaConsulta.setEnabled(false);
          
                    this.cajaSaldoInicial.setText("");
                    this.cajaSalarios.setText("");
                    this.cajaProveedores.setText("");
                    this.cajaServicios.setText("");
                    this.cajaOtrosGastos.setText("");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Debe proporcionar los datos obligatorios", "Atención:", JOptionPane.WARNING_MESSAGE);            
            }
    }
    
    public void datosConsultados()
    {
        //CONEXION CON LA BASE DE DATOS
        Connection con = null;
         try 
            {
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://"+Conexion.nombreServidor+":"+Conexion.puerto+"/"+Conexion.nombreBD;
                con = DriverManager.getConnection(url, Conexion.usuarioBD, Conexion.contrasena);
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select sum(anticipo) as Anticipos from pedidos where formaPago ='Crédito'and fechaSistema = '" + fechaActual +"'");
               //RESULTADOS DE LA CONSULTA
                while(rs.next())
                { 
                    anticipos = rs.getString("Anticipos");
                    if(anticipos == null)
                    {
                        anticipos = "0.0";
                    }
                }  
            
                rs = st.executeQuery("select sum(total) as AlContado from venta where formaPago = 'Al Contado' and fechaSistema = '" + fechaActual +"'");
                while(rs.next())
                { 
                    alContado = rs.getString("AlContado");
                    if(alContado == null)
                    {
                        alContado ="0.0";
                    }
                } 
            
                rs = st.executeQuery("select sum(total) as Cheques from venta where  formaPago = 'Cheques' and fechaSistema = '" + fechaActual +"'");
                while(rs.next())
                { 
                    cheques = rs.getString("Cheques");
                    if(cheques == null)
                    {
                        cheques = "0.0";
                    }        
                } 
            
                rs = st.executeQuery("select sum(total) as Vales from venta where  formaPago = 'Vales' and fechaSistema = '" + fechaActual +"'");
                while(rs.next())
                { 
                    vales = rs.getString("Vales");
                    if(vales == null)
                    {
                        vales = "0.0";
                    }
                } 
            } 
            catch (ClassNotFoundException | SQLException e) 
            {
                System.out.println("Error: "+e.getMessage());
            }        
            //SE AGREGAN A LOS COMPONENTES LOS DATOS OBTENIDOS EN LA CONSULTA
            this.etiquetaAnticipos.setText(anticipos);
            this.etiquetaAlContado.setText(alContado);
            this.etiquetaCheques.setText(cheques);
            this.etiquetaVales.setText(vales);

            calculoCorte();//EJECUTAMOS EL CALCULO DEL CORTE CON LOS DATOS OBTENIDOS
            this.etiquetaSaldoFinal.setText(saldoFinal);
    }
    
    private void cajaProveedoresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaProveedoresKeyTyped
       //VALIDACION CAJA PROVEEDORES
        char caracter = evt.getKeyChar();
        if(((caracter < '0') || (caracter > '9')) && (caracter != evt.VK_BACK_SPACE) && (caracter !='.'))
        {
            evt.consume();
        }
        if (caracter=='.' && cajaProveedores.getText().contains(".")) 
        {
            evt.consume();            
        }
        if (cajaProveedores.getText().length() >= 10){
            evt.consume();
        }  
    }//GEN-LAST:event_cajaProveedoresKeyTyped

    private void cajaServiciosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaServiciosKeyTyped
       //VALIDACION CAJA SERVICIOS
        char caracter = evt.getKeyChar();
        if(((caracter < '0') || (caracter > '9')) && (caracter != evt.VK_BACK_SPACE) && (caracter !='.'))
        {
            evt.consume();
        }
        if (caracter=='.' && cajaServicios.getText().contains(".")) 
        {
            evt.consume();            
        }
        if (cajaServicios.getText().length() >= 10){
            evt.consume();
        }  
    }//GEN-LAST:event_cajaServiciosKeyTyped

    private void cajaOtrosGastosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaOtrosGastosKeyTyped
       //VALIDACION CAJA OTROS GASTOS
        char caracter = evt.getKeyChar();
        if(((caracter < '0') || (caracter > '9')) && (caracter != evt.VK_BACK_SPACE) && (caracter !='.'))
        {
            evt.consume();
        }
        if (caracter=='.' && cajaOtrosGastos.getText().contains(".")) 
        {
            evt.consume();            
        }
        if (cajaOtrosGastos.getText().length() >= 10){
            evt.consume();
        }  
    }//GEN-LAST:event_cajaOtrosGastosKeyTyped

    public void validaCorte()
    {
        //METODO PARA VALIDAD EL CORTE DE CAJA CON RESPECTO A LA FECHA
        Connection con = null;
         try 
            {
                //CONEXION CON LA BASE DE DATOS
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://"+Conexion.nombreServidor+":"+Conexion.puerto+"/"+Conexion.nombreBD;
                con = DriverManager.getConnection(url, Conexion.usuarioBD, Conexion.contrasena);
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select fechaCorte as Fecha from corteCaja where fechaCorte = '" + fechaActual +"'");
                //ESTA BANDERA ME SIRVE PARA SABER SI PUEDE REALIZARCE EL CORTE DE CAJA O NO, SEGUN EL RESULTADO DE LA CONSULTA
                int banderaFecha = 0;
               
                while(rs.next())
                { 
                    //SI LA CONSULTA ARROJO INFORMACION DE QUE YA HAY UN CORTE DE CAJA DE ESTE DÍA 
                    //ENTONCES NO SE PODRA HACER OTRO CORTE DE CAJA DEL MISMO DIA
                    banderaFecha = 1;
                    validaFecha = rs.getString("Fecha");
                  
                    if(validaFecha == null)
                    {
                            banderaFecha=2;
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "El corte de caja del día de hoy, ya fue realizado", "Atención:", JOptionPane.WARNING_MESSAGE);            
                    }
                } 
                if (banderaFecha == 0)
                {
                    //DE LO CONTRARIO AQUI SE MANDA EJECUTAR EL CORTE.
                    corte();
                }
            } 
            catch (ClassNotFoundException | SQLException e) 
            {
                System.out.println("Error: "+e.getMessage());
            }  
    }
    private void bntCorteCajaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntCorteCajaMouseClicked
       //ANTES DE REALIZAR EL CORTE DE CAJA VALIDAMOS QUE NO HAYA NINGUN CORTE DE CAJA DEL
        //MISMO DIA QUE QUEREMOS REALIZAR.
        validaCorte();
    }//GEN-LAST:event_bntCorteCajaMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel $1;
    private javax.swing.JLabel $10;
    private javax.swing.JLabel $11;
    private javax.swing.JLabel $12;
    private javax.swing.JLabel $13;
    private javax.swing.JLabel $14;
    private javax.swing.JLabel $15;
    private javax.swing.JLabel $2;
    private javax.swing.JLabel $3;
    private javax.swing.JLabel $4;
    private javax.swing.JLabel $5;
    private javax.swing.JLabel $6;
    private javax.swing.JLabel $7;
    private javax.swing.JLabel $8;
    private javax.swing.JLabel $9;
    private javax.swing.JLabel AlContado;
    private javax.swing.JLabel Anticipo;
    private javax.swing.JPanel Base;
    private javax.swing.JLabel Cheques;
    private javax.swing.JLabel DIOtrosGastos;
    private javax.swing.JLabel DIProveedores;
    private javax.swing.JLabel DISalarios;
    private javax.swing.JLabel DISaldoInicial;
    private javax.swing.JLabel DIServicios;
    private javax.swing.JLabel Fecha;
    private javax.swing.JLabel FechaDeConsultas;
    private javax.swing.JLabel FolioDeCorte;
    private javax.swing.JLabel Hora;
    private javax.swing.JLabel OtrosGastos;
    private javax.swing.JPanel PanelDatosAjustes;
    private javax.swing.JLabel Proveedores;
    private javax.swing.JLabel Salarios;
    private javax.swing.JLabel SaldoFinal;
    private javax.swing.JLabel SaldoInicial;
    private javax.swing.JLabel Servicios;
    private javax.swing.JLabel Usuarios;
    private javax.swing.JLabel Vales;
    private javax.swing.JButton bntAgregar;
    private javax.swing.JButton bntCancelar;
    private javax.swing.JButton bntConsultas;
    private javax.swing.JButton bntCorteCaja;
    public static javax.swing.JTextField cajaOtrosGastos;
    public static javax.swing.JTextField cajaProveedores;
    public static javax.swing.JTextField cajaSalarios;
    public static javax.swing.JTextField cajaSaldoInicial;
    public static javax.swing.JTextField cajaServicios;
    public static com.toedter.calendar.JDateChooser calFechaConsulta;
    private javax.swing.JLabel etiquetaAlContado;
    private javax.swing.JLabel etiquetaAnticipos;
    private javax.swing.JLabel etiquetaCheques;
    private javax.swing.JLabel etiquetaFecha;
    private javax.swing.JLabel etiquetaFolio;
    private javax.swing.JLabel etiquetaHora;
    private javax.swing.JLabel etiquetaOtrosGastos;
    private javax.swing.JLabel etiquetaProveedores;
    private javax.swing.JLabel etiquetaSalarios;
    private javax.swing.JLabel etiquetaSaldoFinal;
    private javax.swing.JLabel etiquetaSaldoInicial;
    private javax.swing.JLabel etiquetaServicios;
    private javax.swing.JLabel etiquetaUsuario;
    private javax.swing.JLabel etiquetaVales;
    private javax.swing.JLabel labelAlCont;
    private javax.swing.JLabel labelAnt;
    private javax.swing.JLabel labelCheq;
    private javax.swing.JLabel labelEst1;
    private javax.swing.JLabel labelEst14;
    private javax.swing.JLabel labelEst2;
    private javax.swing.JLabel labelEst20;
    private javax.swing.JLabel labelEst21;
    private javax.swing.JLabel labelEst22;
    private javax.swing.JLabel labelEst23;
    private javax.swing.JLabel labelEst24;
    private javax.swing.JLabel labelEst32;
    private javax.swing.JLabel labelEst41;
    private javax.swing.JLabel labelEst42;
    private javax.swing.JLabel labelEst43;
    private javax.swing.JLabel labelHora1;
    private javax.swing.JLabel labelOtrGas;
    private javax.swing.JLabel labelProv;
    private javax.swing.JLabel labelSal;
    private javax.swing.JLabel labelSalIni;
    private javax.swing.JLabel labelSer;
    private javax.swing.JLabel labelVal;
    private javax.swing.JLabel lineaDivisoria;
    private javax.swing.JLabel lineaSumatoria;
    private javax.swing.JPanel panelAjustes;
    private javax.swing.JPanel panelBotonesAjustes;
    private javax.swing.JPanel panelConsultas;
    private javax.swing.JPanel panelCorteCaja;
    private javax.swing.JPanel panelDatosIniciales;
    private javax.swing.JDesktopPane panelGeneral;
    // End of variables declaration//GEN-END:variables
}
