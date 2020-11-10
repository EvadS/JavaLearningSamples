package com.soap.box.address.entity;


import com.soap.box.address.enums.MinerAddressType;
import com.sun.istack.internal.NotNull;

import javax.persistence.*;

@Entity
public class MinerAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String address;

    @Column(name = "addressType")
    @Enumerated(EnumType.ORDINAL)
    private MinerAddressType addressType;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "node_address_id", nullable = true)
    private NodeAddress nodeAddress;


    public MinerAddress() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public NodeAddress getNodeAddress() {
        return nodeAddress;
    }

    public void setNodeAddress(NodeAddress nodeAddress) {
        this.nodeAddress = nodeAddress;
    }

    public MinerAddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(MinerAddressType addressType) {
        this.addressType = addressType;
    }
}
