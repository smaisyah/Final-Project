package com.mii.ServerApp.controllers;

import com.mii.ServerApp.models.Loan;
import com.mii.ServerApp.services.LoanService;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/loan")
public class LoanController {

  private LoanService loanService;

  @GetMapping
  public List<Loan> getAll() {
    return loanService.getAll();
  }

  @GetMapping("/{id}")
  public Loan getById(@PathVariable Integer id) {
    return loanService.getById(id);
  }

  @PostMapping
  public Loan create(@RequestBody Loan loan) {
    return loanService.create(loan);
  }

  @PutMapping("/{id}")
  public Loan update(
    @PathVariable Integer id,
    @RequestBody Loan loan
  ) {
    return loanService.update(id, loan);
  }

  @DeleteMapping("/{id}")
  public Loan delete(@PathVariable Integer id) {
    return loanService.delete(id);
  }
}