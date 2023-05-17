package com.mii.merodata.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
    @GenericGenerator(name = "employee_seq", strategy = "com.mii.merodata.models.SequenceNikGeneratorEmployee", parameters = {
            @Parameter(name = SequenceNikGeneratorEmployee.INCREMENT_PARAM, value = "1"),
            @Parameter(name = SequenceNikGeneratorEmployee.NUMBER_FORMAT_PARAMETER, value = "%03d")
    })
    @Column(name = "nik", nullable = false)
    private String nik;

    @Column(name = "employee_name", nullable = false, length = 50)
    private String name;

    @Column(nullable = false)
    private Gender gender;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(length = 13, unique = true, nullable = false)
    private String phone;

    @Column
    private String address;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = true)
    private Department department;

    @ManyToOne
    @JoinColumn(name = "manager_id", nullable = true)
    private Employee manager;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private User user;

    // @OneToMany(mappedBy = "employee")
    // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    // private List<Submition> submitions;
}
