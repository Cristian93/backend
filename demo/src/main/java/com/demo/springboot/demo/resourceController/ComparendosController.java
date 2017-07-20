package com.demo.springboot.demo.resourceController;

import com.demo.springboot.demo.dto.ComparendosDto;
import com.demo.springboot.demo.dto.IdentificacionDto;
import com.demo.springboot.demo.services.ComparendoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import servicios.ClsDatosComparendos;
import servicios.EstadoCuenta_Service;
import servicios.Exception_Exception;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/comparendos")
public class ComparendosController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ComparendosDto.class);

    @Autowired
    private ComparendoService comparendoService;

    @GetMapping("/hi/{name}")
    public String hi(@PathVariable String name) {

        IdentificacionDto id = new IdentificacionDto();
        id.setNumero("8909039388");
        id.setTipo(4);

        try {
            List<ClsDatosComparendos> listComparendos = new EstadoCuenta_Service().getEstadoCuentaPort().comparendos(id.getNumero(), id.getTipo()).getComparendos();
            listComparendos.forEach((comparendo) -> System.out.println("comparendo : " + comparendo.getCodigoInfraccion() + " - " + comparendo.getInfractorComparendo()));
        } catch (Exception_Exception e) {
            e.printStackTrace();
        }
        return "Hi " + name;
    }

    @PostMapping
    @CrossOrigin
    public List<ComparendosDto> getComparendos(@RequestBody IdentificacionDto identificacion) {
        LOGGER.info("Este es el Log");
        List<ComparendosDto> listComparendosDto = new ArrayList<>();
        identificacion.getPlacas().forEach((placa) -> System.out.println("placa : " + placa ));

        if (identificacion.getTipo() != null && identificacion.getNumero() != null) {
            if(identificacion.getPlacas().size() > 0){
                listComparendosDto = comparendoService.getComparendosPlaca(identificacion);
            }else{
                listComparendosDto = comparendoService.getComparendos(identificacion);
            }
        }
        return listComparendosDto;
    }
}
