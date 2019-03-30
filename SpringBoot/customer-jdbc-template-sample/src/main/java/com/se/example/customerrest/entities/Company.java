package com.se.example.customerrest.entities;

public class Company {

    public String companyId;
    public String name;
    public String ceo;
    public String country;
    public String foundationYear;
    public String noOfEmployee;

    public Company(){
    }

    public Company(String companyId, String name, String ceo, String country,String foundationYear,String noOfEmployee) {
        this.companyId = companyId;
        this.name = name;
        this.ceo = ceo;
        this.country = country;
        this.foundationYear = foundationYear;
        this.noOfEmployee = noOfEmployee;
    }

    public String getCompanyId() {
        return companyId;
    }
    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getCeo() {
        return ceo;
    }
    public void setCeo(String ceo) {
        this.ceo = ceo;
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public String getFoundationYear() {
        return foundationYear;
    }
    public void setFoundationYear(String foundationYear) {
        this.foundationYear = foundationYear;
    }

    public String getNoOfEmployee() {
        return noOfEmployee;
    }
    public void setNoOfEmployee(String noOfEmployee) {
        this.noOfEmployee = noOfEmployee;
    }

}