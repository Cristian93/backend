package us.aosinternational.notifications.SMS;

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
public class SMSController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SMSController.class);

    @Autowired
    SMSService SMSservice;

    /*@RequestMapping("/SMSs")
    public List<SMS> SMSs() {
        return SMSservice.getSMSs();
    }*/
    @RequestMapping(method = RequestMethod.POST, value = "/SMSs")
    public void sendSMS(@RequestBody SMS[] SMSs) {
        LOGGER.info("Envio de " + SMSs.length + " SMS(s)");
        SMSservice.sendSMS(SMSs);
    }

}
