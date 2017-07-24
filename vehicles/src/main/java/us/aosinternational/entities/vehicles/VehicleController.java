/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.aosinternational.entities.vehicles;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Assist 02
 */
@RestController
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @RequestMapping("/vehicles")
    public List<Vehicle> getVehicles() throws IOException {

        return vehicleService.getVehicles();
    }

    @RequestMapping("/vehicles/{licensePlate}")
    public Vehicle getVehicle(@PathVariable String licensePlate) throws IOException {

        return vehicleService.getVehicle(licensePlate);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/vehicles")
    public void createVehicle(@RequestBody Vehicle[] vehicles) throws IOException {
        vehicleService.createVehicle(vehicles);
    }
}
