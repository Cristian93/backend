package com.demo.springboot.demo.Dto;

public class IdentificacionDto {

    private String numero;

    private Integer tipo;

    private String placa;

    public IdentificacionDto() {
    }

    public IdentificacionDto(String numero, Integer tipo, String placa) {
        this.numero = numero;
        this.tipo = tipo;
        this.placa = placa;
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

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
