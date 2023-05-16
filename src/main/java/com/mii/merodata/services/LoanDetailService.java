package com.mii.merodata.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.mii.merodata.models.LoanDetail;
import com.mii.merodata.repositories.LoanDetailRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoanDetailService {
    private LoanDetailRepository loanDetailRepository;
    private ModelMapper modelMapper;
    private ProductService productService;
    
    public List<LoanDetail> getAll(){
        return loanDetailRepository.findAll();
    }

    public LoanDetail getById(Integer id) {
        return loanDetailRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Loan Not found"));
    }

    public LoanDetail create(LoanDetail loandDetail) {
        return loanDetailRepository.save(loandDetail);
    }

    public LoanDetail update(Integer id, LoanDetail loanDetail) {
        getById(id);
        loanDetail.setId(id);
        return loanDetailRepository.save(loanDetail);
    }

    public LoanDetail delete(Integer id) {
        LoanDetail loanDetail = getById(id);
        loanDetailRepository.delete(loanDetail);
        return loanDetail;
    }
}
