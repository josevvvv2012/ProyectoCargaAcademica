/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocargaacademica;

import UpperEssential.UpperEssentialLookAndFeel;
import UpperEssential.UpperTheme;
import Vista.ScreenInicio;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author negro
 */
public class ProyectoCargaAcademica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
          try {
            UIManager.setLookAndFeel(new UpperEssentialLookAndFeel());

        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        cambioInterfaz();
        ScreenInicio Principal = new ScreenInicio();
        Principal.setVisible(true);

        
        
    }
    
    public static void cambioInterfaz() {
        try {
            UpperEssentialLookAndFeel uelaf = new UpperEssentialLookAndFeel();
            UpperTheme ut = new UpperTheme();
            //ut.setPrimary1(Color.red);
            //ut.setPrimary2(Color.blue); //Color de seleccion
            //ut.setPrimary3(Color.orange); // color cambio de color de boton
            //ut.setSecondary1(Color.green);
            //ut.setSecondary2(Color.LIGHT_GRAY);
            ut.setSecondary3(Color.gray); // Color fondo
            // ut.setBlack(Color.magenta);
            ut.setWhite(Color.white);

            uelaf.setCurrentTheme(ut);
            UIManager.setLookAndFeel(uelaf);

        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

    }
}
