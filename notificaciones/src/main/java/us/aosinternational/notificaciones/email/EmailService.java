/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.aosinternational.notificaciones.email;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cristian David Franco Garcia
 */
@Service
public class EmailService {

    private List<Email> emailss = new ArrayList<>(Arrays.asList(new Email("cristian.franco@aossas.com", "Pago de Multa", "Paguela")));

    public List<Email> getEmails() {

        return emailss;
    }

    //Crear Email
    public void sendEmail(Email[] emails) {

        //emails.add(email);
        for (int i = 0; i < emails.length; i++) {

            //Enviar mensaje
            try {

                String FROM = "cristiandavidfrancogarcia@gmail.com";

                Properties props = new Properties();
                props.setProperty("mail.smtp.host", "smtp.gmail.com");
                props.setProperty("mail.smtp.ssl.enable", "true");
                props.setProperty("mail.smtp.starttls.enable", "true");
                props.setProperty("mail.smtp.auth", "true");
                props.setProperty("mail.smtp.port", "465");
                props.setProperty("mail.smtp.user", FROM);

                // Preparamos la sesion
                Session session = Session.getDefaultInstance(props);

                // Construimos el mensaje
                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress(FROM));
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(
                        emails[i].getTo()));
                message.setSubject(emails[i].getSubject());
                message.setText(emails[i].getText());

                // Lo enviamos.
                Transport t = session.getTransport("smtp");
                t.connect(FROM, "PRUEBASAOS");
                t.sendMessage(message, message.getAllRecipients());
                // Cierre.
                t.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

}
