package com.mii.metrodata.clientappsima.clientappsima.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mii.metrodata.clientappsima.clientappsima.models.Category;

import java.util.List;

@Service
public class CategoryService {
    private RestTemplate restTemplate;

    @Autowired
    public CategoryService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${server.baseUrl}/category")
    private String url;


    public List<Category> getAll(){
        return restTemplate.exchange(
            url,
            HttpMethod.GET,
             null,
            new ParameterizedTypeReference<List<Category>>() {     
            }).getBody();
    }

    public Category getById(int id){
        return restTemplate.exchange(
            url + "/" + id,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<Category>() {  
            } ).getBody();
    }

    public Category create(Category category){
        return restTemplate.exchange(
            url,
            HttpMethod.POST,
            new HttpEntity(category),
            new ParameterizedTypeReference<Category>() {     
            }).getBody();
    }

    public Category update(int id, Category category) {
        return restTemplate.exchange(
            url + "/" + id,
                HttpMethod.PUT,
                new HttpEntity(category),
                new ParameterizedTypeReference<Category>() {
                }
        ).getBody();
    }

    public Category delete(int id){
        return restTemplate.exchange(
            url + "/" + id,
            HttpMethod.DELETE,
              null,
             new ParameterizedTypeReference<Category>() {
          }).getBody();
    }
}