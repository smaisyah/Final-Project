package com.mii.merodata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mii.merodata.models.Submition;

@Repository
public interface SubmitionRepository extends JpaRepository<Submition, Integer>{
    
}
