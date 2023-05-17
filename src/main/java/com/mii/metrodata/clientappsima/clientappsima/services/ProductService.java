package com.mii.metrodata.clientappsima.clientappsima.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.mii.metrodata.clientappsima.clientappsima.models.Product;
import java.util.List;

@Service
public class ProductService {
    private RestTemplate restTemplate;

    @Autowired
    public ProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${server.baseUrl}/product")
    private String url;


    public List<Product> getAll(){
        return restTemplate.exchange(
            url,
            HttpMethod.GET,
             null,
            new ParameterizedTypeReference<List<Product>>() {     
            }).getBody();
    }

    public Product getById(int id){
        return restTemplate.exchange(
            url + "/" + id,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<Product>() {  
            } ).getBody();
    }

    public Product create(Product product){
        return restTemplate.exchange(
            url,
            HttpMethod.POST,
            new HttpEntity(product),
            new ParameterizedTypeReference<Product>() {     
            }).getBody();
    }

    public Product update(int id, Product product) {
        return restTemplate.exchange(
            url + "/" + id,
                HttpMethod.PUT,
                new HttpEntity(product),
                new ParameterizedTypeReference<Product>() {
                }
        ).getBody();
    }

    public Product delete(int id){
        return restTemplate.exchange(
            url + "/" + id,
            HttpMethod.DELETE,
              null,
             new ParameterizedTypeReference<Product>() {
          }).getBody();
    }
}