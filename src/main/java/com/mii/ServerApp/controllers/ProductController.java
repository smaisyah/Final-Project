package com.mii.ServerApp.controllers;

import com.mii.ServerApp.models.Product;
import com.mii.ServerApp.services.ProductService;

import java.util.List;
import lombok.AllArgsConstructor;

// import org.springframework.security.access.prepost.PreAuthorize;
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

  // @PreAuthorize("hasAnyAuthority('READ_ADMIN', 'READ_USER')")
  @GetMapping
  public List<Product> getAll() {
    return productService.getAll();
  }

  // @PreAuthorize("hasAnyAuthority('READ_ADMIN', 'READ_USER')")
  @GetMapping("/{id}")
  public Product getById(@PathVariable Integer id) {
    return productService.getById(id);
  }

  // @PreAuthorize("hasAuthority('CREATE_ADMIN')")
  @PostMapping
  public Product create(@RequestBody Product product) {
    return productService.create(product);
  }

  // @PreAuthorize("hasAuthority('CREATE_ADMIN')")
  @PutMapping("/{id}")
  public Product update(
    @PathVariable Integer id,
    @RequestBody Product product
  ) {
    return productService.update(id, product);
  }

  // @PreAuthorize("hasAuthority('CREATE_ADMIN')")
  @DeleteMapping("/{id}")
  public Product delete(@PathVariable Integer id) {
    return productService.delete(id);
  }
}