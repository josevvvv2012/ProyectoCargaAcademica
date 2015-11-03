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
public class Usuario{
    
    
    int idUsuario;
    int identificacion;
    String nombre;
    Perfil idPerfil;
    String login;
    String contrasenia;
    boolean estado;

    
     public Usuario() {
    }
    public Usuario(int idUsuario,int identificacion, String nombre,Perfil idPerfil, String login, String contrasenia, boolean estado) {
        this.idUsuario = idUsuario;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.idPerfil = idPerfil;
        this.login = login;
        this.contrasenia = contrasenia;
        this.estado = estado;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Perfil getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Perfil idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    @Override
    public String toString() {
        return getNombre();
    }

    
    
    
   
    
    
    
    
}
