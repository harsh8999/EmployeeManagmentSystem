package com.example.EmployeeManagementSystem.entity;


public enum Designation {

    ENGINEER("engineer");
    // other designations as required...

    private String value;

    public String getValue() {
        return value;
    }

    Designation(String value){
        this.value = value;
    }


    public static Designation fromValue(String value) {
        for (Designation designation : values()) {
            if (designation.value.equalsIgnoreCase(value)) {
                return designation;
            }
        }
        throw new IllegalArgumentException("No enum constant for value: " + value);
    }
    

}
