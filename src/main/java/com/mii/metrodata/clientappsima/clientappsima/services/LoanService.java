package com.mii.metrodata.clientappsima.clientappsima.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mii.metrodata.clientappsima.clientappsima.models.Loan;

import java.util.List;

@Service
public class LoanService {
    private RestTemplate restTemplate;

    @Autowired
    public LoanService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${server.baseUrl}/loan")
    private String url;


    public List<Loan> getAll(){
        return restTemplate.exchange(
            url,
            HttpMethod.GET,
             null,
            new ParameterizedTypeReference<List<Loan>>() {     
            }).getBody();
    }

    public Loan getById(int id){
        return restTemplate.exchange(
            url + "/" + id,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<Loan>() {  
            } ).getBody();
    }

    public Loan create(Loan loan){
        return restTemplate.exchange(
            url,
            HttpMethod.POST,
            new HttpEntity(loan),
            new ParameterizedTypeReference<Loan>() {     
            }).getBody();
    }

    public Loan update(int id, Loan loan) {
        return restTemplate.exchange(
            url + "/" + id,
                HttpMethod.PUT,
                new HttpEntity(loan),
                new ParameterizedTypeReference<Loan>() {
                }
        ).getBody();
    }

    public Loan delete(int id){
        return restTemplate.exchange(
            url + "/" + id,
            HttpMethod.DELETE,
              null,
             new ParameterizedTypeReference<Loan>() {
          }).getBody();
    }
}