package org.testingsol.tas.f_processdriven.model;

public class Customer {

    private String name;
    private String email;

    public Customer(String name) {
        this.name = name;
        this.email = name.replace(" ", ".") + "@mail.com";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
