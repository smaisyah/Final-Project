// package com.mii.ServerApp.controllers;

// import com.mii.ServerApp.models.User;
// import com.mii.ServerApp.models.dto.request.LoginRequest;
// import com.mii.ServerApp.models.dto.request.UserRequest;
// import com.mii.ServerApp.models.dto.responses.LoginResponse;
// import com.mii.ServerApp.services.AuthService;
// import lombok.AllArgsConstructor;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RestController;

// @RestController
// @AllArgsConstructor
// public class AuthController {

//   private AuthService authService;

//   @PostMapping("/login")
//   public LoginResponse login(@RequestBody LoginRequest loginRequest) {
//     return authService.login(loginRequest);
//   }

//   @PostMapping("/register")
//   public User create(@RequestBody UserRequest userRequest) {
//     return authService.create(userRequest);
//   }
// }
