package com.sample.galleryservice.exception;

public class BucketNotFoundException extends RuntimeException {

    public BucketNotFoundException(String bucketId) {
        super("Bucket not found with id " + bucketId);
    }
}