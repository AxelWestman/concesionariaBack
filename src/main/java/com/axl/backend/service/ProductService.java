package com.axl.backend.service;
import com.axl.backend.model.Category;
import com.axl.backend.model.Product;
import com.axl.backend.dto.ProductDTO;
import com.axl.backend.repository.ProductRepository;
import com.axl.backend.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public Product createProduct(ProductDTO dto){

        Category category = categoryRepository.findById(dto.getCategory_id()).orElseThrow(() -> new RuntimeException("Caregoría no encontrada"));

        Product product = new Product(
                dto.getName_product(),
                dto.getDescription(),
                dto.getPrice(),
                category
        );

        return productRepository.save(product);

    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }


}
