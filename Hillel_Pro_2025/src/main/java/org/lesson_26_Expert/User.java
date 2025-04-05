package org.lesson_26_Expert;

public class User {

    private String name;
    Address address;

    public User(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getAddress() {
        return this.name + ": " + address.getAddress();
    }
}
