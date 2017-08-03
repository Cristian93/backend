package us.aosinternational.parametrization.entities;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Cristian David Franco Garcia
 */
@RestController
public class ParametrizationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ParametrizationController.class);

    @Autowired
    private ParametrizationService parametrizationService;

    @RequestMapping("/parametrization")
    public Parametrization getParametrization() throws IOException {
        LOGGER.info("Ingresa consulta de parametrización");
        return parametrizationService.getParametrization();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/parametrization")
    public void saveParametrization(@RequestBody Parametrization parametrization) throws IOException {
        LOGGER.info("Ingresa guardar parametrización");
        parametrizationService.saveParametrization(parametrization);

    }

}
