# [Алгоритмы](../../)

## Алгоритм Кнута — Морриса — Пратта

## Алгоритм действий:
1) находится Префикс-функция `П(j)` (такойже длины `N` как и поисковая строка `S(i)`, где `i,jE[0,N-1]`)
а) `П[0] = 0`
б) `j = П[i - 1]` -> если `S[i] == S[j]`, то `П[i] = j + 1`, иначе если `S[i] != S[j]` и `j > 0`, то `j = П[j - 1]` и повторяем цикл -> `П[i] = j`
Вычислительная сложность нахождения Префикс-функции `O(N)`
2) решается задача с помощью Префикс-функция

### Применимость:
1) поиска подстроки
2) подсчёта различных подстрок
3) для сжатия строк

### Вычислительная сложность:

`O(N+M)`, где `N` длина строки, а `M` длина подстроки

### Алгоритм

- Java:

``` Java
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
```
- Kotlin:
``` Kotlin
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
```
### Примеры тестов:

- Java:
``` Java
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
```
- Kotlin:
``` Kotlin
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
    fun testAlgorithmKnuthMorrisPrattTree() {
        val result =
            AlgorithmKnuthMorrisPratt.searchNumberOfSubstrings(stringTestTree, subStringTestTree)
        Assert.assertEquals(result.toLong(), testTree.toLong())
    }
}
```