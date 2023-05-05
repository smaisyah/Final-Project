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