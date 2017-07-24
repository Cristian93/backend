package com.demo.springboot.demo.ResourceController;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;
import com.google.firebase.auth.internal.FirebaseCustomAuthToken;
import com.google.firebase.tasks.OnSuccessListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@RestController
@RequestMapping("login")
public class LoginController {

    @GetMapping
    public void authenticate(HttpServletRequest request) {
        System.out.println("Token: " + request.getHeader("Authorization"));

        try {
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setServiceAccount(new FileInputStream(ClassLoader.getSystemResource("taxRobot.json").getFile()))
                    .setDatabaseUrl("https://taxrobot-51cb8.firebaseio.com/")
                    .build();

            FirebaseApp firebasApp = FirebaseApp.initializeApp(options);
            FirebaseAuth.getInstance(firebasApp).verifyIdToken(request.getHeader("Authorization"))
                    .addOnSuccessListener(new OnSuccessListener<FirebaseToken>() {
                        @Override
                        public void onSuccess(FirebaseToken decodeToken) {
                            System.out.println("UID: " + decodeToken.getUid());
                            System.out.println("Email: " + decodeToken.getEmail());
                        }
                    });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
