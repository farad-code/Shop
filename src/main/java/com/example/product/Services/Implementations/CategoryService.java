package com.example.product.Services.Implementations;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.product.CustomErrorHandler.NotFound;
import com.example.product.Dto.Category.CategoryRequest;
import com.example.product.Dto.Category.CategoryResponse;
import com.example.product.Dto.Category.SearchByNameRequest;
import com.example.product.Entities.Category;
import com.example.product.Repositories.CategoryDao;
import com.example.product.Services.ICategoryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class CategoryService implements ICategoryService {
    
    private final CategoryDao categoryDao;

    
    @Override
    public CategoryResponse addCategory(CategoryRequest request) {
        Category category = new Category();
        category.setName(request.categoryName());
        Category newCategory = categoryDao.save(category);
        //response
        CategoryResponse response = new CategoryResponse(newCategory.getId(),newCategory.getName());
        return response;
       

    }

    @Override
    public List<CategoryResponse> getCategories() {
        List<Category> categories = categoryDao.findAll();
        return categories.stream().map(Category-> new CategoryResponse(Category.getId(),Category.getName()) ).collect(Collectors.toList());
    }

    @Override
    public CategoryResponse getCategory(Long id) {
       Optional<Category> category = categoryDao.findById(id);
        if(!category.isPresent()) throw new NotFound("No Category was found");;
        CategoryResponse response = new CategoryResponse(category.get().getId(),category.get().getName());
        return response; 
    }

    @Override
    public boolean deleteCategory(Long id) {
        Optional<Category> category = categoryDao.findById(id);
        if(category.isPresent()) {
            categoryDao.deleteById(id);
            return true;
        }
        throw new NotFound("No Category was found");
    }

    @Override
    public CategoryResponse updateCategory(CategoryRequest request, Long id) {
        Optional<Category> updateCategory = categoryDao.findById(id);
        if(updateCategory.isPresent()) {
            log.info("checking what is in this", updateCategory.get());
            Category existingCategory = updateCategory.get();
            existingCategory.setName(request.categoryName());
            categoryDao.save(existingCategory);
            CategoryResponse response = new CategoryResponse(existingCategory.getId(),existingCategory.getName());
            return response;
        }
       throw new NotFound("No Category was found");
    }

    @Override
    public CategoryResponse findCategoryByName(SearchByNameRequest request) {
        Optional<Category> category = categoryDao.findCategoryByName(request.categoryName());
        Category foundCategory = category.get();
        CategoryResponse response = new CategoryResponse(foundCategory.getId(),foundCategory.getName());
        return response;
       
    }
    
}
