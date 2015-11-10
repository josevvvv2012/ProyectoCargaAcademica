/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Materias;

import Controlador.Conexion;
import Controlador.ControllerSql;
import Controlador.FuncionesController;
import Modelo.Administrador;
import Modelo.Grupo;
import Modelo.Materia;
import Modelo.Perfil;
import Modelo.Salon;
import Modelo.Usuario;
import static Vista.SuperAdministrador.CUPUsuario.comboPerfil;
import static groovyjarjarasm.asm.tree.InsnList.check;
import java.awt.Color;
import java.awt.Component;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;//Importaciones
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author negro
 */
public class MateriasProfesor extends javax.swing.JFrame {
    
    DefaultTableModel tabla;
    
    ControllerSql obj = new ControllerSql();
    FuncionesController cc = new FuncionesController();
    private final List<Usuario> Usuario;
   //ControllerSql obj;
    CallableStatement cts;
    Connection cn;
    ResultSet r;
   private ArrayList<Object[]> data1;
    
    
    
    /**
     * Creates new form MateriasProfesor
     */
    public MateriasProfesor() {
       setUndecorated(true);
       initComponents();
       cn = Conexion.getConn();
       cargarTablaMaterias();
       cargarTablaMaterias2();
       obj = ControllerSql.getInstancia();
      cargarTablaMateriasBloques();
       /*cargar los datos del perfil en el combo*/
       comboProfesores.setModel(new javax.swing.DefaultComboBoxModel(cc.listaUsuarioProfesores().toArray()));
       Usuario = cc.listaUsuarioProfesores();
       comboProfesores.setSelectedIndex(0);
       

       tabla = (DefaultTableModel) jTable3.getModel();
    }

    
    /*
    @cargar las datos de la tabla usuario 
    @autor jose vanegas . jvanegasv@ucentral.edu.co
    */
     public void cargarTablaMaterias() {

        DefaultTableModel tabla = new DefaultTableModel();
        PreparedStatement ps;
        try {
            tabla.addColumn("Cod Materia");
            tabla.addColumn("Nombre");
            tabla.addColumn("Tipo");
            tabla.addColumn("No Creditos");
            tabla.addColumn("Int Horaria");
            tabla.addColumn("Semestre");
            tabla.addColumn("Check");
            
            ps = cn.prepareStatement("SELECT idMateria,nombreMateria,tipo,creditos,intHoraria,semestre FROM materia");
            r = ps.executeQuery();

            while (r.next()) {
              //  Object dato[] = new Object[7];
                
                Object dato[]={"Id Materia","Nombre","Tipo","No Creditos","Int Horaria","Semestre",false};
                        
               
                for (int i = 0; i < 6; i++) {
                    dato[i] = r.getString(i + 1);
                    
                }
                tabla.addRow(dato);
            }
            this.jTable1.setModel(tabla);
            
            
        //Se crea el JCheckBox en la columna indicada en getColumn, en este caso, la primera columna
        jTable1.getColumnModel().getColumn( 6 ).setCellEditor( new Celda_CheckBox() );
        //para pintar la columna con el CheckBox en la tabla, en este caso, la primera columna
        jTable1.getColumnModel().getColumn( 6 ).setCellRenderer(new Render_CheckBox());   

        } catch (Exception e) {
        }
    }

     
     /*
    @cargar las datos de la tabla usuario 
    @autor jose vanegas . jvanegasv@ucentral.edu.co
    */
     public void cargarTablaMaterias2() {

         
           String myTableName13="-- Volcando estructura para tabla baaa0.salon\n" +
"CREATE TABLE IF NOT EXISTS `HorarioTemp` (\n" +
"  `idHorarioTemp` int(11) NOT NULL AUTO_INCREMENT,\n" +
"  `Lunes` varchar(255) DEFAULT NULL,\n" +
"  `estadoLunes` bit(1) DEFAULT NULL,\n" +
"  `Martes` varchar(255) DEFAULT NULL,\n" +
"  `estadoMartes` bit(1) DEFAULT NULL,\n" +
"  PRIMARY KEY (`idHorarioTemp`)\n" +
") ENGINE=InnoDB DEFAULT CHARSET=utf8;";
         
        DefaultTableModel tabla = new DefaultTableModel();
        PreparedStatement ps;
        try {
            tabla.addColumn("id");
            tabla.addColumn("Lunes");
            tabla.addColumn("Estado");
            tabla.addColumn("Martes");
            tabla.addColumn("Estado");
            
            
            ps = cn.prepareStatement("select idHorarioTemp,Lunes,estadoLunes,Martes,estadoMartes from HorarioTemp");
            r = ps.executeQuery();

            while (r.next()) {
              //  Object dato[] = new Object[7];
                
                Object dato[]={"hora","Lunes",false,"Martes",false};
                        
               
                for (int i = 0; i < 5; i++) {
                    dato[i] = r.getString(i + 1);
                    
                }
                tabla.addRow(dato);
            }
            this.jTable2.setModel(tabla);
            
            
//        //Se crea el JCheckBox en la columna indicada en getColumn, en este caso, la primera columna
//        jTable2.getColumnModel().getColumn( 3 ).setCellEditor( new Celda_CheckBox() );
//        //para pintar la columna con el CheckBox en la tabla, en este caso, la primera columna
//        jTable2.getColumnModel().getColumn( 3 ).setCellRenderer(new Render_CheckBox());   
//        
//        
//        //Se crea el JCheckBox en la columna indicada en getColumn, en este caso, la primera columna
//        jTable2.getColumnModel().getColumn( 5 ).setCellEditor( new Celda_CheckBox() );
//        //para pintar la columna con el CheckBox en la tabla, en este caso, la primera columna
//        jTable2.getColumnModel().getColumn( 5 ).setCellRenderer(new Render_CheckBox());   

        } catch (Exception e) {
        }
    }
  
     
     
     
        
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        comboProfesores = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        BtnCancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableHorario = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        btnPrueba = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

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

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jLabel1.setText("Profesor");

