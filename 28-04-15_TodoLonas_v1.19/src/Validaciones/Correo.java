package Validaciones;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
*@Ingeniero: Gerardo Rosales Hernández
*@Propósito: Verificar que el campo recibido es un correo
*/

public class Correo {
        
    public static boolean verifica(String recibido)  
    {
        Pattern pat = Pattern.compile("^[ñÑ\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9ñÑ]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
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
        System.out.println(verifica("añoNuevo@outlook.com"));
    } 
}
