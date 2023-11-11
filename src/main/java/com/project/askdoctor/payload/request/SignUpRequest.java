package com.project.askdoctor.payload.request;

import java.util.Set;

import javax.validation.constraints.*;

public class SignUpRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    @Size(min = 3, max = 20)
    private String name;


    @Size(min = 3, max = 20)
    private String speciality;

    private Set<String> role;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }
    public void setName(String username) {
        this.name = name;
    }

    public String getSpeciality() {
        return speciality;
    }
    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRole() {
        return this.role;
    }
    public void setRole(Set<String> role) {

        this.role = role;
    }
}