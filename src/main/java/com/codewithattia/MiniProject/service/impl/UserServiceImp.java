package com.codewithattia.MiniProject.service.impl;

import com.codewithattia.MiniProject.model.User;
import com.codewithattia.MiniProject.repository.UserRepository;
import com.codewithattia.MiniProject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class UserServiceImp implements UserService

{
    private final UserRepository userRepository;


    public UserDetailsService userDetailsService()
    {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return userRepository.findByEmail(username);
            }
        };
    }



}
