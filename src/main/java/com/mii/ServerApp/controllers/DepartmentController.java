package com.mii.ServerApp.controllers;

import com.mii.ServerApp.models.Department;
import com.mii.ServerApp.services.DepartmentService;
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
@RequestMapping("/department")
public class DepartmentController {

  private DepartmentService departmentService;

  @GetMapping
  public List<Department> getAll() {
    return departmentService.getAll();
  }

  @GetMapping("/{id}")
  public Department getById(@PathVariable Integer id) {
    return departmentService.getById(id);
  }

  @PostMapping
  public Department create(@RequestBody Department department) {
    return departmentService.create(department);
  }

  @PutMapping("/{id}")
  public Department update(
    @PathVariable Integer id,
    @RequestBody Department department
  ) {
    return departmentService.update(id, department);
  }

  @DeleteMapping("/{id}")
  public Department delete(@PathVariable Integer id) {
    return departmentService.delete(id);
  }
}
