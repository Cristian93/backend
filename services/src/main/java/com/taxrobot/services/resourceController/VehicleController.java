package com.taxrobot.services.resourceController;

import com.taxrobot.services.dto.VehicleDto;
import com.taxrobot.services.services.VehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author Cristian David Franco Garcia
 */
@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private static final Logger LOGGER = LoggerFactory.getLogger(VehicleController.class);

    @Autowired
    VehicleService vehicleService;

    @GetMapping
    public List<VehicleDto> getVehicles() throws IOException {
        LOGGER.info("Ingresa consulta de todos los vehiculos");
        return vehicleService.getVehicles();
    }

    @GetMapping("/{licensePlate}")
    public VehicleDto getVehicle(@PathVariable String licensePlate) throws IOException {
        LOGGER.info("Ingresa consulta de vehiculos por placa: " + licensePlate);
        return vehicleService.getVehicle(licensePlate);
    }

    @PostMapping
    public void createVehicle(@RequestBody VehicleDto[] vehicles) throws IOException {
        LOGGER.info("Creación de " + vehicles.length + " vehiculos");
        vehicleService.createVehicle(vehicles);
    }
}
