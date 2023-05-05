package com.mii.merodata.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mii.merodata.models.Category;
import com.mii.merodata.services.CategoryService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/category")
public class CategoryController {
  private CategoryService categoryService;

  @GetMapping
  public List<Category> getAll() {
    return categoryService.getAll();
  }

  @GetMapping("/{id}")
  public Category getById(@PathVariable Integer id) {
    return categoryService.getById(id);
  }

  @PostMapping
  public Category create(@RequestBody Category Category) {
    return categoryService.create(Category);
  }

  @PutMapping("/{id}")
  public Category update(@PathVariable Integer id, @RequestBody Category Category) {
    return categoryService.update(id, Category);
  }

  @DeleteMapping("/{id}")
  public Category delete(@PathVariable Integer id) {
    return categoryService.delete(id);
  }
}
