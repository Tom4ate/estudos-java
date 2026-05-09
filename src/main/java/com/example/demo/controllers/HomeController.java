package com.example.demo.controllers;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public HashMap<String, String> index() {
        return new HashMap<String, String>() {{
            put("message", "Your server is running!");
            put("time", String.valueOf(System.currentTimeMillis()));
        }};
    }


    @GetMapping("/home")
    public String home() {
        return "Hello ";
    }
    
    // @GetMapping("/home")
    // public String home(@RequestParam(defaultValue = "Lucas") String name) {
    //     return "Hello " + name;
    // }


}