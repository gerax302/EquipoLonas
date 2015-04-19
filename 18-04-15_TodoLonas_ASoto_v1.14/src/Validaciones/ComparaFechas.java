package Validaciones;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ComparaFechas {

    public static void comparaFechas(String fechaRecibida)
    {
        try
        {
            Calendar cal=Calendar.getInstance();
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            
            String fechaActual = cal.get(cal.DATE)+"/"+ (cal.get(cal.MONTH)+1)+"/"+cal.get(cal.YEAR); 
            String hora = cal.get(cal.HOUR_OF_DAY)+":"+cal.get(cal.MINUTE) ; 

            Date date1 = format.parse(fechaActual);
            Date date2 = format.parse(fechaRecibida);
            
            System.out.println("");
            
            if (date1.compareTo(date2) <= 0) {
                System.out.println("fechaActual es menor a la fechaRecibida");
            }
            else
                System.out.println("fechaActual es mayor a la  fechaRecibida");
        }
        catch(ParseException pe)
        {
            System.out.println("Houston, tenemos problemas: "+pe);
        }    
    }
    
    public static void main(String[] args)  
    {
        comparaFechas("10/03/2015");
    }

}
