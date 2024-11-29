package com.msaggik.algorithmsdatastructures.java.ai;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MultiLayerPerceptronTest {

    @Test
    public void testPredict() {
        MultiLayerPerceptron mlp = new MultiLayerPerceptron(2, 3, 1, 0.1);
        double[] input = {0.5, 0.2};
        double[] output = mlp.predict(input);

        // Проверяем, что выход имеет правильный размер
        assertEquals(1, output.length);

        // Проверяем, что выход находится в диапазоне [0, 1]
        assertTrue(output[0] >= 0 && output[0] <= 1);
    }

    @Test
    public void testWeightsInitialization() {
        MultiLayerPerceptron mlp = new MultiLayerPerceptron(2, 3, 1, 0.1);

        // Проверяем, что веса не равны нулю
        for (double[] weights : mlp.weightsInputHidden) {
            for (double weight : weights) {
                assertNotEquals(0, weight, 0.01);
            }
        }

        for (double[] weights : mlp.weightsHiddenOutput) {
            for (double weight : weights) {
                assertNotEquals(0, weight, 0.01);
            }
        }
    }
}
