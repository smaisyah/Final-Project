package com.mii.metrodata.clientappsima.clientappsima.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Integer id;
    private String name;
    private Integer quantity;
    private String description;
    private Category category;
    private User user;
}
