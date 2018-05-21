package com.hillel.patterns;

public class BasicPizza implements Item {

    @Override
    public void prepare() {
        makeBasicPizza();
    }

    private void makeBasicPizza() {
        System.out.print(" Basic Pizza");
    }
}
