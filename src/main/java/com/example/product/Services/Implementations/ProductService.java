package com.example.product.Services.Implementations;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.product.CustomErrorHandler.NotFound;
import com.example.product.Dto.Product.CreateProductRequest;
import com.example.product.Dto.Product.ProductResponse;
import com.example.product.Dto.Product.UpdateProductRequest;
import com.example.product.Entities.Category;
import com.example.product.Entities.Product;
import com.example.product.Repositories.CategoryDao;
import com.example.product.Repositories.ProductDao;
import com.example.product.Services.IProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class ProductService implements IProductService {

    private final ProductDao productDao;
    private final CategoryDao categoryDao;

    @Override
    public ProductResponse createProduct(CreateProductRequest request) {
        Optional<Category> category = categoryDao.findById(request.categoryId());
        if (!category.isPresent())
            throw new NotFound("No Category was found");
        ;
        Category existingCategory = category.get();
        Product product = new Product(request.productName(), request.price(), request.productAvailabilityInfo(),
                request.description(), existingCategory);
        Product newProduct = productDao.save(product);
        // response
        return new ProductResponse(newProduct.getId(), newProduct.getName(), newProduct.getPrice(),
                newProduct.getProductInfo(), newProduct.getDescription());
    }

    @Override
    public List<ProductResponse> fetchAllProducts() {
        List<ProductResponse> products = productDao.findAll()
                .stream()
                .map(product -> new ProductResponse(product.getId(), product.getName(), product.getPrice(),
                        product.getProductInfo(), product.getDescription()))
                .collect(Collectors.toList());
        return products;
    }

    @Override
    public ProductResponse fetchProductById(Long id) {
        Optional<Product> product = productDao.findById(id);
        if (!product.isPresent())
            throw new NotFound("No Product was found " +id);
        // response
        return new ProductResponse(product.get().getId(), product.get().getName(), product.get().getPrice(),
                product.get().getProductInfo(), product.get().getDescription());
    }

    @Override
    public ProductResponse updateProduct(Long id, UpdateProductRequest request) {
        Optional<Product> product = productDao.findById(id);
        if (!product.isPresent())
            throw new NotFound("No Product was found");
        Product existingProduct = product.get();
        existingProduct.setName(request.productName());
        existingProduct.setPrice(request.price());
        existingProduct.setProductInfo(request.productAvailabilityInfo());
        existingProduct.setDescription(request.description());
        productDao.save(existingProduct);
        // response
        return new ProductResponse(existingProduct.getId(), existingProduct.getName(), existingProduct.getPrice(),
                existingProduct.getProductInfo(), existingProduct.getDescription());
    }

    @Override
    public boolean deleteProduct(Long id) {
        Optional<Product> product = productDao.findById(id);
        if (!product.isPresent())
            throw new NotFound("No Product was found");
        productDao.deleteById(id);
        return true;
    }

    @Override
    public List<ProductResponse> ShowAllProductsBelongToCategory(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ShowAllProductsBelongToCategory'");
    }

}
