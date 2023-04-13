package com.example.product.Dto.Product;

import java.util.List;

import com.example.product.Enumerations.ProductInfo;

public record CreateProductResponse(
    Long productId,
    String productName,
    double price,
    ProductInfo productAvailabilityInfo,
    String description,
    List<String> productImages
) {
    
}
