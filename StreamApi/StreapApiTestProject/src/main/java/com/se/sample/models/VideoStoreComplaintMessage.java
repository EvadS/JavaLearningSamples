package com.se.sample.models;

public class VideoStoreComplaintMessage {
    private Guid guid;
    private SegmentHash segmentHash;

    public VideoStoreComplaintMessage(Guid guid, SegmentHash segmentHash) {
        this.guid = guid;
        this.segmentHash = segmentHash;
    }

    public Guid getGuid() {
        return guid;
    }

    public void setGuid(Guid guid) {
        this.guid = guid;
    }

    public SegmentHash getSegmentHash() {
        return segmentHash;
    }

    public void setSegmentHash(SegmentHash segmentHash) {
        this.segmentHash = segmentHash;
    }
}
