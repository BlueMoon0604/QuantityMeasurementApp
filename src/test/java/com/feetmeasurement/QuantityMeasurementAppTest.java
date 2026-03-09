package com.feetmeasurement;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class QuantityMeasurementAppTest {

    @Test
    void testLengthEquality_FeetAndInches() {
        Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(12.0, LengthUnit.INCH);
        assertTrue(q1.equals(q2));
    }

    @Test
    void testWeightEquality_KilogramAndGram() {
        Quantity<WeightUnit> q1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> q2 = new Quantity<>(1000.0, WeightUnit.GRAM);
        assertTrue(q1.equals(q2));
    }

    @Test
    void testVolumeEquality_LitreAndMillilitre() {
        Quantity<VolumeUnit> q1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        assertTrue(q1.equals(q2));
    }

    @Test
    void testConversion_Length() {
        Quantity<LengthUnit> q1 = new Quantity<>(2.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = q1.convertTo(LengthUnit.INCH);
        assertEquals(24.0, q2.getValue());
    }

    @Test
    void testConversion_Weight() {
        Quantity<WeightUnit> q1 = new Quantity<>(2.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> q2 = q1.convertTo(WeightUnit.GRAM);
        assertEquals(2000.0, q2.getValue());
    }
    @Test
    void testConversion_Volume() {
        Quantity<VolumeUnit> q1 = new Quantity<>(1.0, VolumeUnit.GALLON);
        Quantity<VolumeUnit> q2 = q1.convertTo(VolumeUnit.LITRE);

        // Correct precise conversion
        assertEquals(3.79, q2.getValue(), 0.0001);
    }
    @Test
    void testAddition_SameUnit_Length() {
        Quantity<LengthUnit> q1 = new Quantity<>(3.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(2.0, LengthUnit.FEET);
        Quantity<LengthUnit> result = q1.add(q2);
        assertEquals(5.0, result.getValue());
    }
    @Test
    void testAddition_CrossUnit_Length() {
        Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(12.0, LengthUnit.INCH);
        Quantity<LengthUnit> result = q1.add(q2);
        assertEquals(2.0, result.getValue());
    }
    @Test
    void testAddition_SameUnit_Weight() {
        Quantity<WeightUnit> q1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> q2 = new Quantity<>(1000.0, WeightUnit.GRAM);
        Quantity<WeightUnit> result = q1.add(q2);
        assertEquals(2.0, result.getValue());
    }
    @Test
    void testSubtraction_SameUnit_Length() {
        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(5.0, LengthUnit.FEET);
        Quantity<LengthUnit> result = q1.subtract(q2);
        assertEquals(5.0, result.getValue());
    }
    @Test
    void testSubtraction_CrossUnit_Length() {
        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(6.0, LengthUnit.INCH);
        Quantity<LengthUnit> result = q1.subtract(q2);
        assertEquals(9.5, result.getValue());
    }

    @Test
    void testSubtraction_ResultingInNegative() {
        Quantity<LengthUnit> q1 = new Quantity<>(5.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> result = q1.subtract(q2);
        assertEquals(-5.0, result.getValue());
    }

    @Test
    void testSubtraction_WithZeroOperand() {
        Quantity<LengthUnit> q1 = new Quantity<>(5.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(0.0, LengthUnit.INCH);
        Quantity<LengthUnit> result = q1.subtract(q2);
        assertEquals(5.0, result.getValue());
    }
    @Test
    void testDivision_SameUnit_Length() {
        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(2.0, LengthUnit.FEET);
        double result = q1.divide(q2);
        assertEquals(5.0, result);
    }
    @Test
    void testDivision_CrossUnit_Length() {
        Quantity<LengthUnit> q1 = new Quantity<>(24.0, LengthUnit.INCH);
        Quantity<LengthUnit> q2 = new Quantity<>(2.0, LengthUnit.FEET);
        double result = q1.divide(q2);
        assertEquals(1.0, result);
    }

    @Test
    void testDivision_ByZero_Throws() {
        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(0.0, LengthUnit.FEET);
        assertThrows(ArithmeticException.class, () -> q1.divide(q2));
    }
    @Test
    void testNullOperand_Addition() {
        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        assertThrows(IllegalArgumentException.class, () -> q1.add(null));
    }

    @Test
    void testNullOperand_Subtraction() {
        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        assertThrows(IllegalArgumentException.class, () -> q1.subtract(null));
    }

    @Test
    void testNullOperand_Division() {
        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        assertThrows(IllegalArgumentException.class, () -> q1.divide(null));
    }
    @Test
    void testCrossCategory_Addition() {
        Quantity<LengthUnit> length = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<WeightUnit> weight = new Quantity<>(5.0, WeightUnit.KILOGRAM);
        assertThrows(IllegalArgumentException.class, () -> length.add((Quantity) weight));
    }

    @Test
    void testCrossCategory_Subtraction() {
        Quantity<LengthUnit> length = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<WeightUnit> weight = new Quantity<>(5.0, WeightUnit.KILOGRAM);
        assertThrows(IllegalArgumentException.class, () -> length.subtract((Quantity) weight));
    }
    @Test
    void testArithmetic_ChainedOperations() {
        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(2.0, LengthUnit.FEET);
        Quantity<LengthUnit> q3 = new Quantity<>(1.0, LengthUnit.FEET);
        double divisionOperand = 3.0;

        Quantity<LengthUnit> addSub = q1.subtract(q2).add(q3);
        assertEquals(9.0, addSub.getValue());

        double divisionResult = addSub.divide(new Quantity<>(divisionOperand, LengthUnit.FEET));
        assertEquals(3.0, divisionResult);
    }
    @Test
    void testRounding_Addition() {
        Quantity<LengthUnit> q1 = new Quantity<>(10.126, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(0.124, LengthUnit.FEET);
        Quantity<LengthUnit> result = q1.add(q2);
        assertEquals(10.25, result.getValue());
    }

    @Test
    void testRounding_Subtraction() {
        Quantity<LengthUnit> q1 = new Quantity<>(10.126, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(0.124, LengthUnit.FEET);
        Quantity<LengthUnit> result = q1.subtract(q2);
        assertEquals(10.0, result.getValue());
    }
}