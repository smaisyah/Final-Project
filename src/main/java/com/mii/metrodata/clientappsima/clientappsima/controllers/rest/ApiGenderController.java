package com.mii.metrodata.clientappsima.clientappsima.controllers.rest;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mii.metrodata.clientappsima.clientappsima.models.Gender;
import com.mii.metrodata.clientappsima.clientappsima.services.GenderService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/gender")
@AllArgsConstructor
public class ApiGenderController {

    private GenderService genderservice;

    @GetMapping
    public List<Gender> getAll(){
        return genderservice.getAll();
    }

    @GetMapping("/{id}")
    public Gender getById(@PathVariable int id){
        return genderservice.getById(id);
    }
}
