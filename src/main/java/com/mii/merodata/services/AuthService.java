package com.mii.merodata.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.mii.merodata.models.User;
import com.mii.merodata.models.dto.request.LoginRequest;
import com.mii.merodata.models.dto.respon.LoginResponse;
import com.mii.merodata.repositories.UserRepository;

import lombok.AllArgsConstructor;

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

