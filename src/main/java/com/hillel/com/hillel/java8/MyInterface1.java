package com.hillel.com.hillel.java8;

public interface MyInterface1 {
    void say(String s);

    default void sayHello() {
        System.out.println("Hello!");
    }

    static void sayBye() {
        System.out.println("Bye");
    }
}
