package com.hillel.lambda3;

@FunctionalInterface
public interface UserBuilder {
    User create(String name);
}
