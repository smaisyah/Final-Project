package com.mii.merodata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mii.merodata.models.Employee;

@Repository
public interface Employeerepository extends JpaRepository<Employee, Integer>{
    
}
