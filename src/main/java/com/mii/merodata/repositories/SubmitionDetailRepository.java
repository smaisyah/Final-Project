package com.mii.merodata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mii.merodata.models.SubmitionDetail;

@Repository
public interface SubmitionDetailRepository extends JpaRepository<SubmitionDetail,Integer> {
    
}
