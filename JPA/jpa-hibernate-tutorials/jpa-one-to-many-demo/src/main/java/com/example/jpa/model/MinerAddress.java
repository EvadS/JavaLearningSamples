package com.example.jpa.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * Created by rajeevkumarsingh on 21/11/17.
 */
@Entity
@Table(name = "miner_address")
public class MinerAddress extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String address;

    @NotNull
    private String vrs;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "node_address_id", nullable = true)
    private NodeAddress nodeAddress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getVrs() {
        return vrs;
    }

    public void setVrs(String vrs) {
        this.vrs = vrs;
    }

    public NodeAddress getNodeAddress() {
        return nodeAddress;
    }

    public void setNodeAddress(NodeAddress nodeAddress) {
        this.nodeAddress = nodeAddress;
    }
}
