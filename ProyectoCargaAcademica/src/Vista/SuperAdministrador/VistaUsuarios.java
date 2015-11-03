/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.SuperAdministrador;

import Controlador.Conexion;
import Controlador.ControllerSql;
import java.awt.HeadlessException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author negro
 */
public class VistaUsuarios extends javax.swing.JFrame {

    
    ControllerSql obj;
    CallableStatement cts;
    Connection cn;
    ResultSet r;
    CUPUsuario  formUsuario;
    String Mod = "Modificar";

 
    /**
     * Creates new form VistaUsuarios
     */
    public VistaUsuarios() {
        setUndecorated(true);
        initComponents();
        cn = Conexion.getConn();
        cargar();
    }

    /*
    @cargar las datos de la tabla usuario 
    @autor jose vanegas . jvanegasv@ucentral.edu.co
    */    
    public void cargar() {

        DefaultTableModel tabla = new DefaultTableModel();
        PreparedStatement ps;
        try {
            tabla.addColumn("IdUsuario");
            tabla.addColumn("Identificacion");
            tabla.addColumn("Nombre");
            tabla.addColumn("Perfil");
            tabla.addColumn("Login");
            tabla.addColumn("Clave");
            tabla.addColumn("tipoContrato");
            tabla.addColumn("habilitadoEn");
            tabla.addColumn("estadoDispo");
            tabla.addColumn("Estado");
            
            ps = cn.prepareStatement("SELECT idusuario,identificacion,nombre,idPerfil,login,contrasenia,tipoContrato,"
                    + "habilitadoEn,estadoDispo,estado FROM usuario");
            r = ps.executeQuery();

            while (r.next()) {
                Object dato[] = new Object[10];
                
                for (int i = 0; i < 10; i++) {
                    dato[i] = r.getString(i + 1);
                    //log(String.valueOf(dato[0]));
                }
                tabla.addRow(dato);
            }
            this.jTable1.setModel(tabla);

        } catch (Exception e) {
        }
    }
    
     /*
     *Consulta los datos de la tabla
    @autor jose vanegas -jvanegasv@ucentral.edu.co
    */
  
  public void consultarTable()
    {
     log("Consultar tabla");
        String x = jTextField1.getText();
        log(String.valueOf(x));
        PreparedStatement ps;
        DefaultTableModel tabla = new DefaultTableModel();

        try {
           tabla.addColumn("IdUsuario");
            tabla.addColumn("Identificacion");
            tabla.addColumn("Nombre");
            tabla.addColumn("Perfil");
            tabla.addColumn("Login");
            tabla.addColumn("Clave");
            tabla.addColumn("tipoContrato");
            tabla.addColumn("habilitadoEn");
            tabla.addColumn("estadoDispo");
            tabla.addColumn("Estado");
          
          
            cts = cn.prepareCall("{call filtraUsuarioId(?)}");//procedimiento almacenado
            cts.setString(1, x);
            r = cts.executeQuery();


            while (r.next()) {
                Object dato[] = new Object[10];
                for (int i = 0; i < 10; i++) {
                    dato[i] = r.getString(i + 1);

                    log(String.valueOf(dato[i]));
                }
                tabla.addRow(dato);
            }
            this.jTable1.setModel(tabla);

        } catch (Exception e) {
        }
    
  }
  
