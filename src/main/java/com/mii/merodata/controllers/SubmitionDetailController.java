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

import com.mii.merodata.models.SubmitionDetail;
import com.mii.merodata.models.dto.request.SubmitionRequest;
import com.mii.merodata.services.EmailService;
import com.mii.merodata.services.SubmitionDetailService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/detsub")
public class SubmitionDetailController {
    private SubmitionDetailService submitionDetailService;
    private EmailService emailService;

    @GetMapping
    public List<SubmitionDetail> getAll() {
        return submitionDetailService.getAll();
    }

    @GetMapping("/{id}")
    public SubmitionDetail getById(@PathVariable Integer id) {
        return submitionDetailService.getById(id);
    }

    @PostMapping
    public SubmitionDetail create(@RequestBody SubmitionRequest submitionRequest) {
        return submitionDetailService.create(submitionRequest);
    }

    @PutMapping("/{id}")
    public SubmitionDetail update(@PathVariable Integer id, @RequestBody SubmitionDetail user) {
        return submitionDetailService.update(id, user);
    }

    @DeleteMapping("/{id}")
    public SubmitionDetail delete(@PathVariable Integer id) {
        return submitionDetailService.delete(id);
    }

    @PostMapping("/SubEmail")
    public void createFinance(@RequestBody SubmitionDetail submitionDetail){
        emailService.sendEmailSubmition(submitionDetail);
    }
}
