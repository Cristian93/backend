/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.aosinternational.notificaciones.SMS;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Cristian David Franco Garcia
 */
@RestController
public class SMSController {

    @Autowired
    SMSService SMSservice;

    @RequestMapping("/SMSs")
    public List<SMS> SMSs() {

        return SMSservice.getSMSs();

    }

    @RequestMapping(method = RequestMethod.POST, value = "/SMSs")
    public void sendSMS(@RequestBody SMS SMS) {
        SMSservice.sendSMS(SMS);
    }

}
