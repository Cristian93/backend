/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.aosinternational.notificaciones.email;

import java.lang.reflect.Method;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Assist 02
 */
@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @RequestMapping("/emails")
    public List<Email> getEmails() {
        return emailService.getEmails();
    }

    //sendEmails
    @RequestMapping(method = RequestMethod.POST, value = "/emails")
    public void sendEmail(@RequestBody Email email) {
        emailService.sendEmail(email);
    }
}
