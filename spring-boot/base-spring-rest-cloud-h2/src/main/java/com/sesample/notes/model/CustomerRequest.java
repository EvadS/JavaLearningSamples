package com.sesample.notes.model;

import javax.validation.constraints.NotBlank;

public class CustomerRequest {
    @NotBlank
    private String name;

    public CustomerRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
