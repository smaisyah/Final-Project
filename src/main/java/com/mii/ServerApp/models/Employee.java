package com.mii.ServerApp.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_employee")
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "employee_id")
  private Integer id;

  @Column(name = "nip", nullable = false)
  private Integer nip;

  @Column(name = "employee_name", length = 100, nullable = false)
  private String name;

  @Column(name = "email", length = 50, nullable = false)
  private String email;

  @Column(nullable = false)
  private Gender gender;

  @Column(name = "phone_number", nullable = false)
  private String phone;
  
  @Column(name = "address", length = 150, nullable = false)
  private String address; 

  @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
  @PrimaryKeyJoinColumn
  private User user;

  @OneToMany(mappedBy = "employee") 
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private List<Loan> loans;

  @ManyToOne
	@JoinColumn(name="manager_id", nullable = false)
	private Employee manager;

	@OneToMany(mappedBy="manager")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private List<Employee> subordinates;

  @ManyToOne
	@JoinColumn(name="department_id", nullable = false)
	private Department department;

  @OneToMany(mappedBy = "employee")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private List<Submition> submitions;

}
