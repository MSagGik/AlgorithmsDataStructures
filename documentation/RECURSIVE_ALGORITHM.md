# [Алгоритмы](../)

## Рекурсия

### Применимость:

Имеет смысл использовать в задачах, которые можно разбить на одинаковые повторяющиеся действия

Алгоритм действий:
1) определяются уникальные начальные условия (с выходом из рекурсии)
2) запуск рекурсии

### Пример: факториал и числа Фибоначчи

- Java:

``` Java
public class RecursiveAlgorithm {

    static long calculationFactorial(long value) {
        if(value == 1) return 1L;
        return value * calculationFactorial(value - 1);
    }

    static long calculationValueFibonacci(long index) {
        if(index == 0) return 0L;
        if(index == 1) return 1L;
        return calculationValueFibonacci(index - 1) + calculationValueFibonacci(index - 2);
    }
}
```
- Kotlin:
``` Kotlin
object RecursiveAlgorithm {
    fun calculationFactorial(value: Long): Long {
        if (value == 1L) return 1L
        return value * calculationFactorial(value - 1)
    }

    fun calculationValueFibonacci(index: Long): Long {
        if (index == 0L) return 0L
        if (index == 1L) return 1L
        return calculationValueFibonacci(index - 1) + calculationValueFibonacci(index - 2)
    }
}
```
### Примеры тестов:

- Java:
``` Java
public class RecursiveAlgorithmTest {

    @Test(timeout = 100)
    public void testCalculationFactorialOne() {
        long result = RecursiveAlgorithm.calculationFactorial(10L);
        Assert.assertEquals(result, 3_628_800L);
    }

    @Test(timeout = 100)
    public void testCalculationFactorialTwo() {
        long result = RecursiveAlgorithm.calculationFactorial(14L);
        Assert.assertEquals(result, 87_178_291_200L);
    }

    @Test(timeout = 100)
    public void testCalculationFibonacciOne() {
        long result = RecursiveAlgorithm.calculationValueFibonacci(10L);
        Assert.assertEquals(result, 55);
    }

    @Test(timeout = 100)
    public void testCalculationFibonacciTwo() {
        long result = RecursiveAlgorithm.calculationValueFibonacci(14L);
        Assert.assertEquals(result, 377);
    }
}

```
- Kotlin:
``` Kotlin
class RecursiveAlgorithmTest {
    @Test(timeout = 100)
    fun testCalculationFactorialOne() {
        val result = RecursiveAlgorithm.calculationFactorial(10L)
        Assert.assertEquals(result, 3628800L)
    }

    @Test(timeout = 100)
    fun testCalculationFactorialTwo() {
        val result = RecursiveAlgorithm.calculationFactorial(14L)
        Assert.assertEquals(result, 87178291200L)
    }

    @Test(timeout = 100)
    fun testCalculationFibonacciOne() {
        val result = RecursiveAlgorithm.calculationValueFibonacci(10L)
        Assert.assertEquals(result, 55)
    }

    @Test(timeout = 100)
    fun testCalculationFibonacciTwo() {
        val result = RecursiveAlgorithm.calculationValueFibonacci(14L)
        Assert.assertEquals(result, 377)
    }
}
```