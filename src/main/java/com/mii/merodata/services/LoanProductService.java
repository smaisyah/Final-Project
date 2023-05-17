package com.mii.merodata.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.mii.merodata.models.LoanProduct;
import com.mii.merodata.models.Product;
import com.mii.merodata.repositories.LoanProductRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoanProductService {
    private LoanProductRepository loanProductRepository;
    private ProductService productService;
    private EmailService emailService;

    public List<LoanProduct> getAll() {
        return loanProductRepository.findAll();
    }

    public LoanProduct getById(Integer id) {
        return loanProductRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Loan Not found"));
    }

    public LoanProduct create(LoanProduct loandDetail) {
        Product product = productService.getById(loandDetail.getProduct().getId());
        Integer currentQuantity = product.getQuantity();
        Integer quantityLoan = loandDetail.getQuantity();
        if (currentQuantity < quantityLoan) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Cannot borrow more than available quantity");
        }
        return loanProductRepository.save(loandDetail);
    }

    public LoanProduct update(Integer id, LoanProduct loanDetail) {
        getById(id);
        loanDetail.setId(id);
        // emailService.sendEmailLoan(loanDetail);
        return loanProductRepository.save(loanDetail);
    }

    public LoanProduct delete(Integer id) {
        LoanProduct loanDetail = getById(id);
        loanProductRepository.delete(loanDetail);
        return loanDetail;
    }
}
