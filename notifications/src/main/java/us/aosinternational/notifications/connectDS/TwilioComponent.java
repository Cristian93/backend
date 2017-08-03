package us.aosinternational.notifications.connectDS;

import com.twilio.Twilio;

/**
 *
 * @author Cristian David Franco Garcia
 */
public class TwilioComponent {

    public static final String ACCOUNT_SID = "ACde2a91e339ab3fd86ead445c8b49beb1";
    public static final String AUTH_TOKEN = "f3692e5c8d1951bc330281dc22a28146";
    public static final String FROM = "+17863984877";

    public void getTwilioConnection() {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }
}
