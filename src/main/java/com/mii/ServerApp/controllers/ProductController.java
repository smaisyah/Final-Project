package com.mii.ServerApp.controllers;

import com.mii.ServerApp.models.Product;
import com.mii.ServerApp.services.ProductService;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {

  private ProductService productService;

  @GetMapping
  public List<Product> getAll() {
    return productService.getAll();
  }

  @GetMapping("/{id}")
  public Product getById(@PathVariable Integer id) {
    return productService.getById(id);
  }

  @PostMapping
  public Product create(@RequestBody Product product) {
    return productService.create(product);
  }

  @PutMapping("/{id}")
  public Product update(
    @PathVariable Integer id,
    @RequestBody Product product
  ) {
    return productService.update(id, product);
  }

  @DeleteMapping("/{id}")
  public Product delete(@PathVariable Integer id) {
    return productService.delete(id);
  }
}