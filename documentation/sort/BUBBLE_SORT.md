# [Алгоритмы](../../)

## Сортировка "Пузырьком"

### Применимость:

Для сортировки малых последовательностей 

### Вычислительная сложность:

`O(N^2)`
### Затраты памяти:

`O(1)`

### Пример:

- Java:

``` Java
public class BubbleSort {

    public static int[] bubbleSort(int[] arrayInt) {
        for (int i = 0; i < arrayInt.length - 1; i++)
            for (int j = i + 1; j < arrayInt.length; j++) {
                if(arrayInt[i] > arrayInt[j]) {
                    int value = arrayInt[i];
                    arrayInt[i] = arrayInt[j];
                    arrayInt[j] = value;
                }
            }
        return arrayInt;
    }
}
```
- Kotlin:
``` Kotlin
object BubbleSort {
    fun bubbleSort(arrayInt: IntArray): IntArray {
        for (i in 0 until arrayInt.size - 1) for (j in i + 1 until arrayInt.size) {
            if (arrayInt[i] > arrayInt[j]) {
                val value = arrayInt[i]
                arrayInt[i] = arrayInt[j]
                arrayInt[j] = value
            }
        }
        return arrayInt
    }
}
```
### Примеры тестов:

- Java:
``` Java
public class BubbleSortTest {
    private final int[] arrayTestOne = {123, -10, 0, 1, -5, 1000, 321, 2, 0, 11};
    private final int[] arrayTestSortOne = {-10, -5, 0, 0, 1, 2, 11, 123, 321, 1000};
    private final int[] arrayTestTwo = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3, -4, -5};
    private final int[] arrayTestSortTwo = {-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    @Test(timeout = 100)
    public void testBubbleSortOne() {
        int[] result = BubbleSort.bubbleSort(arrayTestOne);
        Assert.assertArrayEquals(result, arrayTestSortOne);
    }

    @Test(timeout = 100)
    public void testBubbleSortTwo() {
        int[] result = BubbleSort.bubbleSort(arrayTestTwo);
        Assert.assertArrayEquals(result, arrayTestSortTwo);
    }
}
```
- Kotlin:
``` Kotlin
class BubbleSortTest {
    private val arrayTestOne = intArrayOf(123, -10, 0, 1, -5, 1000, 321, 2, 0, 11)
    private val arrayTestSortOne = intArrayOf(-10, -5, 0, 0, 1, 2, 11, 123, 321, 1000)
    private val arrayTestTwo = intArrayOf(10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3, -4, -5)
    private val arrayTestSortTwo = intArrayOf(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    @Test(timeout = 100)
    fun testBubbleSortOne() {
        val result = BubbleSort.bubbleSort(arrayTestOne)
        Assert.assertArrayEquals(result, arrayTestSortOne)
    }

    @Test(timeout = 100)
    fun testBubbleSortTwo() {
        val result = BubbleSort.bubbleSort(arrayTestTwo)
        Assert.assertArrayEquals(result, arrayTestSortTwo)
    }
}
```