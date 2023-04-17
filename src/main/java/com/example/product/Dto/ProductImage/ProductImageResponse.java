package com.example.product.Dto.ProductImage;

import java.util.List;

public record ProductImageResponse(
        Long productImageId,
        List<String> productImages) {

}
