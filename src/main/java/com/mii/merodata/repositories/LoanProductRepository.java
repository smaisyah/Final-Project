package com.mii.merodata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mii.merodata.models.LoanProduct;

@Repository
public interface LoanProductRepository extends JpaRepository<LoanProduct,Integer>{
    
}
