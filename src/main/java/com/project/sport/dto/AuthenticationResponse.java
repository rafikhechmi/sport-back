package com.project.sport.dto;

import java.io.Serializable;
import java.util.List;

public class AuthenticationResponse implements Serializable {

    private final String token;

    private final String username;

    private final List<String> roles;

    public String getToken() {
        return token;
    }

    public String getUsername() {
        return username;
    }

    public List<String> getRoles() {
        return roles;
    }

    public AuthenticationResponse(String token, String username, List<String> roles) {
        this.token = token;
        this.username = username;
        this.roles = roles;
    }
}
