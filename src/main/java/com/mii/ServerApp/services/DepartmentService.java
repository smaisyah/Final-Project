package com.mii.ServerApp.services;

import com.mii.ServerApp.models.Department;
import com.mii.ServerApp.repositories.DepartmentRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class DepartmentService {

  private DepartmentRepository departmentRepository;

  public List<Department> getAll() {
    return departmentRepository.findAll();
  }

  public Department getById(Integer id) {
    return departmentRepository
      .findById(id)
      .orElseThrow(() ->
        new ResponseStatusException(
          HttpStatus.NOT_FOUND,
          "Department not found!!"
        )
      );
  }

  public Department create(Department department) {
    return departmentRepository.save(department);
  }

  public Department update(Integer id, Department department) {
    getById(id); // method getById
    department.setId(id);
    return departmentRepository.save(department);
  }

  public Department delete(Integer id) {
    Department department = getById(id);
    departmentRepository.delete(department);
    return department;
  }
}