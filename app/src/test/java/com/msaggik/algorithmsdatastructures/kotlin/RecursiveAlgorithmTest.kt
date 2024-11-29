package com.msaggik.algorithmsdatastructures.kotlin

import com.msaggik.algorithmsdatastructures.kotlin.RecursiveAlgorithm
import org.junit.Assert
import org.junit.Test

class RecursiveAlgorithmTest {
    @Test(timeout = 100)
    fun testCalculationFactorialOne() {
        val result = RecursiveAlgorithm.calculationFactorial(10L)
        Assert.assertEquals(result, 3628800L)
    }

    @Test(timeout = 100)
    fun testCalculationFactorialTwo() {
        val result = RecursiveAlgorithm.calculationFactorial(14L)
        Assert.assertEquals(result, 87178291200L)
    }

    @Test(timeout = 100)
    fun testCalculationFibonacciOne() {
        val result = RecursiveAlgorithm.calculationValueFibonacci(10L)
        Assert.assertEquals(result, 55)
    }

    @Test(timeout = 100)
    fun testCalculationFibonacciTwo() {
        val result = RecursiveAlgorithm.calculationValueFibonacci(14L)
        Assert.assertEquals(result, 377)
    }
}
