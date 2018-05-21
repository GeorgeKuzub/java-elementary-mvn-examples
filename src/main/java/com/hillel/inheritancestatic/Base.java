package com.hillel.inheritancestatic;

public class Base {
    private int i;

    public int getI() {
        return i;
    }

    public static void met1() {
        System.out.println("Base:met1()");
    }

    public static void main(String[] args) {
        Base base1 = new Base();
        Base base2 = new Child();
        Child child = new Child();
        base1.met1();
        base2.met1();
        child.met1();
    }
}

class Child extends Base {

    public static void met1() {
        System.out.println("Child:met1()");
    }
}