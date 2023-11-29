package com.codewithattia.MiniProject.service;

import com.codewithattia.MiniProject.dto.JwtAuthenticationResponse;
import com.codewithattia.MiniProject.dto.LoginRequest;
import com.codewithattia.MiniProject.dto.SignUpRequest;
import com.codewithattia.MiniProject.model.User;

public interface AuthenticationService {
    User signup(SignUpRequest signUpRequest);
    JwtAuthenticationResponse signIn(LoginRequest loginRequest);
}
