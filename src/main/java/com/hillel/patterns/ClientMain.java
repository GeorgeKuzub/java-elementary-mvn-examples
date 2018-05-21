package com.hillel.patterns;

import java.util.Arrays;
import java.util.List;

public class ClientMain {
    public static void main(String[] args) {
        List<Item> orders = Arrays.asList(

                new BasicPizza(),
                new DeepFried(new DoubleCheese(new BasicPizza())),
                new DoubleCheese(new Spicy(new DeepFried(new BasicPizza())))

        );

        for (Item item : orders) {
            item.prepare();
            System.out.println(" ");
        }
    }
}
