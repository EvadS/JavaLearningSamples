package com.rest.samples.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.soapbox.basenode.*;


import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import net.consensys.cava.bytes.Bytes;
import net.consensys.cava.rlp.RLP;
import net.consensys.cava.rlp.RLPWriter;

import javax.validation.constraints.NotNull;

public class NodeAddressModel implements RLPSerialise
 {

    @NotNull
    private String guid;

    @NotNull
    private String ip;

    @NotNull
    private int port;

    private boolean status;

    private String vrsTranscoding;
    private String vrsStorage;
    private String vrsCashing;

    private String signature;

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public NodeAddressModel() {
        // Empty but needed
    }

    public NodeAddressModel(@NotNull String guid, @NotNull String ip, @NotNull int port, boolean status, String vrsTranscoding,
                            String vrsStorage, String vrsCashing) {
        this.guid = guid;
        this.ip = ip;
        this.port = port;
        this.status = status;
        this.vrsTranscoding = vrsTranscoding;
        this.vrsStorage = vrsStorage;
        this.vrsCashing = vrsCashing;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getVrsTranscoding() {
        return vrsTranscoding;
    }

    public void setVrsTranscoding(String vrsTranscoding) {
        this.vrsTranscoding = vrsTranscoding;
    }

    public String getVrsStorage() {
        return vrsStorage;
    }

    public void setVrsStorage(String vrsStorage) {
        this.vrsStorage = vrsStorage;
    }

    public String getVrsCashing() {
        return vrsCashing;
    }

    public void setVrsCashing(String vrsCashing) {
        this.vrsCashing = vrsCashing;
    }

    @JsonIgnore
    public byte[] toBytes() {
        return getBytes().toArray();
    }

    @JsonIgnore
    public Bytes getBytes() {
        return RLP.encode(this :: writeTo);
    }

    private void writeTo(RLPWriter rlpWriter) {
        rlpWriter.writeByteArray(guid.getBytes());
        rlpWriter.writeString(ip);
        rlpWriter.writeInt(port);

        rlpWriter.writeString(vrsTranscoding);
        rlpWriter.writeString(vrsStorage);
        rlpWriter.writeString(vrsCashing);
    }
}