package com.se.sample;

public class Person {
    private String id;
    private String name;
    private Address address;
    private String bookId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBookIds() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public String getBookId() {
        return bookId;
    }

    public Person() {
    }

    /**
     *
     * @param id
     * @param name
     * @param address
     * @param bookId
     */
    public Person(String id, String name, Address address, String bookId) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.bookId = bookId;
    }
}
