package com.mii.merodata.services;

import com.mii.merodata.models.Employee;
import com.mii.merodata.models.Role;
import com.mii.merodata.models.User;
import com.mii.merodata.models.dto.request.LoginRequest;
import com.mii.merodata.models.dto.request.UserRequest;
import com.mii.merodata.models.dto.responses.LoginResponse;
import com.mii.merodata.repositories.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
// @NoArgsConstructor
@AllArgsConstructor
public class AuthService {

  private AuthenticationManager authenticationManager;
  private UserRepository userRepository;
  // private AppUserDetailService appUserDetailService;
  private ModelMapper modelMapper;
  private PasswordEncoder passwordEncoder;
  private RoleService roleService;
  private EmailService emailService;

  // public LoginResponse login(LoginRequest loginRequest) {
  //   // login request
  //   UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(
  //     loginRequest.getUsername(),
  //     loginRequest.getPassword()
  //   );

  //   // set principle
  //   Authentication auth = authenticationManager.authenticate(authReq);
  //   SecurityContextHolder.getContext().setAuthentication(auth);

  //   User user = userRepository
  //     .findByUsernameOrEmployee_Email(
  //       loginRequest.getUsername(),
  //       loginRequest.getUsername()
  //     )
  //     .get();

  //   UserDetails userDetails = appUserDetailService.loadUserByUsername(
  //     loginRequest.getUsername()
  //   );

  //   List<String> authorities = userDetails
  //     .getAuthorities()
  //     .stream()
  //     .map(authority -> authority.getAuthority())
  //     .collect(Collectors.toList());

  //   return new LoginResponse(
  //     user.getUsername(),
  //     user.getEmployee().getEmail(),
  //     authorities
  //   );
  // }
  
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
    userRepository.save(user);
    emailService.sendEmailUser(userRequest);
  }

  public void createManager(UserRequest userRequest) {
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
    userRepository.save(user);
    emailService.sendEmailUser(userRequest);
  }

  public void createITsupport(UserRequest userRequest) {
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
    userRepository.save(user);
    emailService.sendEmailUser(userRequest);
  }
}
