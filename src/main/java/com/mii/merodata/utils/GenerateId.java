package com.mii.merodata.utils;

import org.springframework.stereotype.Component;

@Component
public class GenerateId {
    private String intial = "MCC";
    private Integer maxDigit = 3;
    private Integer currentId = 0;

    public String idGenerate() {
        currentId++;
        String formatId = String.format("%s%0" + maxDigit + "d", intial, currentId);
        return formatId;
    }
}
