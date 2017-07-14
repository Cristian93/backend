package com.demo.springboot.demo.Services;

import com.demo.springboot.demo.Dto.ComparendosDto;
import com.demo.springboot.demo.Dto.IdentificacionDto;
import org.springframework.stereotype.Component;
import servicios.ClsDatosComparendos;
import servicios.EstadoCuenta_Service;
import servicios.Exception_Exception;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ComparendoService {

    public List<ComparendosDto> getComparendos(IdentificacionDto identificacion) {
        List<ClsDatosComparendos> listClsDatosComparendos = null;
        List<ComparendosDto> listComparendosDto = new ArrayList<>();

        try {
            listClsDatosComparendos = new EstadoCuenta_Service().getEstadoCuentaPort().comparendos(identificacion.getNumero(), identificacion.getTipo()).getComparendos();
            listComparendosDto = listClsDatosComparendos.stream()
                    .map(datos -> new ComparendosDto(
                                    datos.getNumeroComparendo(),
                                    identificacion,
                                    datos.getFechaComparendo(),
                                    datos.getDireccionComparendo(),
                                    datos.getEstadoComparendo(),
                                    Boolean.valueOf(datos.getFotodeteccion()),
                                    datos.getCodigoInfraccion(),
                                    new BigDecimal(datos.getTotal()),
                                    datos.getSecretariaComparendo(),
                                    datos.getPlacaVehiculo(),
                                    datos.getTipoVehiculo(),
                                    datos.getServicioVehiculo()
                            )
                    ).collect(Collectors.toList());
        } catch (Exception_Exception e) {
            e.printStackTrace();
        }
        return listComparendosDto;
    }
}
