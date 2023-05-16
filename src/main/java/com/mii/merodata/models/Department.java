package com.mii.merodata.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "department_name", length = 50, nullable = false)
    private String name;

    @Column(name = "budget", nullable = false)
    private Double budget;

    @OneToOne
    @JoinColumn(name = "manager_id", referencedColumnName = "id", nullable = true)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Employee manager;

    @OneToMany(mappedBy = "department")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Employee> employees;
}
