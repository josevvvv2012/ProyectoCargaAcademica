/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Administrador;

import Controlador.Conexion;
import VistaInicio.VistaPrincipal;
import static Controlador.Conexion.servidor;
import static Controlador.Conexion.dbName;
import static Controlador.Conexion.login;
import static Controlador.Conexion.password;
import Controlador.ControllerSql;
import VistaInicio.VistaLogin;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Jose Vanegas - jvanegas@ucentral.edu.co
 */
public class VistaConexionBD extends javax.swing.JFrame {

ControllerSql obj;
    
    /**
     * Creates new form InterfazP
     */
    public VistaConexionBD() {
        setUndecorated(true);
        initComponents();
        ValidadCaracteres(txtNombreBD);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnTest = new javax.swing.JButton();
        btnCreaBd = new javax.swing.JButton();
        ComboBoxDrivers = new javax.swing.JComboBox();
        jlSalida = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombreBD = new javax.swing.JTextField();
        txtRespuesta = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        txtServidor = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(102, 255, 255));
        jLabel1.setText("DRIVER");

        jLabel2.setBackground(new java.awt.Color(102, 255, 255));
        jLabel2.setText("USER");

        jLabel3.setBackground(new java.awt.Color(102, 255, 255));
        jLabel3.setText("PASSWORD");

