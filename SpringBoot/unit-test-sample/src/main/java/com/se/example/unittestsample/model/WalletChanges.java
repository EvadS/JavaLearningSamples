package com.se.example.unittestsample.model;

import net.consensys.cava.bytes.Bytes;

public class WalletChanges {
    private String walletAddress;
    private net.consensys.cava.bytes.Bytes accountState;

    public WalletChanges() {
    }

    public WalletChanges(String walletAddress, Bytes accountState) {
        this.walletAddress = walletAddress;
        this.accountState = accountState;
    }

    public String getWalletAddress() {
        return walletAddress;
    }

    public void setWalletAddress(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    public Bytes getAccountState() {
        return accountState;
    }

    public void setAccountState(Bytes accountState) {
        this.accountState = accountState;
    }
}