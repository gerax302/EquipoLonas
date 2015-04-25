package Notificaciones;

import java.util.Timer;
import java.util.TimerTask;

class Launcher extends TimerTask
{
    Timer temporizador;
    int contador=0, duracion=6, topeEventos=3;
    
    Pruebas p = new Pruebas();
   
    
    //primer método al ejecutar el Launcher
    public void programar(int duracion)
    { 
        temporizador = new Timer();
        // Ejecutar dentro de param1 cada milisegundos, repetir param2 cada 3 segundos
        temporizador.scheduleAtFixedRate(this, duracion*1000, duracion*1000);
        this.duracion = duracion;       
    }
    
    public void run()
    {
        contador++;
        System.out.println("Ejecución [Hilo]" + contador);
        p.mostrarAlerta();
        // Poner a dormir la cantidad en segundos, como si fuera una tarea demasiado larga
        try
        {
            Thread.sleep(4*1000);
        }
        catch (InterruptedException ie)
        {
            System.out.println("Error [X]: "+ie.getCause().toString());
        }
        if (contador == topeEventos)
        {
            this.detener();
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
        t.programar(6);
    }
    
}