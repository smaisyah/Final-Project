package com.mii.metrodata.clientappsima.clientappsima.models;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Loan {
    private String id;
    private Date loanDate;
    private Date returnDate;
    private String description;
    private Employee employee;
    private Status status;
}
