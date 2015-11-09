/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Materias;

import Controlador.Conexion;
import Controlador.ControllerSql;
import Controlador.FuncionesController;
import Modelo.Perfil;
import Vista.SuperAdministrador.CUPUsuario;
import static Vista.SuperAdministrador.CUPUsuario.btnGuardar;
import static Vista.SuperAdministrador.CUPUsuario.comboEstado;
import static Vista.SuperAdministrador.CUPUsuario.comboHabien;
import static Vista.SuperAdministrador.CUPUsuario.comboPerfil;
import static Vista.SuperAdministrador.CUPUsuario.comboTipoC;
import static Vista.SuperAdministrador.CUPUsuario.txtCedula;
import static Vista.SuperAdministrador.CUPUsuario.txtLogin;
import static Vista.SuperAdministrador.CUPUsuario.txtNombre;
import static Vista.SuperAdministrador.CUPUsuario.txtPassword;
import Vista.SuperAdministrador.VistaUsuarios;
import java.awt.HeadlessException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author negro
 */
public class CUPMaterias extends javax.swing.JFrame {

    ControllerSql obj = new ControllerSql();
    FuncionesController cc = new FuncionesController();
//    private final List<Perfil> Perfil;
    CallableStatement cts;
    Connection cn;
    ResultSet r;
    VistaUsuarios VistaUsuarios;
    
