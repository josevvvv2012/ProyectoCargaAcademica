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
import Vista.SuperAdministrador.VistaConexionBD;
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
    static Boolean estado;

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

   
   String myTableName1 ="CREATE TABLE IF NOT EXISTS  `perfil` (\n" +
"  `idperfil` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',\n" +
"  `nombre` VARCHAR(255) NULL DEFAULT NULL COMMENT '',\n" +
"  `estado` BIT(1) NULL DEFAULT NULL COMMENT '',\n" +
"  PRIMARY KEY (`idperfil`)  COMMENT '')\n" +
"ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;";   

    
 String myTableName2="CREATE TABLE IF NOT EXISTS `usuario` (\n" +
"  `idusuario` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',\n" +
"  `identificacion` INT(11) NOT NULL COMMENT '',\n" +
"  `nombre` VARCHAR(255) NULL DEFAULT NULL COMMENT '',\n" +
"  `idPerfil` INT(11) NOT NULL COMMENT '',\n" +
"  `login` VARCHAR(45) NULL DEFAULT NULL COMMENT '',\n" +
"  `contrasenia` VARCHAR(45) NULL DEFAULT NULL COMMENT '',\n" +
"  `tipoContrato` VARCHAR(255) NULL DEFAULT NULL COMMENT '',\n" +
"  `habilitadoEn` VARCHAR(255) NULL DEFAULT NULL COMMENT '',\n" +
"  `estadoDispo` BIT(1) NULL DEFAULT NULL COMMENT '',\n" +         
"  `estado` BIT(1) NULL DEFAULT NULL COMMENT '',\n" +
"  PRIMARY KEY (`idusuario`)  COMMENT '',\n" +
"  INDEX `Perfil` (`idPerfil` ASC)  COMMENT '',\n" +
"  CONSTRAINT `FK_usuario_perfil`\n" +
"    FOREIGN KEY (`idPerfil`)\n" +
"    REFERENCES `perfil` (`idperfil`))\n" +
"ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;";
 
 /*
String myTableName3 ="CREATE TABLE IF NOT EXISTS `baaa0`.`profesor` (\n" +
"  `idprofesor` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',\n" +
"  `tipoContrato` VARCHAR(255) NULL DEFAULT NULL COMMENT '',\n" +
"  `habilitadoEn` VARCHAR(255) NULL DEFAULT NULL COMMENT '',\n" +
"  `estadoDispo` BIT(1) NULL DEFAULT NULL COMMENT '',\n" +
"  PRIMARY KEY (`idprofesor`)  COMMENT '',\n" +
"  CONSTRAINT `FK_Profesor_usuario`\n" +
"    FOREIGN KEY (`idprofesor`)\n" +
"    REFERENCES `baaa0`.`usuario` (`idusuario`) ON DELETE CASCADE ON UPDATE CASCADE )\n" +
"ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;";
*/
  
  String myTableName4 ="CREATE TABLE IF NOT EXISTS `administrador` (\n" +
"  `idAdmin` INT(11) NOT NULL COMMENT '',\n" +
"  `tipoContrato` VARCHAR(50) NULL DEFAULT NULL COMMENT '',\n" +
"  PRIMARY KEY (`idAdmin`)  COMMENT '',\n" +
"  CONSTRAINT `FK_Administrador_usuario`\n" +
"    FOREIGN KEY (`idAdmin`)\n" +
"    REFERENCES `usuario` (`idusuario`))\n" +
"ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;";
  
  
  String myTableName5 ="CREATE TABLE IF NOT EXISTS `BackFrame` (\n" +
"  `idBackFrame` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',\n" +          
"  `idUsuario` INT(11) NULL COMMENT '',\n" +
"  `jframe` VARCHAR(225) NULL COMMENT '',\n" +
"  `txtdato` VARCHAR(255) NULL COMMENT '',\n" +
"  `dato` VARCHAR(255) NULL COMMENT '',\n" +
"  `estado` BIT(1) NULL COMMENT '',\n" +
"  PRIMARY KEY (`idBackFrame`)  COMMENT '',\n" +
"  INDEX `fk_BackFrame_usuario1_idx` (`idUsuario` ASC)  COMMENT '',\n" +
"  CONSTRAINT `fk_BackFrame_usuario1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idusuario`) ON DELETE CASCADE ON UPDATE CASCADE  " +
" )ENGINE=InnoDB DEFAULT CHARSET=utf8;";
  
  String myTableName6 ="CREATE TABLE IF NOT EXISTS `materia` (\n" +
