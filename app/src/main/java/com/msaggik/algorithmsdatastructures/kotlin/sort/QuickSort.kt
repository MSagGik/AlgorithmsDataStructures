package com.msaggik.algorithms.kotlin.sort

object QuickSort {
    fun quickSort(arrayInt: IntArray): IntArray {
        if (arrayInt.size < 2) return arrayInt

        val left = 0
        val right = arrayInt.size - 1
        quickSortBase(arrayInt, left, right)

        return arrayInt
    }

    private fun quickSortBase(arrayInt: IntArray, left: Int, right: Int) {
        if (left >= right) return

        val indexMiddle = (left + right) / 2
        val middle = arrayInt[indexMiddle]
        var l = left
        var r = right
        while (l <= r) {
            while (arrayInt[l] < middle) l++
            while (arrayInt[r] > middle) r--
            if (l <= r) {
                val value = arrayInt[l]
                arrayInt[l] = arrayInt[r]
                arrayInt[r] = value
                l++
                r--
            }
        }

        if (left < r) quickSortBase(arrayInt, left, r)
        if (right > l) quickSortBase(arrayInt, l, right)
    }
}