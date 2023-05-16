package com.mii.merodata.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "history")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "history_id")
    private Integer id;

    @Temporal(TemporalType.DATE)
    @Column(name = "history_Date", nullable = false)
    private Date historyDate;

    @ManyToOne
    @JoinColumn(name = "action_by", nullable = true)
    private User user;

    @ManyToOne
    @JoinColumn(name = "submition_id", nullable = true)
    private Submition submition;

    @ManyToOne
    @JoinColumn(name = "loan_id", nullable = true)
    private Loan loan;
}
