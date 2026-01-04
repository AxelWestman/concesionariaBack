package com.axl.backend.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String description;

    @Column(nullable = false)
    private BigDecimal price;


    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category_id;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    public Product(){}

    public Product(Long id, String description, BigDecimal price, Category category_id, LocalDateTime createdAt) {
        this.description = description;
        this.price = price;
        this.category_id = category_id;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
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

    public Category getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Category category_id) {
        this.category_id = category_id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

}
