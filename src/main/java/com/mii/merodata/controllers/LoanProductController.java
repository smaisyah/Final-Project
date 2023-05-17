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

import com.mii.merodata.models.LoanProduct;
import com.mii.merodata.services.EmailService;
import com.mii.merodata.services.LoanProductService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/detloan")
public class LoanProductController {
    private LoanProductService loanProductService;
    private EmailService emailService;

    @GetMapping
    public List<LoanProduct> getAll() {
        return loanProductService.getAll();
    }

    @GetMapping("/{id}")
    public LoanProduct getById(@PathVariable Integer id) {
        return loanProductService.getById(id);
    }

    @PostMapping
    public void create(@RequestBody LoanProduct loanDetail) {
        loanProductService.create(loanDetail);
    }

    @PutMapping("/{id}")
    public LoanProduct update(
            @PathVariable Integer id,
            @RequestBody LoanProduct loan) {
        return loanProductService.update(id, loan);
        
    }

    @DeleteMapping("/{id}")
    public LoanProduct delete(@PathVariable Integer id) {
        return loanProductService.delete(id);
    }
}
