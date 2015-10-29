 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import Vista.Administrador.VistaConexionBD;
import groovy.xml.Entity;


/**
 *
 * @author NEGRO
 */
public class Conexion {

    VistaConexionBD vistaMBD = new VistaConexionBD();
    public static String url;
    public static String dbAddress = "jdbc:mysql://localhost:3306/";
    public final static String driver = "com.mysql.jdbc.Driver";
    private static Connection conn = null;
    public static String servidor;
    public static String login;
    public static String password;
    public static String dbName;

    private static Conexion conex = null;

    public Conexion() {
        try {
            conectar();
        } catch (Exception ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Conexion getInstance() {
        if (conex == null) {
            conex = new Conexion();
        }
        return conex;
    }

    //metodo para conectar con la BD
    public static boolean conectar() throws Exception {
        try {
            url = "jdbc:mysql://"+servidor + dbName;
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url, login, password);

            if (conn != null) {
                System.out.println("Conexión..." + url + "...Ok" + "...Usuario:..." + login);
                //return Boolean.getBoolean(dbName);
            }

            return true;
        } catch (SQLException ex) {

            System.out.println("Erroronectar con la DB..." + url + "...Usuario:..." + login);
            return false;
        }
    }//fin del metodo conectar

    public static boolean createDatabase() throws Exception {

        try {

            url = "jdbc:mysql://"+servidor;
            Class.forName(driver);
            conn = DriverManager.getConnection(url, login, password);
            Statement s = conn.createStatement();
            int myResult = s.executeUpdate("CREATE DATABASE IF NOT EXISTS " + dbName);

            if (conn != null) {
                System.out.println("Conexión..Creacion database." + url + "...Ok" + "...Usuario:..." + login);
            }

            return true;

        } catch (ClassNotFoundException  ex) {

            System.out.println("Erroronectar con la DB..." + url + "...Usuario:..." + login);
            return false;
        }

    }

    public static boolean createTable() throws Exception {

        login = VistaConexionBD.txtNombre.getText();
        password = VistaConexionBD.txtPassword.getText();
        dbName = VistaConexionBD.txtNombreBD.getText();

    String myTableName1 ="CREATE TABLE IF NOT EXISTS `profesor` (\n" +
"  `idprofesor` int(11) NOT NULL AUTO_INCREMENT,\n" +
"  `tipoContrato` varchar(255) DEFAULT NULL,\n" +
"  `estadoDispo` bit(1) DEFAULT NULL,\n" +
"  PRIMARY KEY (`idprofesor`)\n" +
") ENGINE=InnoDB DEFAULT CHARSET=utf8;";

    
 String myTableName2="CREATE TABLE IF NOT EXISTS `usuario` (\n" +
"  `idusuario` int(11) NOT NULL,\n" +
"  `nombre` varchar(255) DEFAULT NULL,\n" +
"  `idPerfil` int(11) NOT NULL,\n" +
"  `login` varchar(45) DEFAULT NULL,\n" +
"  `contrasenia` varchar(45) DEFAULT NULL,\n" +
"  `estado` bit(1) DEFAULT NULL,\n" +
"  PRIMARY KEY (`idusuario`),\n" +
"  KEY `Perfil` (`idPerfil`),\n" +
"  CONSTRAINT `FK_usuario_perfil` FOREIGN KEY (`idusuario`) REFERENCES `profesor` (`idprofesor`) ON DELETE NO ACTION ON UPDATE NO ACTION\n" +
") ENGINE=InnoDB DEFAULT CHARSET=utf8;";

  String myTableName3 ="CREATE TABLE IF NOT EXISTS `mybd` (\n" +
"  `idbd` int(11) NOT NULL AUTO_INCREMENT,\n" +
"  `nombre` varchar(255) DEFAULT NULL,\n" +
"  `estado` bit(1) DEFAULT NULL,\n" +
"  PRIMARY KEY (`idbd`)\n" +
") ENGINE=InnoDB DEFAULT CHARSET=utf8;";
  
  
  String myTableName4 ="CREATE TABLE IF NOT EXISTS `BackFrame` (\n" +
"  `idBackFrame` INT NOT NULL COMMENT '',\n" +
"  `idUsuario` INT(11) NULL COMMENT '',\n" +
"  `jframe` VARCHAR(225) NULL COMMENT '',\n" +
"  `txtdato` VARCHAR(255) NULL COMMENT '',\n" +
"  `date` VARCHAR(255) NULL COMMENT '',\n" +
"  `Estado` BINARY(1) NULL COMMENT '',\n" +
"  PRIMARY KEY (`idBackFrame`)  COMMENT '',\n" +
"  INDEX `fk_BackFrame_usuario1_idx` (`idUsuario` ASC)  COMMENT '',\n" +
"  CONSTRAINT `fk_BackFrame_usuario1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION\n" +
" )ENGINE=InnoDB DEFAULT CHARSET=utf8;";
  
        try {
            Class.forName(driver);

            url = "jdbc:mysql://localhost:3306/";
            conn = DriverManager.getConnection(url + dbName, login, password);
            Statement s = conn.createStatement();
            s.executeUpdate(myTableName1);
            s.executeUpdate(myTableName2);
            s.executeUpdate(myTableName3);
            s.executeUpdate(myTableName4);
    
        
            System.out.println("Tables Created");

            if (conn != null) {
                System.out.println("Conexión..Creacion table." + url + "...Ok" + "...Usuario:..." + login);
                
            }
            return true;
        } catch (SQLException e) {
            System.out.println("Error en la creacion de la table");
        }

        return false;
    }

   public static Connection getConn() {
        return conn;
    }

}//fin de la clase

