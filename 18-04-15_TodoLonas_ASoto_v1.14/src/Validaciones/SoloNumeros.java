package Validaciones;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
*@Ingeniero: Gerardo Rosales Hernández
*@Propósito: Verificar que el campo recibido contiene unicamente números
*/

public class SoloNumeros {
        
    public static boolean verifica(String recibido)  
    {
        Pattern pat = Pattern.compile("[0-9]+");
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
        System.out.println(verifica("23"));
    } 
}
