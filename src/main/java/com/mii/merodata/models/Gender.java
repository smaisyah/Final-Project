package com.mii.merodata.models;

public enum Gender {
    L("Laki - laki"),
    P("Perempuan");

    private String labelGender;
    Gender(String labelGender) {
        this.labelGender = labelGender;
    }
    public String getLabelGender() {
        return labelGender;
    }
}
