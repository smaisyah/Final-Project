package com.mii.metrodata.clientappsima.clientappsima.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private Integer id;
    private String name;
    private Double budget;
    private Employee manager;
}
