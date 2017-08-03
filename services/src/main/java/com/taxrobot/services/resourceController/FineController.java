package com.taxrobot.services.resourceController;

import com.taxrobot.services.dto.FineDto;
import com.taxrobot.services.dto.GetFineRequestDto;
import com.taxrobot.services.services.FineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/fine")
public class FineController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FineDto.class);

    @Autowired
    private FineService fineService;

    @PostMapping
    public List<FineDto> getFine(@RequestBody GetFineRequestDto fineRequest) {
        LOGGER.info("Ingreso a consulta de comparendos");
        List<FineDto> listFineDto = new ArrayList<>();

        try  {
            if(fineRequest.getPlacas().size() > 0 && fineRequest.getPlacas() != null){
                LOGGER.info("Placas a consultar: " + fineRequest.getPlacas());
                listFineDto = fineService.getFinePlaca(fineRequest);
            }else{
                listFineDto = fineService.getFine(fineRequest);
            }
        }catch (NullPointerException e){
            LOGGER.error(e.getClass() + " - " + e.getMessage());
        }
        return listFineDto;
    }
}
