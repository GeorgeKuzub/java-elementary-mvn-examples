package com.hillel.lambda;

public class NumberExpressionHelper {
    public static boolean isNegative(int x) {
        return x < 0;
    }

    public static boolean isPositive(int x) {
        return x > 0;
    }

    public static boolean isEven(int x) {
        return x % 2 == 0;
    }

    public static boolean isOdd(int x) {
        return x % 2 != 0;
    }

}
