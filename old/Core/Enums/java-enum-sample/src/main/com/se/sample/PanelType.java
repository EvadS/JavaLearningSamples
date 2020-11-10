package com.se.sample;

/**
 * Created by Evgeniy Skiba on 22.Mar.2019
 */
public enum PanelType {
    PAS8(0xA6), PAS83(0xA7);

    private int code;

    private PanelType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}