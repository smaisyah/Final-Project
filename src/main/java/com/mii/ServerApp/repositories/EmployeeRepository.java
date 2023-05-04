package com.mii.ServerApp.repositories;

import com.mii.ServerApp.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {}
