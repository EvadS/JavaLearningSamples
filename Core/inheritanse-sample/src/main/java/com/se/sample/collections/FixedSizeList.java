package com.se.sample.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;

public class FixedSizeList<T>  {
    private ArrayList<T> list = new ArrayList<>();
    protected static final int DEFAULT_MAX_SIZE = 100;
    private int limit;

    public FixedSizeList() {

        this(DEFAULT_MAX_SIZE);
    }

    public FixedSizeList(int limit) {
        this.limit = this.limit < 1 ? DEFAULT_MAX_SIZE : limit;
    }

    public FixedSizeList(CopyOnWriteArrayList<T> transactionPoolElements) {
        this(transactionPoolElements.size());

        for (T item : transactionPoolElements) {
            this.add(item);
        }
    }

    public boolean add(T element) {
        assertMaxSizeNotReached(1);
        return super.add(element);
    }


    public void add(int index, T element) {
        assertMaxSizeNotReached(1);
        list.add(index, element);
    }


    public boolean addAll(Collection<? extends T> collection) {
        assertMaxSizeNotReached(collection.size());
        return list.addAll(collection);
    }


    public boolean addAll(int index, Collection<? extends T> elements) {
        assertMaxSizeNotReached(elements.size());
        return list.addAll(index, elements);
    }

    private void assertMaxSizeNotReached(int size) {
        if (this.list.size() + size >= limit) {
            throw new RuntimeException("size max reached");
        }
    }
}
