package com.msaggik.algorithmsdatastructures.kotlin.search

/**
 * Алгоритм Кнута — Морриса — Пратта
 * применим к задачам:
 * 1) поиска подстроки
 * 2) подсчёта различных подстрок
 * 3) для сжатия строк
 * <p>
 * Алгоритм действий:
 * 1) находится Префикс-функция П(j) (такойже длины N как и поисковая строка S(i), где i,jE[0,N-1])
 * а) П[0] = 0
 * б) j = П[i - 1] -> если S[i] == S[j], то П[i] = j + 1, иначе если S[i] != S[j] и j > 0, то j = П[j - 1] и повторяем цикл -> П[i] = j
 * Вычислительная сложность нахождения Префикс-функции O(N)
 * 2) решается задача с помощью Префикс-функция
 * Вычислительная сложность алгоритма Кнута — Морриса — Пратта поиска подстроки O(N+M), где N длина строки, а M длина подстроки
 **/

object AlgorithmKnuthMorrisPratt {

    fun prefixFunction(text: String): IntArray {
        val prefixFun = IntArray(text.length)
        prefixFun[0] = 0
        for (i in 1 until text.length) {
            var j = prefixFun[i - 1]
            while (j > 0 && (text[i] != text[j])) j = prefixFun[j - 1]
            if (text[i] == text[j]) j += 1
            prefixFun[i] = j
        }
        return prefixFun
    }

    fun searchNumberOfSubstrings(text: String, substrings: String): Int {
        if (text.isEmpty() || substrings.isEmpty() || text.length < substrings.length) return 0

        val prefixFun = prefixFunction(text)
        val substringEntryIndices: MutableList<Int> = ArrayList()

        var i = 0
        var j = 0

        do {
            if (text[i] == substrings[j]) {
                i++
                j++
            }
            if (j == substrings.length) {
                substringEntryIndices.add(i - j)
                j = prefixFun[j - 1]
            } else if (i < text.length && text[i] != substrings[j]) {
                if (j != 0) j = prefixFun[j - 1]
                else i++
            }
        } while (i < text.length)

        return substringEntryIndices.size
    }
}