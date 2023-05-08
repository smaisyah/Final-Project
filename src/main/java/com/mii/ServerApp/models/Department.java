package com.mii.ServerApp.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

// import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_department")
public class Department {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "department_id")
  private Integer id;

  @Column(name = "department_name", nullable = false)
  private String name;

  @Column(name = "budget", nullable = false)
  private Double budget;

  @OneToMany(mappedBy = "department") 
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private List<Employee> employes;
}
