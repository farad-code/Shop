package com.example.product.Services.Implementations;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.product.Configurations.JwtService;
import com.example.product.Dto.Auth.LoginRequest;
import com.example.product.Dto.Auth.LoginResponse;
import com.example.product.Dto.Auth.RegisterRequest;
import com.example.product.Dto.Auth.RegisterResponse;
import com.example.product.Entities.User;
import com.example.product.Repositories.UserDao;
import com.example.product.Services.IAuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements IAuthService {

    private final AuthenticationManager authenticationManager;
    private final UserDao userDao;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public RegisterResponse registerUser(RegisterRequest request) {
        var user = User
                .builder()
                .firstName(request.firstName())
                .otherNames(request.otherNames())
                .dob(request.dateOfBirth())
                .password(passwordEncoder.encode(request.password()))
                .email(request.email())
                .mobile(request.mobile())
                .role(request.role())
                .build();
        User savedUser = userDao.save(user);
        // response
        return new RegisterResponse(
                savedUser.getId(),
                savedUser.getFirstName(),
                savedUser.getOtherNames(),
                savedUser.getDob(),
                savedUser.getEmail(),
                savedUser.getMobile(),
                savedUser.getRole());

    }

    @Override
    public LoginResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()));
        var user = userDao.findByEmail(request.email())
                .orElseThrow(() -> new UsernameNotFoundException("No user found"));
        var jwtToken = jwtService.generateToken(user);
        // response
        return new LoginResponse(jwtToken);
    }

}
