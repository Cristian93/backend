package com.demo.springboot.demo.resourceController;

import com.demo.springboot.demo.connectDS.FireBaseComponent;
import com.demo.springboot.demo.util.JwtComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    private JwtComponent jwtComponent;

    @Autowired
    private FireBaseComponent fireBaseComponent;

    @GetMapping
    public void authenticate(HttpServletRequest request) {
        System.out.println("Token: " + request.getHeader("Authorization"));
        jwtComponent.verifyJWT(fireBaseComponent.getFirebaseApp(), request.getHeader("Authorization"));
    }

}
