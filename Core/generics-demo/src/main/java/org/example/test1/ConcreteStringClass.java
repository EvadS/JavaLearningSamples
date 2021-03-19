package org.example.test1;

/**
 * Created by Evgeniy Skiba on 17.03.21
 */
public class ConcreteStringClass extends MyAbstractClass<Integer, String>{

    private String concreteStringClassValue;

    public ConcreteStringClass(Integer id, String someValue, String concreteStringClassValue) {
        super(id, someValue);
        this.concreteStringClassValue = concreteStringClassValue;
    }
}