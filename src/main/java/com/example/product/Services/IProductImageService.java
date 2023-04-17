package com.example.product.Services;

import com.example.product.Dto.ProductImage.BulkProductImageRequest;
import com.example.product.Dto.ProductImage.BulkProductImageUpdateRequest;
import com.example.product.Dto.ProductImage.ProductImageResponse;
import com.example.product.Dto.ProductImage.SingleProductImageRequestUpdate;

public interface IProductImageService {
    boolean deleteProductImage(Long id);

    boolean bulkDeleteImage(BulkProductImageRequest productImage);

    ProductImageResponse updateBulkProductImage(BulkProductImageUpdateRequest productImage);

    ProductImageResponse updateProductImage(SingleProductImageRequestUpdate productImage);

}
