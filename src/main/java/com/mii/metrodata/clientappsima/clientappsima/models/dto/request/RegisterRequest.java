package com.mii.metrodata.clientappsima.clientappsima.models.dto.request;

import com.mii.metrodata.clientappsima.clientappsima.models.Department;
import com.mii.metrodata.clientappsima.clientappsima.models.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
	private String name;
	private String email;
	private String gender;
	private String phone;
	private String address;
	private Employee manajer;
	private Department department;
	private String username;
	private String password;
}
