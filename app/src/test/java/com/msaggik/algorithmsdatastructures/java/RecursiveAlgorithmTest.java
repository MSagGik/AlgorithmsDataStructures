package com.msaggik.algorithmsdatastructures.java;

import org.junit.Assert;
import org.junit.Test;

public class RecursiveAlgorithmTest {

    @Test(timeout = 100)
    public void testCalculationFactorialOne() {
        long result = RecursiveAlgorithm.calculationFactorial(10L);
        Assert.assertEquals(result, 3_628_800L);
    }

    @Test(timeout = 100)
    public void testCalculationFactorialTwo() {
        long result = RecursiveAlgorithm.calculationFactorial(14L);
        Assert.assertEquals(result, 87_178_291_200L);
    }

    @Test(timeout = 100)
    public void testCalculationFibonacciOne() {
        long result = RecursiveAlgorithm.calculationValueFibonacci(10L);
        Assert.assertEquals(result, 55);
    }

    @Test(timeout = 100)
    public void testCalculationFibonacciTwo() {
        long result = RecursiveAlgorithm.calculationValueFibonacci(14L);
        Assert.assertEquals(result, 377);
    }
}
