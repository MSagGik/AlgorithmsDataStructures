package com.msaggik.algorithmsdatastructures.kotlin.sort

import com.msaggik.algorithms.kotlin.sort.MergeSort
import org.junit.Assert
import org.junit.Test

class MergeSortTest {
    private val arrayTestOne = intArrayOf(123, -10, 0, 1, -5, 1000, 321, 2, 0, 11)
    private val arrayTestSortOne = intArrayOf(-10, -5, 0, 0, 1, 2, 11, 123, 321, 1000)
    private val arrayTestTwo = intArrayOf(10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3, -4, -5)
    private val arrayTestSortTwo = intArrayOf(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    @Test(timeout = 100)
    fun testMergeSortOne() {
        val result = MergeSort.mergeSort(arrayTestOne)
        Assert.assertArrayEquals(result, arrayTestSortOne)
    }

    @Test(timeout = 100)
    fun testMergeSortTwo() {
        val result = MergeSort.mergeSort(arrayTestTwo)
        Assert.assertArrayEquals(result, arrayTestSortTwo)
    }
}