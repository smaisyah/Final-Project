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

import com.mii.metrodata.clientappsima.clientappsima.models.User;
import com.mii.metrodata.clientappsima.clientappsima.services.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class ApiUserController {

    private UserService userService;

    @GetMapping
    public List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable int id){
        return userService.getById(id);
    }

    @PostMapping
    public User create(@RequestBody User user){
        return userService.create(user);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable int id, @RequestBody User user){
        return userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    public User delete(@PathVariable int id){
        return userService.delete(id);
    }
}