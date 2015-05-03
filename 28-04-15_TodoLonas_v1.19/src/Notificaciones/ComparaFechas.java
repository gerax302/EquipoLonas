package Notificaciones;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ComparaFechas {

    public static Calendar cal=Calendar.getInstance();
    public static SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
    public static String fechaActual = cal.get(cal.DATE)+"-"+ (cal.get(cal.MONTH)+1)+"-"+cal.get(cal.YEAR); 
    //public static String hora = cal.get(cal.HOUR_OF_DAY)+":"+cal.get(cal.MINUTE) ;     
      
    public static String compararFechas(String fechaRecibida)
    {
        int valor = 0;
        String es = "";
        try 
        {
            Date date1 = format.parse(fechaActual);
            Date date2 = format.parse(fechaRecibida);
            if(date1.compareTo(date2)==0)
            {
                //Fechas Iguales, mismo día.
                valor = 0;
                es = "Igual";
            }
            else
            {
                if (date2.compareTo(date1) <= 0) 
                {
                    //Fecha Actual es menor
                    valor = -1;
                    es = "Menor";
                }
                else
                {
                    //Fecha Actual es mayor
                    valor = +1;
                    es = "Mayor";
                }
            }
        }
        catch(ParseException pe)
        {
            System.out.println("Error al comparar las fechas");
        }
        return es;
    }    
    
    public static int diasDiferencia(String fechaRecibida)
    {
        long diferencia = 0;
        try
        {
            Date date1 = format.parse(fechaActual);
            Date date2 = format.parse(fechaRecibida); 
            diferencia = getDateDiff(date1, date2, TimeUnit.DAYS);        
        }
        catch(ParseException pe)
        {
            System.out.println("Error al procesar la información... "+pe);
        }
        int val = Integer.parseInt(diferencia+"");
        return val;
    }     
    
    
    public static String sumaDias(String fechaRecibida)
    {
        String fechaConvertida2 = "";
        Date date2=null;
        try
        {
            Date date1 = format.parse(fechaActual);
            date2 = format.parse(fechaRecibida);             
            //Ssumar un día a la fecha actual
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date2); // Configuramos la fecha que se recibe
            calendar.add(Calendar.DAY_OF_YEAR, 1);  // numero de días a añadir, o restar en caso de días<0
            date2 = calendar.getTime(); // Devuelve el objeto Date con los nuevos días añadidos 
            fechaConvertida2 = cal.get(cal.DATE)+"-"+ (cal.get(cal.MONTH)+1)+"-"+cal.get(cal.YEAR); 
            //Fin codigo para sumar un día a la fecha actual      
            System.out.println("Fecha Hoy:  "+date1);               
        }
        catch (Exception ex) {
            System.out.println("Error al sumar días");
        }
        return date2+"" + "\t"+fechaConvertida2;
    }
    
    public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) 
    {
        long diffInMillies = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
    }
    
    public static void main(String[] args)  
    {
        String fechaParametro = "4-5-2015";
        
        System.out.println("Fecha Actual: "+fechaActual);
        System.out.println("Fecha Recibe: "+fechaParametro);        
        System.out.println("");
        
        System.out.println("Comparando: La Fecha Recibida Es "+compararFechas(fechaParametro));
        System.out.println("");
        
        //System.out.print("Días de diferencia: "+diasDiferencia(fechaParametro));
        System.out.print("Retorna: "+diasDiferencia(fechaParametro));
        System.out.println("");
    }
}
