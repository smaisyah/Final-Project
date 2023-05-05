package com.mii.merodata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mii.merodata.models.Department;

@Repository
public interface DepartentRepository extends JpaRepository<Department,Integer>{
    
}
