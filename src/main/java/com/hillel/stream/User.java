package com.hillel.stream;

import java.util.Random;

public class User {
    private String name;
    private int iq;

    public User(String name) {
        this.name = name;
        this.iq = new Random().nextInt(150);
    }

    public String getName() {
        return name;
    }

    public int getIq() {
        return iq;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", iq=" + iq +
                '}';
    }
}
