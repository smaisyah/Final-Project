package com.mii.merodata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mii.merodata.models.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan,Integer>{
    
}
