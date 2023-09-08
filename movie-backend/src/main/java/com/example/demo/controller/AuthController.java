package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.model.requests.LoginRequest;
import com.example.demo.model.requests.RegistrationRequest;
import com.example.demo.repository.UserRepository;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public String registerUser(@RequestBody RegistrationRequest registrationRequest) {

        // Create a new User object and populate it with the registration data
        User newUser = new User();
        newUser.setEmail(registrationRequest.getEmail());
        newUser.setPassword(registrationRequest.getPassword()); // No password encoding
        newUser.setUsername(registrationRequest.getUsername());


        // Save the new user in the database
        userRepository.save(newUser);

        System.out.println("User registered successfully!");
        return "User registered successfully!";
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody LoginRequest loginRequest) {
        // Fetch the user from the database using the provided username
        User user = userRepository.findByEmail(loginRequest.getEmail());

        // Check if the user exists and the provided password matches the stored password
        if (user != null && user.getPassword().equals(loginRequest.getPassword())) {
            // Generate a secure signing key
            SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

            // Build the JWT token
            String token = Jwts.builder()
                    .setSubject(user.getEmail()) // You can use any relevant user info as the subject
                    .signWith(secretKey)
                    .compact();

            return token;
        } else {
            return "Login failed!";
        }
    }
}

