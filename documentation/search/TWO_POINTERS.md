# [Алгоритмы](../../)

## Два указателя

### Применимость:

Для отсортированной последовательности чисел

### Вычислительная сложность:

Только для положительной последовательности `O(N)`
Для положительной и отрицательной последовательности может быть до 4х раз медленее

### Пример: поиск наличия чисел сумма которых равняется "sum"

- Java:

``` Java
public class TwoPointers {
    static boolean isSumNumbers(int[] arrayInt, int sum) {
        int left = 0, right = arrayInt.length - 1;
        while (left < right) {
            if (arrayInt[left] + arrayInt[right] == sum) return true;
            else if (arrayInt[left] + arrayInt[right] < sum) left++;
            else right--;
        }
        return false;
    }
}
```
- Kotlin:
``` Kotlin
class TwoPointers {
    companion object {
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
}
```
### Примеры тестов:

- Java:
``` Java
public class TwoPointersTest {

    private final int[] arrayTestOne = {2, 10, 21, 123, 888, 3221, 1000};
    private final int[] arrayTestTwo = {-123, -17, -3, 0, 2, 10, 21, 123, 888, 3221, 1000};

    @Test(timeout = 100)
    public void testIsSumNumbersOneTrue() {
        boolean result = TwoPointers.isSumNumbers(arrayTestOne, 133);
        Assert.assertTrue(result);
    }

    @Test(timeout = 100)
    public void testIsSumNumbersOneFalse() {
        boolean result = TwoPointers.isSumNumbers(arrayTestOne, 131);
        Assert.assertFalse(result);
    }

    @Test(timeout = 100)
    public void testIsSumNumbersTwoTrue() {
        boolean result = TwoPointers.isSumNumbers(arrayTestTwo, 133);
        Assert.assertTrue(result);
    }

    @Test(timeout = 100)
    public void testIsSumNumbersTwoFalse() {
        boolean result = TwoPointers.isSumNumbers(arrayTestTwo, 131);
        Assert.assertFalse(result);
    }
}
```
- Kotlin:
``` Kotlin
class TwoPointersTest {

    private val arrayTestOne = intArrayOf(2, 10, 21, 123, 888, 3221, 1000)
    private val arrayTestTwo = intArrayOf(-123, -17, -3, 0, 2, 10, 21, 123, 888, 3221, 1000)

    @Test(timeout = 100)
    fun testIsSumNumbersTrue() {
        val result = TwoPointers.isSumNumbers(arrayTestOne, 133)
        Assert.assertTrue(result)
    }

    @Test(timeout = 100)
    fun testIsSumNumbersFalse() {
        val result = TwoPointers.isSumNumbers(arrayTestOne, 131)
        Assert.assertFalse(result)
    }

    @Test(timeout = 100)
    fun testIsSumNumbersTwoTrue() {
        val result = TwoPointers.isSumNumbers(arrayTestTwo, 133)
        Assert.assertTrue(result)
    }

    @Test(timeout = 100)
    fun testIsSumNumbersTwoFalse() {
        val result = TwoPointers.isSumNumbers(arrayTestTwo, 131)
        Assert.assertFalse(result)
    }
}
```
