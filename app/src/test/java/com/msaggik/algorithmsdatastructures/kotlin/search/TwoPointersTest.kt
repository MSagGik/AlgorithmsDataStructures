package com.msaggik.algorithmsdatastructures.kotlin.search

import org.junit.Assert
import org.junit.Test

class TwoPointersTest {

    private val arrayTestOne = intArrayOf(2, 10, 21, 123, 888, 3221, 1000)
    private val arrayTestTwo = intArrayOf(-123, -17, -3, 0, 2, 10, 21, 123, 888, 3221, 1000)

    @Test(timeout = 100)
    fun testIsSumNumbersTrue() {
        val result = TwoPointers.isSumNumbers(arrayTestOne, 133)
        Assert.assertTrue(result)
    }

    @Test(timeout = 100)
    fun testIsSumNumbersFalse() {
        val result = TwoPointers.isSumNumbers(arrayTestOne, 131)
        Assert.assertFalse(result)
    }

    @Test(timeout = 100)
    fun testIsSumNumbersTwoTrue() {
        val result = TwoPointers.isSumNumbers(arrayTestTwo, 133)
        Assert.assertTrue(result)
    }

    @Test(timeout = 100)
    fun testIsSumNumbersTwoFalse() {
        val result = TwoPointers.isSumNumbers(arrayTestTwo, 131)
        Assert.assertFalse(result)
    }
}