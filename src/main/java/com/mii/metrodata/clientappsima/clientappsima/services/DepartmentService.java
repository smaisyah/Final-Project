package com.mii.metrodata.clientappsima.clientappsima.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mii.metrodata.clientappsima.clientappsima.models.Department;

import java.util.List;

@Service
public class DepartmentService {
    private RestTemplate restTemplate;

    @Autowired
    public DepartmentService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${server.baseUrl}/department")
    private String url;


    public List<Department> getAll(){
        return restTemplate.exchange(
            url,
            HttpMethod.GET,
             null,
            new ParameterizedTypeReference<List<Department>>() {     
            }).getBody();
    }

    public Department getById(int id){
        return restTemplate.exchange(
            url + "/" + id,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<Department>() {  
            } ).getBody();
    }

    public Department create(Department department){
        return restTemplate.exchange(
            url,
            HttpMethod.POST,
            new HttpEntity(department),
            new ParameterizedTypeReference<Department>() {     
            }).getBody();
    }

    public Department update(int id, Department department) {
        return restTemplate.exchange(
            url + "/" + id,
                HttpMethod.PUT,
                new HttpEntity(department),
                new ParameterizedTypeReference<Department>() {
                }
        ).getBody();
    }

    public Department delete(int id){
        return restTemplate.exchange(
            url + "/" + id,
            HttpMethod.DELETE,
              null,
             new ParameterizedTypeReference<Department>() {
          }).getBody();
    }
}