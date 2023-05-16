package com.mii.merodata.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "detail_submition")
public class SubmitionDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "poduct_name", nullable = false)
    private String name;

    @Column(name = "quantity_product", nullable = false)
    private Integer quantity;

    @Column(name = "descripton_product", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "quantity_buy", nullable = false)
    private Integer quantityBuy;

    @ManyToOne
    @JoinColumn(name = "submition_id", nullable = false)
    private Submition submition;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
}
