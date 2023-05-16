package com.mii.merodata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mii.merodata.models.LoanDetail;

@Repository
public interface LoanDetailRepository extends JpaRepository<LoanDetail,Integer>{
    
}
