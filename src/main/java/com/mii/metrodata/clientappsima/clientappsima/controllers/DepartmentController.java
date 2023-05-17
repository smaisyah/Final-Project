package com.mii.metrodata.clientappsima.clientappsima.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mii.metrodata.clientappsima.clientappsima.models.Department;
import com.mii.metrodata.clientappsima.clientappsima.services.DepartmentService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/department")
@AllArgsConstructor
public class DepartmentController {
    private DepartmentService departmentService;

    @GetMapping
    public String index(Model model){
        List<Department> departments = departmentService.getAll();
        model.addAttribute("departments", departments);
        return "view/department";
    }

    @GetMapping("/create")
    public String createView(Department department){
        return "department/create-form";
    }

    @PostMapping
    public String create(Department department){
        departmentService.create(department);
        return "redirect:/department";
    }

    @GetMapping("/update/{id}")
    public String updateView(@PathVariable int id,Model model){
        model.addAttribute("department", departmentService.getById(id));
        return "department/update-form";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable int id, Department department){
        departmentService.update(id, department);
        return "redirect:/department";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        departmentService.delete(id);
        return "redirect:/department";
    }
}