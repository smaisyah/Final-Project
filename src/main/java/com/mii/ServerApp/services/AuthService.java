// package com.mii.ServerApp.services;

// import com.mii.ServerApp.models.Employee;
// import com.mii.ServerApp.models.Role;
// import com.mii.ServerApp.models.User;
// import com.mii.ServerApp.models.dto.request.LoginRequest;
// import com.mii.ServerApp.models.dto.request.UserRequest;
// import com.mii.ServerApp.models.dto.responses.LoginResponse;
// import com.mii.ServerApp.repositories.UserRepository;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.stream.Collectors;
// import lombok.AllArgsConstructor;
// import org.modelmapper.ModelMapper;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Service;

// @Service
// @AllArgsConstructor
// public class AuthService {

//   private AuthenticationManager authenticationManager;
//   private UserRepository userRepository;
//   private AppUserDetailService appUserDetailService;
//   private ModelMapper modelMapper;
//   private PasswordEncoder passwordEncoder;
//   private RoleService roleService;

//   public LoginResponse login(LoginRequest loginRequest) {
//     // login request
//     UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(
//       loginRequest.getUsername(),
//       loginRequest.getPassword()
//     );

//     // set principle
//     Authentication auth = authenticationManager.authenticate(authReq);
//     SecurityContextHolder.getContext().setAuthentication(auth);

//     User user = userRepository
//       .findByUsernameOrEmployee_Email(
//         loginRequest.getUsername(),
//         loginRequest.getUsername()
//       )
//       .get();

//     UserDetails userDetails = appUserDetailService.loadUserByUsername(
//       loginRequest.getUsername()
//     );

//     List<String> authorities = userDetails
//       .getAuthorities()
//       .stream()
//       .map(authority -> authority.getAuthority())
//       .collect(Collectors.toList());

//     return new LoginResponse(
//       user.getUsername(),
//       user.getEmployee().getEmail(),
//       authorities
//     );
//   }

//   public User create(UserRequest userRequest) {
//     Employee employee = modelMapper.map(userRequest, Employee.class);
//     User user = modelMapper.map(userRequest, User.class);

//     // set password
//     user.setPassword(passwordEncoder.encode(userRequest.getPassword()));

//     // set Role
//     List<Role> roles = new ArrayList<>();
//     roles.add(roleService.getById(1));
//     user.setRoles(roles);

//     employee.setUser(user);
//     user.setEmployee(employee);
//     return userRepository.save(user);
//   }
// }
