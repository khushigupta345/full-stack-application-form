package com.example.controller;


import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.config.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins ="http://localhost:4200")
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired private UserRepository userRepo;
    @Autowired private JwtUtil jwtUtil;
    @Autowired private PasswordEncoder encoder;

    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody User request) {
        Optional<User> existing = userRepo.findByEmail(request.getEmail());

        if (existing.isPresent()) {
        	
          if(existing.get().isFormSubmitted() && existing.get().isFormUpdated()) {
        	  String token = jwtUtil.generateToken(existing.get().getEmail());
              return ResponseEntity.ok(Map.of("message","Form already submitted and update by this email","token", token));
            }
          else if (existing.get().isFormSubmitted()) {
            	 String token = jwtUtil.generateToken(existing.get().getEmail());
                return ResponseEntity.ok(Map.of("message","Form already submitted by this email","token", token));
            }
            String token = jwtUtil.generateToken(existing.get().getEmail());
            return ResponseEntity.ok(Map.of("token", token));
          
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(encoder.encode(request.getPassword()));
        userRepo.save(user);

        String token = jwtUtil.generateToken(user.getEmail());
        return ResponseEntity.ok(Map.of("token", token));
    }
}