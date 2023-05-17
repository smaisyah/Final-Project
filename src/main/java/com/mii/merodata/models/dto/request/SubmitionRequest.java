package com.mii.merodata.models.dto.request;

import com.mii.merodata.models.Category;
import com.mii.merodata.models.Submition;

import lombok.Data;

@Data
public class SubmitionRequest {
    private Category category;
    private String name;
    private Integer quantity;
    private String description;
    private Double price;
    private Submition submition;
}
