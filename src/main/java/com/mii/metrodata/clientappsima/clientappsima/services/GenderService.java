package com.mii.metrodata.clientappsima.clientappsima.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mii.metrodata.clientappsima.clientappsima.models.Gender;

@Service
public class GenderService {
    private RestTemplate restTemplate;
    
    @Autowired
    public GenderService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${server.baseUrl}/status")
    private String url;

    public List<Gender> getAll(){
        return restTemplate.exchange(
            url,
            HttpMethod.GET,
             null,
            new ParameterizedTypeReference<List<Gender>>() {     
            }).getBody();
    }

    public Gender getById(int id){
        return restTemplate.exchange(
            url + "/" + id,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<Gender>() {  
            } ).getBody();
    }
}