        txtNombre.setBackground(new java.awt.Color(204, 204, 204));
        txtNombre.setText("root");
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        btnTest.setBackground(new java.awt.Color(204, 204, 204));
        btnTest.setText("TEST ");
        btnTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTestActionPerformed(evt);
            }
        });

        btnCreaBd.setBackground(new java.awt.Color(204, 204, 204));
        btnCreaBd.setText("CREAR BASE DE DATOS");
        btnCreaBd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreaBdActionPerformed(evt);
            }
        });

        ComboBoxDrivers.setBackground(new java.awt.Color(204, 204, 204));
        ComboBoxDrivers.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "com.mysql.jdbc.Driver" }));

        jLabel4.setBackground(new java.awt.Color(102, 255, 255));
        jLabel4.setText("NOMBRE BASE DE DATOS");

        txtNombreBD.setBackground(new java.awt.Color(204, 204, 204));
        txtNombreBD.setText("baaa0");

        txtRespuesta.setBackground(new java.awt.Color(102, 255, 102));
        txtRespuesta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtRespuesta.setForeground(new java.awt.Color(255, 0, 0));
        txtRespuesta.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtRespuesta.setText("Esperando Conexion..");

        jLabel5.setText("Diligencia los campos correspondientes como tiene configurado");

        jLabel6.setText("el servicio de base de datos ");

        jLabel7.setText("User y Password");

        jLabel8.setText("@Jose Vanegas");

        txtPassword.setBackground(new java.awt.Color(204, 204, 204));
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        jLabel9.setText("NOMBRE SERVIDOR");

        txtServidor.setText("localhost:3306/");
        txtServidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtServidorActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/minimizar.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cerrar2.png"))); // NOI18N
        jButton3.setText("jButton2");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombreBD)
                                    .addComponent(ComboBoxDrivers, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtServidor)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(81, 81, 81)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPassword)
                                    .addComponent(txtNombre)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(137, 137, 137)
                                .addComponent(jLabel6)
                                .addGap(36, 36, 36)
                                .addComponent(jlSalida))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel9))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(166, 166, 166)
                                .addComponent(jLabel7)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(txtRespuesta)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnTest)
                            .addGap(134, 134, 134)
                            .addComponent(btnCreaBd)
                            .addGap(28, 28, 28))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(68, 68, 68))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboBoxDrivers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtServidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNombreBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreaBd)
                    .addComponent(btnTest))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtRespuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlSalida)
                        .addGap(57, 57, 57)
                        .addComponent(jLabel8))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTestActionPerformed
        // TODO add your handling code here:

        if (ValidarCamposVacios(txtServidor, txtNombre, txtNombreBD)) {
            JOptionPane.showMessageDialog(this, "Faltan datos en los campos.");
        } else {
            servidor = txtServidor.getText();
            login = txtNombre.getText();
            password = txtPassword.getText();
            dbName = txtNombreBD.getText();
            try {
                if (Conexion.conectar()) {
                    txtRespuesta.setText("Conexion Exitosa");

                    VistaPrincipal ini = new VistaPrincipal();

                    Dimension pantall = Toolkit.getDefaultToolkit().getScreenSize();
                    //obtenemos el tamaño de la ventana  
                    Dimension ventan = ini.getSize();
                    //para centrar la ventana lo hacemos con el siguiente calculo  
                    ini.setLocation((pantall.width - ventan.width) / 2, (pantall.height - ventan.height) / 2);
                    ini.setVisible(true);

                    this.dispose();

                } else {
                    txtRespuesta.setText("Conexion Fallida");
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }

        }

    }//GEN-LAST:event_btnTestActionPerformed

    private void btnCreaBdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreaBdActionPerformed
        // TODO add your handling code here:

        if (ValidarCamposVacios(txtServidor, txtNombre, txtNombreBD)) {
            JOptionPane.showMessageDialog(this, "Faltan datos en los campos.");

        } else {

            if (ValidarCamposVacios(txtServidor, txtNombre, txtNombreBD)) {
                JOptionPane.showMessageDialog(this, "Faltan datos en los campos.");

            } else {

                try {
                    servidor = txtServidor.getText();
                    login = txtNombre.getText();
                    password = txtPassword.getText();
                    dbName = txtNombreBD.getText();
                    if (Conexion.createDatabase()) {
                        txtRespuesta.setText("Creacion Exitosa Base de datos");
                        
                        
                        if (Conexion.createTable()) {
                            txtRespuesta.setText("Creacion Exitosa script sql");
                            
                            
                            VistaLogin ini = new VistaLogin();

                            Dimension pantall = Toolkit.getDefaultToolkit().getScreenSize();
                            //obtenemos el tamaño de la ventana  
                            Dimension ventan = ini.getSize();
                            //para centrar la ventana lo hacemos con el siguiente calculo  
                            ini.setLocation((pantall.width - ventan.width) / 2, (pantall.height - ventan.height) / 2);
                            ini.setVisible(true);
                            
                            

                            crearNombreBD();
                            this.dispose();
                           
                            
                            /*
                             Vista.VistaPrincipal.btnCalculosMensuales.setEnabled(true);
                             Vista.VistaPrincipal.btnCargarEmpleado.setEnabled(true);
                             Vista.VistaPrincipal.btnNominaGeneral.setEnabled(true);
                             Vista.VistaPrincipal.btnNominaPorCedula.setEnabled(true);
                             Vista.VistaPrincipal.btnConfiguracion.setEnabled(false);
                             */
                        } else {
                            txtRespuesta.setText("Creacion Fallida script sql");
                        }

                    } else {
                        txtRespuesta.setText("Creacion Fallida de Base de datos ");
                    }

                   
                    
                } catch (Exception ex) {
                    System.out.println(ex);
                }

            }
        }
        
        
    }//GEN-LAST:event_btnCreaBdActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        setExtendedState(ICONIFIED);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtServidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtServidorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtServidorActionPerformed

   public void crearNombreBD()
    {
    try {
          
                    servidor = txtServidor.getText();
                    login = txtNombre.getText();
                    password = txtPassword.getText();
                    dbName = txtNombreBD.getText();
         
                obj = new ControllerSql();
                    
                     boolean  res = obj.AgregarBd(servidor,login,password,dbName);
                      log("CREAR");
                    
                
                
                if (res == true) {
                    JOptionPane.showMessageDialog(null, "Usuario Registrado Correctamente");
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo ingresar un nuevo Empleado ya existe en la base"
                            + "de datos");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "por favor verifique la conexion del servidor");

            }
    } 
    
    /*
     @autor Jose Vanegas
     */
    public void ValidadCaracteres(JTextField a) {
        a.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                Character ch = e.getKeyChar();
                if (Character.isDigit(e.getKeyChar()) && !Character.isDigit(e.getKeyChar())) {
                    // if(((ch < '0') || (ch > '9')) && (ch != KeyEvent.VK_BACK_SPACE)&& (ch !='.')){ 

                    getToolkit().beep();
                    e.consume();;
                }

            }
        });
    }


    /*
     @autor Jose Vanegas
     */
    public boolean ValidarCamposVacios(JTextField... textFields) {
        for (JTextField textField : textFields) {
            if (textField.getText().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    
     public void log(String a) {
        System.out.println("la valor  = " + " " + a);
    }   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox ComboBoxDrivers;
    public static javax.swing.JButton btnCreaBd;
    public static javax.swing.JButton btnTest;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JLabel jlSalida;
    public static javax.swing.JTextField txtNombre;
    public static javax.swing.JTextField txtNombreBD;
    public static javax.swing.JPasswordField txtPassword;
    public static javax.swing.JLabel txtRespuesta;
    private javax.swing.JTextField txtServidor;
    // End of variables declaration//GEN-END:variables
}
