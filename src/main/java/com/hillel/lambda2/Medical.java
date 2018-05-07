package com.hillel.lambda2;


/**
 * @param <T> any 1st input parameter of type T
 * @param <U> any 2nd input parameter of type U
 * @param <R> any 3rd output result of method/function estimate
 */
@FunctionalInterface
public interface Medical<T, U, R> {
    R estimate(T r, U d);
}
