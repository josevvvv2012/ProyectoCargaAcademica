/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author negro
 */
public class Materia {
    
    String myTableName6 ="CREATE TABLE IF NOT EXISTS `baaa0`.`materia` (\n" +
"  `idMateria` INT(11) NOT NULL COMMENT '',\n" +
"  `nombreMateria` VARCHAR(50) NULL DEFAULT NULL COMMENT '',\n" +
"  `tipo` VARCHAR(50) NULL DEFAULT NULL COMMENT '',\n" +
"  `creditos` INT(11) NULL DEFAULT NULL COMMENT '',\n" +
"  `intHoraria` INT(11) NULL DEFAULT NULL COMMENT '',\n" +
"  `semestre` INT(11) NULL DEFAULT NULL COMMENT '',\n" +
"  `idAdministrador` INT(11) NULL DEFAULT NULL COMMENT '',\n" +
"  PRIMARY KEY (`idMateria`)  COMMENT '',\n" +
"  INDEX `idAdministrador` (`idAdministrador` ASC)  COMMENT '',\n" +
"  CONSTRAINT `FK_Materia_Administrador`\n" +
"    FOREIGN KEY (`idAdministrador`)\n" +
"    REFERENCES `baaa0`.`administrador` (`idAdmin`))\n" +
"ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;";
  
  
  
  int idMateria;
  String nombreMateria;
  String tipo;
  int creditos;
  int intHoraria;
  int semestre;
  Administrador idAdministrador;
  
  
  
    public Materia() {
    }
    public Materia(int idMateria,String nombreMateria,String tipo,int creditos,int intHoraria,int semestre,Administrador idAdministrador) {
        this.idMateria = idMateria;
        this.nombreMateria = nombreMateria;
        this.tipo = tipo;
        this.creditos = creditos;
        this.intHoraria = intHoraria;
        this.semestre = semestre;
        this.idAdministrador = idAdministrador;
    }
  
  
  
  /**
 * @return the idMateria
 */
public int getIdMateria() {
    return idMateria;
}
  
  /**
 * @return the nombreMateria
 */
public String getNombreMateria() {
    return nombreMateria;
}
  
  /**
 * @return the tipo
 */
public String getTipo() {
    return tipo;
}
  
  
  /**
 * @return the creditos
 */
public int getCreditos() {
    return creditos;
}
  
  
  /**
 * @return the intHoraria
 */
public int getIntHoraria() {
    return intHoraria;
}
  
  /**
 * @return the semestre
 */
public int getSemestre() {
    return semestre;
}
  
  
   /**
 * @return the idAdministrador
 */
 public Administrador getidAdministrador() {
        return idAdministrador;
    }
  
  
  /**
 * @param idMateria the idMateria to set
 */
public void setIdMateria(int idMateria) {
    this.idMateria = idMateria;
}
  
  
  /**
 * @param nombreMateria the nombreMateria to set
 */
public void setNombreMateria(String nombreMateria) {
    this.nombreMateria = nombreMateria;
}
  
 /**
 * @param tipo the tipo to set
 */
public void setTipo(String tipo) {
    this.tipo = tipo;
}
  
  /**
 * @param creditos the creditos to set
 */
public void setCreditos(int creditos) {
    this.creditos = creditos;
}
  
  /**
 * @param intHoraria the intHoraria to set
 */
public void setIntHoraria(int intHoraria) {
    this.intHoraria = intHoraria;
}
  
  /**
 * @param semestre the semestre to set
 */
public void setSemestre(int semestre) {
    this.semestre = semestre;
}
  
 public void setidAdministrador(Administrador idAdministrador) {
        this.idAdministrador = idAdministrador;
    }
  

  
}
