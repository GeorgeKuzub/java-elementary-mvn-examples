package com.hillel.patterns;

public class PizzaDecorator implements Item {
    private Item item;

    public PizzaDecorator(Item item) {
        this.item = item;
    }

    @Override
    public void prepare() {
        item.prepare();
    }
}
