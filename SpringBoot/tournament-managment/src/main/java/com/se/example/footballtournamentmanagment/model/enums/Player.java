package com.se.example.footballtournamentmanagment.model.enums;

public class Player {

    private Long Id ;
    private String fName;
    private String lName;
    private String bDate;

    private String amplua;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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

    public String getbDate() {
        return bDate;
    }

    public void setbDate(String bDate) {
        this.bDate = bDate;
    }

    public String getAmplua() {
        return amplua;
    }

    public void setAmplua(String amplua) {
        this.amplua = amplua;
    }
}
