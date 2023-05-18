package com.mii.metrodata.clientappsima.clientappsima.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String id;
    private String username;
    private String password;
    private Boolean isEnabled = true;
	private Boolean isAccountNonLocked = true;
}