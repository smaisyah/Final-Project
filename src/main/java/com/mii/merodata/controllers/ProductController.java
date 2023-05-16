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

import com.mii.merodata.models.Product;
import com.mii.merodata.services.ProductService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
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

    // Without DTO
    // @PreAuthorize("hasAuthority('CREATE_ADMIN')")
    @PostMapping
    public Product create(@RequestBody Product Product) {
        return productService.create(Product);
    }

    // // With DTO
    // @PostMapping("/dto")
    // // @PreAuthorize("hasAuthority('CREATE_ADMIN')")
    // public Product createWithDTO(@RequestBody ProductRequest ProductRequest) {
    // return ProductService.createWithDTO(ProductRequest);
    // }

    // // with modelmapper
    // // @PreAuthorize("hasAuthority('CREATE_ADMIN')")
    // @PostMapping("/dto-mm")
    // public Product createWithModelMapper(
    // @RequestBody ProductRequest ProductRequest) {
    // return ProductService.createWithModelMapper(ProductRequest);
    // }

    // @PreAuthorize("hasAuthority('UPDATE_ADMIN')")
    @PutMapping("/{id}")
    public Product update(@PathVariable Integer id, @RequestBody Product Product) {
        return productService.update(id, Product);
    }

    // @PreAuthorize("hasAuthority('DELETE_ADMIN')")
    @DeleteMapping("/{id}")
    public Product delete(@PathVariable Integer id) {
        return productService.delete(id);
    }
}
