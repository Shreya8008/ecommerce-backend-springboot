package com.ecommerce.ecommerce_backend.service;

import com.ecommerce.ecommerce_backend.entity.Category;
import com.ecommerce.ecommerce_backend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    // ✅ CREATE
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    // ✅ GET ALL
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // ✅ GET BY ID
    public Category getCategoryById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.orElse(null);
    }

    // ✅ UPDATE
    public Category updateCategory(Long id, Category updatedCategory) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);

        if (optionalCategory.isPresent()) {
            Category category = optionalCategory.get();
            category.setName(updatedCategory.getName());
            return categoryRepository.save(category);
        }
        return null;
    }

    // ✅ DELETE
    public String deleteCategory(Long id) {
        categoryRepository.deleteById(id);
        return "Category deleted successfully!";
    }
}