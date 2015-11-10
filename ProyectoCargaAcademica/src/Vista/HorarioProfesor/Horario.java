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
public class Horario implements Comparable <Horario> {
    Clase[] clases;
    Dia[] dias;
    int totaldias,tiempoEnLaUni,horasmuertas, diasconlahoradelacomidalibre;
    double mediaEntrada,desviacionHoraEntrada,mediasig,desviacionNumAsignaturas;
    
    Horario (Clase[] c){
        clases=c;
        totaldias=0;
        tiempoEnLaUni=0;
        horasmuertas=0;
        mediaEntrada=0; //sumatorio(dia[i].horafin-dia[i].horaini)/totaldias
        desviacionHoraEntrada=0;
        mediasig=0;
        desviacionNumAsignaturas=0;
        diasconlahoradelacomidalibre=0;
        dias = new Dia[7];
        
        for (int i=0; i<7;i++) dias[i]=new Dia();
        
        for (int i=0; i < clases.length; i++)
        {
            dias[clases[i].dia-1].Clase(c[i]);
        }
        
        
        boolean flagcomer=false;     
        
        for (int i=0; i<7;i++)
        {
            if (dias[i].horasDeClase != 0)
            {
                tiempoEnLaUni+=dias[i].tiempoEnLaUni;
                totaldias++;
                mediaEntrada+=dias[i].ini;
                mediasig+=dias[i].numasignaturas;
            }
            
            for (int j=dias[i].ini; j <dias[i].fin; j++)
            {
                if (!dias[i].ocupado[j])
                {
                    dias[i].horasmuertas++;
                    horasmuertas++;
                }
                
                //10->13 y 15->15:30
                for (int k=10; k <= 15; k++)
                {
                    
                    if (!dias[i].ocupado[k])
                    {
                        if (flagcomer) 
                        {
                            dias[i].horapacomer=true;
//                            dias[i].horasmuertas-=2; //No se considera hora muerta comer
                        }
                        else            flagcomer=true;
                    }
                    else flagcomer=false;
                }
                
            }
        }
        
        mediaEntrada/=totaldias;
        mediasig/=totaldias;
        for (int i=0; i<7; i++)
        {
            if (dias[i].horasDeClase!=0)
            {
                desviacionHoraEntrada += (dias[i].ini-mediaEntrada)*(dias[i].ini-mediaEntrada);
                desviacionNumAsignaturas += (dias[i].numasignaturas-mediasig)*(dias[i].numasignaturas-mediasig);
                if (dias[i].horapacomer)
                {
                    diasconlahoradelacomidalibre++;
//                    horasmuertas--;
                }
            }
        }
        desviacionHoraEntrada/= totaldias-1;
        desviacionHoraEntrada=Math.sqrt(desviacionHoraEntrada);
        desviacionNumAsignaturas/= totaldias-1;
        desviacionNumAsignaturas=Math.sqrt(desviacionNumAsignaturas);
    }

    @Override
    public int compareTo(Horario h) 
    { 
        int res = h.diasconlahoradelacomidalibre - diasconlahoradelacomidalibre; 
                
        if (res==0) res= horasmuertas - h.horasmuertas;
        
        if (res==0) res = totaldias - h.totaldias;
        
        if (res==0) res = tiempoEnLaUni - h.tiempoEnLaUni; 
        
        if (res != 0) return res;
        else
        {
            double aux = desviacionHoraEntrada - h.desviacionHoraEntrada;
            
             if      (aux < 0) return -1;
             else if (aux > 0) return  1;
             else
             {
                 
                if (res == 0)
                {
                    aux=desviacionNumAsignaturas-h.desviacionNumAsignaturas;
                    if      (aux < 0) return -1;
                    else if (aux > 0) return  1;
                    else return 0;
                }
                     
            
                return res;
             }
        }
    }
    
}