        BtnCancelar.setText("Cancelar");
        BtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Asignar Materias - Horario");

        jTableHorario.setAutoCreateRowSorter(true);
        jTableHorario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Lunes 6 - 7 am"},
                {"Lunes 7 - 8 am"},
                {"Lunes 8 - 9 am"},
                {"Lunes 9 - 10 am"}
            },
            new String [] {
                "Lunes"
            }
        ));
        jScrollPane2.setViewportView(jTableHorario);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable3);

        btnPrueba.setText("Prueba");
        btnPrueba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPruebaActionPerformed(evt);
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
        jScrollPane4.setViewportView(jTable2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(comboProfesores, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(432, 432, 432)
                                .addComponent(btnPrueba)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnGuardar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(BtnCancelar)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel2))
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboProfesores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrueba)
                    .addComponent(btnGuardar)
                    .addComponent(BtnCancelar))
                .addGap(151, 151, 151))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
//// TODO add your handling code here:
//        
//        
//        // TODO add your handling code  here:
//         DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
//        //ahora obtenemos la fila selccionada
//        int fila_select = jTable1.getSelectedRow();
//
//        if(fila_select<0){
//            // no se puede eliminar
//            JOptionPane.showMessageDialog(this,"Tabla vacia o no ha seleccionado uan fila.");
//        }else {
//          // la eliminamos del modelo:
//       // modelo.removeRow(fila_select);
//            //colocar la funcion que pinte
//            
//            //jTable1.setSelectionBackground(Color.black);
////            jTable1.setDefaultRenderer (Object.class, new MiRender());
//            installCellRenderers(jTable1);
//      
//        }
//        //eliminar(fila_select+1); 
//        //System.out.println("hola");
        
            

           
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        setExtendedState(ICONIFIED);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    
    
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:for (int i = 0; i < table.getRowCount(); i++) {
         
           cargaDatosObject();

//        if (tabla.getRowCount() > 0){
//        
//        
//        
//        
//        	for (int i = 0; i < jTable3.getRowCount(); i++) {
//                        
//                    String dataCol1 = jTable3.getValueAt(i, 0).toString();
//                    String dataCol2 = jTable3.getValueAt(i, 1).toString();
//                    String dataCol3 = jTable3.getValueAt(i, 2).toString();
//                    String dataCol4 = jTable3.getValueAt(i, 3).toString();
//                    
//                    
//                    Object dato[]={dataCol1,dataCol2,dataCol3,dataCol4};
//                    
//                    log("hola "+String.valueOf(dato[0].toString()+"   "+dato[1].toString()
//                    +"   "+dato[2].toString()+"   "+dato[3].toString()));
//                    
//                    
//                    String x = dato[0].toString()+dato[1];
//                    
//                    log(x);
//                    Object datoTablaH[]={x,x,x,x};  
//                    
//                    if(x.equals("Lunes6 - 7 am"))
//                    {
//                        
//                        DefaultTableModel tabla = new DefaultTableModel();        
//                        
//                        log("datoTablaH"+String.valueOf(datoTablaH[0].toString()));
//                         tabla.addRow(datoTablaH);
////                            
//                         jTableHorario.setModel(tabla);
////                       
//                         log("soy Lunes con dato ");
//                                
//                    }
//                    else{
//                    
//                    log("soy Lunes con dato 1");
//                    }
//                    
//                    
//                    
////                    log("hola");
////					Boolean chked = Boolean.valueOf(jTable1.getValueAt(i, 6).toString());                                        
////                                        log("chked"+String.valueOf(chked));
////					String dataCol7 = jTable1.getValueAt(i, 1).toString();
////                                                log("data campor check"+String.valueOf(dataCol7));
//////                                                
////					if (chked) {
////						JOptionPane.showMessageDialog(null, dataCol7);
////                                                
////                                                log(String.valueOf(filas.toArray()));
////                                                
//////                                                            filas.add(new Clase(
//////                                 (String) tabla.getValueAt(i, 0) ,
//////                                dia2int((String) tabla.getValueAt(i, 1)),
//////                                hora(Double.parseDouble(((String) tabla.getValueAt(i, 2)).replace(':','.'))),
//////                                hora(Double.parseDouble(((String) tabla.getValueAt(i, 3)).replace(':','.')))));
////
////                                                
////// int idSalon;String codigoSalonM;String nombreSalon;String Ubicacion;boolean estado; dia hora salon ubicacion
////                                                
//////int idMateria;int codMaterias;String nombreMateria;String tipo;int creditos;int intHoraria;int semestre;Administrador idAdministrador;      
////                                                
//////cod,nombre,tipo,Nocreditos,IntHoria,semestre                                                
////                                                
////                                                
////                                             filas.add(new Materia(
////                                                        1,
////                                                        (int) tabla.getValueAt(1, 0),
////                                                        (String ) tabla.getValueAt(i, 1),
////                                                        (String) tabla.getValueAt(i, 2),
////                                                        (int) tabla.getValueAt(i, 3),
////                                                        (int) tabla.getValueAt(i, 4),
////                                                        (int) tabla.getValueAt(i, 5)
////                                                        ,null));
////                                                
////                                                
////                                                
////					}
//                    
//                    
//                    
//                                        
//				}
//                
//                
//                
//                
//        }        
                
    }//GEN-LAST:event_btnGuardarActionPerformed

    public void cargaDatosObject() {

        if (tabla.getRowCount() > 0) {

            for (int i = 0; i < jTable3.getRowCount(); i++) {

                /*Datos de la tabla Dia / hora / Salon / Ubicacion*/
                
                String dataCol1 = jTable3.getValueAt(i, 0).toString();
                String dataCol2 = jTable3.getValueAt(i, 1).toString();
                String dataCol3 = jTable3.getValueAt(i, 2).toString();
                String dataCol4 = jTable3.getValueAt(i, 3).toString();

                Object dato[] = {dataCol1, dataCol2, dataCol3, dataCol4};  // Columna de los datos de la tabla jtable3

//                log("hola " + String.valueOf(dato[0].toString() + "   " + dato[1].toString()
//                        + "   " + dato[2].toString() + "   " + dato[3].toString()));

                String cadenaConca = dato[0].toString()+" "+dato[1]; // concatena los datos de dia y hora

                log(cadenaConca);
                compara(cadenaConca);
         
            }

        }

    }
    
    public void compara(String datos) {
//        DefaultTableModel tabla = new DefaultTableModel();
         log("*****************************************************************************");
        log("compara datos" + datos);

        if (tabla.getRowCount() > 0) {

            for (int i = 0; i < jTableHorario.getRowCount(); i++) {

                String dataCol1 = jTableHorario.getValueAt(i, 0).toString();
               // String dataCol2 = jTableHorario.getValueAt(i, 1).toString();

                log("--------------------------------------------------------------------");
                
                Object dato[] = {dataCol1};
                //log("hola " + String.valueOf(dato[0].toString() + "   " + dato[1].toString()));
                String x = dato[0].toString();
                log("  x = " +x);

                if (x.equals(datos)) {
                    
                             // fila columna
         String dataCol2 = jTableHorario.getValueAt(0, 0).toString();
        log("valor de la celda "+String.valueOf(dataCol2));
                    log("si conside en el horario jtable Horario ");

        //DefaultTableModel tabla = new DefaultTableModel();
////  
//
//                    tabla.addRow(dato);
                    tabla.addRow(dato);
                    jTableHorario.setModel(tabla);
                    

                } else {

                    log("No es conside");
                }

            }

        }

    }
    
    
    
    
    
    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
        
    }//GEN-LAST:event_BtnCancelarActionPerformed

    
  
    
    private void btnPruebaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPruebaActionPerformed

