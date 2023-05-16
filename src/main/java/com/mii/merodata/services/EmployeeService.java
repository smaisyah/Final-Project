package com.mii.merodata.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.mii.merodata.models.Employee;
import com.mii.merodata.repositories.EmployeeRepository;
import com.mii.merodata.utils.GenerateId;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;
    private GenerateId generateId;

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Employee getById(Integer id) {
        return employeeRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));
    }

    public Employee create(Employee employee) {
        // String intial = "MCC";
        // Integer maxDigit = 3;
        // Integer currentId = 0;

        // currentId++;
        // String formatId = String.format("%s%0" + maxDigit + "d", intial, currentId);
        
        // employee.setNik(formatId);
        return employeeRepository.save(employee);
    }

    public Employee update(Integer id, Employee employee) {
        getById(id); // method getById
        employee.setId(id);
        return employeeRepository.save(employee);
    }

    public Employee delete(Integer id) {
        Employee employee = getById(id);
        employeeRepository.delete(employee);
        return employee;
    }
}
