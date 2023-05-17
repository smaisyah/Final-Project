package com.mii.metrodata.clientappsima.clientappsima.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mii.metrodata.clientappsima.clientappsima.models.Employee;
import com.mii.metrodata.clientappsima.clientappsima.models.dto.request.RegisterRequest;
import com.mii.metrodata.clientappsima.clientappsima.services.EmployeeService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/home")
@AllArgsConstructor
public class HomeController {
    private EmployeeService employeeService;

    @GetMapping
	public String home(RegisterRequest registerRequest, Model model) {
		List<Employee> employees = employeeService.getAll();
		model.addAttribute("employees", employees);
		Employee newEmployee = new Employee();
		model.addAttribute("newEmployee", newEmployee);
		return "view/home";
	}
}
