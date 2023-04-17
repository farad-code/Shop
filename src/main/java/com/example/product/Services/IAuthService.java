package com.example.product.Services;

import com.example.product.Dto.Auth.LoginRequest;
import com.example.product.Dto.Auth.LoginResponse;
import com.example.product.Dto.Auth.RegisterRequest;
import com.example.product.Dto.Auth.RegisterResponse;

public interface IAuthService {
    RegisterResponse registerUser(RegisterRequest request);

    LoginResponse login(LoginRequest request);

}
