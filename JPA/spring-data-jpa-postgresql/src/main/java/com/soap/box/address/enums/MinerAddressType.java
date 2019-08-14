package com.soap.box.address.enums;

import java.util.HashMap;
import java.util.Map;

public enum MinerAddressType {
    Caching(1),
    Storage(2),
    Transcode(3);

    private int value;
    private static Map map = new HashMap<>();

    private MinerAddressType(int value) {
        this.value = value;
    }

    static {
        for (MinerAddressType pageType : MinerAddressType.values()) {
            map.put(pageType.value, pageType);
        }
    }

    public static MinerAddressType valueOf(int pageType) {
        return (MinerAddressType) map.get(pageType);
    }

    public int getValue() {
        return value;
    }
}