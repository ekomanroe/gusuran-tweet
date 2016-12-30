package com.springboot.model.Enum;

/**
 * Created by eko.j.manurung on 12/23/2016.
 */
public enum MaritalStatus {

    SINGLE("Single"),
    MARRIED("Married"),
    IN_RELATIONSHIP("In Relationship");

    private String value;

    MaritalStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
