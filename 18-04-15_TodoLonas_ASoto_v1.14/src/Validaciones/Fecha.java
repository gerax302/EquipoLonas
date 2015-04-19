package Validaciones;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
*@Ingeniero: Gerardo Rosales Hernández
*@Propósito: Verificar que el campo recibido es una fecha con formato d/m/y
*/

public class Fecha {
        
    //Formato (dd/MM/yyyy):
    public static boolean verifica(String recibido)  
    {
        String exp ="^(?:(?:0?[1-9]|1\\d|2[0-8])(\\/|-)(?:0?[1-9]|1[0-2]))(\\/|-)(?:[1-9]\\d\\d\\d|\\d[1-9]\\d\\d|\\d\\d[1-9]\\d|\\d\\d\\d[1-9])$|^(?:(?:31(\\/|-)(?:0?[13578]|1[02]))|(?:(?:29|30)(\\/|-)(?:0?[1,3-9]|1[0-2])))(\\/|-)(?:[1-9]\\d\\d\\d|\\d[1-9]\\d\\d|\\d\\d[1-9]\\d|\\d\\d\\d[1-9])$|^(29(\\/|-)0?2)(\\/|-)(?:(?:0[48]00|[13579][26]00|[2468][048]00)|(?:\\d\\d)?(?:0[48]|[2468][048]|[13579][26]))$" ; 
        Pattern pat = Pattern.compile(exp);
         Matcher mat = pat.matcher(recibido);
         if (mat.matches()) 
         {
             return true;
         } 
         else 
         {
             return false;
         } 
    }
    
    public static void main(String[] args)
    {
        System.out.println(verifica("28/2/2015"));
    } 
}
