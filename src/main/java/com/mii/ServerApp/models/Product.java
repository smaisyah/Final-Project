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
@Table(name = "tb_product")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "product_id")
  private Integer id;

  @ManyToOne
  @JoinColumn(name="category_id", nullable=false)
  private Category category;

  @ManyToOne
  @JoinColumn(name="it_support", nullable=false)
  private User user;

  @Column(name = "product_name", nullable = false)
  private String name;

  @Column(name = "quantity", length = 100, nullable = false)
  private Integer quantity;

  @Column(name = "description", length = 20, nullable = false)
  private String description;

  @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
  @PrimaryKeyJoinColumn 
  private Loan loan;

  
}
