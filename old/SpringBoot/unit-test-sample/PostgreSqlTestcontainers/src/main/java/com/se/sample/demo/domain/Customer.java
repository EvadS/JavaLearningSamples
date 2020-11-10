package com.se.sample.demo.domain;

import junit.runner.Version;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity(name = "customer")

public class Customer {
    @Id
    private long id;
    private String name;
    private String address;
    private boolean is_active;



    public Customer(long id, String name, String address, boolean is_active) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.is_active = is_active;
    }

    public Customer(String name, String address, boolean is_active) {
        this.name = name;
        this.address = address;
        this.is_active = is_active;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id &&
                is_active == customer.is_active &&
                Objects.equals(name, customer.name) &&
                Objects.equals(address, customer.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, is_active);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", is_active=" + is_active +
                '}';
    }
}