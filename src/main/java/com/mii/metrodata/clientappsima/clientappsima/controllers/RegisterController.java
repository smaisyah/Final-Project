// package com.mii.metrodata.clientappsima.clientappsima.controllers;

// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;

// import com.mii.metrodata.clientappsima.clientappsima.models.dto.request.RegisterRequest;
// import com.mii.metrodata.clientappsima.clientappsima.services.RegisterService;

// import lombok.AllArgsConstructor;

// @Controller
// @RequestMapping("/register")
// @AllArgsConstructor
// public class RegisterController {
//     private RegisterService registerService;

//     @GetMapping
//     public String registerPage(RegisterRequest registerRequest){
//         return "auth/register";
//     }

//     @PostMapping
//     public String register(RegisterRequest registerRequest){
//         registerService.register(registerRequest);
//         return "redirect:/login";
//     }
// }