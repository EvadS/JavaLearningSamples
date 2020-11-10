package com.sanju.bm.errorhandler;

import lombok.Getter;

/**
 * @author Sanjoy Kumer Deb
 * @since  06/10/2017.
 */

public class ResourceNotFoundException extends Exception {
    private String code;
    private String feature;
    private String reason;

    public ResourceNotFoundException(String feature, String code, String reason) {
        super(reason);
        this.reason=reason;
        this.feature = feature;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getFeature() {
        return feature;
    }

    public String getReason() {
        return reason;
    }
}
