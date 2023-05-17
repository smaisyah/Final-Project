package com.mii.merodata.models.dto.request;

import com.mii.merodata.models.Department;
import com.mii.merodata.models.Employee;

import lombok.Data;

@Data
public class UserRequest {
    private String nik;
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
