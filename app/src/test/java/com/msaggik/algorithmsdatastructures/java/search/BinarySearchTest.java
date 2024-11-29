package com.msaggik.algorithmsdatastructures.java.search;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTest {
    private final int[] arrayTestOne = {2, 10, 21, 123, 888, 3221, 1000};
    private final int[] arrayTestTwo = {-123, -17, -3, 0, 2, 10, 21, 123, 888, 3221, 10000};

    @Test(timeout = 100)
    public void testBinarySearchOneTrue() {
        int result = BinarySearch.isValueInArray(arrayTestOne, 21);
        Assert.assertEquals(result, 2);
    }

    @Test(timeout = 100)
    public void testBinarySearchOneFalse() {
        int result = BinarySearch.isValueInArray(arrayTestOne, 100);
        Assert.assertEquals(result, -1);
    }

    @Test(timeout = 100)
    public void testBinarySearchTwoTrue() {
        int result = BinarySearch.isValueInArray(arrayTestTwo, 21);
        Assert.assertEquals(result, 6);
    }

    @Test(timeout = 100)
    public void testBinarySearchFalse() {
        int result = BinarySearch.isValueInArray(arrayTestTwo, 100);
        Assert.assertEquals(result, -1);
    }
}
