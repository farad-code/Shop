package com.example.product.Dto.ProductImage;

import org.springframework.web.multipart.MultipartFile;

public record SingleProductImageRequestUpdate(
    Long productImageId,
    MultipartFile productImage
) {
    
}
