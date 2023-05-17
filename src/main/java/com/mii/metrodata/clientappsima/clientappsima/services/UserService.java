package com.mii.metrodata.clientappsima.clientappsima.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mii.metrodata.clientappsima.clientappsima.models.User;


@Service
public class UserService {
    private RestTemplate restTemplate;
    
    @Autowired
    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${server.baseUrl}/user")
    private String url;

    @Value("${server.baseUrl}")
	private String url_reg;

    public List<User> getAll(){
        return restTemplate.exchange(
            url,
            HttpMethod.GET,
             null,
            new ParameterizedTypeReference<List<User>>() {     
            }).getBody();
    }

    public User getById(int id){
        return restTemplate.exchange(
            url + "/" + id,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<User>() {  
            } ).getBody();
    }

    public User create(User user){
        return restTemplate.exchange(
            url,
            HttpMethod.POST,
            new HttpEntity(user),
            new ParameterizedTypeReference<User>() {     
            }).getBody();
    }

    public User update(int id, User user) {
        return restTemplate.exchange(
            url + "/" + id,
                HttpMethod.PUT,
                new HttpEntity(user),
                new ParameterizedTypeReference<User>() {
                }
        ).getBody();
    }

    public User delete(int id){
        return restTemplate.exchange(
            url + "/" + id,
            HttpMethod.DELETE,
              null,
             new ParameterizedTypeReference<User>() {
          }).getBody();
    }
}