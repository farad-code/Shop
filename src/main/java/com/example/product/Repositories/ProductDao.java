package com.example.product.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.product.Entities.Product;

@Repository
public interface ProductDao extends JpaRepository<Product,Long> {
    
    Product findProductByName(String name);
}
