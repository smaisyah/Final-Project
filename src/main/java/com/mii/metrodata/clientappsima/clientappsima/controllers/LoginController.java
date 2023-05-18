package com.mii.metrodata.clientappsima.clientappsima.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mii.metrodata.clientappsima.clientappsima.models.dto.request.LoginRequest;
import com.mii.metrodata.clientappsima.clientappsima.models.dto.request.RegisterRequest;
import com.mii.metrodata.clientappsima.clientappsima.services.LoginService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/login")
@AllArgsConstructor
public class LoginController {

    private LoginService loginService;

    @GetMapping
    public String loginPage(LoginRequest loginRequest){
        return "auth/login";
    }

    @PostMapping
    public String login(LoginRequest loginRequest){
        if (!loginService.login(loginRequest)){
            return "redirect:/login?error=true";
        }
        return "redirect:/employee";
    }

    @GetMapping("/register")
	public String registerPage(RegisterRequest registerRequest) {
		return "auth/register";
	}
    
}