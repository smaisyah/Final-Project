package com.mii.merodata.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.mii.merodata.models.Category;
import com.mii.merodata.repositories.CategoryRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public Category getById(Integer id) {
        return categoryRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
    }

    public Category create(Category Category) {
        return categoryRepository.save(Category);
    }

    public Category update(Integer id, Category Category) {
        Category reg = getById(id);
        Category.setId(id);
        Category.setProducts(reg.getProducts());
        return create(Category);
    }

    public Category delete(Integer id) {
        Category Category = getById(id);
        categoryRepository.delete(Category);
        return Category;
    }
}
