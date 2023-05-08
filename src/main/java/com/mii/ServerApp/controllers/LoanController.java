package com.mii.ServerApp.controllers;

import com.mii.ServerApp.models.Loan;
import com.mii.ServerApp.models.dto.request.LoanRequest;
import com.mii.ServerApp.services.LoanService;

import java.util.List;
import lombok.AllArgsConstructor;

import org.springframework.security.access.prepost.PreAuthorize;
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

  @PreAuthorize("hasAnyAuthority('READ_ADMIN', 'READ_USER')")
  @GetMapping
  public List<Loan> getAll() {
    return loanService.getAll();
  }

  @PreAuthorize("hasAnyAuthority('READ_ADMIN', 'READ_USER')")
  @GetMapping("/{id}")
  public Loan getById(@PathVariable Integer id) {
    return loanService.getById(id);
  }

  // without dto
  @PreAuthorize("hasAuthority('CREATE_ADMIN')")
  @PostMapping
  public Loan create(@RequestBody Loan loan) {
    return loanService.create(loan);
  }

  // with dto
  @PreAuthorize("hasAuthority('CREATE_ADMIN')")
  @PostMapping("/dto")
  public Loan createWithDTO(@RequestBody LoanRequest loanRequest) {
    return loanService.createWithDTO(loanRequest);
  }

  // // with modelmapper
  // @PreAuthorize("hasAuthority('CREATE_ADMIN')")
  // @PostMapping("/dto-mm")
  // public Loan createWithModelMapper(
  //   @RequestBody LoanRequest loanRequest
  // ) {
  //   return loanService.createWithModelMapper(loanRequest);
  // }

  @PutMapping("/{id}")
  @PreAuthorize("hasAuthority('UPDATE_ADMIN')")
  public Loan update(
    @PathVariable Integer id,
    @RequestBody Loan loan
  ) {
    return loanService.update(id, loan);
  }

  @PreAuthorize("hasAuthority('UPDATE_ADMIN')")
  @DeleteMapping("/{id}")
  public Loan delete(@PathVariable Integer id) {
    return loanService.delete(id);
  }
}