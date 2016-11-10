package com.androidpath.androidtest.junittest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/11/10 17:27 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */
public class CalculatorTest {


    @After
    public void tearDown() throws Exception {
        System.out.println("success");
    }

    private Calculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    public void sum() throws Exception {
        assertEquals(6d, calculator.sum(1d, 5d), 0);
    }

    @Test
    public void substract() throws Exception {
        assertEquals(1d, calculator.substract(5d, 4d), 0);
    }

    @Test
    public void divide() throws Exception {
        assertEquals(4d, calculator.divide(20d, 5d), 0);
    }

    @Test
    public void multiply() throws Exception {
        assertEquals(10d, calculator.multiply(2d, 5d), 0);
    }
}