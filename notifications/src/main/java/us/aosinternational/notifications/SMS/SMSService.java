/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.aosinternational.notifications.SMS;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.stereotype.Service;
import us.aosinternational.notifications.SMS.SMS;

/**
 *
 * @author Cristian David Franco Garcia
 */
@Service
public class SMSService {

    private List<SMS> SMSs = new ArrayList<>(Arrays.asList(new SMS("+573208943", "Pago de Multa - Paguela")));

    public List<SMS> getSMSs() {
        return SMSs;
    }

    public void sendSMS(SMS SMS) {
        SMSs.add(SMS);

        //Enviar SMS   
        String ACCOUNT_SID = "ACde2a91e339ab3fd86ead445c8b49beb1";
        String AUTH_TOKEN = "f3692e5c8d1951bc330281dc22a28146";

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(new PhoneNumber(SMS.getTo()), new PhoneNumber("+17863984877"), SMS.getText()).create();

        /*Message message = Message.creator(new PhoneNumber(SMS.getTo()), new PhoneNumber(SMS.getFrom()),
                SMS.getText())
                .setMediaUrl("https://c1.staticflickr.com/3/2899/14341091933_1e92e62d12_b.jpg")
                .create();*/
        System.out.println(message.getSid());
    }

}
