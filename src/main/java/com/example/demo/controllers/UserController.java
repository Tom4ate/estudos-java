package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

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

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @PostMapping("/users")
    public User postUser(@RequestBody User entity) {
        return repository.save(entity);
    }

    @PatchMapping("/users/{id}")
    public User patchUser(@PathVariable Long id, @RequestBody User entity) {
        return repository.findById(id)
                .map(user -> {
                    if (entity.getName() != null) user.setName(entity.getName());
                    if (entity.getEmail() != null) user.setEmail(entity.getEmail());
                    if (entity.getPassword() != null) user.setPassword(entity.getPassword());
                    return repository.save(user);
                })
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
    }

    // @PutMapping("/users/{id}")
    // public String putUser(@PathVariable String id, @RequestBody String entity) {   
    //     return entity;
    // }

}
