package com.se.sample.manytomanydemo.entities.enums;

public enum Category {
    SPORT("S"), MUSIC("M"), TECHNOLOGY("T");

    private String code;

    private Category(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
