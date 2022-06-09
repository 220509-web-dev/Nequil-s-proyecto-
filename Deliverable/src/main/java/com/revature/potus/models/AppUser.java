package com.revature.potus.models;

import java.util.Objects;

public class AppUser {

    private int id;
    private String lastName;
    private String email;
    private String username;
    private String password;

    // The jackson mapping utility needs to have access to a no-args constructor
    public AppUser() {
    }

    public AppUser(int id, String username, String password) {
        this.id = id;
//        this.lastName = lastName;
//        this.email = email;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

//    public String getLastName() {
//        return lastName;
//    }

//    public String getEmail() {
//        return email;
//    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }

//    public void setEmail(String email) {
//        this.email = email;
//    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return id == appUser.id && Objects.equals(username, appUser.username) && Objects.equals(password, appUser.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password);
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
