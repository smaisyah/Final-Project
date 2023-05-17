package com.mii.merodata.services;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.mii.merodata.models.History;
import com.mii.merodata.models.Loan;
import com.mii.merodata.models.LoanProduct;
import com.mii.merodata.models.Product;
import com.mii.merodata.repositories.HistoryRepository;
import com.mii.merodata.repositories.LoanRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class LoanService {
    private LoanRepository loanRepository;
    private StatusService statusService;
    private HistoryRepository historyRepository;
    private ProductService productService;

    public List<Loan> getAlll() {
        return loanRepository.findAll();
    }

    public Loan getById(Integer id) {
        return loanRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Loan Not found"));
    }

    public Loan create(Loan loan) {
        loan.setStatus(statusService.getById(1));
        loan.setLoanDate(new Date());
        Loan saveLoan = loanRepository.save(loan);

        History history = new History();
        history.setHistoryDate(new Date());
        history.setLoan(getById(saveLoan.getId()));
        history.setEmployee(saveLoan.getEmployee());
        history.setStatus(saveLoan.getStatus());
        historyRepository.save(history);

        return saveLoan;
    }

    public Loan update(Integer id, Loan loan) {
        Loan loanOld = getById(id); // get loan old
        loan.setId(id);
        loan.setLoanDate(new Date());
        if (loan.getStatus().getId() == 2) {
            for (LoanProduct loanProduct : loanOld.getDetailLoans()) {
                Product product = productService.getById(loanProduct.getProduct().getId());
                Integer currentQuantity = product.getQuantity();
                Integer quantityLoan = loanProduct.getQuantity();
                product.setQuantity(currentQuantity -= quantityLoan); // a-=b == a=a-b
                productService.update(product.getId(), product);
            }
        }
        Loan updateLoan = loanRepository.save(loan);

        History history = new History();
        history.setHistoryDate(new Date());
        history.setLoan(getById(updateLoan.getId()));
        history.setEmployee(updateLoan.getEmployee());
        history.setStatus(updateLoan.getStatus());
        historyRepository.save(history);

        return updateLoan;
    }

    public Loan delete(Integer id) {
        Loan loan = getById(id);
        loanRepository.delete(loan);
        return loan;
    }
}
