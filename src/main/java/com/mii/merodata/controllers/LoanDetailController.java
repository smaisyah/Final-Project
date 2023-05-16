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

import com.mii.merodata.models.LoanDetail;
import com.mii.merodata.services.LoanDetailService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/detloan")
public class LoanDetailController {
    private LoanDetailService loanDetailService;

    @GetMapping
    public List<LoanDetail> getAll() {
        return loanDetailService.getAll();
    }

    @GetMapping("/{id}")
    public LoanDetail getById(@PathVariable Integer id) {
        return loanDetailService.getById(id);
    }

    @PostMapping
    public LoanDetail create(@RequestBody LoanDetail loanDetail) {
        return loanDetailService.create(loanDetail);
    }

    @PutMapping("/{id}")
    public LoanDetail update(
            @PathVariable Integer id,
            @RequestBody LoanDetail loan) {
        return loanDetailService.update(id, loan);
    }

    @DeleteMapping("/{id}")
    public LoanDetail delete(@PathVariable Integer id) {
        return loanDetailService.delete(id);
    }
}
