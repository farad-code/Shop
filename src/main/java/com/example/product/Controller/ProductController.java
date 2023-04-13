package com.example.product.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.product.Dto.Product.CreateProductRequest;
import com.example.product.Dto.Product.CreateProductResponse;
import com.example.product.Dto.Product.ProductResponse;
import com.example.product.Dto.Product.UpdateProductRequest;
import com.example.product.Services.Implementations.ProductServiceImpl;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductServiceImpl productService;

    @GetMapping
    public List<ProductResponse> fetchAllProducts() {
        List<ProductResponse> products = productService.fetchAllProducts();
        return products;
    }

    @GetMapping("{id}")
    public ProductResponse fetchProduct(@PathVariable Long id) {
        ProductResponse product = productService.fetchProductById(id);
        return product;
    }

    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE })
    public CreateProductResponse createProduct(@Valid @ModelAttribute CreateProductRequest request) throws IOException {
        CreateProductResponse product = productService.createProduct(request);
        return product;
    }

    @DeleteMapping("{id}")
    public boolean deleteProduct(@PathVariable Long id) {
        boolean isDeleted = productService.deleteProduct(id);
        return isDeleted;
    }

    @PutMapping("{id}")
    public ProductResponse updateProduct(@PathVariable Long id, @Valid @RequestBody UpdateProductRequest request) {
        ProductResponse product = productService.updateProduct(id, request);
        return product;
    }
}
