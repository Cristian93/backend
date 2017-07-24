package com.demo.springboot.demo.dto;

import java.util.List;

public class IdentificacionDto {

    private String numero;

    private Integer tipo;

    private List<String> placas;

    public IdentificacionDto() {
    }

    public IdentificacionDto(String numero, Integer tipo, List<String> placas) {
        this.numero = numero;
        this.tipo = tipo;
        this.placas = placas;
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

    public List<String> getPlacas() {
        return placas;
    }

    public void setPlacas(List<String> placas) {
        this.placas = placas;
    }
}
