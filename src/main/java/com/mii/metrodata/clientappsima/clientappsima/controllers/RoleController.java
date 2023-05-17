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

import com.mii.metrodata.clientappsima.clientappsima.models.Role;
import com.mii.metrodata.clientappsima.clientappsima.services.RoleService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/role")
@AllArgsConstructor
public class RoleController {
    private RoleService roleService;

    @GetMapping
	public String home(Model model) {
		List<Role> roles = roleService.getAll();
		model.addAttribute("roles", roles);
		Role newrole = new Role();
		model.addAttribute("newrole", newrole);
		return "view/role";
	}

    @GetMapping("/create")
    public String createView(Role role){
        return "role/create-form";
    }

    @PostMapping
    public String create(Role role){
        roleService.create(role);
        return "redirect:/role";
    }

    @GetMapping("/update/{id}")
    public String updateView(@PathVariable int id,Model model){
        model.addAttribute("role", roleService.getById(id));
        return "role/update-form";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable int id, Role role){
        roleService.update(id, role);
        return "redirect:/role";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        roleService.delete(id);
        return "redirect:/role";
    }
}