"  `idMateria` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',\n" +
"  `codMateria` INT(11) NOT NULL COMMENT '',\n" +          
"  `nombreMateria` VARCHAR(50) NULL DEFAULT NULL COMMENT '',\n" +
"  `tipo` VARCHAR(50) NULL DEFAULT NULL COMMENT '',\n" +
"  `creditos` INT(11) NULL DEFAULT NULL COMMENT '',\n" +
"  `intHoraria` INT(11) NULL DEFAULT NULL COMMENT '',\n" +
"  `semestre` INT(11) NULL DEFAULT NULL COMMENT '',\n" +
"  `idAdministradorM` INT(11) NULL DEFAULT NULL COMMENT '',\n" +
"  PRIMARY KEY (`idMateria`)  COMMENT '',\n" +
"  INDEX `idAdministradorM` (`idAdministradorM` ASC)  COMMENT '',\n" +
"  CONSTRAINT `FK_Materia_Administrador`\n" +
"    FOREIGN KEY (`idAdministradorM`)\n" +
"    REFERENCES `usuario` (`idusuario`))\n" +
"ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;";
  
  String myTableName7 ="CREATE TABLE IF NOT EXISTS `horariomateria` (\n" +
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
"    REFERENCES `materia` (`idMateria`))\n" +
"ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;";
  
  String myTableName8 ="CREATE TABLE IF NOT EXISTS `horarioprofesor` (\n" +
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
"    REFERENCES `usuario` (`idusuario`))\n" +
"ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;";
  
   String myTableName9 ="CREATE TABLE IF NOT EXISTS `mybd` (\n" +
"  `idbd` int(11) NOT NULL AUTO_INCREMENT,\n" +
"  `servidor` varchar(255) DEFAULT NULL,\n"     +
"  `login` varchar(255) DEFAULT NULL,\n" +
"  `password` varchar(255) DEFAULT NULL,\n" +
"  `dbName` varchar(255) DEFAULT NULL,\n" +          
"  `estado` bit(1) DEFAULT NULL,\n" +
"  PRIMARY KEY (`idbd`)\n" +
") ENGINE=InnoDB DEFAULT CHARSET=utf8;";
   
/*      
      
 String myTableName10 ="CREATE TABLE IF NOT EXISTS `grupo` (\n" +
"  `idgrupo` int(11) NOT NULL AUTO_INCREMENT,\n" +
"  `idmateria` varchar(255) DEFAULT NULL,\n" +
"  `jornada` varchar(255) DEFAULT NULL,\n" +
"  `bloque` int(11) NOT NULL ,\n" +        
"  `estado` bit(1) DEFAULT NULL,\n" +
"  PRIMARY KEY (`idgrupo`)\n" +
") ENGINE=InnoDB DEFAULT CHARSET=utf8;";
 */

// String myTableName10="-- Volcando estructura para tabla baaa0.salon\n" +
//"CREATE TABLE IF NOT EXISTS `salon` (\n" +
//"  `idsalon` int(11) NOT NULL AUTO_INCREMENT,\n" +
//"  `codigoSalon` varchar(255) DEFAULT NULL,\n" +
//"  `codBloque` int(11) DEFAULT NULL,\n" +
//"  `nombreSalon` varchar(255) DEFAULT NULL,\n" +
//"  `ubicacion` varchar(255) DEFAULT NULL,\n" +
//"  `estado` bit(1) DEFAULT NULL,\n" +
//"  PRIMARY KEY (`idsalon`)\n" +
//") ENGINE=InnoDB DEFAULT CHARSET=utf8;";  
 

 String myTableName10="-- Volcando estructura para tabla baaa0.salon\n" +
"CREATE TABLE IF NOT EXISTS `salon` (\n" +
"  `idsalon` int(11) NOT NULL AUTO_INCREMENT,\n" +
"  `codigoSalon` varchar(255) DEFAULT NULL,\n" +
"  `nombreSalon` varchar(255) DEFAULT NULL,\n" +
"  `ubicacion` varchar(255) DEFAULT NULL,\n" +
"  `estado` bit(1) DEFAULT NULL,\n" +
"  PRIMARY KEY (`idsalon`)\n" +
") ENGINE=InnoDB DEFAULT CHARSET=utf8;";     
   
   
 
  String myTableName11="CREATE TABLE IF NOT EXISTS `bloque` (\n" +
