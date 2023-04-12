package com.example.product.Dto.Category;

import jakarta.validation.constraints.NotBlank;

public record CategoryRequest(
   @NotBlank String categoryName
) {}
