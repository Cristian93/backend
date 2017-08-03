package com.taxrobot.services.resourceController;

import com.taxrobot.services.dto.GetFineRequestDto;
import com.taxrobot.services.dto.TaxDto;
import com.taxrobot.services.services.TaxService;
import com.taxrobot.services.services.VehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tax")
public class TaxController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaxController.class);

    private final VehicleService vehicleService;

    private final TaxService taxService;

    @Autowired
    public TaxController(VehicleService vehicleService, TaxService taxService) {
        this.vehicleService = vehicleService;
        this.taxService = taxService;
    }

    @PostMapping
    public List<TaxDto> getTax(@RequestBody GetFineRequestDto licensesRequest){
        LOGGER.info("Ingreso a consulta de Impuestos");
        List<String> licensesList;
        if(null == licensesRequest.getPlacas() || licensesRequest.getPlacas().size() < 1){
            licensesList = new ArrayList<>();
            vehicleService.getVehicles().forEach(vehicle -> licensesList.add(vehicle.getLicensePlate()));
        }else{
            licensesList = licensesRequest.getPlacas();
        }
        List<TaxDto> taxList = taxService.getTax(licensesList);
        return taxList;
    }
}
