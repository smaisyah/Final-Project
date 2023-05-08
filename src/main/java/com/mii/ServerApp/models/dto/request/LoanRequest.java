package com.mii.ServerApp.models.dto.request;

import java.sql.Date;

import lombok.Data;

@Data
public class LoanRequest {

  private Integer employeeId;
  private Integer productId;
  private Date loan_date;
  private Date return_date;
  private Integer quantity_loan;
  private String description;
  private String status;
}
