package com.codewithattia.MiniProject.controller;

import com.codewithattia.MiniProject.dto.JwtAuthenticationResponse;
import com.codewithattia.MiniProject.dto.LoginRequest;
import com.codewithattia.MiniProject.dto.SignUpRequest;
import com.codewithattia.MiniProject.model.User;
import com.codewithattia.MiniProject.service.AuthenticationService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@CrossOrigin("*")
@RequestMapping("/api/auth")


public class AuthenticationController {

    
    @Autowired
    private AuthenticationService authenticationService;


    @PostMapping("/signup")
    public ResponseEntity<User>sighup(@RequestBody SignUpRequest signUpRequest)
    {
        return ResponseEntity.ok(authenticationService.signup(signUpRequest));

    }
    @PostMapping("/login")
    public ResponseEntity<JwtAuthenticationResponse>signin(@RequestBody LoginRequest loginRequest)
    {
        return ResponseEntity.ok(authenticationService.signIn(loginRequest));

    }



}
