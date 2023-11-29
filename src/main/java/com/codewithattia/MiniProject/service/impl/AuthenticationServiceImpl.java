package com.codewithattia.MiniProject.service.impl;

import com.codewithattia.MiniProject.dto.JwtAuthenticationResponse;
import com.codewithattia.MiniProject.dto.LoginRequest;
import com.codewithattia.MiniProject.dto.SignUpRequest;
import com.codewithattia.MiniProject.model.Role;
import com.codewithattia.MiniProject.model.User;
import com.codewithattia.MiniProject.repository.UserRepository;
import com.codewithattia.MiniProject.service.AuthenticationService;
import com.codewithattia.MiniProject.service.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor

public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    //validate email and pasword
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;
    public User signup(SignUpRequest signUpRequest)
    {
        User user=new User();
        user.setEmail(signUpRequest.getEmail());
        user.setFirstName(signUpRequest.getFirstName());
        user.setLastName(signUpRequest.getLastName());
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        return userRepository.save(user);
    }
    public JwtAuthenticationResponse signIn(LoginRequest loginRequest)
    {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),loginRequest.getPassword()));

        var user=userRepository.findByEmail(loginRequest.getEmail());
        var jwt=jwtService.generateToken(user);
        var refresh=jwtService.generateRefreshToken(new HashMap<>(),user);
        JwtAuthenticationResponse jwtAuthenticationResponse=new JwtAuthenticationResponse();
        jwtAuthenticationResponse.setToken(jwt);
        jwtAuthenticationResponse.setRefreshToken(refresh);
        return jwtAuthenticationResponse;

    }
}
