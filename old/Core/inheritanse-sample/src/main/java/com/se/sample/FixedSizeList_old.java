package com.se.sample;


import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;

public class FixedSizeList_old<T> extends ArrayList<T> {
    protected static final int DEFAULT_MAX_SIZE = 100;
    private int limit;

    public FixedSizeList_old() {

        this(DEFAULT_MAX_SIZE);
    }

    public FixedSizeList_old(int limit) {
        super(limit < 1 ? DEFAULT_MAX_SIZE : limit);
        this.limit = limit;
    }

    public FixedSizeList_old(CopyOnWriteArrayList<T> transactionPoolElements) {
        this(transactionPoolElements.size());

        for (T item : transactionPoolElements) {
            this.add(item);
        }
    }

    @Override
    public boolean add(T element) {
        assertMaxSizeNotReached(1);
        return super.add(element);
    }

    @Override
    public void add(int index, T element) {
        assertMaxSizeNotReached(1);
        super.add(index, element);
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        assertMaxSizeNotReached(collection.size());
        return super.addAll(collection);
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> elements) {
        assertMaxSizeNotReached(elements.size());
        return super.addAll(index, elements);
    }

    private void assertMaxSizeNotReached(int size) {
        if (this.size() + size >= limit) {
            throw new RuntimeException("size max reached");
        }
    }
}
