    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import static Controlador.Conexion.dbName;
import static Controlador.Conexion.driver;
import static Controlador.Conexion.login;
import static Controlador.Conexion.url;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author negro
 */
public class ControllerSql {//public 

    Connection conexion;
    Statement stm;
    ResultSet rs;

    
    private static ControllerSql cs = new ControllerSql();
    
      public static ControllerSql getInstancia(){
        return cs;
    }
    
    public ControllerSql() {  //class public
        
        try {

            Class.forName("com.mysql.jdbc.Driver");
            String db = "jdbc:mysql://localhost/" + Conexion.dbName;
            conexion = DriverManager.getConnection(db, Conexion.login, Conexion.password);
            stm = conexion.createStatement();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    
 private static int Ingreso(Usuario p) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql="select  idPerfil from usuario where login=? and contrasenia=?";
        try (Connection cn= Conexion.getConn();
                PreparedStatement ps= cn.prepareStatement(sql)){
            ps.setString(1,p.getLogin());
            ps.setString(2,p.getContrasenia());
            try (ResultSet rs= ps.executeQuery()){
                rs.next();
                r=rs.getInt(1); 
            }
        }
        return r;
    }

  public boolean AgregarCampoBackFrame(int idusuario,String nombreFrame, String txtCampo, String txtdato) {
      
      int estado = 1;
        try {
            String query = " insert into backframe(idUsuario,jframe,txtdato,dato,estado)"
                    + " values (?,?,?,?,?)";

            // preparo la consulta para mi base de datos
            PreparedStatement preparedStmt = conexion.prepareStatement(query);
            
            preparedStmt.setInt(1, idusuario);
            preparedStmt.setString(2, nombreFrame);
            preparedStmt.setString(3, txtCampo);
            preparedStmt.setString(4, txtdato);
            preparedStmt.setInt(5, estado);
            

            // ejecuto mi query
            preparedStmt.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }
    } 
  
    public ResultSet ConsultarBackFrame() {
        try {

            String query = "select * from backframe where Estado = 1";
            Statement st = conexion.createStatement();
            rs = st.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error");
            return null;
        }
    }

       public boolean deleteBackFrame(int idUsuario,String jframe) {
           
     try {
            String query = "delete from backframe where idUsuario = ? and jframe=? and estado =1";
            PreparedStatement preparedStmt = conexion.prepareStatement(query);
            preparedStmt.execute();

            return true;
        } catch (SQLException e) {
            return false;
        }
    }
 
       
       /*
      String myTableName3 ="CREATE TABLE IF NOT EXISTS `mybd` (\n" +
"  `idbd` int(11) NOT NULL AUTO_INCREMENT,\n" +
"  `servidor` varchar(255) DEFAULT NULL,\n" +
"  `login` varchar(255) DEFAULT NULL,\n" +
"  `password` varchar(255) DEFAULT NULL,\n" +
"  `dbName` varchar(255) DEFAULT NULL,\n" +          
"  `estado` bit(1) DEFAULT NULL,\n" +
"  PRIMARY KEY (`idbd`)\n" +
") ENGINE=InnoDB DEFAULT CHARSET=utf8;";
       */
    public boolean AgregarBd(String servidor,String login , String password , String dbName) {

        
        try {
            String query = "INSERT INTO mybd (servidor,login,password,dbName,estado)"
                + " VALUES (?,?,?,?,1);";
        

            // preparo la consulta para mi base de datos
            PreparedStatement preparedStmt = conexion.prepareStatement(query);
            preparedStmt.setString(1, servidor);
            preparedStmt.setString(2, login);
            preparedStmt.setString(3, password);
            preparedStmt.setString(4, dbName);

            // ejecuto mi query
            preparedStmt.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
        
       
       
  public static int IngresoLogin(Usuario p) throws ClassNotFoundException, SQLException
    {
        return Ingreso(p);
    }

      public void log(String a) {
        System.out.println("la valor  = " + " " + a);
    }  
}
