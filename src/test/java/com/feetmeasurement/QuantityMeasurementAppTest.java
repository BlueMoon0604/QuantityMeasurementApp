package com.feetmeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {
    void testLengthEquality_FeetToInches() {
        QuantityLength f = new QuantityLength(1, LengthUnit.FEET);
        QuantityLength i = new QuantityLength(12, LengthUnit.INCHES);
        assertEquals(f, i);
    }
    @Test
    void testLengthEquality_YardToFeet() {
        QuantityLength f = new QuantityLength(3, LengthUnit.FEET);
        QuantityLength y = new QuantityLength(1, LengthUnit.YARDS);
        assertEquals(f, y);
    }

    @Test
    void testLengthConversion() {
        QuantityLength f = new QuantityLength(1, LengthUnit.FEET);
        double inches = f.convertTo(LengthUnit.INCHES);
        assertEquals(12, inches, 0.001);
    }
    @Test
    void testLengthAddition() {
        QuantityLength f = new QuantityLength(1, LengthUnit.FEET);
        QuantityLength i = new QuantityLength(2, LengthUnit.INCHES);
        QuantityLength result = f.add(i);
        assertEquals(14, result.convertTo(LengthUnit.INCHES), 0.001);
    }

    @Test
    void testWeightEquality_Kilogram() {
        QuantityWeight w1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight w2 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        assertEquals(w1, w2);
    }
    @Test
    void testWeightEquality_KgToGram() {
        QuantityWeight w1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight w2 = new QuantityWeight(1000.0, WeightUnit.GRAM);
        assertEquals(w1, w2);
    }

    @Test
    void testWeightConversion_KgToGram() {
        QuantityWeight w = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight result = w.convertTo(WeightUnit.GRAM);
        assertEquals(1000.0, result.getValue(), 0.001);
    }

    @Test
    void testWeightConversion_PoundToKg() {
        QuantityWeight w = new QuantityWeight(2.20462, WeightUnit.POUND);
        QuantityWeight result = w.convertTo(WeightUnit.KILOGRAM);
        assertEquals(1.0, result.getValue(), 0.01);
    }

    @Test
    void testWeightAddition_DefaultUnit() {
        QuantityWeight w1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight w2 = new QuantityWeight(1000.0, WeightUnit.GRAM);
        QuantityWeight result = w1.add(w2);
        assertEquals(2.0, result.getValue(), 0.001);
    }
    @Test
    void testWeightAddition_TargetUnit() {
        QuantityWeight w1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight w2 = new QuantityWeight(1000.0, WeightUnit.GRAM);
        QuantityWeight result = w1.add(w2, WeightUnit.GRAM);
        assertEquals(2000.0, result.getValue(), 0.001);
    }
    @Test
    void testLengthVsWeightNotEqual() {
        QuantityLength l = new QuantityLength(1, LengthUnit.FEET);
        QuantityWeight w = new QuantityWeight(1, WeightUnit.KILOGRAM);
        assertNotEquals(l, w);
    }
}