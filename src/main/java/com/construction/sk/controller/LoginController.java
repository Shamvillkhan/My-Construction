package com.construction.sk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginForm() {
    	System.out.println("helloCon");
        return "login"; // Points to login.html
    }

    @GetMapping("/req/signup")
    public String showSignupForm() {
    	System.out.println("helloCon2");
        return "signup"; // Points to signup.html
    }
}

