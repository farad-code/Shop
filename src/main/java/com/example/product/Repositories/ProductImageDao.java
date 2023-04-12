package com.example.product.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.product.Entities.ProductImage;



@Repository
public interface ProductImageDao extends JpaRepository<ProductImage,Long> {
    
}
