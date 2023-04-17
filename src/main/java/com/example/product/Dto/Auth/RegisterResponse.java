package com.example.product.Dto.Auth;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.example.product.Enumerations.Role;

public record RegisterResponse(
    Long id,
    String firstName, 
    String otherNames,
    String email,
    String mobileNumber,
    String dateOfBirth,
    Role roleName
    
) {}
