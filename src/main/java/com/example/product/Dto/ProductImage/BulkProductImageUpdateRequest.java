package com.example.product.Dto.ProductImage;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public record BulkProductImageUpdateRequest(
        Long productImageId,
        List<MultipartFile> productImages) {

}
