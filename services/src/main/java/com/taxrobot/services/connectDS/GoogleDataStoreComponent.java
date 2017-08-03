package com.taxrobot.services.connectDS;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreException;
import com.google.cloud.datastore.DatastoreOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

public class GoogleDataStoreComponent {

    private static Datastore datastore;
    private static final Logger LOGGER = LoggerFactory.getLogger(GoogleDataStoreComponent.class);

    public GoogleDataStoreComponent() {
        datastore = createDatastore();
        LOGGER.info("Se crea conexión a Datastore");
    }

    Datastore createDatastore() {
        DatastoreOptions options = null;
        try {
            //Autenticación por medio de Google Cloud SDK Shell
            //Autenticación con archivo .json
            options = DatastoreOptions.newBuilder()
                    .setProjectId("taxrobot-51cb8")
                    .setCredentials(GoogleCredentials.fromStream(new ClassPathResource("/taxRobotDS.json").getInputStream()))
                    .build();
        } catch (IOException | DatastoreException e) {
            LOGGER.info(e.getClass() + " - " + e.getMessage());
        }
        return options.getService();
    }

    public Datastore getDatastore(){
        return datastore;
    }
}
