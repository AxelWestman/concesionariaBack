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

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public Product createProduct(ProductDTO dto) {

        Category category = categoryRepository.findById(dto.getCategory_id()).orElseThrow(() -> new RuntimeException("Caregoría no encontrada"));

        Product product = new Product(
                dto.getName_product(),
                dto.getDescription(),
                dto.getPrice(),
                category
        );

        return productRepository.save(product);

    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        return product;
    }

    public Product deleteProduct(Long id) {
        Product product = this.getProductById(id);
        productRepository.deleteById(product.getId());
        return product;
    }

    public Product modifyProduct(ProductDTO dto, Long id){
        Product product = this.getProductById(id);

        product.setName_product(dto.getName_product());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());

        if(dto.getCategory_id() != null){
            Category category = categoryRepository.findById(dto.getCategory_id()).orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
            product.setCategory_id(category);
        }

        return productRepository.save(product);

    }

}