    /**
     * Creates new form CUPMaterias
     */
    public CUPMaterias() {
        setUndecorated(true);
        initComponents();
        cn = Conexion.getConn();
        
        
        /*Recupera los datos en caso de se caiga la conexion*/
       txtIdMateria.setName("txtIdMateria");
       txtNombre.setName("txtNombre");
       txtCreditos.setName("txtCreditos");
       txtIntHoraria.setName("txtIntHoraria");
       txtSemestre.setName("txtSemestre");
       
       BackFrame(txtIdMateria,txtNombre,txtCreditos,txtIntHoraria,txtSemestre);
        
        VistaMaterias VistaMaterias;
       /*Validacion de campos*/
        ValidadCaracteres(txtNombre);
        ValidadSoloNumeros(txtIntHoraria);
        ValidadSoloNumeros(txtSemestre);
        ValidadSoloNumeros(txtIdMateria);
        
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        comboTipoM = new javax.swing.JComboBox();
        txtIdMateria = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtCreditos = new javax.swing.JTextField();
        txtIntHoraria = new javax.swing.JTextField();
        txtSemestre = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Cod Materia");

        jLabel2.setText("Nombre");

        jLabel3.setText("Tipo");

        jLabel4.setText("Creditos");

        jLabel5.setText("Intensidad Horaria");

        jLabel6.setText("Semestre");

        comboTipoM.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Teorico", "Practica", "Teorico-Practica" }));

        txtIdMateria.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIdMateriaFocusLost(evt);
            }
        });

        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombreFocusLost(evt);
            }
        });

        txtCreditos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCreditosFocusLost(evt);
            }
        });

        txtIntHoraria.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIntHorariaFocusLost(evt);
            }
        });

        txtSemestre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSemestreFocusLost(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/minimizar.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cerrar2.png"))); // NOI18N
        jButton6.setText("jButton2");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Crear Materia");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIdMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(comboTipoM, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtSemestre, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombre)
                                    .addComponent(txtCreditos)
                                    .addComponent(txtIntHoraria))
                                .addGap(3, 3, 3)))))
                .addContainerGap(131, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(155, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(76, 76, 76)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIdMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboTipoM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCreditos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtIntHoraria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        setExtendedState(ICONIFIED);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed
   
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        
        
         VistaMaterias VistaMaterias = new VistaMaterias();
        
        if((VistaMaterias.getMod() != btnGuardar.getText()))
        {
       CrearMateria();
        }
        else{
      EditarMateria();
        }
        
        
        
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtIdMateriaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdMateriaFocusLost
        // TODO add your handling code here:
        SaveJTextFieldFrame(txtIdMateria);
    }//GEN-LAST:event_txtIdMateriaFocusLost

    private void txtNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusLost
        // TODO add your handling code here:
        SaveJTextFieldFrame(txtNombre);
    }//GEN-LAST:event_txtNombreFocusLost

    private void txtCreditosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCreditosFocusLost
        // TODO add your handling code here:
        SaveJTextFieldFrame(txtCreditos);
    }//GEN-LAST:event_txtCreditosFocusLost

    private void txtIntHorariaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIntHorariaFocusLost
        // TODO add your handling code here:
        
        SaveJTextFieldFrame(txtIntHoraria);
    }//GEN-LAST:event_txtIntHorariaFocusLost

    private void txtSemestreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSemestreFocusLost
        // TODO add your handling code here:
        
        SaveJTextFieldFrame(txtSemestre);
    }//GEN-LAST:event_txtSemestreFocusLost

    /*Funciones*/
    
    
    /*
    @Valida Campos vacios
    @auto jvanegasv@ucentral.edu.co
    */
    
      public boolean ValidarCamposVacios(JTextField... textFields) {
        for (JTextField textField : textFields) {
            if (textField.getText().isEmpty()) {
                return true;
            }
        }
        return false;
    }
 
     /*
    @Valida que los campor solo contengan numeros
    @auto jvanegasv@ucentral.edu.co
    */    
      
    public void ValidadSoloNumeros(JTextField a) {
        a.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                Character ch = e.getKeyChar();
                if (!Character.isDigit(e.getKeyChar()) && (ch != KeyEvent.VK_BACK_SPACE) && (ch != '.')) {
         // if(((ch < '0') || (ch > '9')) && (ch != KeyEvent.VK_BACK_SPACE)&& (ch !='.')){ 

                    getToolkit().beep();
                    e.consume();;
                }
            }
        });
    }

    /*
    @Valida que los campor solo contengan caracteres
    @auto jvanegasv@ucentral.edu.co
    */    
    
    public void ValidadCaracteres(JTextField a) {
        a.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                Character ch = e.getKeyChar();
                if (Character.isDigit(e.getKeyChar())) {
         // if(((ch < '0') || (ch > '9')) && (ch != KeyEvent.VK_BACK_SPACE)&& (ch !='.')){ 

                    getToolkit().beep();
                    e.consume();;
                }

            }
        });
    }
      
      
      
      
      /*
      @Guardar los datos de cada JTextField para recuperar los datos
       en casos se caiga el servicio del servidor
      @autor jose vanegas - jvamegasv@ucentral.edu.co
      */
    public void SaveJTextFieldFrame(JTextField... textFields)
    {

        for (JTextField textField : textFields) {

            String b = textField.getName();

            String txtCampo = b;
            String txtdato = textField.getText();
            String nombreFrame = "CUPMaterias";

            try {

                obj = new ControllerSql();

                boolean res = obj.AgregarCampoBackFrame(1, nombreFrame, txtCampo, txtdato);

                if (res == true) {
                    log("Usuario Registrado Correctamente");

                } else {
                    
                    log("No se pudo ingresar un nuevo Empleado ya existe en la base"
                            + "de datos");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "por favor verifique la conexion del servidor");

            }

        }
   
    }
      
      
    /*
      @Retorna los datos recuperados en caso que se cierra la aplicacion
      @auto jose vanegas -jvanegasv@ucentral.edu.co
    */    
    public void BackFrame(JTextField... textFields) {
        String campos = "";
        try {

            ResultSet rs;
            rs = obj.ConsultarBackFrame();
            while (rs.next()) {
                campos = rs.getString(4);//Nombre
                //txtNombre.setText(rs.getString(5));//Nombre   
                //log(String.valueOf(campos));  
                for (JTextField textField : textFields) {

                    String b = textField.getName();

                    if (campos.equals(b)) {
                        textField.setText(rs.getString(5));
                    }
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(CUPUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
      
    public void deleteDataFrame(int idUsuario) {
        
        // TODO add your handling code here:
          String cod=  Integer.toString(idUsuario);
          String nombreFrame = "CUPUsuario";
          
          log("idUsuario"+String.valueOf(cod));
        try {
            cts=cn.prepareCall("{call eliminarbackframe(?,?)}");
            cts.setString(1, cod);
            cts.setString(2, nombreFrame);
            int rpta=cts.executeUpdate();

            if(rpta==1){
            
            
                
          log("No se eliminado correctamente los datos");
                    }else {
             
                log("Se ha eliminado correctamente los datos");

            }

        }catch (SQLException | HeadlessException e) {JOptionPane.showMessageDialog(this, e.toString());
        }
    }
    
    
    /*********************************************************************************************/
   public void CrearMateria()
   {
   
       if (ValidarCamposVacios(txtIdMateria,txtNombre,txtCreditos,txtIntHoraria,txtSemestre)) {
            JOptionPane.showMessageDialog(this, "Faltan datos en los campos.");
        } else {

            int idMateria = Integer.parseInt(txtIdMateria.getText());
            String nombre = txtNombre.getText();
            Object tipoMateria = comboTipoM.getSelectedItem();
            int Creditos = Integer.parseInt(txtCreditos.getText());
            int IntHoraria = Integer.parseInt(txtIntHoraria.getText());
            int Semestre = Integer.parseInt(txtSemestre.getText());
            
          
            
            try {

//                 int intperfil = Integer.parseInt(sperfil);
                
                
                 

                boolean res = obj.CrearMateria(idMateria, nombre, nombre, Creditos, IntHoraria, Semestre);

                if (res == true) {
                   this.dispose();
                    VistaMaterias VistaMaterias = new VistaMaterias();
                    VistaMaterias.setVisible(true);
                    JOptionPane.showMessageDialog(null, "Materia Registrada Correctamente");

                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo ingresar otro usuario ya existe"
                            + "de datos");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "por favor verifique la conexion del servidor ");

            }

            deleteDataFrame(1);
        }
       
   }
    
   
   public void EditarMateria()
   {
       
       // TODO add your handling code here:
        if (ValidarCamposVacios(txtIdMateria,txtNombre,txtCreditos,txtIntHoraria,txtSemestre)) {
            JOptionPane.showMessageDialog(this, "Faltan datos en los campos.");

        } else {
            
            int idMateria = Integer.parseInt(txtIdMateria.getText());
            String nombre = txtNombre.getText();
            Object tipoMateria = comboTipoM.getSelectedItem();
            int Creditos = Integer.parseInt(txtCreditos.getText());
            int IntHoraria = Integer.parseInt(txtIntHoraria.getText());
            int Semestre = Integer.parseInt(txtSemestre.getText());
    

            try {
        
                
                obj = new ControllerSql();
              
                   
                      boolean res = obj.actualizarMateria(idMateria, nombre, WIDTH, Creditos, IntHoraria, Semestre);
//                      boolean res = obj.actualizarUsuario(identificacion,nombre);
                        log("EDITAR");
                        
                
                
                if (res == true) {
                    JOptionPane.showMessageDialog(null, "Se Modifico Correctamente el materia");
                   
                    this.dispose();
                    VistaMaterias VistaMaterias = new VistaMaterias();
                    VistaMaterias.setVisible(true);
                    
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo Actualizar ocurrio un problema"
                            + "de datos");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "por favor verifique la conexion del servidor");

            }
        }
        
   }
   
   public void log(String a) {
        System.out.println("la valor  = " + " " + a);
    } 
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CUPMaterias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CUPMaterias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CUPMaterias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CUPMaterias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CUPMaterias().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    public static javax.swing.JButton btnGuardar;
    public static javax.swing.JComboBox comboTipoM;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public static javax.swing.JTextField txtCreditos;
    public static javax.swing.JTextField txtIdMateria;
    public static javax.swing.JTextField txtIntHoraria;
    public static javax.swing.JTextField txtNombre;
    public static javax.swing.JTextField txtSemestre;
    // End of variables declaration//GEN-END:variables
}
