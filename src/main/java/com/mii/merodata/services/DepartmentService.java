package com.mii.merodata.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.mii.merodata.models.Department;
import com.mii.merodata.repositories.DepartmentRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class DepartmentService {
    private DepartmentRepository departmentRepository;

    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    public Department getById(Integer id) {
        return departmentRepository
                .findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Department not found"));
    }

    public Department create(Department department) {
        return departmentRepository.save(department);
    }

    public Department update(Integer id, Department department) {
        getById(id);
        department.setId(id);
        return create(department);
    }

    public Department delete(Integer id) {
        Department department = getById(id);
        departmentRepository.delete(department);
        return department;
    }

}
