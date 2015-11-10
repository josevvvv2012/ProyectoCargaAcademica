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
public class Salon {
    
    int idSalon;
    String codigoSalonM;
    String nombreSalon;
    String Ubicacion;
    boolean estado;
    
     public Salon() {
    }

    public Salon(int idSalon, String codigoSalonM, String nombreSalon, String Ubicacion, boolean estado) {
        this.idSalon = idSalon;
        this.codigoSalonM = codigoSalonM;
        this.nombreSalon = nombreSalon;
        this.Ubicacion = Ubicacion;
        this.estado = estado;
    }

    public int getIdSalon() {
        return idSalon;
    }

    public void setIdSalon(int idSalon) {
        this.idSalon = idSalon;
    }

    public String getCodigoSalonM() {
        return codigoSalonM;
    }

    public void setCodigoSalonM(String codigoSalonM) {
        this.codigoSalonM = codigoSalonM;
    }

    public String getNombreSalon() {
        return nombreSalon;
    }

    public void setNombreSalon(String nombreSalon) {
        this.nombreSalon = nombreSalon;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String Ubicacion) {
        this.Ubicacion = Ubicacion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return getNombreSalon();
    } 
    
}
