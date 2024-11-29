package com.msaggik.algorithmsdatastructures.java.sort;

import org.junit.Assert;
import org.junit.Test;

public class InsertionSortTest {
    private final int[] arrayTestOne = {123, -10, 0, 1, -5, 1000, 321, 2, 0, 11};
    private final int[] arrayTestSortOne = {-10, -5, 0, 0, 1, 2, 11, 123, 321, 1000};
    private final int[] arrayTestTwo = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3, -4, -5};
    private final int[] arrayTestSortTwo = {-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    @Test(timeout = 100)
    public void testInsertionSortOne() {
        int[] result = InsertionSort.insertionSort(arrayTestOne);
        Assert.assertArrayEquals(result, arrayTestSortOne);
    }

    @Test(timeout = 100)
    public void testInsertionSortTwo() {
        int[] result = InsertionSort.insertionSort(arrayTestTwo);
        Assert.assertArrayEquals(result, arrayTestSortTwo);
    }
}
