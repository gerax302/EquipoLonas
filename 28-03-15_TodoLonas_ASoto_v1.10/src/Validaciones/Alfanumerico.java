package Validaciones;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
*@Ingeniero: Gerardo Rosales Hernández
*@Propósito: Verificar que el campo recibido contiene unicamente números
*/

public class Alfanumerico {
        
    public static boolean verifica(String recibido)  
    {
        Pattern pat = Pattern.compile("[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s\\w\\-\\.\\,]+");
        //Valida minus, mayus, acentos, ñ ,_, . y -
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
        System.out.println(verifica("María.perez.34_56-1"));
        System.out.println(verifica("ROHG921125HZSRR06_GRH_23.7-1, "));
    } 
}
