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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_submition")
public class Submition {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "submition_id")
  private Integer id;

  @Column(name = "submition_date", nullable = false)
  private Integer loan_date;

  @Column(name = "price", length = 100, nullable = false)
  private Integer return_date;

  @Column(name = "quantity_buy", length = 50, nullable = false)
  private Integer quantity_buy;

  @Column(name = "description", length = 20, nullable = false)
  private String description;

  @Column(name = "status", nullable = false)
  private String status;
  
}