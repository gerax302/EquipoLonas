package Notificaciones;

import Validaciones.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ComparaFechas {

    public static Calendar cal=Calendar.getInstance();
    public static SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    
    public static String fechaActual = cal.get(cal.DATE)+"/"+ (cal.get(cal.MONTH)+1)+"/"+cal.get(cal.YEAR); 
    public static String hora = cal.get(cal.HOUR_OF_DAY)+":"+cal.get(cal.MINUTE) ;     
      
    
    public static int compararFechas(String fechaRecibida)
    {
        int valor = 0;
        try 
        {
            Date date1 = format.parse(fechaActual);
            Date date2 = format.parse(fechaRecibida);
            if(date1.compareTo(date2)==0)
            {
                //Fechas Iguales, mismo día.
                valor = 0;
            }
            else
            {
                if (date2.compareTo(date1) <= 0) 
                    //Fecha Actual es menor
                    valor = -1;
                else
                //Fecha Actual es mayor
                    valor = +1;
            }
        }
        catch(ParseException pe)
        {
            System.out.println("Error al comparar las fechas");
        }
        return valor;
    }    
    
    public static long diasDiferencia(String fechaRecibida)
    {
        long valor = 0;
        try
        {
            Date date1 = format.parse(fechaActual);
            Date date2 = format.parse(fechaRecibida); 
            valor = getDateDiff(date1, date2, TimeUnit.DAYS);        
        }
        catch(ParseException pe)
        {
            System.out.println("Houston, tenemos problemas: "+pe);
        }
        return valor;
    }     
    
    
    public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) 
    {
        long diffInMillies = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
    }
    
    public static void main(String[] args)  
    {
        String fechaParametro = "1/3/2015";
        
        System.out.println("Fecha Actual: "+fechaActual);
        System.out.println("Fecha Recibe: "+fechaParametro);
        
        System.out.println("");
        
        System.out.print("Comparando: ");
        System.out.println(compararFechas(fechaParametro));
        
        System.out.print("Días de diferencia: ");  
        System.out.println(diasDiferencia(fechaParametro));
    }
}
