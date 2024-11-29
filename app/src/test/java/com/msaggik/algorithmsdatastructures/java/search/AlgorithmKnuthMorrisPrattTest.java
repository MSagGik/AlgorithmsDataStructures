package com.msaggik.algorithmsdatastructures.java.search;

import org.junit.Assert;
import org.junit.Test;

public class AlgorithmKnuthMorrisPrattTest {
    private final String stringTestOne = "bnbsdbcb s c scsnmsmcs sdnmndns";
    private final int[] arrayTestOne = {0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private final String stringTestTwo = "asdfghjkasdfghjkasdfghjk";
    private final int[] arrayTestTwo = {0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
    private final String stringTestTree = "Qdfdnnfdfddnnfcdmmfdfdnmmfdfdv";
    private final String subStringTestTree = "fdf";
    private final int testTree = 3;

    @Test(timeout = 100)
    public void testAlgorithmKnuthMorrisPrattOne() {
        int[] result = AlgorithmKnuthMorrisPratt.prefixFunction(stringTestOne);
        Assert.assertArrayEquals(result, arrayTestOne);
    }

    @Test(timeout = 100)
    public void testAlgorithmKnuthMorrisPrattTwo() {
        int[] result = AlgorithmKnuthMorrisPratt.prefixFunction(stringTestTwo);
        Assert.assertArrayEquals(result, arrayTestTwo);
    }

    @Test(timeout = 100)
    public void testAlgorithmKnuthMorrisPrattTree() {
        int result = AlgorithmKnuthMorrisPratt.searchNumberOfSubstrings(stringTestTree, subStringTestTree);
        Assert.assertEquals(result, testTree);
    }
}
