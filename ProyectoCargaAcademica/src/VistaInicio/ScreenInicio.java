package VistaInicio;

import Controlador.Conexion;
import static Controlador.Conexion.dbName;
import static Controlador.Conexion.login;
import static Controlador.Conexion.password;
import static Controlador.Conexion.servidor;
import Vista.Administrador.VistaConexionBD;
import static Vista.Administrador.VistaConexionBD.txtNombre;
import static Vista.Administrador.VistaConexionBD.txtNombreBD;
import static Vista.Administrador.VistaConexionBD.txtPassword;
import static Vista.Administrador.VistaConexionBD.txtRespuesta;
import VistaInicio.VistaPrincipal;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ScreenInicio extends javax.swing.JFrame {

    HiloProgreso hilo;

    public ScreenInicio() {
        //Método por defecto
        initComponents();
        iniciarSplash();
        //Creamos un objeto HiloProgreso al cual
        //le pasamos por parámetro la barra de progreso
        hilo = new HiloProgreso(progreso);
        //Iniciamos el Hilo
        hilo.start();
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        //obtenemos el tamaño de la ventana  
        Dimension ventana = this.getSize();
        //para centrar la ventana lo hacemos con el siguiente calculo  
        this.setLocation((pantalla.width - ventana.width) / 2, (pantalla.height - ventana.height) / 2);
        //Le damos tamaño y posición a nuestro Frame
//        this.setLocation(400, 200);
        this.setSize(598, 260);

        //Liberamos recursos
        hilo = null;

    }

    public void iniciarSplash() {
        this.getjProgressBar1().setBorderPainted(true);
        this.getjProgressBar1().setForeground(new Color(50, 50, 153, 100));
        this.getjProgressBar1().setStringPainted(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        progreso = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/logo.PNG"))); // NOI18N
        jPanel2.add(jLabel1, java.awt.BorderLayout.CENTER);

        progreso.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                progresoStateChanged(evt);
            }
        });
        jPanel2.add(progreso, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void progresoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_progresoStateChanged
    if (progreso.getValue() == 100) {
        this.dispose();
//Aqui llamamos al JFrame que queremos que aparezca despues
        // VistaPrincipal ini = new VistaPrincipal();
        try {
            //        VistaConexionBD ini = new VistaConexionBD();
//
//        Dimension pantall = Toolkit.getDefaultToolkit().getScreenSize();
//        //obtenemos el tamaño de la ventana  
//        Dimension ventan = ini.getSize();
//        //para centrar la ventana lo hacemos con el siguiente calculo  
//        ini.setLocation((pantall.width - ventan.width) / 2, (pantall.height - ventan.height) / 2);
//        ini.setVisible(true);
            
            servidor = "localhost:3306/" ;
            login = "root";
            password = "";
            dbName = "baadsa0";
         
            try {
                if (Conexion.conectar()) {
                    System.out.println("Conexion Exitosa");

                    
                    VistaLogin VistaLogin = new VistaLogin();
                    VistaLogin.setVisible(true);
             

                } else {
                    System.out.println("Conexion Fallida");
                    
                    VistaConexionBD VistaConexionBD = new VistaConexionBD();
                    VistaConexionBD.setVisible(true);
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
            
            
        } catch (Exception ex) {
            Logger.getLogger(ScreenInicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }// TODO add your handling code here:
}//GEN-LAST:event_progresoStateChanged

//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//
//            public void run() {
//                
//                Principal prin = new Principal();
//                        prin.setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar progreso;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JProgressBar getjProgressBar1() {
        return progreso;
    }
}
