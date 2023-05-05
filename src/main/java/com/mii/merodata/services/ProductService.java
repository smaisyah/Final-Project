package com.mii.merodata.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.mii.merodata.models.Product;
import com.mii.merodata.repositories.ProductRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProductService {
    private ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product getById(Integer id) {
        return productRepository
                .findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Not found"));
    }

    public Product create(Product Product) {
        return productRepository.save(Product);
    }

    public Product update(Integer id, Product Product) {
        getById(id);
        Product.setId(id);
        return create(Product);
    }

    public Product delete(Integer id) {
        Product Product = getById(id);
        productRepository.delete(Product);
        return Product;
    }
}
