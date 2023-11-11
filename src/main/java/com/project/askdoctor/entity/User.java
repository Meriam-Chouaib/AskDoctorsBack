package com.project.askdoctor.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.HashSet;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;


//@Table(name="user")
@AllArgsConstructor
@Data
@NoArgsConstructor

@Entity
@Table(name = "users", 
    uniqueConstraints = { 
      @UniqueConstraint(columnNames = "username"),
      @UniqueConstraint(columnNames = "name")
    })
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long _id;


    private String name;

    @NotBlank
    private String username;

    @Override
    public String toString() {
        return "User{" +
                "id=" + _id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", speciality='" + speciality + '\'' +
                ", description='" + description + '\'' +
                ", isLogged=" + isLogged +
                ", isAdmin=" + isAdmin +
                ", isTest=" + isTest +
                ", picture='" + picture + '\'' +
                ", roles=" + roles +
                '}';
    }

    @NotBlank
    private String password;


    private String speciality;

    private String description;


    private Boolean isLogged;

    private Boolean isAdmin;


    private Boolean isTest;

    private String picture;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(  name = "user_roles", 
          joinColumns = @JoinColumn(name = "user_id"),
          inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
     
  
    public User(String username, String name, String password, String speciality) {
      this.username = username;
      this.name = name;
      this.password = password;
      this.speciality = speciality;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLogged(Boolean logged) {
        isLogged = logged;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public void setTest(Boolean test) {
        isTest = test;
    }

    public long getId() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getSpeciality() {
        return speciality;
    }

    public String getDescription() {
        return description;
    }


    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Set<Role> getRoles() {
        return roles;
      }
    
      public void setRoles(Set<Role> roles) {
        this.roles = roles;
      }
}