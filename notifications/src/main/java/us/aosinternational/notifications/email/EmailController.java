package us.aosinternational.notifications.email;

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
public class EmailController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailController.class);

    @Autowired
    private EmailService emailService;

    /*@RequestMapping("/emails")
    public List<Email> getEmails() {
        return emailService.getEmails();
    }*/
    @RequestMapping(method = RequestMethod.POST, value = "/emails")
    public void sendEmail(@RequestBody Email[] emails) throws IOException {
        LOGGER.info("Envio de " + emails.length + " correo(s) electrónicos");
        emailService.sendEmail(emails);
    }

    /*@RequestMapping(method = RequestMethod.POST, value = "/emailsAdmin")
    public void sendEmailAdmin() throws IOException {
        emailService.sendEmailAdmin();
    }*/
}
