package com.mii.metrodata.clientappsima.clientappsima.services;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mii.metrodata.clientappsima.clientappsima.models.dto.request.LoginRequest;
import com.mii.metrodata.clientappsima.clientappsima.models.dto.request.RegisterRequest;
import com.mii.metrodata.clientappsima.clientappsima.models.dto.respones.LoginRespon;

@Service
public class RegisterService {

    private RestTemplate restTemplate;

    @Autowired
    public RegisterService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${server.baseUrl}/")
    private String url;

    public boolean login(LoginRequest logReq) {
        try {
            ResponseEntity<LoginRespon> response = restTemplate.exchange(
                    url + "login",
                    HttpMethod.POST,
                    new HttpEntity(logReq),
                    new ParameterizedTypeReference<LoginRespon>() {
                    });

            if (response.getStatusCode() == HttpStatus.OK) {
                setPrinciple(response.getBody(), logReq.getPassword());
                return true;
            }

        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public void setPrinciple(LoginRespon logres, String password) {
        Collection<GrantedAuthority> authorities = logres.getAuthorities().stream()
                .map(authority -> new SimpleGrantedAuthority(authority))
                .collect(Collectors.toList());

        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(logres.getUsername(),
                password, authorities);
        SecurityContextHolder.getContext().setAuthentication(authToken);
    }

    public RegisterRequest register(RegisterRequest registerRequest) {
        return restTemplate.exchange(
                url + "user",
                HttpMethod.POST,
                new HttpEntity(registerRequest),
                new ParameterizedTypeReference<RegisterRequest>() {
                }).getBody();
    }
}