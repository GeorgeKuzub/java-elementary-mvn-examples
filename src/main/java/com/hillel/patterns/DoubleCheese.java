package com.hillel.patterns;

public class DoubleCheese extends PizzaDecorator {
    public DoubleCheese(Item inner) {
        super(inner);
    }

    @Override
    public void prepare() {
        super.prepare();
        makeDoubleCheese();
    }

    private void makeDoubleCheese() {
        System.out.print(" + Double Cheese");
    }
}
