package com.msaggik.algorithms.kotlin.sort

object MergeSort {
    fun mergeSort(arrayInt: IntArray): IntArray {
        val length = arrayInt.size

        mergeSortBase(arrayInt, length)

        return arrayInt
    }

    private fun mergeSortBase(arrayInt: IntArray, length: Int) {
        if (length < 2) return

        val indexMiddle = length / 2
        val leftLength = indexMiddle
        val rightLength = length - indexMiddle

        // division into 2 arrays
        val leftArray = IntArray(leftLength)
        val rightArray = IntArray(rightLength)

        for (i in 0 until length) {
            if (i < indexMiddle) leftArray[i] = arrayInt[i]
            else rightArray[i - indexMiddle] = arrayInt[i]
        }

        // recursive further division
        mergeSortBase(leftArray, leftLength)
        mergeSortBase(rightArray, rightLength)

        // merge arrays
        var i = 0
        var j = 0
        var k = 0
        while (i < leftLength && j < rightLength) {
            arrayInt[k++] = if (leftArray[i] <= rightArray[j]) leftArray[i++] else rightArray[j++]
        }
        while (i < leftLength) arrayInt[k++] = leftArray[i++]
        while (j < rightLength) arrayInt[k++] = rightArray[j++]
    }
}