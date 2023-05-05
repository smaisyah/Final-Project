package com.mii.ServerApp.services;

import com.mii.ServerApp.models.Loan;
import com.mii.ServerApp.repositories.LoanRepository;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class LoanService {

  private LoanRepository loanRepository;

  public List<Loan> getAll() {
    return loanRepository.findAll();
  }

  public Loan getById(Integer id) {
    return loanRepository
      .findById(id)
      .orElseThrow(() ->
        new ResponseStatusException(
          HttpStatus.NOT_FOUND,
          "Loan not found!!"
        )
      );
  }

  public Loan create(Loan loan) {
    return loanRepository.save(loan);
  }

  public Loan update(Integer id, Loan loan) {
    getById(id); // method getById
    loan.setId(id);
    return loanRepository.save(loan);
  }

  public Loan delete(Integer id) {
    Loan loan = getById(id);
    loanRepository.delete(loan);
    return loan;
  }
}
