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

    String myTableName1 ="CREATE TABLE IF NOT EXISTS `baaa0`.`profesor` (\n" +
"  `idprofesor` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',\n" +
"  `tipoContrato` VARCHAR(255) NULL DEFAULT NULL COMMENT '',\n" +
"  `estadoDispo` BIT(1) NULL DEFAULT NULL COMMENT '',\n" +
"  PRIMARY KEY (`idprofesor`)  COMMENT '')\n" +
"ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;";

    
 String myTableName2="CREATE TABLE IF NOT EXISTS `baaa0`.`usuario` (\n" +
"  `idusuario` INT(11) NOT NULL COMMENT '',\n" +
"  `nombre` VARCHAR(255) NULL DEFAULT NULL COMMENT '',\n" +
"  `idPerfil` INT(11) NOT NULL COMMENT '',\n" +
"  `login` VARCHAR(45) NULL DEFAULT NULL COMMENT '',\n" +
"  `contrasenia` VARCHAR(45) NULL DEFAULT NULL COMMENT '',\n" +
"  `estado` BIT(1) NULL DEFAULT NULL COMMENT '',\n" +
"  PRIMARY KEY (`idusuario`)  COMMENT '',\n" +
"  INDEX `Perfil` (`idPerfil` ASC)  COMMENT '',\n" +
"  CONSTRAINT `FK_usuario_perfil`\n" +
"    FOREIGN KEY (`idusuario`)\n" +
"    REFERENCES `baaa0`.`profesor` (`idprofesor`))\n" +
"ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;";
 
  String myTableName3 ="CREATE TABLE IF NOT EXISTS `baaa0`.`administrador` (\n" +
"  `idAdmin` INT(11) NOT NULL COMMENT '',\n" +
"  `tipoContrato` VARCHAR(50) NULL DEFAULT NULL COMMENT '',\n" +
"  PRIMARY KEY (`idAdmin`)  COMMENT '',\n" +
"  CONSTRAINT `FK_Administrador_usuario`\n" +
"    FOREIGN KEY (`idAdmin`)\n" +
"    REFERENCES `baaa0`.`usuario` (`idusuario`))\n" +
"ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;";
  
  
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
  
  String myTableName5 ="CREATE TABLE IF NOT EXISTS `baaa0`.`materia` (\n" +
"  `idMateria` INT(11) NOT NULL COMMENT '',\n" +
"  `nombreMateria` VARCHAR(50) NULL DEFAULT NULL COMMENT '',\n" +
"  `tipo` VARCHAR(50) NULL DEFAULT NULL COMMENT '',\n" +
"  `creditos` INT(11) NULL DEFAULT NULL COMMENT '',\n" +
"  `intHoraria` BIGINT(20) NULL DEFAULT NULL COMMENT '',\n" +
"  `semestre` INT(11) NULL DEFAULT NULL COMMENT '',\n" +
"  `idAdministrador` INT(11) NULL DEFAULT NULL COMMENT '',\n" +
"  PRIMARY KEY (`idMateria`)  COMMENT '',\n" +
"  INDEX `idAdministrador` (`idAdministrador` ASC)  COMMENT '',\n" +
"  CONSTRAINT `FK_Materia_Administrador`\n" +
"    FOREIGN KEY (`idAdministrador`)\n" +
"    REFERENCES `baaa0`.`administrador` (`idAdmin`))\n" +
"ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;";
  
  String myTableName6 ="CREATE TABLE IF NOT EXISTS `baaa0`.`horariomateria` (\n" +
"  `idHMateria` INT(11) NOT NULL COMMENT '',\n" +
"  `codigoMateria` INT(11) NULL DEFAULT NULL COMMENT '',\n" +
"  `grupo` VARCHAR(50) NULL DEFAULT NULL COMMENT '',\n" +
"  `dia` VARCHAR(50) NULL DEFAULT NULL COMMENT '',\n" +
"  `hora` VARCHAR(50) NULL DEFAULT NULL COMMENT '',\n" +
"  `duracion` INT(11) NULL DEFAULT NULL COMMENT '',\n" +
"  `semestre` VARCHAR(50) NULL DEFAULT NULL COMMENT '',\n" +
"  `jornada` VARCHAR(50) NULL DEFAULT NULL COMMENT '',\n" +
"  PRIMARY KEY (`idHMateria`)  COMMENT '',\n" +
"  INDEX `codigoMateria` (`codigoMateria` ASC)  COMMENT '',\n" +
"  CONSTRAINT `FK_horarioMateria_Materia`\n" +
"    FOREIGN KEY (`codigoMateria`)\n" +
"    REFERENCES `baaa0`.`materia` (`idMateria`))\n" +
"ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;";
  
  String myTableName7 ="CREATE TABLE IF NOT EXISTS `baaa0`.`horarioprofesor` (\n" +
"  `idHprofesor` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',\n" +
"  `idProfesor` INT(11) NULL DEFAULT NULL COMMENT '',\n" +
"  `dia` VARCHAR(50) NULL DEFAULT NULL COMMENT '',\n" +
"  `hora` VARCHAR(50) NULL DEFAULT NULL COMMENT '',\n" +
"  `estado` BIT(1) NULL DEFAULT NULL COMMENT '',\n" +
"  `tipoHorario` VARCHAR(50) NULL DEFAULT NULL COMMENT '',\n" +
"  PRIMARY KEY (`idHprofesor`)  COMMENT '',\n" +
"  INDEX `idProfesor` (`idProfesor` ASC)  COMMENT '',\n" +
"  CONSTRAINT `FK_horarioProfesor_profesor`\n" +
"    FOREIGN KEY (`idProfesor`)\n" +
"    REFERENCES `baaa0`.`profesor` (`idprofesor`))\n" +
"ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;";
  
   String myTableName8 ="CREATE TABLE IF NOT EXISTS `mybd` (\n" +
"  `idbd` int(11) NOT NULL AUTO_INCREMENT,\n" +
"  `servidor` varchar(255) DEFAULT NULL,\n" +
"  `login` varchar(255) DEFAULT NULL,\n" +
"  `password` varchar(255) DEFAULT NULL,\n" +
"  `dbName` varchar(255) DEFAULT NULL,\n" +          
"  `estado` bit(1) DEFAULT NULL,\n" +
"  PRIMARY KEY (`idbd`)\n" +
") ENGINE=InnoDB DEFAULT CHARSET=utf8;";
   
 
  
  
  
  
        try {
            Class.forName(driver);

            url = "jdbc:mysql://localhost:3306/";
            conn = DriverManager.getConnection(url + dbName, login, password);
            Statement s = conn.createStatement();
            s.executeUpdate(myTableName1);
            s.executeUpdate(myTableName2);
            s.executeUpdate(myTableName3);
            s.executeUpdate(myTableName4);
            s.executeUpdate(myTableName5);
            s.executeUpdate(myTableName6);
            s.executeUpdate(myTableName7);
            s.executeUpdate(myTableName8);
    
        
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

