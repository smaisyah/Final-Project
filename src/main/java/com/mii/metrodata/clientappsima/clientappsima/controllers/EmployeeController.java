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

import com.mii.metrodata.clientappsima.clientappsima.models.Employee;
import com.mii.metrodata.clientappsima.clientappsima.models.dto.request.RegisterRequest;
import com.mii.metrodata.clientappsima.clientappsima.services.EmployeeService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/employee")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;

    @GetMapping
	public String home(RegisterRequest registerRequest, Model model) {
		List<Employee> employees = employeeService.getAll();
		model.addAttribute("employees", employees);
		Employee newEmployee = new Employee();
		model.addAttribute("newEmployee", newEmployee);
		return "view/employee";
	}

    // @GetMapping("/create")
    // public String createView(Employee employee){
    //     return "employee/create-form";
    // }

    @PostMapping
    public String create(Employee employee){
        employeeService.create(employee);
        return "redirect:/employee";
    }

    // @GetMapping("/update/{nik}")
    // public String updateView(@PathVariable String nik,Model model){
    //     model.addAttribute("employee", employeeService.getById(nik));
    //     return "employee/update-form";
    // }

    @PutMapping("/{nik}")
    public String update(@PathVariable String nik, Employee employee){
        employeeService.update(nik, employee);
        return "redirect:/employee";
    }

    @DeleteMapping("/{nik}")
    public String delete(@PathVariable String nik){
        employeeService.delete(nik);
        return "redirect:/employee";
    }
}