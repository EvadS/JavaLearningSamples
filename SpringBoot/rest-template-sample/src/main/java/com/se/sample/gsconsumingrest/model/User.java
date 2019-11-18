package com.se.sample.gsconsumingrest.model;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 3453281303625368221L;
    public User(){
    }
    private Integer userid;
    private String username;

    public User(Integer userid, String username){
        this.userid = userid;
        this.username = username;
    }
    public Integer getUserid() {
        return userid;
    }
    public void setUserid(Integer userid) {
        this.userid = userid;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    @Override
    public String toString() {
        return "User [userid=" + userid + ", username=" + username + "]";
    }
}
