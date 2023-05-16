package com.mii.merodata.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.mii.merodata.models.Employee;
import com.mii.merodata.models.Role;
import com.mii.merodata.models.User;
import com.mii.merodata.models.dto.request.UserRequest;
import com.mii.merodata.repositories.UserRepository;
import com.mii.merodata.utils.GenerateId;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserService {
    private UserRepository userRepository;
    private ModelMapper modelMapper;
    private RoleService roleService;
    private EmployeeService employeeService;
    private GenerateId generateId;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(Integer id) {
        return userRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Data User not found!!!"));
    }

    public User create(UserRequest userRequest) {
        Employee employee = modelMapper.map(userRequest, Employee.class);
        User user = modelMapper.map(userRequest, User.class);

        // set Role
        List<Role> roles = new ArrayList<>();
        roles.add(roleService.getById(1));
        user.setRoles(roles);

        // Employee emp = employeeService.getById(employee.getId());
        // String nik = emp.getNik();


        employee.setUser(user);
        // employee.setNik(employee.getNik());
        Employee emp = employeeService.create(employee);
        user.setEmployee(emp);
        // user.setUsername(nik);
        // user.setPassword(nik);
        return userRepository.save(user);
    }

    public User update(Integer id, User user) {
        getById(id); // method getById
        user.setId(id);
        return userRepository.save(user);
    }

    public User delete(Integer id) {
        User user = getById(id);
        userRepository.delete(user);
        return user;
    }

    public User addRole(Integer id, Role role) {
        User user = getById(id);
        List<Role> roles = user.getRoles();
        roles.add(roleService.getById(role.getId()));
        user.setRoles(roles);
        return userRepository.save(user);
    }
}
