package com.se.sample.models;

import java.util.Objects;

public class KeeperData {

    private Guid guid;
    private long deadline; // timestamp in milliseconds
    private SegmentHash segmentHash;

    public KeeperData(Guid guid, long deadline, SegmentHash segmentHash) {
        this.guid = guid;
        this.deadline = deadline;
        this.segmentHash = segmentHash;
    }

    public KeeperData(Guid  guid, long deadline, byte [] segmentHash) {
        this.guid =  guid;
        this.deadline = deadline;
        this.segmentHash = new SegmentHash(segmentHash);
    }


    public Guid getGuid() {
        return guid;
    }

    public void setGuid(Guid guid) {
        this.guid = guid;
    }

    public long getDeadline() {
        return deadline;
    }

    public void setDeadline(long deadline) {
        this.deadline = deadline;
    }



    public SegmentHash getSegmentHash() {
        return segmentHash;
    }

    public void setSegmentHash(SegmentHash segmentHash) {
        this.segmentHash = segmentHash;
    }

    @Override
    public String toString() {
        return "KeeperData{" +
                "guid=" + guid +
                ", deadline=" + deadline +
                ", segmentHash=" + segmentHash +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeeperData that = (KeeperData) o;
        return deadline == that.deadline &&
                guid.equals(that.guid) &&
                segmentHash.equals(that.segmentHash);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guid, deadline, segmentHash);
    }
}
