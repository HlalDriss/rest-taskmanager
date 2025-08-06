package com.dhlal.resttaskmanager.controller;


import com.dhlal.resttaskmanager.dto.*;
import com.dhlal.resttaskmanager.model.User;
import com.dhlal.resttaskmanager.repository.UserRepository;
import com.dhlal.resttaskmanager.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String register(@RequestBody AuthRequest request) {
        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        userRepository.save(user);
        return "User registered successfully";
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        String token = jwtUtil.generateToken(request.getEmail());
        return new AuthResponse(token);
    }
}
