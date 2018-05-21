package com.hillel.patterns;

public class Spicy extends PizzaDecorator {
    public Spicy(Item inner) {
        super(inner);
    }

    @Override
    public void prepare() {
        super.prepare();
        makeSpicy();
    }

    private void makeSpicy() {
        System.out.print(" + Spicy");
    }


}
