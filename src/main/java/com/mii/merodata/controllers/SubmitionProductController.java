package com.mii.merodata.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mii.merodata.models.SubmitionProduct;
import com.mii.merodata.models.dto.request.SubmitionRequest;
import com.mii.merodata.services.SubmitionProductService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/detsub")
public class SubmitionProductController {
    private SubmitionProductService submitionProductService;

    @GetMapping
    public List<SubmitionProduct> getAll() {
        return submitionProductService.getAll();
    }

    @GetMapping("/{id}")
    public SubmitionProduct getById(@PathVariable Integer id) {
        return submitionProductService.getById(id);
    }

    @PostMapping
    public void create(@RequestBody SubmitionRequest submitionRequest) {
        submitionProductService.create(submitionRequest);
    }

    @PostMapping("/restok")
    public SubmitionProduct restok(@RequestBody SubmitionProduct submitionProduct) {
        return submitionProductService.reStok(submitionProduct);
    }

    @PutMapping("/{id}")
    public SubmitionProduct update(@PathVariable Integer id, @RequestBody SubmitionProduct user) {
        return submitionProductService.update(id, user);
    }

    @DeleteMapping("/{id}")
    public SubmitionProduct delete(@PathVariable Integer id) {
        return submitionProductService.delete(id);
    }
}
