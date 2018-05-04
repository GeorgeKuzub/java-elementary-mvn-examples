package com.hillel.lambda;

import org.junit.Test;

import static com.hillel.lambda.SimpleLambda.*;
import static org.junit.Assert.assertEquals;

public class SimpleLambdaTest {

    @Test
    public void testCountNegNumbers() throws Exception {
        double d = 0.4;
        int[] a = {0, 1, 2, -1, -2, -3};

        int actual = countNumbers(a, d);
        assertEquals(-6, actual);
    }


    @Test
    public void testCountPositiveNumbers() throws Exception {
        double d = 1;
        int[] a = {0, 1, 2, -1, -2, -3};

        int actual = countNumbers(a, d);
        assertEquals(3, actual);
    }

    @Test
    public void testCountEvenNumbers() throws Exception {
        int[] a = {2, 4, 3, 5, 7};
        assertEquals(6, countEvenNumbers(a));
    }

    @Test
    public void testConcatStrs() throws Exception {
        assertEquals("1981",
                concatStrs("19", "81"));
    }

    @Test
    public void testSum() throws Exception {
        assertEquals(30, sum(10, 20));
    }

    @Test
    public void testCountNegativeNumbers() throws Exception {
        int[] a = {-1, 0, 3, -100, 5, -3};
        assertEquals(3, countNegativeNumbers(a));
    }

    @Test
    public void testComlexCaclInternal() throws Exception {
        assertEquals(2000, comlexCaclInternal(10, 10));
    }

    @Test
    public void testComplexCalc() throws Exception {
        int actual = complexCalc(5, 5);
        assertEquals(5000, actual);
    }

    @Test
    public void testTerminalProcess() throws Exception {
        terminalProcess("as");
    }

    @Test
    public void testPower() throws Exception {
        assertEquals(100, power(10));
    }

    @Test
    public void testSub() throws Exception {
        int actual = sub(10, 5);
    }

    @Test
    public void testAdd() throws Exception {
        int actual = add(10, 20);
        assertEquals(30, actual);
    }

}