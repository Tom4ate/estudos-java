package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    // @GetMapping("/home")
    // public String home(@RequestParam(defaultValue = "Lucas") String name) {
    //     return "Hello " + name;
    // }

    @GetMapping("/home")
    public String home() {
        return "Hello ";
    }

}