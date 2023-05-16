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

import com.mii.merodata.models.Loan;
import com.mii.merodata.services.LoanService;
import com.mii.merodata.services.StatusService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/loan")
public class LoanController {
    private LoanService loanService;
    private StatusService statusService;

    @GetMapping
    public List<Loan> getAll() {
        return loanService.getAlll();
    }

    @GetMapping("/{id}")
    public Loan getById(@PathVariable Integer id) {
        return loanService.getById(id);
    }

    @PostMapping
    public Loan create(@RequestBody Loan loan) {
        loan.setStatus(statusService.getById(1));
        return loanService.create(loan);
    }

    @PutMapping("/{id}")
    public Loan update(
            @PathVariable Integer id,
            @RequestBody Loan loan) {
        return loanService.update(id, loan);
    }

    @DeleteMapping("/{id}")
    public Loan delete(@PathVariable Integer id) {
        return loanService.delete(id);
    }
}