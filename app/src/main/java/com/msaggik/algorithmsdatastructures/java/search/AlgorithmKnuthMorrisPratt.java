package com.msaggik.algorithmsdatastructures.java.search;

import java.util.ArrayList;
import java.util.List;

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

public class AlgorithmKnuthMorrisPratt {

    public static int[] prefixFunction(String text) {
        int[] prefixFun = new int[text.length()];
        prefixFun[0] = 0;
        for (int i = 1; i < text.length(); i++) {
            int j = prefixFun[i - 1];
            while (j > 0 && (text.charAt(i) != text.charAt(j))) j = prefixFun[j - 1];
            if (text.charAt(i) == text.charAt(j)) j += 1;
            prefixFun[i] = j;
        }
        return prefixFun;
    }

    public static int searchNumberOfSubstrings(String text, String substrings) {

        if(text.isEmpty() || substrings.isEmpty() || text.length() < substrings.length()) return 0;

        int[] prefixFun = prefixFunction(text);
        List<Integer> substringEntryIndices = new ArrayList<>();

        int i = 0, j = 0;

        do {
            if (text.charAt(i) == substrings.charAt(j)) {
                i++;
                j++;
            }
            if (j == substrings.length()) {
                substringEntryIndices.add(i - j);
                j = prefixFun[j - 1];
            } else if (i < text.length() && text.charAt(i) != substrings.charAt(j)) {
                if (j != 0) j = prefixFun[j - 1];
                else i++;
            }
        } while (i < text.length());

        return substringEntryIndices.size();
    }
}
