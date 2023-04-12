package com.example.product.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.product.Entities.Category;


@Repository
public interface CategoryDao extends JpaRepository<Category,Long>  {
    
    Optional<Category> findCategoryByName(String name);
}
