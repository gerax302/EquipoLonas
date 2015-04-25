package Notificaciones;
    
import nicon.notify.core.Notification;

public class Pruebas 
{
    public static void mostrarAlerta()
    {
        try
        {
            Notification.show("Sistema Todo Lonas ", "Ha ocurrido un error", Notification.ERROR_MESSAGE, Notification.NICON_LIGHT_THEME);
            Notification.show("Sistema Todo Lonas ", "Operación Exitosa", Notification.OK_MESSAGE, Notification.NICON_LIGHT_THEME);
            Notification.show("Sistema Todo Lonas ", "El producto requiere su atención", Notification.WARNING_MESSAGE, Notification.NICON_LIGHT_THEME);
            Notification.show(Notification.UPDATE_ICON_BLUE, "Sistema Todo Lonas ", "Actualice sus datos", Notification.NICON_LIGHT_THEME);
        }
        catch(Exception e)
        {
            System.out.println("Error de alerta: "+e.getCause().toString());
        }
    }
    
    public static void main(String[] args) 
    {
        String prod = "Lona Impresa 20x20";
        String est =  "urgente";
        mostrarAlerta();
    }
    
}
