package com.mii.ServerApp.models.dto.request;

import com.mii.ServerApp.models.Department;
import com.mii.ServerApp.models.Employee;

import lombok.Data;

@Data
public class UserRequest {

  private Integer nip;
  private String name;
  private String email;
  private String gender;
  private String phone;
  private String address;
  private Employee manager;
  private Department department;
  private String username;
  private String password;

}