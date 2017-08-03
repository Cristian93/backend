/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.aosinternational.notifications.connectDS;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import java.io.IOException;
import org.springframework.core.io.ClassPathResource;

/**
 *
 * @author Assist 02
 */
public class GoogleDataStoreComponent {

    private static Datastore datastore;

    public GoogleDataStoreComponent() {
        datastore = createDatastore();
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        return options.getService();
    }

    public Datastore getDatastore() {
        return datastore;
    }

}
