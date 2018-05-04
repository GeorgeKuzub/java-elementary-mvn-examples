package com.hillel.lambda;

@FunctionalInterface
public interface GenericCalc<T> {
    T process(T p1, T p2);
}
