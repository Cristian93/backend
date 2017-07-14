package com.demo.springboot.demo.Dto;

public class IdentificacionDto {

    private String numero;

    private Integer tipo;

    public IdentificacionDto() {
    }

    public IdentificacionDto(String numero, Integer tipo) {
        this.numero = numero;
        this.tipo = tipo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

}
