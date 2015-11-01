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
public class Perfil {
    
    
    int idPerfil;
    String nombre;
    int estado;

    public Perfil(int idPerfil, String nombre, int estado) {
        this.idPerfil = idPerfil;
        this.nombre = nombre;
        this.estado = estado;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int isEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        return getNombre();
    } 
    
}
