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
public class Clase implements Comparable <Clase> {
    public String asig;
    int dia, horaini, horafin, duracion;
   
    
    Clase (String as, int d, int i, int f) {
        asig=as;
        dia=d;
        horaini=i;
        horafin=f;
        duracion=horafin-horaini;
    }
    
    boolean Coincide(Clase c){
            return (dia==c.dia && 
                  ((horaini <= c.horaini && (duracion + c.duracion)> (c.horafin - horaini)) ||
                   (c.horaini <= horaini && (duracion + c.duracion)> (horafin - c.horaini))));
    }
    
    public String hora2String(int h){
        String res; 
        switch (h)
        {
            case  0: res="08:00"; break;
            case  1: res="08:30"; break;
            case  2: res="09:00"; break;
            case  3: res="09:30"; break;
            case  4: res="10:00"; break;
            case  5: res="10:30"; break;
            case  6: res="11:00"; break;
            case  7: res="11:30"; break;
            case  8: res="12:00"; break;
            case  9: res="12:30"; break;
            case 10: res="13:00"; break;
            case 11: res="13:30"; break;
            case 12: res="14:00"; break;
            case 13: res="14:30"; break;
            case 14: res="15:00"; break;
            case 15: res="15:30"; break;
            case 16: res="16:00"; break;
            case 17: res="16:30"; break;
            case 18: res="17:00"; break;
            case 19: res="17:30"; break;
            case 20: res="18:00"; break;
            case 21: res="18:30"; break;
            case 22: res="19:00"; break;
            case 23: res="19:30"; break;
            case 24: res="20:00"; break;
            case 25: res="20:30"; break;
            case 26: res="21:00"; break;
            case 27: res="21:30"; break;
            case 28: res="22:00"; break;
            case 29: res="22:30"; break;
            default: res="23:00"; break;
        }
        return res;
    }
    
    @Override      
    public String toString()
    {
        String res;
        
        switch (dia)
        {
            case 1: res="L ";
                    break;
            case 2: res="M ";
                    break;
            case 3: res="X ";
                    break;
            case 4: res="J ";
                    break;
            case 5: res="V ";
                    break;
            case 6: res="S ";
                    break;
           default: res="D ";
                    break;
        }
        res+=hora2String(horaini)+"-"+hora2String(horafin);
                
        return res;
    }


    @Override
    public int compareTo(Clase c) {
        return  asig.compareTo(c.asig);
    }
}
