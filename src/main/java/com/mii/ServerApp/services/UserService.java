package com.mii.ServerApp.services;

import com.mii.ServerApp.models.Role;
import com.mii.ServerApp.models.User;
import com.mii.ServerApp.repositories.UserRepository;
// import java.util.Collections;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class UserService {

  private RoleService roleService;
  private UserRepository userRepository;

  // private ModelMapper modelMapper;
  // private PasswordEncoder passwordEncoder;

  public List<User> getAll() {
    return userRepository.findAll();
  }

  public User getById(Integer id) {
    return userRepository
      .findById(id)
      .orElseThrow(() ->
        new ResponseStatusException(
          HttpStatus.NOT_FOUND,
          "Data User not found!!!"
        )
      );
  }

  // public User create(UserRequest userRequest) {
  //   Employee employee = modelMapper.map(userRequest, Employee.class);
  //   User user = modelMapper.map(userRequest, User.class);

    // // Set role user secara otomatis pada saat create user
    // Role userRole = roleService.getById(1); // .getByRoleName("user");
    // user.setRoles(Collections.singletonList(userRole)); //  metode Collections.singletonList() untuk membuat sebuah daftar satu elemen yang berisi objek Role yang kita dapatkan sebelumnya.

     // set password
    //  user.setPassword(passwordEncoder.encode(userRequest.getPassword()));

    // set Role
    // List<Role> roles = new ArrayList<>();
    // roles.add(roleService.getById(1));
    // user.setRoles(roles);

  //   employee.setUser(user);
  //   user.setEmployee(employee);
  //   return userRepository.save(user);
  // }

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