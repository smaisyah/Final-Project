package com.mii.merodata.controllers;

import com.mii.merodata.models.User;
import com.mii.merodata.models.dto.request.LoginRequest;
import com.mii.merodata.models.dto.request.UserRequest;
import com.mii.merodata.models.dto.responses.LoginResponse;
import com.mii.merodata.services.AuthService;
// import com.mii.merodata.services.AuthService;
import com.mii.merodata.services.EmailService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthController {

  private AuthService authService;
  private EmailService emailService;

  // @PostMapping("/login")
  // public LoginResponse login(@RequestBody LoginRequest loginRequest) {
  //   return authService.login(loginRequest);
  // }

  @PostMapping("/register-user")
  public void createUser(@RequestBody UserRequest userRequest){
    authService.createUser(userRequest);
  }

  @PostMapping("/register-manager")
  public void createManager(@RequestBody UserRequest userRequest){
    authService.createManager(userRequest);
  }

  @PostMapping("/register-itsupport")
  public void createITsupport(@RequestBody UserRequest userRequest){
    authService.createITsupport(userRequest);
  }
}