"  `idbloque` int(11) NOT NULL,\n" +
"  `codBloque` varchar(45) DEFAULT NULL,\n" +
"  `dia` varchar(45) DEFAULT NULL,\n" +
"  `hora` varchar(45) DEFAULT NULL,\n" +
"  `estado` bit(1) DEFAULT NULL,\n" +
"  `idsalon` int(11) NOT NULL,\n" +
"  PRIMARY KEY (`idbloque`),\n" +
"  KEY `fk_bloque_salon1_idx` (`idsalon`),\n" +
"  CONSTRAINT `fk_bloque_salon1` FOREIGN KEY (`idsalon`) REFERENCES `salon` (`idsalon`) ON DELETE NO ACTION ON UPDATE NO ACTION\n" +
") ENGINE=InnoDB DEFAULT CHARSET=utf8;";
 
   
 String myTableName12 ="CREATE TABLE IF NOT EXISTS `grupo` (\n" +
"  `idgrupo` int(11) NOT NULL AUTO_INCREMENT,\n" +
"  `idMateria` int(11) NOT NULL,\n" +
"  `idbloque` int(11) NOT NULL,\n" +
"  `jornada` varchar(255) DEFAULT NULL,\n" +
"  `estado` bit(1) DEFAULT NULL,\n" +
"  PRIMARY KEY (`idgrupo`),\n" +
"  KEY `fk_grupo_materia1_idx` (`idMateria`),\n" +
"  KEY `fk_grupo_bloque1_idx` (`idbloque`),\n" +
"  CONSTRAINT `fk_grupo_bloque1` FOREIGN KEY (`idbloque`) REFERENCES `bloque` (`idbloque`) ON DELETE NO ACTION ON UPDATE NO ACTION,\n" +
"  CONSTRAINT `fk_grupo_materia1` FOREIGN KEY (`idMateria`) REFERENCES `materia` (`idMateria`) ON DELETE NO ACTION ON UPDATE NO ACTION\n" +
") ENGINE=InnoDB DEFAULT CHARSET=utf8;";
           
 
 
 
 
 
   String insertTable1 ="INSERT INTO `perfil` (`idperfil`, `nombre`, `estado`) VALUES (1, 'SuperAdministrador', b'1');";
   String insertTable2 ="INSERT INTO `perfil` (`idperfil`, `nombre`, `estado`) VALUES (2, 'Administrador', b'1');";        
   String insertTable3 ="INSERT INTO `perfil` (`idperfil`, `nombre`, `estado`) VALUES (3, 'Profesor', b'1');";        
   String insertTable4="INSERT INTO `usuario` (`idusuario`, `identificacion`, `nombre`, `idPerfil`, `login`, `contrasenia`, `estado`) VALUES (1, 1022, 'jose', 1, 'admin', 'admin', b'1');";
   String insertTable5="INSERT INTO `usuario` (`idusuario`, `identificacion`, `nombre`, `idPerfil`, `login`, `contrasenia`, `tipoContrato`, `habilitadoEn`, `estadoDispo`, `estado`) VALUES (3, 122, 'jose2', 3, 'x', 'x', 'Fijo', 'Nocturna', b'1', b'1');";
   String insertTable6="INSERT INTO `materia` (`idMateria`, `codMateria`, `nombreMateria`, `tipo`, `creditos`, `intHoraria`, `semestre`) VALUES (1, 829292, 'ingles', '1', 1, 1, 2);";
   String insertTable7="INSERT INTO `materia` (`idMateria`, `codMateria`, `nombreMateria`, `tipo`, `creditos`, `intHoraria`, `semestre`) VALUES (2, 33829292, 'teatro', '1', 1, 1, 2);";
   
   String insertTable8="INSERT INTO `salon` (`codigoSalon`, `nombreSalon`, `ubicacion`, `estado`) VALUES ('1A', 'Salon Eventos', 'Cll 22', b'1');";
   String insertTable9="INSERT INTO `salon` (`codigoSalon`, `nombreSalon`, `ubicacion`, `estado`) VALUES ('1F', 'Salon Audio', 'Cll 7', b'1');";
   
 
       
     String prodfiltraUsuarioID="CREATE PROCEDURE `filtraUsuarioId`(IN `cod` INT)\n" +
	"	\n" +
	"SELECT * FROM usuario WHERE idusuario = cod ";
      
      
      String prodfiltraMateriaID="CREATE PROCEDURE `filtraMateriaId`(IN `cod` INT)\n" +
	"	\n" +
	"SELECT * FROM materia WHERE idMateria = cod ";
      
      
       String prodfiltraGrupoID="CREATE PROCEDURE `prodfiltraGrupoID`(IN `cod` INT)\n" +
	"	\n" +
	"SELECT * FROM grupo WHERE idgrupo = cod ";
      
       
       String prodfiltraSalonID="CREATE PROCEDURE `prodfiltraSalonID`(IN  `cod` VARCHAR(100))\n" +
	"	\n" +
	"SELECT * FROM salon WHERE  codigoSalon = cod ";
       
      
       String prodEliminarUsuario="CREATE PROCEDURE `eliminarUsuario`(IN `cod` INT)\n" +
	"	\n" +
	"delete from usuario where idusuario = cod ";
      
 
       String prodEliminarMateria="CREATE PROCEDURE `eliminarMateria`(IN `cod` INT)\n" +
	"	\n" +
	"delete from materia where idMateria = cod ";
       
       
       String prodEliminarGrupo="CREATE PROCEDURE `eliminarGrupo`(IN `cod` INT)\n" +
	"	\n" +
	"delete from grupo where idgrupo = cod ";
       
       String prodEliminarSalon="CREATE PROCEDURE `eliminarSalon`(IN `cod` INT)\n" +
	"	\n" +
	"delete from salon where idsalon = cod ";
       
       
       String prodEliminarBackframe="CREATE PROCEDURE `eliminarbackframe`(IN `cod` INT , IN  `frame` VARCHAR(100) )\n" +
	"	\n" +
	"delete from backframe where idUsuario = cod and jframe = frame ";
