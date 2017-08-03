package com.taxrobot.services.dto;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FineDto {

    private String numero;
    private Date fecha;
    private String direccion;
    private String estado;
    private Boolean fotodeteccion;
    private String codigo;
    private BigDecimal total;
    private String secretaria;
    private String placaVehiculo;
    private String tipoVehiculo;
    private String servicioVehiculo;

    public FineDto(String numero, String fecha, String direccion, String estado, Boolean fotodeteccion, String codigo, BigDecimal total, String secretaria, String placaVehiculo, String tipoVehiculo, String servicioVehiculo) {
        this.numero = numero;
        this.fecha = parseDate(fecha);
        this.direccion = direccion;
        this.estado = estado;
        this.fotodeteccion = fotodeteccion;
        this.codigo = codigo;
        this.total = total;
        this.secretaria = secretaria;
        this.placaVehiculo = placaVehiculo;
        this.tipoVehiculo = tipoVehiculo;
        this.servicioVehiculo = servicioVehiculo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Boolean getFotodeteccion() {
        return fotodeteccion;
    }

    public void setFotodeteccion(Boolean fotodeteccion) {
        this.fotodeteccion = fotodeteccion;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPlacaVehiculo() {
        return placaVehiculo;
    }

    public void setPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
    }

    public String getSecretaria() {
        return secretaria;
    }

    public void setSecretaria(String secretaria) {
        this.secretaria = secretaria;
    }

    public String getServicioVehiculo() {
        return servicioVehiculo;
    }

    public void setServicioVehiculo(String servicioVehiculo) {
        this.servicioVehiculo = servicioVehiculo;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Date parseDate(String sFecha) {
        Date fecha = null;
        try {
            fecha = new SimpleDateFormat("yyyy/MM/dd").parse(sFecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return fecha;
    }
}