package com.example.product.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.Services.Implementations.ProductImageServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/products-image")
@RequiredArgsConstructor
public class ProductImageController {
    
private final ProductImageServiceImpl productImageService;


}
