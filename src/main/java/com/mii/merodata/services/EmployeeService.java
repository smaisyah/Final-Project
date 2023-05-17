package com.mii.merodata.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.mii.merodata.models.Employee;
import com.mii.merodata.repositories.EmployeeRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Employee getById(String nik) {
        return employeeRepository.findByNik(nik);
    }

    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee update(String nik, Employee employee) {
        getById(nik); // method getById
        employee.setNik(nik);
        return employeeRepository.save(employee);
    }

    public Employee delete(String nik) {
        Employee employee = getById(nik);
        employeeRepository.delete(employee);
        return employee;
    }
}
