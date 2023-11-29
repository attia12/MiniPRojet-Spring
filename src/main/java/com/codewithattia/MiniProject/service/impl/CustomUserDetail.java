package com.codewithattia.MiniProject.service.impl;

import com.codewithattia.MiniProject.model.User;
import com.codewithattia.MiniProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service

public class CustomUserDetail implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =(User) this.userRepository.findByEmail(username);
        if(user == null)
        {
            System.out.println("user not found");
            throw new UsernameNotFoundException("No user found !!");

        }
        return user;
    }


}


