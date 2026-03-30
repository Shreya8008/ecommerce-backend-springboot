package com.ecommerce.ecommerce_backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Double price;

    private Integer stock;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "category_id")
    private Category category;

    // ✅ GETTERS & SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {   // ✅ FIX
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {   // ✅ IMPORTANT
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {   // ✅ IMPORTANT
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {   // ✅ FIX
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Category getCategory() {   // ✅ IMPORTANT
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}