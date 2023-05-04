package com.mii.ServerApp.controllers;

import com.mii.ServerApp.models.Employee;
import com.mii.ServerApp.services.EmployeeService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/employee")
public class EmployeeController {

  private EmployeeService employeeService;

  @GetMapping
  public List<Employee> getAll() {
    return employeeService.getAll();
  }

  @GetMapping("/{id}")
  public Employee getById(@PathVariable Integer id) {
    return employeeService.getById(id);
  }

  @PostMapping
  public Employee create(@RequestBody Employee employee) {
    return employeeService.create(employee);
  }

  @PutMapping("/{id}")
  public Employee update(
    @PathVariable Integer id,
    @RequestBody Employee employee
  ) {
    return employeeService.update(id, employee);
  }

  @DeleteMapping("/{id}")
  public Employee delete(@PathVariable Integer id) {
    return employeeService.delete(id);
  }
}