package com.mii.metrodata.clientappsima.clientappsima.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mii.metrodata.clientappsima.clientappsima.models.Category;
import com.mii.metrodata.clientappsima.clientappsima.services.CategoryService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/category")
@AllArgsConstructor
public class CategoryController {
    private CategoryService categoryService;

    @GetMapping
    public String index(Model model){
        List<Category> categorys = categoryService.getAll();
        model.addAttribute("categorys", categorys);
        return "view/category";
    }
    
    @GetMapping("/create")
    public String createView(Category category){
        return "view/category";
    }

    @PostMapping
    public String create(Category category){
        categoryService.create(category);
        return "redirect:/category";
    }

    @GetMapping("/update/{id}")
    public String updateView(@PathVariable int id,Model model){
        model.addAttribute("category", categoryService.getById(id));
        return "category/update-form";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable int id, Category category){
        categoryService.update(id, category);
        return "redirect:/category";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        categoryService.delete(id);
        return "redirect:/category";
    }
}