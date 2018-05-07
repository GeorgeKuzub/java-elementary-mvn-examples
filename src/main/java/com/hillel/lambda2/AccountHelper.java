package com.hillel.lambda2;

import java.util.function.BiFunction;

public class AccountHelper {

    public double getMedicalSum(Person p, Integer day,
                                BiFunction<Double, Integer, Double> m) {

        return m.apply(p.getRate(), day);
    }

    public double getOvertimeSum(Person p, Double hours,
                                 BiFunction<Double, Double, Double> o) {

        return o.apply(p.getRate(), hours);
    }
}
