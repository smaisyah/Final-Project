package com.mii.merodata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mii.merodata.models.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer>{
    
}
