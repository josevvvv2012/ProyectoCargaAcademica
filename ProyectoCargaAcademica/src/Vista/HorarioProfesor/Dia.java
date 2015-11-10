/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.HorarioProfesor;

/**
 *
 * @author negro
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author monkey
 */
public class Dia {
    public int ini, fin, horasDeClase, tiempoEnLaUni, numasignaturas,horasmuertas; 
    public double mediainifin;
    
    boolean [] ocupado = new boolean[30];
    public boolean horapacomer;
    
    Dia()
    {
        ini=30;
        fin=0;
        horasDeClase=0;
        tiempoEnLaUni=0;
        horasmuertas=0;
        mediainifin=0;
        numasignaturas=0;
        horapacomer=false;
        for (int i=0; i<30; i++) ocupado[i]=false;
    }
    
    void Clase(Clase c)
    {  
        numasignaturas++;
        
        for (int i=c.horaini; i < c.horafin; i++){
            ocupado[i]=true;
        }
        
        if ((c.horaini < ini) && (c.horafin > fin))
        {
            ini=c.horaini;
            fin=c.horafin;
            horasDeClase += c.duracion;
            tiempoEnLaUni = fin-ini;
        }
        else if (c.horaini < ini)
        {
            ini=c.horaini;
            horasDeClase += c.duracion;
            tiempoEnLaUni = fin-ini;
        }
        else if (c.horafin > fin)
        {
            fin=c.horafin;
            horasDeClase += c.duracion;
            tiempoEnLaUni = fin-ini;
        }
    }
}