   /*
     *Seleccionar los datos de la tabla
    @autor jose vanegas -jvanegasv@ucentral.edu.co
    */
 public int seleccionarfila(int a) {
        
        
        
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        int row = jTable1.getSelectedRow();
        //ahora obtenemos la fila selccionada
        int fila_select = jTable1.getSelectedRow();

        if (fila_select < 0) {
            // no se puede eliminar
            JOptionPane.showMessageDialog(this, "Tabla vacia o no ha seleccionado uan fila para editar.");
        } else {
          
          formUsuario = new  CUPUsuario();
          formUsuario.setVisible(true);
          
          
          String idUsuario =jTable1.getValueAt(row, 1).toString();
          String nombre =jTable1.getValueAt(row, 2).toString();
          String Perfil =jTable1.getValueAt(row, 3).toString();
          String Login =jTable1.getValueAt(row, 4).toString();
          String Clave =jTable1.getValueAt(row, 5).toString();
           String TipoC =jTable1.getValueAt(row, 6).toString();
          String Habilien =jTable1.getValueAt(row, 7).toString();
          String EstadoD =jTable1.getValueAt(row, 8).toString();
          String Estado =jTable1.getValueAt(row, 9).toString();
          
          
            
          formUsuario.btnGuardar.setText(getMod());
          formUsuario.txtCedula.setEnabled(false);
          
//            log("perfil"+"  "+Perfil);
         
         if(Integer.parseInt(Perfil) != 2)
         {
            
         formUsuario.txtCedula.setText(idUsuario);
         formUsuario.txtNombre.setText(nombre);
         formUsuario.comboPerfil.setSelectedIndex(2);
         formUsuario.txtLogin.setText(Login);
         formUsuario.txtPassword.setText(Clave);
         }else{
         
         formUsuario.txtCedula.setText(idUsuario);
         formUsuario.txtNombre.setText(nombre);
         formUsuario.txtLogin.setText(Login);
         formUsuario.txtPassword.setText(Clave);
         formUsuario.comboTipoC.setSelectedItem(TipoC);
         formUsuario.comboHabien.setSelectedItem(EstadoD);
         } 
            a = 1;
            
        }
        
        log(String.valueOf(a));
        return a;
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        btnSeleccionar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Exportar");

        jButton2.setText("Crear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Gestio Usuario");

        jLabel2.setText("Buscar");

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

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jTable1);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnSeleccionar.setText("Editar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(212, 212, 212)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSeleccionar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminar)
                                .addGap(0, 31, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel1))
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton2)
                                .addComponent(jLabel2))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnBuscar)
                                .addComponent(btnSeleccionar)
                                .addComponent(btnEliminar)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jButton1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        setExtendedState(ICONIFIED);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    // TODO add your handling code here:
        CUPUsuario  CUPUsuario = new CUPUsuario();
        CUPUsuario.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        consultarTable();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        // TODO add your handling code here:
        seleccionarfila(0);
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
                
        // TODO add your handling code  here:
         DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        //ahora obtenemos la fila selccionada
        int fila_select = jTable1.getSelectedRow();

        if(fila_select<0){
            // no se puede eliminar
            JOptionPane.showMessageDialog(this,"Tabla vacia o no ha seleccionado uan fila.");
        }else {
          // la eliminamos del modelo:
        modelo.removeRow(fila_select);
       
        }
        eliminar(fila_select+1); 
   
    }//GEN-LAST:event_btnEliminarActionPerformed

    public void eliminar(int idUsuario)
    {
            
        // TODO add your handling code here:
          String cod=  Integer.toString(idUsuario);
          log("idUsuario"+String.valueOf(cod));
        try {
            cts=cn.prepareCall("{call eliminarUsuario(?)}");
            cts.setString(1, cod);
            int rpta=cts.executeUpdate();

            if(rpta==1){
            JOptionPane.showMessageDialog(this, "Empleado Eliminado","Aviso",JOptionPane.INFORMATION_MESSAGE);
          
                    }else {
             JOptionPane.showMessageDialog(this, "Empleado No Eliminado","Aviso",JOptionPane.INFORMATION_MESSAGE);

            }

        }catch (SQLException | HeadlessException e) {JOptionPane.showMessageDialog(this, e.toString());
        }
    }
    
  
    public void log(String a) {
        System.out.println("la valor  = " + " " + a);
    } 
    
      public void setMod(String Mod) {
        this.Mod = Mod;
    }
      
     public String getMod() {
        return Mod;
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
            java.util.logging.Logger.getLogger(VistaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
