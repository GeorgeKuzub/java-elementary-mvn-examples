package com.hillel.lambda;

/**
 * Simple Lambda Expressions - Part I
 */
public class SimpleLambda {
    private static int k1 = 100;
    private static int k2 = 20;


    public static int countNumbers(int[] arr, double d) {
        Expression func = selectFuncByCondition(d);
        return sumNumbers(arr, func);
    }

    public static int countEvenNumbers(int[] arr) {
        return sumEvenNumbers(arr);
    }

    public static String concatStrs(String s1, String s2) {
        GenericCalc<String> csFunc = (p1, p2) -> p1 + p2;
        return csFunc.process(s1, s2);
    }

    public static int sum(int n1, int n2) {
        GenericCalc<Integer> iFunc = (p1, p2) -> p1 + p2;
        return iFunc.process(n1, n2);
    }

    public static int countNegativeNumbers(int[] arr) {
        Expression func = n -> n < 0;
        return countNumsByCondition(arr, func);
    }

    public static int comlexCaclInternal(int param1, int param2) {
        int f = 100;
        Calculateable calcFunc = (x, y) -> f * (param1 + param2);

        return calcFunc.calc(param1, param2);
    }

    public static int complexCalc(int param1, int param2) {
        Calculateable calcFunc = (x, y) -> {
            k1 = k1 / k2; // 5
            int k = k2 * 5; // 100
            return (param1 + param2) * (k1 * k);
        };
        return calcFunc.calc(param1, param2);
    }

    public static void terminalProcess(String param) {
        Processable p = s -> System.out.println(s);
        p.process(param);
    }

    public static int add(int param1, int param2) {

        Calculateable calc = (a, b) -> a + b;

        return calc.calc(10, 20);
    }

    public static int sub(int param1, int param2) {
        Calculateable calc = (x, y) -> x - y;

        return calc.calc(param1, param2);
    }


    public static int power(int param) {
        Power p = x -> x * x;
        return p.pow(10);
    }

    private static int countNumsByCondition(int[] arr, Expression expr) {
        int count = 0;
        for (int n : arr) {
            if (expr.check(n)) {
                count++;
            }
        }
        return count;
    }

    private static int sumNumbers(int[] arr, Expression func) {
        int sum = 0;
        for (int n : arr) {
            if (func.check(n)) {
                sum += n;
            }
        }
        return sum;
    }


    private static Expression selectFuncByCondition(double d) {
        if (d < 0.5) {
            return NumberExpressionHelper::isNegative;
        } else {
            return NumberExpressionHelper::isPositive;
        }
    }

    private static int sumEvenNumbers(int[] arr) {
        int sum = 0;
        Expression refFunc = NumberExpressionHelper::isEven;
        for (int n : arr) {
            if (refFunc.check(n)) {
                sum += n;
            }
        }
        return sum;
    }

}