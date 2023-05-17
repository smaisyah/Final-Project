package com.mii.merodata.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer id;

    @Column(name = "product_name", nullable = false)
    private String name;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "it_support", nullable = false)
    private User user;

    // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    // @ManyToMany(mappedBy = "products")
    // private List<Submition> submitions;

    @OneToMany(mappedBy = "submition")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<SubmitionProduct> detailSubmitions;

    @OneToMany(mappedBy = "loan")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<LoanProduct> detailLoans;
}
