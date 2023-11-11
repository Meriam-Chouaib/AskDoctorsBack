package com.project.askdoctor.payload.response;

import java.util.List;

public class UserInfoResponse {
    private Long _id;
    private String username;
    private List<String> roles;

    public UserInfoResponse(Long _id, String username, List<String> roles) {
        this._id = _id;
        this.username = username;
        this.roles = roles;
    }

    public Long getId() {
        return _id;
    }

    public void setId(Long id) {
        this._id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoles() {
        return roles;
    }
}