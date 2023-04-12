package com.example.product.Dto.Product;

import com.example.product.Enumerations.ProductInfo;

public record ProductResponse(
    Long productId,
    String productName,
    double price,
    ProductInfo productAvailabilityInfo,
    String description
) {}
