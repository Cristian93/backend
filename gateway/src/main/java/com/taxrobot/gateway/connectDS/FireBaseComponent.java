package com.taxrobot.gateway.connectDS;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class FireBaseComponent {

    private static FirebaseApp firebaseApp;
    private static final Logger LOGGER = LoggerFactory.getLogger(FireBaseComponent.class);

    private FireBaseComponent() {
        firebaseApp = FirebaseApp.initializeApp(getOptions());
    }

    FirebaseOptions getOptions() {
        FirebaseOptions options = null;
        try {
            options = new FirebaseOptions.Builder()
                    .setServiceAccount(new ClassPathResource("/taxRobot.json").getInputStream())
                    .setDatabaseUrl("https://taxrobot-51cb8.firebaseio.com/")
                    .build();
        } catch (IOException e) {
            LOGGER.error(e.getClass() + ": " + e.getMessage());
        }
        return options;
    }

    public FirebaseApp getFirebaseApp() {
        return firebaseApp;
    }
}

