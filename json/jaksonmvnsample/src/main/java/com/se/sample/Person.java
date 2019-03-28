package com.se.sample;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * Created by Evgeniy Skiba on 26.Mar.2019
 */
public class Person {

    @JsonProperty("id")
    private int personId;
    private String fName;
    private String lName;

   // @JsonIgnore
    private  Address adress;


    public Person() {

    }

    public Person(int personId, String fName, String lName, Address adress) {
        this.personId = personId;
        this.fName = fName;
        this.lName = lName;
        this.adress = adress;
    }

    //@JsonSetter("id")
    public int getPersonId() {
        return personId;
    }

  ///  @JsonSetter("id")
    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public Address getAdress() {
        return adress;
    }

    public void setAdress(Address adress) {
        this.adress = adress;
    }
}
