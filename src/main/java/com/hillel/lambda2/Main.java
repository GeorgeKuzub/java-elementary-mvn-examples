package com.hillel.lambda2;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        AccountHelper aHelper =
                new AccountHelper();
        Person p = new Person("Ksusha", 10.00);

        Double cashToReturn =
                aHelper.getMedicalSum(p, 3, (r, d) -> 0.7 * r * 8 * d);
        System.out.println(cashToReturn);


        Double cashTForOvertime =
                aHelper.getOvertimeSum(p, 18D, (r, h) -> 2 * r * h);
        System.out.println(cashTForOvertime);


        String s = "57";

        Function<String, Integer> func = Integer::valueOf;
        System.out.println(func.apply(s));


    }
}
