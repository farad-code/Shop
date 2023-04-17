package com.example.product.Dto.ProductImage;

import org.springframework.web.multipart.MultipartFile;

public record SingleProductImageRequest(
    MultipartFile productImage
) {
    
}
