package com.com.soapbox.basenode.consensus.accounts;

import com.soapbox.basenode.utils.StringUtils;

import java.security.PublicKey;
import java.util.Arrays;

public class Address {

    private static final String ADDRESS_PATTERN = "^[0-9a-fA-F]{40}$";
    private static final int ADDRESS_LENGTH = 20;

    private byte[] address;

    Address(String address) throws ParseException {
        if (!address.matches(ADDRESS_PATTERN)) {
            throw new ParseException("Wrong address format");
        }

        this.address = StringUtils.hexStringToByteArray(address);
    }

    public Address(byte[] address) throws ParseException {
        if (address == null || address.length !=ADDRESS_LENGTH) {
            throw new ParseException("Wrong address data");
        }
        this.address = address;
    }


    public byte[] toBytes() {
        return address;
    }


    public void validate() {

    }
}

