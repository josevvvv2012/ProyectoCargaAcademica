package Vista.HorarioProfesor;

import Controlador.Conexion;
import Controlador.ControllerSql;
import Controlador.FuncionesController;
import Modelo.Usuario;
import static Vista.Materias.MateriasProfesor.comboProfesores;
import java.io.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AsignarHorarioP extends javax.swing.JFrame {

    CallableStatement cts;
    Connection cn;
    ResultSet r;
    
    DefaultTableModel tabla;
    DefaultTableModel tabla1;
    
    ArrayList<Asignatura> Asignaturas = new ArrayList<Asignatura>();
    int maxTurnos=0;
    int[] horarioBT; //Se emplea en el Backtracking
    public ArrayList <Horario> soluciones = new ArrayList <Horario>  ();
        
    boolean sustituidoPorDuracion=true;
    
    ControllerSql obj = new ControllerSql();
    FuncionesController cc = new FuncionesController();
    private final List<Usuario> Usuario;
   private ArrayList<Object[]> data1;
    
    
    public AsignarHorarioP() {
        //Inicializa componentetr
        setUndecorated(true);
        initComponents();
        
        
        //Centra la ventana
        setLocationRelativeTo (null);
        
        //Crea el modelo de la tabla
   tabla = (DefaultTableModel) jTable1.getModel();
   tabla1 = (DefaultTableModel) jTable2.getModel();
   cn = Conexion.getConn();
   cargartable();
   
   
      /*cargar los datos del perfil en el combo*/
       comboProfesores.setModel(new javax.swing.DefaultComboBoxModel(cc.listaUsuarioProfesores().toArray()));
       Usuario = cc.listaUsuarioProfesores();
       comboProfesores.setSelectedIndex(0);
   
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        comboProfesores = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();

        jToolBar1.setRollover(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Generador de horarios");
        setFocusable(false);
        setIconImage(new ImageIcon("monkey.png").getImage());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Materia", "Día", "Hora inicial", "Hora final", "Eliminar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowSelectionAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaEliminarTurno(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Seleccionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonInsertarFila(evt);
            }
        });

        jButton2.setText("Generar horarios");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonGenerarHorarios(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Asignacion de Horario");

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/minimizar.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cerrar2.png"))); // NOI18N
        jButton8.setText("jButton2");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel2.setText("Profesor");
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(450, 450, 450)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                        .addGap(178, 178, 178))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addGap(7, 7, 7)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(290, 290, 290)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(jLabel2)
                .addGap(28, 28, 28)
                .addComponent(comboProfesores, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboProfesores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void BotonInsertarFila(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonInsertarFila

        
        insertaTabla2();
    }//GEN-LAST:event_BotonInsertarFila

   public void cargartable() 
   {
    DefaultTableModel tabla1 = new DefaultTableModel();
        PreparedStatement ps;
        try {
            tabla1.addColumn("Materia");
            tabla1.addColumn("Dia");
            tabla1.addColumn("HoraInicial");
            tabla1.addColumn("HoraFinal");
            
           
            ps = cn.prepareStatement("select mate.nombreMateria,blo.dia,blo.hora,blo.horaFinal from materia mate\n" +
"inner join grupo gru ON mate.idMateria = gru.idMateria\n" +
"inner join bloque blo ON gru.idbloque = blo.idbloque\n" +
"where mate.codMateria = 829292");
            r = ps.executeQuery();

            while (r.next()) {
                Object dato[] = new Object[4];
                
                for (int i = 0; i < 4; i++) {
                    dato[i] = r.getString(i + 1);
                    //log(String.valueOf(dato[0]));
                }
                tabla1.addRow(dato);
            }
            this.jTable2.setModel(tabla1);
            

        } catch (Exception e) {
        }
         
        
        
 
   }
   
   
    public void insertaTabla2() {

        if (tabla1.getRowCount() > 0) {

            for (int i = 0; i < jTable2.getRowCount(); i++) {

                /*Datos de la tabla Dia / hora / Salon / Ubicacion*/
                String dataCol1 = jTable2.getValueAt(i, 0).toString();
                String dataCol2 = jTable2.getValueAt(i, 1).toString();
                String dataCol3 = jTable2.getValueAt(i, 2).toString();
                String dataCol4 = jTable2.getValueAt(i, 3).toString();

                Object dato[] = {dataCol1, dataCol2, dataCol3, dataCol4};  // Columna de los datos de la tabla jtable3

                String cadenaConca = dato[0].toString() + " " + dato[1]; // concatena los datos de dia y hora

                Object nuevo[] = {dataCol1, dataCol2, dataCol3, dataCol4, false};
                tabla.addRow(nuevo);

            }

        }

    }
   
   
    public static int dia2int ( String dia){
        if      (dia.equals("Lunes"))     return 1;
        else if (dia.equals("Martes"))    return 2;
        else if (dia.equals("Miércoles")) return 3;
        else if (dia.equals("Jueves"))    return 4;
        else if (dia.equals("Viernes"))   return 5;
        else if (dia.equals("Sábado"))    return 6;
        else                              return 7;
    }
    
    //Esta función tiene traca. 
    // Las horas tienen un rango de [8,23], donde pueden haber valores medios (8:30)
    // Si lo desplazamos -8, el rango es [0-15], 
    // Pero cada hora puede ser en punto, o y media, es decir, 2 valores
    // Entonces, lo que devuelve esta en el rango [0-30]
    // Donde 8->0, 8:30->1, 9->2, 9:30->3 ... 23:00->30
    public static int hora(double h)
    {
        h= (h-8)*2;
        int res= (int) h;
        
        if (h == res) return res;
        else          return res+1;
        
    }
    
    private void BotonGenerarHorarios(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonGenerarHorarios
     if (tabla.getRowCount() > 0){
         
        ArrayList <Clase> filas = new ArrayList <Clase> ();
         System.out.println(filas.toString());
         System.out.println(filas.toArray());
        

        for (int i=0; i< tabla.getRowCount(); i++)
        {
            
            filas.add(new Clase(
                                 (String) tabla.getValueAt(i, 0) ,
                                dia2int((String) tabla.getValueAt(i, 1)),
                                hora(Double.parseDouble(((String) tabla.getValueAt(i, 2)).replace(':','.'))),
                                hora(Double.parseDouble(((String) tabla.getValueAt(i, 3)).replace(':','.')))));
        }
        Collections.sort(filas);
                
        String aux="/&@FC7)VYclëÎ=ñO?¿OL*";
        
        int mt=0;
        for (int i=0; i<filas.size(); i++){
            if (!aux.equals(filas.get(i).asig))
            {
                Asignaturas.add(new Asignatura(filas.get(i).asig));
                Asignaturas.get(Asignaturas.size()-1).add(filas.get(i));
                mt=1;
                if (mt>maxTurnos){
                    maxTurnos=mt;
                }
            }
            else
            {
                Asignaturas.get(Asignaturas.size()-1).add(filas.get(i));
                mt++;
                if (mt>maxTurnos){
                    maxTurnos=mt;
                }
            }
            aux=filas.get(i).asig;
        }
        
        generaHorarios();
     }  
    }//GEN-LAST:event_BotonGenerarHorarios

    void generaHorarios()
    {
        if (Asignaturas.size() > 0)
        {
            //Realiza backtracking
            horarioBT = new int[Asignaturas.size()];
            backtrack(0);
        
            if (soluciones.size() > 0)
            {
                //Ordena el vector
                Collections.sort(soluciones);                
                
                //Copia los ArrayList para poder borrar residuos de backtracking
                ArrayList <Horario>  solucopia=new ArrayList <Horario> ();
                solucopia.addAll(soluciones);
                
                ArrayList<Asignatura> asigcopia=new ArrayList<Asignatura>();
                asigcopia.addAll(Asignaturas);
                
                //Carga vista de horarios
                VistaHorarios res=new VistaHorarios(solucopia,asigcopia,this);
                res.setVisible(true);
                this.setVisible(false);
            }
            else
            {
                JOptionPane.showMessageDialog(this,"No existen horarios posibles con estos turnos.",
                                             "Generar horarios",JOptionPane.ERROR_MESSAGE);
            }
        
        
            //Limpia BT
            Asignaturas.clear();
            soluciones.clear();   
            maxTurnos=0;
        }
        
        
        
    }
     void IncluyeEnSoluciones() {
        
        Clase [] temp = new Clase[Asignaturas.size()];
        
        for (int i=0; i < Asignaturas.size(); i++)
        {
           temp[i]=Asignaturas.get(i).clases.get(horarioBT[i]);
        } 
        
        soluciones.add(new Horario(temp));
    }
   
    boolean Coincide(Clase c, int k){
        
        for (int j=0; j<k; j++){
            if (c.Coincide(Asignaturas.get(j).clases.get(horarioBT[j]))){
                return true;
            }
        }
        
        return false;
    }
    
    public void backtrack(int k) {
        for (int i = 0; i <= maxTurnos; i++) {
            if (i< Asignaturas.get(k).clases.size() && !Coincide(Asignaturas.get(k).clases.get(i),k)) {
                
                horarioBT[k]=i;
                
                if (k == Asignaturas.size()-1) {
                      IncluyeEnSoluciones();
                } else {
                    backtrack(k + 1);
                }
            }
        }
    }
        
    private void MenuGuardar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        

    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void tablaEliminarTurno(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEliminarTurno

        for (int i=0; i < tabla.getRowCount(); i++)
        {
            if ((Boolean) tabla.getValueAt(i, 4) == true )
            {
                if ((JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this,"¿Quieres eliminar este turno?","Eliminar turno",JOptionPane.YES_NO_OPTION)))
                {
                    tabla.removeRow(i);
                }
                else
                {
                    tabla.setValueAt(false, i, 4);
                }
            }
        }
    }//GEN-LAST:event_tablaEliminarTurno

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        setExtendedState(ICONIFIED);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AsignarHorarioP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AsignarHorarioP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AsignarHorarioP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AsignarHorarioP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AsignarHorarioP().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox comboProfesores;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}