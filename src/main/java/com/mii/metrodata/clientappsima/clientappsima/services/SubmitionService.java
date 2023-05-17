package com.mii.metrodata.clientappsima.clientappsima.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mii.metrodata.clientappsima.clientappsima.models.Submition;

import java.util.List;

@Service
public class SubmitionService {
    private RestTemplate restTemplate;

    @Autowired
    public SubmitionService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${server.baseUrl}/submition")
    private String url;


    public List<Submition> getAll(){
        return restTemplate.exchange(
            url,
            HttpMethod.GET,
             null,
            new ParameterizedTypeReference<List<Submition>>() {     
            }).getBody();
    }

    public Submition getById(int id){
        return restTemplate.exchange(
            url + "/" + id,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<Submition>() {  
            } ).getBody();
    }

    public Submition create(Submition submition){
        return restTemplate.exchange(
            url,
            HttpMethod.POST,
            new HttpEntity(submition),
            new ParameterizedTypeReference<Submition>() {     
            }).getBody();
    }

    public Submition update(int id, Submition submition) {
        return restTemplate.exchange(
            url + "/" + id,
                HttpMethod.PUT,
                new HttpEntity(submition),
                new ParameterizedTypeReference<Submition>() {
                }
        ).getBody();
    }

    public Submition delete(int id){
        return restTemplate.exchange(
            url + "/" + id,
            HttpMethod.DELETE,
              null,
             new ParameterizedTypeReference<Submition>() {
          }).getBody();
    }
}
