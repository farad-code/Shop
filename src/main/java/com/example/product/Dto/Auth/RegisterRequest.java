package com.example.product.Dto.Auth;

import com.example.product.Enumerations.Role;

public record RegisterRequest(
    String firstName,
    String otherNames,
    String mobile,
    String dateOfBirth,
    String email,
    String password,
    Role role
) {}
