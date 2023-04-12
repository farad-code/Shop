package com.example.product.Services;

import java.util.List;

import com.example.product.Dto.Category.CategoryRequest;
import com.example.product.Dto.Category.CategoryResponse;
import com.example.product.Dto.Category.SearchByNameRequest;



public interface ICategoryService {
    CategoryResponse addCategory(CategoryRequest request);
    List<CategoryResponse> getCategories();
    CategoryResponse getCategory(Long id);
    boolean deleteCategory(Long id);
    CategoryResponse updateCategory(CategoryRequest request,Long id);
    CategoryResponse findCategoryByName(SearchByNameRequest request);
}
