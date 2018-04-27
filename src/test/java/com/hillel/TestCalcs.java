package com.hillel;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TestCalcs {
    private static Calculator calc;


    @BeforeClass
    public static void initBeforeAllTests() {
        calc =
                new Calculator();
    }

    @Test
    public void addTest() {
        int actualResult =
                calc.add(5, 10);

        assertEquals(15, actualResult);
    }

    @Test
    public void powerTest() {
        int actualResult =
                calc.pow(3);

        assertEquals(9, actualResult);
    }

    @Test
    public void divNormalTest() {
        int actualResult =
                calc.div(100, 20);

        assertEquals(5, actualResult);
    }


    @Test
    public void divWhenFirstOperandZeroTest() {
        int actualResult = calc.div(0, 10);
        assertEquals(0, actualResult);
    }

    @Test(expected = MyCustomException.class)
    public void divByZeroTest() {

        calc.div(100, 0);

        fail("This code mustn't be reached so far.");
    }
}
