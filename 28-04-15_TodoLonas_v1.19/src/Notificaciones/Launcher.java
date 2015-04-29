package Notificaciones;

import java.util.Timer;
import java.util.TimerTask;

class Launcher extends TimerTask
{
    Timer temporizador;
    int contador=0, topeEventos=3, duracion;
    
    Pruebas p = new Pruebas();
    
    //primer método al ejecutar el Launcher
    public void programar(int duracion)
    { 
        temporizador = new Timer();
       // Dentro de x milisegundos avísame cada y milisegundos 
        temporizador.scheduleAtFixedRate(this, 1*1000, 6*1000);
        this.duracion = duracion;       
    }
    
    public void run()
    {
        contador++;
        if (contador > topeEventos)
        {
            this.detener();
        }
        else
        {
            try
            {
                System.out.println("Ejecución [Hilo]" + contador);
                Pruebas.mostrarAlerta();
                Thread.sleep(10*1000);
            }
            //catch (InterruptedException ie)
            catch (InterruptedException e)
            {
                //System.out.println("Error [X]: "+ie.getMessage().toString());
                System.out.println("IE");
            }
            catch(NullPointerException at)
            {
                System.out.println("salio");
            }
        }
    }
    
    void detener()
    {
        temporizador.cancel();
    }

    public static void main(String[] args) 
    {
        //cantidad de segundos entre cada ejecución
        Launcher t = new Launcher();
        int duracion = 6;
        t.programar(duracion);
    }
    
}