package com.se.sample.gsconsumingrest.model;

public class UserResponse extends User{
    private boolean isCreated;

    public UserResponse() {

    }
    public UserResponse(User user, boolean isCreated) {
        super(user.getUserid(),user.getUsername());
        this.isCreated = isCreated;
    }

    public UserResponse(Integer userid, String username, boolean isCreated) {
        super(userid, username);
        this.isCreated = isCreated;
    }

    public boolean isCreated() {
        return isCreated;
    }

    public void setCreated(boolean created) {
        isCreated = created;
    }
}
