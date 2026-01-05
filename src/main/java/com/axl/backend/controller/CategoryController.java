package com.axl.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.axl.backend.model.Category;
import com.axl.backend.dto.CategoryDTO;
import com.axl.backend.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @PostMapping("/crearCategoria")
        public ResponseEntity<?> createCategory(@RequestBody CategoryDTO category){
            try{
                Category savedCategory = categoryService.createCategory(category);
                return ResponseEntity.ok(savedCategory);
            }    catch(RuntimeException e){
                return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
            }
        }

    @GetMapping("/obtenerCategorias")
    public ResponseEntity<List<Category>> getAllCategories(){
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @GetMapping("/obtenerCategoriaId/{id}")
    public ResponseEntity<?> getCategoryId(@PathVariable Long id){
        try {
            Category savedCategory = categoryService.getCategoryId(id);
            return ResponseEntity.ok(savedCategory);
        } catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
        }
    }

    @DeleteMapping("/eliminarCategoria/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id){
        try{
            Category savedCategory = categoryService.deleteCategory(id);
            return ResponseEntity.ok(savedCategory);
        } catch(RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
        }
    }

}
