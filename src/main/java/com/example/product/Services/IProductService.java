package com.example.product.Services;

import java.util.List;

import com.example.product.Dto.Product.CreateProductRequest;
import com.example.product.Dto.Product.ProductResponse;
import com.example.product.Dto.Product.UpdateProductRequest;

public interface IProductService {
    ProductResponse createProduct(CreateProductRequest request);
    List<ProductResponse> fetchAllProducts();
    ProductResponse fetchProductById(Long id);
    ProductResponse updateProduct(Long id, UpdateProductRequest request);
    boolean deleteProduct(Long id);
    List<ProductResponse> ShowAllProductsBelongToCategory(Long id);
    
}
