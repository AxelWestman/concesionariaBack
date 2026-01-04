package com.axl.backend.service;

import com.axl.backend.repository.CategoryRepository;
import com.axl.backend.model.Category;
import com.axl.backend.dto.CategoryDTO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;


    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public Category createCategory(CategoryDTO dto){
        Category category = new Category(dto.getName());
        return categoryRepository.save(category);
    }

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Category deleteCategory(Long id){
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
        categoryRepository.delete(category);
        return category;
    }

}
