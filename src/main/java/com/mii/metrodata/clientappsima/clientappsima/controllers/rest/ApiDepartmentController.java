package com.mii.metrodata.clientappsima.clientappsima.controllers.rest;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mii.metrodata.clientappsima.clientappsima.models.Department;
import com.mii.metrodata.clientappsima.clientappsima.services.DepartmentService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/department")
@AllArgsConstructor
public class ApiDepartmentController {

    private DepartmentService departmentService;

    @GetMapping
    public List<Department> getAll(){
        return departmentService.getAll();
    }

    @GetMapping("/{id}")
    public Department getById(@PathVariable int id){
        return departmentService.getById(id);
    }

    @PostMapping
    public Department create(@RequestBody Department department){
        return departmentService.create(department);
    }

    @PutMapping("/{id}")
    public Department update(@PathVariable int id, @RequestBody Department department){
        return departmentService.update(id, department);
    }

    @DeleteMapping("/{id}")
    public Department delete(@PathVariable int id){
        return departmentService.delete(id);
    }
}