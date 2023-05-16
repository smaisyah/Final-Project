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

import com.mii.merodata.models.Submition;
import com.mii.merodata.models.dto.request.SubmitionRequest;
import com.mii.merodata.services.StatusService;
import com.mii.merodata.services.SubmitionService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("submition")
public class SubmitionController {
    private SubmitionService submitionService;
    private StatusService statusService;

    @GetMapping
    public List<Submition> getAll() {
        return submitionService.getAll();
    }

    @GetMapping("/{id}")
    public Submition getById(@PathVariable Integer id) {
        return submitionService.getById(id);
    }

    @PostMapping
    public Submition create(@RequestBody Submition submition) {
        submition.setStatus(statusService.getById(1));
        return submitionService.create(submition);
    }

    @PutMapping("/{id}")
    public Submition update(
        @PathVariable Integer id,
        @RequestBody Submition Submition) {
        return submitionService.update(id, Submition);
    }

    @DeleteMapping("/{id}")
    public Submition delete(@PathVariable Integer id) {
        return submitionService.delete(id);
    }
}
