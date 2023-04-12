package com.example.product.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.Dto.Category.CategoryRequest;
import com.example.product.Dto.Category.CategoryResponse;
import com.example.product.Dto.Category.SearchByNameRequest;
import com.example.product.Services.Implementations.CategoryService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryResponse> fetchCategories() {
        List<CategoryResponse> categories = categoryService.getCategories();
        return categories;
    }

    @GetMapping("{id}")
    public CategoryResponse fetchCategory(@PathVariable Long id) {
        CategoryResponse category = categoryService.getCategory(id);
        return category;
    }

    @PostMapping
    public CategoryResponse createCategory(@Valid @RequestBody CategoryRequest request) {

        CategoryResponse createdCategory = categoryService.addCategory(request);
        return createdCategory;
    }

    @PutMapping("{id}")
    public CategoryResponse updateCategory(@PathVariable Long id,@Valid @RequestBody CategoryRequest request) {
        CategoryResponse updatedCategory = categoryService.updateCategory(request,id);
        return updatedCategory;
    }

    @DeleteMapping("{id}")
    public boolean deleteCategory(@PathVariable Long id) {
        boolean isDeleted = categoryService.deleteCategory(id);
        return isDeleted;
    }

    @GetMapping("/search-name")
    public CategoryResponse findCategoryByName(SearchByNameRequest request) {
        CategoryResponse searchCategory = categoryService.findCategoryByName(request);
        return searchCategory;
    }
    
}
