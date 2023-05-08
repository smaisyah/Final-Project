package com.mii.ServerApp.models.dto.request;

import lombok.Data;

@Data
public class UserRequest {

  private String name;
  private String email;
  private String phone;
  private String username;
  private String password;
}