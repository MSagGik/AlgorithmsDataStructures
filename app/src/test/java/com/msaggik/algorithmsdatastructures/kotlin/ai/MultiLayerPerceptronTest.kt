package com.msaggik.algorithmsdatastructures.kotlin.ai

import org.junit.Assert.*
import org.junit.Test

class MultiLayerPerceptronTest {

    @Test
    fun testPredict() {
        val mlp = MultiLayerPerceptron(2, 3, 1, 0.1)
        val input = doubleArrayOf(0.5, 0.2)
        val output = mlp.predict(input)

        // Проверяем, что выход имеет правильный размер
        assertEquals(1, output.size)

        // Проверяем, что выход находится в диапазоне [0, 1]
        assertTrue(output[0] in 0.0..1.0)
    }

    @Test
    fun testWeightsInitialization() {
        val mlp = MultiLayerPerceptron(2, 3, 1, 0.1)

        // Проверяем, что веса не равны нулю
        for (weights in mlp.weightsInputHidden) {
            for (weight in weights) {
                assertNotEquals(0.0, weight, 0.01)
            }
        }

        for (weights in mlp.weightsHiddenOutput) {
            for (weight in weights) {
                assertNotEquals(0.0, weight, 0.01)
            }
        }
    }
}