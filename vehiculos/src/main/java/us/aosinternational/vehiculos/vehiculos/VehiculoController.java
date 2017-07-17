/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.aosinternational.vehiculos.vehiculos;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Assist 02
 */
@RestController
public class VehiculoController {

    @Autowired
    VehiculoService vehiculoService;

    @RequestMapping("/vehiculos")
    public List<Vehiculo> getVehiculos() {

        return vehiculoService.getVehiculos();
    }

}
