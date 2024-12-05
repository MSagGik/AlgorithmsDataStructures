package com.msaggik.algorithmsdatastructures.kotlin.search

object TwoPointers {
    fun isSumNumbers(arrayInt: IntArray, sum: Int): Boolean {
        var left = 0
        var right = arrayInt.size - 1
        while (left < right) {
            if (arrayInt[left] + arrayInt[right] == sum) return true
            else if (arrayInt[left] + arrayInt[right] < sum) left++
            else right--
        }
        return false
    }
}