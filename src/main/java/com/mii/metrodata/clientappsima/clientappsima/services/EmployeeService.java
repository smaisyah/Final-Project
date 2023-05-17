package com.mii.metrodata.clientappsima.clientappsima.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mii.metrodata.clientappsima.clientappsima.models.Employee;

import java.util.List;

@Service
public class EmployeeService {
    private RestTemplate restTemplate;

    @Autowired
    public EmployeeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${server.baseUrl}/employee")
    private String url;


    public List<Employee> getAll(){
        return restTemplate.exchange(
            url,
            HttpMethod.GET,
             null,
            new ParameterizedTypeReference<List<Employee>>() {     
            }).getBody();
    }

    public Employee getById(String nik){
        return restTemplate.exchange(
            url + "/" + nik,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<Employee>() {  
            } ).getBody();
    }

    public Employee create(Employee employee){
        return restTemplate.exchange(
            url,
            HttpMethod.POST,
            new HttpEntity(employee),
            new ParameterizedTypeReference<Employee>() {     
            }).getBody();
    }

    public Employee update(String nik, Employee employee) {
        return restTemplate.exchange(
            url + "/" + nik,
                HttpMethod.PUT,
                new HttpEntity(employee),
                new ParameterizedTypeReference<Employee>() {
                }
        ).getBody();
    }

    public Employee delete(String nik){
        return restTemplate.exchange(
            url + "/" + nik,
            HttpMethod.DELETE,
              null,
             new ParameterizedTypeReference<Employee>() {
          }).getBody();
    }
}