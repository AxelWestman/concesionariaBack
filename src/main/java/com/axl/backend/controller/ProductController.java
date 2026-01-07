package com.axl.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.axl.backend.dto.ProductDTO;
import com.axl.backend.model.Product;
import com.axl.backend.service.ProductService;
import org.springframework.web.bind.annotation.*; //averiguar bien esto
import  java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping("/anadirProducto")
    public ResponseEntity<?> createProduct(@RequestBody ProductDTO product){
        try{
            Product savedProduct = productService.createProduct(product);
            return ResponseEntity.ok(savedProduct);
        } catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
        }
    }

    @GetMapping("/obtenerTodosLosProductos")
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/obtenerProductoPorId/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id){
        try{
            Product savedProduct = productService.getProductById(id);
            return ResponseEntity.ok(savedProduct);
        } catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
        }
    }

    @DeleteMapping("/eliminarProducto/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        try{
            Product savedProduct = productService.deleteProduct(id);
            return ResponseEntity.ok(savedProduct);
        } catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
        }
    }

    @PutMapping("/modificarProducto/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody ProductDTO dto, @PathVariable Long id){
        Product updateProduct = productService.modifyProduct(dto, id);
        return ResponseEntity.ok(updateProduct);
    }



}
