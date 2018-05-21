package com.hillel.patterns;

public class DeepFried extends PizzaDecorator {

    public DeepFried(Item inner) {
        super(inner);
    }

    @Override
    public void prepare() {
        super.prepare();
        makeDeepFried();
    }

    private void makeDeepFried() {
        System.out.print(" + Deep Fried");
    }
}
