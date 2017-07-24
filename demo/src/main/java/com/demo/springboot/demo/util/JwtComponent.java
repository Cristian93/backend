package com.demo.springboot.demo.util;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;
import com.google.firebase.tasks.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class JwtComponent {
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtComponent.class);

    public Task<FirebaseToken> verifyJWT(FirebaseApp firebaseApp, String token) {
        LOGGER.info("Verificando token " + token);
        return FirebaseAuth.getInstance(firebaseApp)
                .verifyIdToken(token)
                .addOnSuccessListener(verifyToken -> LOGGER.info("Usuario " + verifyToken.getUid() + " verficado.") )
                .addOnFailureListener(e -> LOGGER.error(e.getClass() + " : " + e.getMessage()));
    }

    public Task<String> createJWT(FirebaseToken firebaseToken){
        String uid = firebaseToken.getUid();
        HashMap<String, Object> additionalClaims = new HashMap<>();
        additionalClaims.put("entity", "Bancolombia");
        additionalClaims.put("email", firebaseToken.getEmail());
        additionalClaims.put("name", firebaseToken.getName());
        additionalClaims.put("picture", firebaseToken.getPicture());
        return FirebaseAuth.getInstance().createCustomToken(uid, additionalClaims)
                .addOnSuccessListener(token -> LOGGER.info("Token creado: " +token))
                .addOnFailureListener(e -> LOGGER.error(e.getClass() + " : " + e.getMessage()));
    }
}
