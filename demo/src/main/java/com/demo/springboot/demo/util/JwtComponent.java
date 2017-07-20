package com.demo.springboot.demo.util;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;
import com.google.firebase.tasks.OnFailureListener;
import com.google.firebase.tasks.OnSuccessListener;
import org.springframework.stereotype.Component;

@Component
public class JwtComponent {

    private FirebaseAuth firebaseAuth;
    private FirebaseToken tokenBase;

    public FirebaseToken verifyJWT(FirebaseApp firebaseApp, String token) {
        firebaseAuth = FirebaseAuth.getInstance(firebaseApp);
        firebaseAuth.verifyIdToken(token)
                .addOnSuccessListener(new OnSuccessListener<FirebaseToken>() {
                    @Override
                    public void onSuccess(FirebaseToken firebaseToken) {
                        System.out.println("OK");
                        tokenBase = firebaseToken;
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(Exception e) {
                        System.out.println("Fallo");
                    }
                });
        return tokenBase;
    }
}
