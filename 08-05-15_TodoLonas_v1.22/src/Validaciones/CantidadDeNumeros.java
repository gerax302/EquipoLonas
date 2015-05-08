package Validaciones;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
*@Ingeniero: Gerardo Rosales Hernández
*@Propósito: Verificar que el campo recibido contiene una cierta cantidad de números
*/

public class CantidadDeNumeros {
        
    public static boolean verifica(String recibido, int minimo, int maximo)  
    {
        String exp = "[0-9]{"+minimo+","+maximo+"}";
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
        System.out.println(verifica("345", 3,5));
    } 
}
