package org.example.test1;

/**
 * Created by Evgeniy Skiba on 17.03.21
 */
public abstract  class MyAbstractClass<T,U> implements MyInterface<T>{

    private T id;

    private U someValue;


    public MyAbstractClass(T id, U someValue) {
        this.id = id;
        this.someValue = someValue;
    }

    @Override
    public T getId() {
        return id;
    }

    @Override
    public String toString() {
        return "MyAbstractClass{" +
                "val1=" + id +
                '}';
    }
}
