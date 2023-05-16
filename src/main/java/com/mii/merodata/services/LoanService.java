package com.mii.merodata.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.mii.merodata.models.Loan;
import com.mii.merodata.repositories.LoanRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class LoanService {
    private LoanRepository loanRepository;

    public List<Loan> getAlll() {
        return loanRepository.findAll();
    }

    public Loan getById(Integer id) {
        return loanRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Loan Not found"));
    }

    public Loan create(Loan loan) {
        return loanRepository.save(loan);
    }

    public Loan update(Integer id, Loan loan) {
        getById(id);
        loan.setId(id);
        return loanRepository.save(loan);
    }

    public Loan delete(Integer id) {
        Loan loan = getById(id);
        loanRepository.delete(loan);
        return loan;
    }
}
