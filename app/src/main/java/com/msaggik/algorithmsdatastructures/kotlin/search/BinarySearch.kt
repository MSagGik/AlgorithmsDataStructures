package com.msaggik.algorithmsdatastructures.kotlin.search

object BinarySearch {
    fun isValueInArray(arrayInt: IntArray, value: Int): Int {
        var left = 0
        var right = arrayInt.size - 1
        while (left <= right) {
            val middle = (left + right) / 2
            val current = arrayInt[middle]
            if (current == value) return middle
            else if (current < value) left = middle + 1
            else right = middle - 1
        }
        return -1
    }
}