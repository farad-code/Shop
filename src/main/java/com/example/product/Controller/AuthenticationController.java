package com.example.product.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.Dto.Auth.LoginRequest;
import com.example.product.Dto.Auth.LoginResponse;
import com.example.product.Dto.Auth.RegisterRequest;
import com.example.product.Dto.Auth.RegisterResponse;
import com.example.product.Services.Implementations.AuthServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthServiceImpl authServiceImpl;

    @PostMapping("login")
    public ResponseEntity<RegisterResponse> registerUser(@RequestBody RegisterRequest request) {
        RegisterResponse response = authServiceImpl.registerUser(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("register")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        LoginResponse response = authServiceImpl.login(request);
        return ResponseEntity.ok(response);
    }
}
