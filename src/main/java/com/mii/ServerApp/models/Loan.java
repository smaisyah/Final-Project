package com.mii.ServerApp.models;

import java.sql.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_loan")
public class Loan {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "loan_id")
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "employee_id", nullable = false)
  private Employee employee;

  @OneToMany(mappedBy="loan")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private List<History> Histories;

  @OneToOne
  @JoinColumn(name = "id", nullable = false)
  private Product product;

  @Column(name = "loan_date", nullable = false)
  private Date loan_date;

  @Column(name = "return_date", nullable = false)
  private Date return_date;

  @Column(name = "quantity_loan", length = 50, nullable = false)
  private Integer quantity_loan;

  @Column(name = "description", length = 50, nullable = false)
  private String description;

  @Column(name = "status", nullable = false)
  private String status;
  
}