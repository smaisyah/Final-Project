package com.mii.metrodata.clientappsima.clientappsima.controllers.rest;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mii.metrodata.clientappsima.clientappsima.models.Submition;
import com.mii.metrodata.clientappsima.clientappsima.services.SubmitionService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/submition")
@AllArgsConstructor
public class ApiSubmitionController {

    private SubmitionService submitionService;

    @GetMapping
    public List<Submition> getAll(){
        return submitionService.getAll();
    }

    @GetMapping("/{id}")
    public Submition getById(@PathVariable int id){
        return submitionService.getById(id);
    }

    @PostMapping
    public Submition create(@RequestBody Submition submition){
        return submitionService.create(submition);
    }

    @PutMapping("/{id}")
    public Submition update(@PathVariable int id, @RequestBody Submition submition){
        return submitionService.update(id, submition);
    }

    @DeleteMapping("/{id}")
    public Submition delete(@PathVariable int id){
        return submitionService.delete(id);
    }
}