package com.mii.merodata.services;

import com.mii.merodata.models.Employee;
import com.mii.merodata.models.Role;
import com.mii.merodata.models.User;
import com.mii.merodata.models.dto.request.LoginRequest;
import com.mii.merodata.models.dto.responses.LoginResponse;
import com.mii.merodata.repositories.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {

  private AuthenticationManager authenticationManager;
  private UserRepository userRepository;
  private AppUserDetailService appUserDetailService;

  public LoginResponse login(LoginRequest loginRequest) {
    // login request
    UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(
      loginRequest.getUsername(),
      loginRequest.getPassword()
    );

    // set principle
    Authentication auth = authenticationManager.authenticate(authReq);
    SecurityContextHolder.getContext().setAuthentication(auth);

    User user = userRepository
      .findByUsernameOrEmployee_Email(
        loginRequest.getUsername(),
        loginRequest.getUsername()
      )
      .get();

    UserDetails userDetails = appUserDetailService.loadUserByUsername(
      loginRequest.getUsername()
    );

    List<String> authorities = userDetails
      .getAuthorities()
      .stream()
      .map(authority -> authority.getAuthority())
      .collect(Collectors.toList());

    return new LoginResponse(
      user.getUsername(),
      user.getEmployee().getEmail(),
      authorities
    );
  }

  }
