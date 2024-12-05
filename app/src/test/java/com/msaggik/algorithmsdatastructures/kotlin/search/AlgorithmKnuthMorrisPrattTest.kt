package com.msaggik.algorithmsdatastructures.kotlin.search

import org.junit.Assert
import org.junit.Test

class AlgorithmKnuthMorrisPrattTest {
    private val stringTestOne = "bnbsdbcb s c scsnmsmcs sdnmndns"
    private val arrayTestOne = intArrayOf(0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    private val stringTestTwo = "asdfghjkasdfghjkasdfghjk"
    private val arrayTestTwo = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)
    private val stringTestTree = "Qdfdnnfdfddnnfcdmmfdfdnmmfdfdv"
    private val subStringTestTree = "fdf"
    private val testTree = 3

    @Test(timeout = 100)
    fun testAlgorithmKnuthMorrisPrattOne() {
        val result = AlgorithmKnuthMorrisPratt.prefixFunction(stringTestOne)
        Assert.assertArrayEquals(result, arrayTestOne)
    }

    @Test(timeout = 100)
    fun testAlgorithmKnuthMorrisPrattTwo() {
        val result = AlgorithmKnuthMorrisPratt.prefixFunction(stringTestTwo)
        Assert.assertArrayEquals(result, arrayTestTwo)
    }

    @Test(timeout = 100)
    fun testAlgorithmKnuthMorrisPrattTreeV1() {
        val result =
            AlgorithmKnuthMorrisPratt.searchNumberOfSubstringsV1(stringTestTree, subStringTestTree)
        Assert.assertEquals(result.toLong(), testTree.toLong())
    }

    @Test(timeout = 100)
    fun testAlgorithmKnuthMorrisPrattTreeV2() {
        val result =
            AlgorithmKnuthMorrisPratt.searchNumberOfSubstringsV2(stringTestTree, subStringTestTree)
        Assert.assertEquals(result.toLong(), testTree.toLong())
    }
}