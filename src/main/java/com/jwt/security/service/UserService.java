package com.jwt.security.service;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.jwt.security.entities.User;
import com.jwt.security.repositories.UserRepository;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
private UserRepository userRepository;

@Autowired
private PasswordEncoder passwordEncoder;
    public List<User> getUser(){
        return userRepository.findAll();
    }

    @PostMapping("/create-user")
    public User createUser(User user){
        user.setUserId(UUID.randomUUID().toString());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    @GetMapping("/current-user")
    public String getLoggedInUser(Principal principal){
        return principal.getName();
    }
}
