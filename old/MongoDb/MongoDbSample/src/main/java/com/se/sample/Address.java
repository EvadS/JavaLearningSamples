package com.se.sample;

public class Address {

    private String street;
    private String city;
    private String phone;
    private String town;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public Address() {

    }

    /**
     *
     * @param street
     * @param city
     * @param phone
     * @param town
     */
    public Address(String street, String city, String phone, String town) {
        this.street = street;
        this.city = city;
        this.phone = phone;
        this.town = town;
    }
}
