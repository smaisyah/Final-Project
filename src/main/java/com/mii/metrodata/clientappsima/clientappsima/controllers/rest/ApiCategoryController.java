package com.mii.metrodata.clientappsima.clientappsima.controllers.rest;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mii.metrodata.clientappsima.clientappsima.models.Category;
import com.mii.metrodata.clientappsima.clientappsima.services.CategoryService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/category")
@AllArgsConstructor
public class ApiCategoryController {

    private CategoryService categoryService;

    @GetMapping
    public List<Category> getAll(){
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable int id){
        return categoryService.getById(id);
    }

    @PostMapping
    public Category create(@RequestBody Category category){
        return categoryService.create(category);
    }

    @PutMapping("/{id}")
    public Category update(@PathVariable int id, @RequestBody Category category){
        return categoryService.update(id, category);
    }

    @DeleteMapping("/{id}")
    public Category delete(@PathVariable int id){
        return categoryService.delete(id);
    }
}