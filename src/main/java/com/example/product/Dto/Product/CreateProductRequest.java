package com.example.product.Dto.Product;

import com.example.product.Enumerations.ProductInfo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateProductRequest(
    @NotBlank String productName,
    @NotNull double price,
    ProductInfo productAvailabilityInfo,
    String description,
    Long categoryId
) {}
