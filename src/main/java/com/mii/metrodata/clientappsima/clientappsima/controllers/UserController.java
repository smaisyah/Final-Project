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

import com.mii.metrodata.clientappsima.clientappsima.models.User;
import com.mii.metrodata.clientappsima.clientappsima.models.dto.request.RegisterRequest;
import com.mii.metrodata.clientappsima.clientappsima.services.EmployeeService;
import com.mii.metrodata.clientappsima.clientappsima.services.UserService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    private EmployeeService employeeService;

	@GetMapping
	public String home(RegisterRequest registerRequest, Model model) {
		List<User> users = userService.getAll();
		model.addAttribute("users", users);
		User newuser = new User();
		model.addAttribute("newuser", newuser);
		return "user/index";
	}

    @GetMapping("/create")
    public String createView(User user){
        return "user/create-form";
    }

    @PostMapping
    public String create(User user){
        userService.create(user);
        return "redirect:/user";
    }

    @GetMapping("/update/{id}")
    public String updateView(@PathVariable int id,Model model){
        model.addAttribute("user", userService.getById(id));
        return "user/update-form";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable int id, User user){
        userService.update(id, user);
        return "redirect:/user";
    }

    @DeleteMapping("/{id}")
	public String delete(@PathVariable int id) {
		employeeService.delete(id);
		return "redirect:/user";
	}
}
