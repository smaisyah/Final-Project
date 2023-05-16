package com.mii.merodata.models.dto.request;

import java.sql.Date;

import javax.jws.soap.SOAPBinding.Use;

import com.mii.merodata.models.Category;
import com.mii.merodata.models.Submition;
import com.mii.merodata.models.User;

public class SubmitionRequest {
    private Category category;
    private User user;
    private String productName;
    private Integer quantity;
    private String description;
    private Integer quantityBuy;
    private Double price;
    private Submition submition;
}
