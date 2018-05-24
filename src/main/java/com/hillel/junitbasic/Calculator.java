package com.hillel.junitbasic;

public class Calculator {
    int add(int x, int y) {
        return x + y;
    }


    int sub(int x, int y) {
        return x - y;
    }


    int mul(int x, int y) {
        return x * y;
    }


    int div(int x, int y) {
        if (y == 0) {
            throw new MyCustomException("The second operand can't be zero.");
        }
        return x / y;
    }

    int pow(int i) {
        return i * i;
    }

    public static void main(String[] args) {
        System.out.println("My main2 program packed into jar, started and finished here.");
    }
}
