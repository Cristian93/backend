package com.taxrobot.services.services;

import com.taxrobot.services.dto.FineDto;
import com.taxrobot.services.dto.GetFineRequestDto;
import com.taxrobot.services.resourceController.FineController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import servicios.ClsDatosComparendos;
import servicios.EstadoCuenta_Service;
import servicios.Exception_Exception;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FineService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FineController.class);

    public List<FineDto> getFine(GetFineRequestDto identificacion) {
        List<ClsDatosComparendos> listClsDatosComparendos;
        List<FineDto> listFineDto = new ArrayList<>();
        try {
            listClsDatosComparendos = new EstadoCuenta_Service().getEstadoCuentaPort().comparendos(identificacion.getNumero(), identificacion.getTipo()).getComparendos();
            LOGGER.info("Se encontraron " + listClsDatosComparendos.size() + " comparendos");
            if (listClsDatosComparendos.size() > 0) {
                listClsDatosComparendos.stream().sorted();
                listFineDto = getMapListDto(listClsDatosComparendos, identificacion);
            }
        } catch (Exception_Exception e) {
            LOGGER.error(e.getClass() + " - " + e.getMessage());
        }
        return listFineDto;
    }

    public List<FineDto> getFinePlaca(GetFineRequestDto identificacion) {
        List<FineDto> listFineDto = getFine(identificacion);
        try {
            if (listFineDto.size() > 0) {
                listFineDto = listFineDto.stream()
                        .filter(clsDatosComparendos -> identificacion.getPlacas().contains(clsDatosComparendos.getPlacaVehiculo()))
                        .collect(Collectors.toList());
            }
        } catch (Exception e) {
            LOGGER.error(e.getClass() + " - " + e.getMessage());
        }
        return listFineDto;
    }

    public List<FineDto> getMapListDto(List<ClsDatosComparendos> listClsDatosComparendos, GetFineRequestDto identificacion) {
        List<FineDto> listFineDto = new ArrayList<>();
        try {
            listFineDto = listClsDatosComparendos.stream()
                    .map(fine -> new FineDto(
                                    fine.getNumeroComparendo(),
                                    fine.getFechaComparendo(),
                                    fine.getDireccionComparendo(),
                                    fine.getEstadoComparendo(),
                                    Boolean.valueOf(fine.getFotodeteccion()),
                                    fine.getCodigoInfraccion(),
                                    new BigDecimal(fine.getTotal()),
                                    fine.getSecretariaComparendo(),
                                    fine.getPlacaVehiculo(),
                                    fine.getTipoVehiculo(),
                                    fine.getServicioVehiculo()
                            )
                    ).collect(Collectors.toList());
        } catch (Exception e) {
            LOGGER.error(e.getClass() + " - " + e.getMessage());
        }

        return listFineDto;
    }
}
