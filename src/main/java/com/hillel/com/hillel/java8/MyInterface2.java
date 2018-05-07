package com.hillel.com.hillel.java8;

public interface MyInterface2 {

    default void sayChao() {
        System.out.println("Chao");
    }

    default void sayHello() {
        System.out.println("Hello!");
    }
}
