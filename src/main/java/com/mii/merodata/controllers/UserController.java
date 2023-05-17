package com.mii.merodata.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mii.merodata.models.Role;
import com.mii.merodata.models.User;
import com.mii.merodata.models.dto.request.UserRequest;
import com.mii.merodata.services.EmailService;
// import com.mii.merodata.services.EmailService;
import com.mii.merodata.services.UserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    private EmailService emailService;

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @PostMapping("/register-user")
    public void createUser(@RequestBody UserRequest userRequest){
        userService.createUser(userRequest);
    }
  
    @PostMapping("/register-manager")
    public void createManager(@RequestBody UserRequest userRequest){
         userService.createManager(userRequest);
    }
  
    @PostMapping("/register-itsupport")
    public void createITsupport(@RequestBody UserRequest userRequest){
         userService.createUser(userRequest);
    }

    @PostMapping("/register-admin")
    public void createAdmin(@RequestBody UserRequest userRequest){
         userService.createUser(userRequest);
    }

    @PostMapping("/register-finance")
    public void createFinance(@RequestBody UserRequest userRequest){
         userService.createUser(userRequest);
    }


    @PutMapping("/{id}")
    public User update(@PathVariable Integer id, @RequestBody User user) {
        return userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    public User delete(@PathVariable Integer id) {
        return userService.delete(id);
    }

    @PostMapping("/{id}")
    public User addRole(@PathVariable Integer id, @RequestBody Role role) {
        return userService.addRole(id, role);
    }
}