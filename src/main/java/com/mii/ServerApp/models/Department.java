package com.mii.ServerApp.models;

import com.fasterxml.jackson.annotation.JsonProperty;
// import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
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

  @OneToOne
  @MapsId
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  @JoinColumn(name = "manager_id")
  private Employee manager;
}
