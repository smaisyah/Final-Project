package com.mii.metrodata.clientappsima.clientappsima.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mii.metrodata.clientappsima.clientappsima.models.Product;
import com.mii.metrodata.clientappsima.clientappsima.services.ProductService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {
    private ProductService productService;

    @GetMapping("/create")
    public String createView(Product product){
        return "product/create-form";
    }

    @PostMapping
    public String create(Product product){
        productService.create(product);
        return "redirect:/product";
    }

    @GetMapping("/update/{id}")
    public String updateView(@PathVariable int id,Model model){
        model.addAttribute("product", productService.getById(id));
        return "product/update-form";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable int id, Product product){
        productService.update(id, product);
        return "redirect:/product";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        productService.delete(id);
        return "redirect:/product";
    }
}