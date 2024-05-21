package com.example.awsjavaspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/security")
public class SecurityController {

    @GetMapping("/home")
    public String home() {
        return "SecurityHome"; // Return the home page view
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "SecurityWelcome"; // Return the welcome page view
    }
}
