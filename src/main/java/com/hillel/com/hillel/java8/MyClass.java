package com.hillel.com.hillel.java8;

public class MyClass implements MyInterface1, MyInterface2 {
    @Override
    public void say(String s) {
        System.out.println(s);
    }

    @Override
    public void sayHello() {
        System.out.println("gf");
    }
}
