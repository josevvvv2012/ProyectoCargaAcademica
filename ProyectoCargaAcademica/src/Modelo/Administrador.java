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
public class Administrador {
 
    
  
  
   int idAdmin;
   String tipoContrato;
  
  
    public Administrador() {
    }
    public Administrador(int idAdmin, String tipoContrato) {
        this.idAdmin = idAdmin;
        this.tipoContrato = tipoContrato;
        
    }
  
  
  /**
 * @return the idAdmin
 */
public int getIdAdmin() {
    return idAdmin;
}
  
  /**
 * @return the tipoContrato
 */
public String getTipoContrato() {
    return tipoContrato;
}
  
  /**
 * @param idAdmin the idAdmin to set
 */
public void setIdAdmin(int idAdmin) {
    this.idAdmin = idAdmin;
}
  
  /**
 * @param tipoContrato the tipoContrato to set
 */
public void setTipoContrato(String tipoContrato) {
    this.tipoContrato = tipoContrato;
}
  
 }