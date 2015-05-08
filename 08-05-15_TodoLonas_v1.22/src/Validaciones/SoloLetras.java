package Validaciones;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
*@Ingeniero: Gerardo Rosales Hernández
*@Propósito: Verificar que el campo recibido contiene unicamente letras
*/

public class SoloLetras {
        
    public static boolean verifica(String recibido)  
    {
        Pattern pat = Pattern.compile("[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+");
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
        System.out.println(verifica("liz"));
    } 
}
