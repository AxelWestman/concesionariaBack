package com.axl.backend.dto;
import java.math.BigDecimal;

public class ProductDTO {

private String name_product;
private String description;
private BigDecimal price;
private Long category_id;

public ProductDTO(String name_product, String description, BigDecimal price, Long category_id){
    this.name_product = name_product;
    this.description = description;
    this.price = price;
    this.category_id = category_id;
}

    public String getName_product() {
        return name_product;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }
}
