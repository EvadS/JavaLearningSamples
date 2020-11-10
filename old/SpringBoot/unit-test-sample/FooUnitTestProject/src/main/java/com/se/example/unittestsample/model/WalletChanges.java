package com.se.example.unittestsample.model;

import net.consensys.cava.bytes.Bytes;

public class WalletChanges {
    private String walletAddress;
    private String accountState;

    public WalletChanges() {
    }

    public WalletChanges(String walletAddress, String accountState) {
        this.walletAddress = walletAddress;
        this.accountState = accountState;
    }

    public String getWalletAddress() {
        return walletAddress;
    }

    public void setWalletAddress(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    public String getAccountState() {
        return accountState;
    }

    public void setAccountState(String accountState) {
        this.accountState = accountState;
    }
}