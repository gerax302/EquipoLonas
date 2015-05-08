package TodoLonas;
import Reloj.Reloj;
import java.text.DateFormat;
import java.util.Calendar; 
import java.util.Date; 
import java.util.GregorianCalendar; 
import javax.swing.JLabel;

public class Logo extends javax.swing.JPanel {
    
    public static int nivel=0,bandera=0, aux_id=0;
    public static String fecha_b="";      
    
    public Logo() {
        initComponents();
        inicializaReloj();
    }

    public void inicializaReloj()
    {   
        fecha_actual();
        Reloj reloj = new Reloj(0, 0, 0, 0);
        //(0,0,0,0 ya que el layout es x defecto) 
        //Si no aquí es donde dan locación y tamaño 
        reloj.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);//Centrado del texto 
        reloj.setFont(new java.awt.Font("Arial", 1, 50));//tipo de letra y tamaño 
        hora.setBounds(0, 0, 200, 100);//Tamaño 
        hora.add(reloj);//Agregado del reloj 
        hora.setVisible(true);//Lo hacemos visible     
    }
    
    public void fecha_actual()
    {
        Calendar c = GregorianCalendar.getInstance();
        int n=c.get(Calendar.DAY_OF_WEEK);
        String dia_sem="";
        if(n==1){ dia_sem="Domingo";}
        else if(n==2){dia_sem="Lunes";}
        else if(n==3){dia_sem="Martes";}
        else if(n==4){dia_sem="Miércoles";}
        else if(n==5){dia_sem="Jueves";}
        else if(n==6){dia_sem="Viernes";}
        else if(n==7){dia_sem="Sábado";}
        String dia = "" + c.get(Calendar.DAY_OF_MONTH);
        int mes =c.get(Calendar.MONTH) + 1;
        String mess="";
        if(mes==1){ mess="Enero";}
        else if(mes==2){mess="Febrero";}
        else if(mes==3){mess="Marzo";}
        else if(mes==4){mess="Abril";}
        else if(mes==5){mess="Mayo";}
        else if(mes==6){mess="Junio";}
        else if(mes==7){mess="Julio";}
        else if(mes==8){mess="Agosto";}
        else if(mes==9){mess="Septiembre";}
        else if(mes==10){mess="Octubre";}
        else if(mes==11){mess="Noviembre";}
        else if(mes==12){mess="Diciembre";}
        
        String anio = "" + c.get(Calendar.YEAR);
        //Sábao, 25 de mayo de 2013
        fecha_b = dia_sem+", "+ dia + " de " + mess + " de " + anio;
        fecha.setText(fecha_b);
    }      
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        hora = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        fecha = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        hora.setBackground(new java.awt.Color(62, 64, 149));
        hora.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/todo lonas grande.png"))); // NOI18N

        fecha.setBackground(new java.awt.Color(0, 0, 0));
        fecha.setFont(new java.awt.Font("Eras Light ITC", 1, 36)); // NOI18N
        fecha.setForeground(new java.awt.Color(0, 175, 239));
        fecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 792, Short.MAX_VALUE)
                    .addComponent(fecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(hora, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(hora, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fecha;
    private javax.swing.JPanel hora;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
