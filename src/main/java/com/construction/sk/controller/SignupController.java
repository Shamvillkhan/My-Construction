package com.construction.sk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.construction.sk.entity.Users;
import com.construction.sk.repository.UserRepository;
 
@RestController
@CrossOrigin(origins = "*")  // ✅ Allow cross-origin requests for frontend
public class SignupController {
    
    @Autowired
    private UserRepository userRep;
    
    @Autowired 
    private PasswordEncoder passwordEncoder;
    
    @PostMapping(value="/req/signup",consumes="application/json")
    public Users creatUser(@RequestBody Users user){
        System.out.println("signupController >>>>>>>>>>>>>>");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRep.save(user);
    }
}
