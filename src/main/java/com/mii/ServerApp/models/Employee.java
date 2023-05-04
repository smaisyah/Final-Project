package com.mii.ServerApp.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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

  @Column(name = "gender", length = 20, nullable = false)
  private String gender;

  @Column(name = "phone_number", nullable = false)
  private String phone;
  
  @Column(name = "address", length = 150, nullable = false)
  private String address;

  @OneToMany(mappedBy = "manager")
  private List<Employee> subordinates;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "manager_id", referencedColumnName = "employee_id")
  private Employee manager;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "department_id", referencedColumnName = "department_id", nullable = false) // untuk menentukan kolom kunci utama yang akan digunakan sebagai referensi antara dua tabel dalam relasi One-to-One atau Many-to-One.
  private Department department;

}
