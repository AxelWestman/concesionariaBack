package com.axl.backend.service;

import com.axl.backend.model.Product;
import com.axl.backend.dto.ProductDTO;
import com.axl.backend.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    //public Product createProduct(ProductDTO dto){

    //}


}
