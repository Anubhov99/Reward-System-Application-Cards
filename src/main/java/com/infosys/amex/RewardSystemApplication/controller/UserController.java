package com.infosys.amex.RewardSystemApplication.controller;

import com.infosys.amex.RewardSystemApplication.dto.UserRegistrationDto;
import com.infosys.amex.RewardSystemApplication.model.User;
import com.infosys.amex.RewardSystemApplication.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserRegistrationDto registrationDto) {
        // Check if username exists
        if (userRepository.findByUsername(registrationDto.username()).isPresent()) {
            return ResponseEntity
                    .badRequest()
                    .body("Username is already taken");
        }

        // Create new user
        User newUser = new User();
        newUser.setUsername(registrationDto.username());
        newUser.setPassword(passwordEncoder.encode(registrationDto.password()));

        // Set default security values (from your User entity)
        newUser.isEnabled();
        newUser.isAccountNonExpired();
        newUser.isCredentialsNonExpired();
        newUser.isAccountNonLocked();

        // Save user
        User savedUser = userRepository.save(newUser);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("User registered successfully");
    }
}