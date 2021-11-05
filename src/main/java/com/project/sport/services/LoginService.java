package com.project.sport.services;

import com.project.sport.dto.AuthenticationCredentials;
import com.project.sport.dto.AuthenticationResponse;

public interface LoginService {

    AuthenticationResponse authenticateUser(AuthenticationCredentials credentials) throws Exception;

}
