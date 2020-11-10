package com.se.core;

/**
 * Interface for estimating size of a specific Java type
 *
 * Created by Anton Nashatyrev on 01.12.2016.
 */
public interface MemSizeEstimator<E> {

    long estimateSize(E e);

    /**
     * byte[] type size estimator
     */
    MemSizeEstimator<byte[]> ByteArrayEstimator = bytes -> {
        return bytes == null ? 0 : bytes.length + 16; // 4 - compressed ref size, 12 - Object header
    };
}