//       TableColumn tcmn = jTableHorario.getColumnModel().getColumn( 1 );
//       tcmn.getHeaderValue();
//        log(String.valueOf(tcmn.getHeaderValue()));
//        
//    if(tcmn.getHeaderValue() == "Lunes")
//    {
//        
//        log("hola soy la columna LUNES");
//    }else
//    {
//    log("No hola soy la columna LUNES");
//    }
        
       TableColumn tcmn = jTableHorario.getColumnModel().getColumn( 1 );
       tcmn.getHeaderValue();
        log(String.valueOf(tcmn.getHeaderValue()));
        
    if(tcmn.getHeaderValue() == "Lunes")
    {
        
        log("hola soy la columna LUNES");
    }else
    {
    log("No hola soy la columna LUNES");
    }        
        
    
     
    }//GEN-LAST:event_btnPruebaActionPerformed

    
    public void installCellRenderers(JTable table) {

        TableCellRenderer defaultRenderer = table.getDefaultRenderer(Object.class);

        TableCellRenderer r = new MiRender(defaultRenderer);

        table.setDefaultRenderer(Object.class, r);

//        TableCellRenderer defaultBooleanRenderer = table.getDefaultRenderer(Boolean.class);
//
//        TableCellRenderer r2 = new MiRender(defaultBooleanRenderer);
//
//        table.setDefaultRenderer(Boolean.class, r2);

    }
    
    

    
    /*
    @cargar las datos de la tabla usuario 
    @autor jose vanegas . jvanegasv@ucentral.edu.co
    */
     public void cargarTablaMateriasBloques() {

        DefaultTableModel tabla = new DefaultTableModel();
        PreparedStatement ps;
        try {
            tabla.addColumn("Dia");
            tabla.addColumn("Hora");
            tabla.addColumn("Salon");
            tabla.addColumn("Ubicacion");
            //tabla.addColumn("Estado");
            
            ps = cn.prepareStatement("select bloq.dia,bloq.hora,salo.nombreSalon,salo.ubicacion from materia mate\n" +
"inner join grupo grup ON grup.idMateria = mate.idMateria\n" +
"inner join bloque bloq ON grup.idbloque = bloq.idbloque\n" +
"inner join salon salo ON bloq.idsalon = salo.idsalon\n" +
"where mate.codMateria = 829292");
            r = ps.executeQuery();

            while (r.next()) {
              //  Object dato[] = new Object[7];
                
                Object dato[]={"Dia","Hora","Salon","Ubicacion"};
                        
               
                for (int i = 0; i < 4; i++) {
                    dato[i] = r.getString(i + 1);
                    
                }
                tabla.addRow(dato);
            }
            this.jTable3.setModel(tabla);
            
            
//        //Se crea el JCheckBox en la columna indicada en getColumn, en este caso, la primera columna
//        jTable1.getColumnModel().getColumn( 6 ).setCellEditor( new Celda_CheckBox() );
//        //para pintar la columna con el CheckBox en la tabla, en este caso, la primera columna
//        jTable1.getColumnModel().getColumn( 6 ).setCellRenderer(new Render_CheckBox());   

        } catch (Exception e) {
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
            java.util.logging.Logger.getLogger(MateriasProfesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MateriasProfesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MateriasProfesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MateriasProfesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MateriasProfesor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnPrueba;
    public static javax.swing.JComboBox comboProfesores;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    public static javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTableHorario;
    // End of variables declaration//GEN-END:variables

     
    }
