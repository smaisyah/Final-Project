package id.co.mii.sima.serverapp.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "submition")
public class Submition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "submition_id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "submition_date", nullable = false)
    private Date submitionDate;

    @Column(name = "quantity_loan", nullable = false)
    private Integer quantityLoan;

    @Column(name = "description", nullable = false)
    private String desc;

    @Column(name = "status", nullable = false)
    private Boolean status;
}
