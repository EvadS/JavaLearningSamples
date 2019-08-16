package com.se.sample;

import java.util.Collection;
import java.util.HashSet;

public class InstrumentedHashSet<E> extends HashSet<E> {
    private  int addCount = 0;
    public InstrumentedHashSet(){

    }

    public InstrumentedHashSet(Collection<? extends E> collection) {
        super(collection);
    }

    public InstrumentedHashSet(int initCap, float loadFactor) {
        super(initCap,loadFactor);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);

    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        addCount+= collection.size();
        return super.addAll(collection);
    }

    public int getAddCount() {
        return addCount;
    }
}

