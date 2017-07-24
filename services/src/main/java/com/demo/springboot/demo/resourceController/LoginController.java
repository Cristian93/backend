package com.demo.springboot.demo.resourceController;

import com.demo.springboot.demo.connectDS.FireBaseComponent;
import com.demo.springboot.demo.util.JwtComponent;
import com.google.firebase.auth.FirebaseToken;
import com.google.firebase.tasks.Task;
import com.google.firebase.tasks.Tasks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("login")
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private JwtComponent jwtComponent;

    @Autowired
    private FireBaseComponent fireBaseComponent;

    @GetMapping
    public void authenticate(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("Ingresa a control de autenticacion de usuario mediante el token");
        String newToken = "NOT AUTHORIZED";
        try {
            FirebaseToken token = Tasks.await(jwtComponent.verifyJWT(fireBaseComponent.getFirebaseApp(), request.getHeader("Authorization")));
            newToken = Tasks.await(jwtComponent.createJWT(token));
        } catch (ExecutionException | InterruptedException e) {
            LOGGER.error(e.getClass() + ": " + e.getMessage() );
        }
        response.setHeader("Authorization", newToken);
    }

    @GetMapping("/test")
    public void pruebaToken(HttpServletRequest request){
        try {
            FirebaseToken token = Tasks.await(jwtComponent.verifyJWT(fireBaseComponent.getFirebaseApp(), request.getHeader("Authorization")));
            System.out.println("TOKEN: " + token.getEmail());
        } catch (ExecutionException | InterruptedException e) {
            LOGGER.error(e.getClass() + ": " + e.getMessage() );
        }
    }

}
