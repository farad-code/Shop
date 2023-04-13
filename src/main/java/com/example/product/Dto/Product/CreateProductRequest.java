package com.example.product.Dto.Product;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.product.Enumerations.ProductInfo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateProductRequest(
    @NotBlank String productName,
    @NotNull double price,
    ProductInfo productAvailabilityInfo,
    String description,
    Long categoryId,
    List<MultipartFile> productImage
    
) {}