//       
//       String prodEliminarBackframe="CREATE PROCEDURE `eliminarbackframe`(IN `cod` INT)\n" +
//	"	\n" +
//	"delete from backframe where idUsuario = cod";       
       
       
        try {
            Class.forName(driver);

            url = "jdbc:mysql://localhost:3306/";
            conn = DriverManager.getConnection(url + dbName, login, password);
            Statement s = conn.createStatement();
            s.executeUpdate(myTableName1);
            s.executeUpdate(myTableName2);
//            s.executeUpdate(myTableName3);
            s.executeUpdate(myTableName4);
            s.executeUpdate(myTableName5);
            s.executeUpdate(myTableName6);
            s.executeUpdate(myTableName7);
            s.executeUpdate(myTableName8);
            s.executeUpdate(myTableName9);
            s.executeUpdate(myTableName10);
            s.executeUpdate(myTableName11);
            s.executeUpdate(myTableName12);
            
            s.executeUpdate(insertTable1);
            s.executeUpdate(insertTable2);
            s.executeUpdate(insertTable3);
            s.executeUpdate(insertTable4);
            s.executeUpdate(insertTable5);
            s.executeUpdate(insertTable6);
            s.executeUpdate(insertTable7);
            s.executeUpdate(insertTable8);
            s.executeUpdate(insertTable9);
          
            s.executeUpdate(prodfiltraUsuarioID);
            s.executeUpdate(prodfiltraMateriaID);
            s.executeUpdate(prodfiltraGrupoID);
            s.executeUpdate(prodfiltraSalonID);
            s.executeUpdate(prodEliminarUsuario);
            s.executeUpdate(prodEliminarMateria);
            s.executeUpdate(prodEliminarBackframe);
            s.executeUpdate(prodEliminarSalon);
            
            
            
            
            
            
    
        
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
  
  
  
  public boolean GetConnection(String usuarioDB, String contraseña ) {
             
             
         try {
             Class.forName("com.mysql.jdbc.Driver");
             String servidor = "jdbc:mysql://localhost:3306/"+dbName;
             
             
             conn = DriverManager.getConnection(servidor, usuarioDB, contraseña);
             estado = true;
           //  estadoConexion (estado,usuarioDB, contraseña, dbName);
             
         } catch (ClassNotFoundException ex) {
            // JOptionPane.showMessageDialog(null, ex.getMessage(), "Error 1 en la Conexión con la BD " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
             log("Error 1 en la Conexión con la BD");
             conn = null;
             estado = false;
         //    estadoConexion (estado,usuarioDB, contraseña, dbName);
         } catch (SQLException ex) {
           //  JOptionPane.showMessageDialog(null, ex.getMessage(), "Error 2 en la Conexión con la BD " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
             log("Error 2 en la Conexión con la BD");
             conn = null;
             estado = false;
         //estadoConexion (estado,usuarioDB, contraseña, dbName);
         } finally {
            
         }
         return estado;
 }
  
  
  public void log(String a) {
        System.out.println("la valor  = " + " " + a);
    }
}//fin de la clase

