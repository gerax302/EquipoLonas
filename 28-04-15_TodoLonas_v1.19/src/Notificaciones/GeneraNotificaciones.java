package Notificaciones;

import nicon.notify.core.Notification;

/**
 * @author Gerardo
 */
public class GeneraNotificaciones 
{
    public static void porEstatus()
    {
    
    }
    
    public static void porFecha()
    {
    
    }
    
    public static void mostrarAlerta()
    {
        try
        {
            Notification.show("Sistema Todo Lonas ", "Existen pedidos retrasados", Notification.ERROR_MESSAGE, Notification.NICON_LIGHT_THEME);
            Notification.show("Sistema Todo Lonas ", "Estás al corriente con tus pedidos", Notification.OK_MESSAGE, Notification.NICON_LIGHT_THEME);
            Notification.show("Sistema Todo Lonas ", "Existen pedidos con fecha de entrega menor a 3 días o en status urgente", Notification.WARNING_MESSAGE, Notification.NICON_LIGHT_THEME);
            //Notification.show(Notification.UPDATE_ICON_BLUE, "Sistema Todo Lonas ", "Actualice sus datos", Notification.NICON_LIGHT_THEME);
        }
        catch(Exception e)
        {
            System.out.println("Error de alerta: "+e.getCause().toString());
        }
    }
    
    public static void main(String[] args) 
    {
        mostrarAlerta();
    }
    
    
}
