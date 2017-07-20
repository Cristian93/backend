package com.demo.springboot.demo.dto;

public class UsuarioDto {

    String idUsuario;
    String nomre;
    String apellido;
    String email;
    String celular;
    IdentificacionDto identificacion;

    public UsuarioDto() {
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomre() {
        return nomre;
    }

    public void setNomre(String nomre) {
        this.nomre = nomre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public IdentificacionDto getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(IdentificacionDto identificacion) {
        this.identificacion = identificacion;
    }
}
