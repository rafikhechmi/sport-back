package com.project.sport.controllers;

import com.project.sport.dto.AuthenticationCredentials;
import com.project.sport.dto.AuthenticationResponse;
import com.project.sport.services.LoginService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public AuthenticationResponse login(@RequestBody AuthenticationCredentials credentials) throws Exception {
        return loginService.authenticateUser(credentials);
    }

}
