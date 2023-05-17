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

import com.mii.metrodata.clientappsima.clientappsima.models.Loan;
import com.mii.metrodata.clientappsima.clientappsima.services.LoanService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/loan")
@AllArgsConstructor
public class ApiLoanController {

    private LoanService loanService;

    @GetMapping
    public List<Loan> getAll(){
        return loanService.getAll();
    }

    @GetMapping("/{id}")
    public Loan getById(@PathVariable int id){
        return loanService.getById(id);
    }

    @PostMapping
    public Loan create(@RequestBody Loan loan){
        return loanService.create(loan);
    }

    @PutMapping("/{id}")
    public Loan update(@PathVariable int id, @RequestBody Loan loan){
        return loanService.update(id, loan);
    }

    @DeleteMapping("/{id}")
    public Loan delete(@PathVariable int id){
        return loanService.delete(id);
    }
}