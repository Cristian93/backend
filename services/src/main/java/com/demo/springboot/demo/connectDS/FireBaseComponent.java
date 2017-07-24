package com.demo.springboot.demo.connectDS;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Service
public class FireBaseComponent {

    private FirebaseApp firebaseApp;

    public FirebaseOptions getOptions(){
        FirebaseOptions options = null;
        try {
            options = new FirebaseOptions.Builder()
                    .setServiceAccount(new FileInputStream(ClassLoader.getSystemResource("taxRobot.json").getFile()))
                    .setDatabaseUrl("https://taxrobot-51cb8.firebaseio.com/")
                    .build();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return options;
    }

    public FirebaseApp getFirebaseApp(){
        if(firebaseApp == null){
            return firebaseApp = FirebaseApp.initializeApp(getOptions());
        }else{
            return firebaseApp;
        }
    }
}

