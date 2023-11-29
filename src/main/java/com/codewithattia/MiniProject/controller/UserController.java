package com.codewithattia.MiniProject.controller;


import com.codewithattia.MiniProject.model.User;
import com.codewithattia.MiniProject.service.impl.CustomUserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/user")


public class UserController {
    @Autowired
    private CustomUserDetail userService;
    @GetMapping("/current-user")
    public User getCurrentUser(Principal principal)
    {

        return (User) this.userService.loadUserByUsername(principal.getName());

    }

}
