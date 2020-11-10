package com.soap.box.address.entity;


import com.sun.istack.internal.NotNull;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
public class NodeAddress {

    @Id
    private String guid;

    @NotNull
    private String ipAddress;

    @NotNull
    private int port;

    private boolean isActive;
    @OneToMany(mappedBy = "nodeAddress", cascade = CascadeType.ALL)
    @Fetch(FetchMode.JOIN)

    private Set<MinerAddress> minerAddress;

    public NodeAddress() {
    }

    public NodeAddress(String guid, String ipAddress, int port, boolean isActive, MinerAddress... minerAddress) {
        this.guid = guid;
        this.ipAddress = ipAddress;
        this.port = port;
        this.isActive = isActive;
        this.minerAddress = Stream.of(minerAddress).collect(Collectors.toSet());
        this.minerAddress.forEach(x -> x.setNodeAddress(this));
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Set<MinerAddress> getMinerAddress() {
        return minerAddress;
    }

    public void setMinerAddress(Set<MinerAddress> minerAddress) {
        this.minerAddress = minerAddress;
    }
}
