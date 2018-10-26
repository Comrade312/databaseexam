package com.database;

import javax.jws.soap.SOAPBinding;

public class User {
    private int id;
    private String password;
    private String name;

    public User() {

    }

    public User(String password, String name){
        this.password = password;
        this.name = name;
    }

    public User(int id, String password, String name){
        this.id = id;
        this.password = password;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " - id: " + id
                + ", name: " + name
                + ", password: " + password
                + ";";
    }
}
