package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;

@RestController
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/users")
    public List<User> users() {
        return repository.findAll();
    }
    
}
