package com.mii.metrodata.clientappsima.clientappsima.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private String nik;
    private String name;
    private Gender gender;
    private String email;
    private String phone;
    private String address;
    private Employee manager;
    private Department department;
    private User user;
}
