package com.msaggik.algorithmsdatastructures.kotlin.search

import org.junit.Assert
import org.junit.Test

class BinarySearchTest {
    private val arrayTestOne = intArrayOf(2, 10, 21, 123, 888, 3221, 1000)
    private val arrayTestTwo = intArrayOf(-123, -17, -3, 0, 2, 10, 21, 123, 888, 3221, 10000)

    @Test(timeout = 100)
    fun testBinarySearchOneTrue() {
        val result = BinarySearch.isValueInArray(arrayTestOne, 21)
        Assert.assertEquals(result.toLong(), 2)
    }

    @Test(timeout = 100)
    fun testBinarySearchOneFalse() {
        val result = BinarySearch.isValueInArray(arrayTestOne, 100)
        Assert.assertEquals(result.toLong(), -1)
    }

    @Test(timeout = 100)
    fun testBinarySearchTwoTrue() {
        val result = BinarySearch.isValueInArray(arrayTestTwo, 21)
        Assert.assertEquals(result.toLong(), 6)
    }

    @Test(timeout = 100)
    fun testBinarySearchFalse() {
        val result = BinarySearch.isValueInArray(arrayTestTwo, 100)
        Assert.assertEquals(result.toLong(), -1)
    }
}