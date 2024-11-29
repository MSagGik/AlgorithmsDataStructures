package com.msaggik.algorithmsdatastructures.java.search;

import org.junit.Assert;
import org.junit.Test;

public class TwoPointersTest {

    private final int[] arrayTestOne = {2, 10, 21, 123, 888, 3221, 1000};
    private final int[] arrayTestTwo = {-123, -17, -3, 0, 2, 10, 21, 123, 888, 3221, 1000};

    @Test(timeout = 100)
    public void testIsSumNumbersOneTrue() {
        boolean result = TwoPointers.isSumNumbers(arrayTestOne, 133);
        Assert.assertTrue(result);
    }

    @Test(timeout = 100)
    public void testIsSumNumbersOneFalse() {
        boolean result = TwoPointers.isSumNumbers(arrayTestOne, 131);
        Assert.assertFalse(result);
    }

    @Test(timeout = 100)
    public void testIsSumNumbersTwoTrue() {
        boolean result = TwoPointers.isSumNumbers(arrayTestTwo, 133);
        Assert.assertTrue(result);
    }

    @Test(timeout = 100)
    public void testIsSumNumbersTwoFalse() {
        boolean result = TwoPointers.isSumNumbers(arrayTestTwo, 131);
        Assert.assertFalse(result);
    }
}
