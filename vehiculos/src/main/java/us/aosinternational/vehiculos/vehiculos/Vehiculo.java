/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.aosinternational.vehiculos.vehiculos;

import javax.print.DocFlavor;
import us.aosinternational.usuario.Usuario;

/**
 *
 * @author Assist 02
 */
public class Vehiculo {

    private String placa;

    private String modelo;

    private String tipoVehiculo;

    private String marca;

    private String year;

    private String lugarExpedicion;

    private Usuario usuario;

    public Vehiculo() {

    }

    public Vehiculo(String placa, String modelo, String tipoVehiculo, String marca, String year, String lugarExpedicion, Usuario usuario) {
        super();
        this.placa = placa;
        this.modelo = modelo;
        this.tipoVehiculo = tipoVehiculo;
        this.marca = marca;
        this.year = year;
        this.lugarExpedicion = lugarExpedicion;
        this.usuario = usuario;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getLugarExpedicion() {
        return lugarExpedicion;
    }

    public void setLugarExpedicion(String lugarExpedicion) {
        this.lugarExpedicion = lugarExpedicion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
