package com.demo.springboot.demo;

import com.demo.springboot.demo.Dto.ComparendosDto;
import com.demo.springboot.demo.Dto.IdentificacionDto;
import com.demo.springboot.demo.Services.ComparendoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import servicios.ClsDatosComparendos;
import servicios.EstadoCuenta_Service;
import servicios.Exception_Exception;
import java.util.ArrayList;
import java.util.List;

@RestController
public class GreetingController {

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

    @PostMapping("/comparendos")
    public List<ComparendosDto> getComparendos(@RequestBody IdentificacionDto identificacion) {
        List<ComparendosDto> listComparendosDto = new ArrayList<>();

        if (identificacion.getTipo() != null && identificacion.getNumero() != null) {
            listComparendosDto = comparendoService.getComparendos(identificacion);
        }
        return listComparendosDto;
    }
}
