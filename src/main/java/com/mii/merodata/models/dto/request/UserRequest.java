package com.mii.merodata.models.dto.request;

import lombok.Data;

@Data
public class UserRequest {
    private String nip;
    private String name;
    private String gender;
    private String email;
    private String phone;
    private String address;
    private String username;
    private String password;
}
