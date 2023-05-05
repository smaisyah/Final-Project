package com.mii.ServerApp.services;

import com.mii.ServerApp.models.Product;
import com.mii.ServerApp.repositories.ProductRepository;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class ProductService {

  private ProductRepository productRepository;

  public List<Product> getAll() {
    return productRepository.findAll();
  }

  public Product getById(Integer id) {
    return productRepository
      .findById(id)
      .orElseThrow(() ->
        new ResponseStatusException(
          HttpStatus.NOT_FOUND,
          "Product not found!!"
        )
      );
  }

  public Product create(Product product) {
    return productRepository.save(product);
  }

  public Product update(Integer id, Product product) {
    getById(id); // method getById
    product.setId(id);
    return productRepository.save(product);
  }

  public Product delete(Integer id) {
    Product product = getById(id);
    productRepository.delete(product);
    return product;
  }
}

