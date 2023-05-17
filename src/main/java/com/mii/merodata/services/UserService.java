package com.mii.merodata.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.mii.merodata.models.Employee;
import com.mii.merodata.models.Role;
import com.mii.merodata.models.User;
import com.mii.merodata.models.dto.request.UserRequest;
import com.mii.merodata.repositories.UserRepository;
// import com.mii.merodata.utils.GenerateId;
import com.mii.merodata.utils.PasswordEncoderUtil;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserService {
    private UserRepository userRepository;
    private ModelMapper modelMapper;
    private RoleService roleService;
    private EmailService emailService;
    private PasswordEncoder passwordEncoder;
    // private GenerateId generateId;

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

    // USER
    public void createUser(UserRequest userRequest) {
        Employee employee = modelMapper.map(userRequest, Employee.class);
        User user = modelMapper.map(userRequest, User.class);
    
        // set password
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
    
        // set Role
        List<Role> roles = new ArrayList<>();
        roles.add(roleService.getById(1));
        user.setRoles(roles);
    
        employee.setUser(user);
        user.setEmployee(employee);
        emailService.sendEmailUser(userRequest);
        userRepository.save(user);
      }

        // Admin
      public void createAdmin(UserRequest userRequest) {
        Employee employee = modelMapper.map(userRequest, Employee.class);
        User user = modelMapper.map(userRequest, User.class);
    
        // set password
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
    
        // set Role
        List<Role> roles = new ArrayList<>();
        roles.add(roleService.getById(2));
        user.setRoles(roles);
    
        employee.setUser(user);
        user.setEmployee(employee);
        emailService.sendEmailUser(userRequest);
        userRepository.save(user);
      }
    
      //MANAGER
      public void createManager(UserRequest userRequest) {
        Employee employee = modelMapper.map(userRequest, Employee.class);
        User user = modelMapper.map(userRequest, User.class);
    
        // set password
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
    
        // set Role
        List<Role> roles = new ArrayList<>();
        roles.add(roleService.getById(3));
        user.setRoles(roles);
    
        employee.setUser(user);
        user.setEmployee(employee);
        emailService.sendEmailUser(userRequest);
        userRepository.save(user);
      }
    
      // iT SUPPORT
      public void createITsupport(UserRequest userRequest) {
        Employee employee = modelMapper.map(userRequest, Employee.class);
        User user = modelMapper.map(userRequest, User.class);
    
        // set password
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
    
        // set Role
        List<Role> roles = new ArrayList<>();
        roles.add(roleService.getById(4));
        user.setRoles(roles);
    
        employee.setUser(user);
        user.setEmployee(employee);
        emailService.sendEmailUser(userRequest);
        userRepository.save(user);
      }

        // Finance
        public void createFinance(UserRequest userRequest) {
            Employee employee = modelMapper.map(userRequest, Employee.class);
            User user = modelMapper.map(userRequest, User.class);
        
            // set password
            user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        
            // set Role
            List<Role> roles = new ArrayList<>();
            roles.add(roleService.getById(5));
            user.setRoles(roles);
        
            employee.setUser(user);
            user.setEmployee(employee);
            emailService.sendEmailUser(userRequest);
            userRepository.save(user);
        }

    public User update(Integer id, User user) {
        getById(id); // method getById
        // user.setId(id);
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
