package com.feetmeasurement;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class QuantityMeasurementAppTest {

    double EPSILON = 0.0001;

    @Test
    void testLengthEquality() {
        Quantity<LengthUnit> length1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> length2 = new Quantity<>(12.0, LengthUnit.INCH);

        assertTrue(length1.equals(length2));
    }

    @Test
    void testLengthConversion() {
        Quantity<LengthUnit> length = new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> result = length.convertTo(LengthUnit.INCH);

        assertEquals(12.0, result.getValue(), EPSILON);
    }

    @Test
    void testLengthAddition() {
        Quantity<LengthUnit> length1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> length2 = new Quantity<>(12.0, LengthUnit.INCH);

        Quantity<LengthUnit> result = length1.add(length2);

        assertEquals(2.0, result.getValue(), EPSILON);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    void testLengthSubtraction() {
        Quantity<LengthUnit> length1 = new Quantity<>(2.0, LengthUnit.FEET);
        Quantity<LengthUnit> length2 = new Quantity<>(12.0, LengthUnit.INCH);

        Quantity<LengthUnit> result = length1.subtract(length2);

        assertEquals(1.0, result.getValue(), EPSILON);
    }

    @Test
    void testLengthDivision() {
        Quantity<LengthUnit> length1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> length2 = new Quantity<>(6.0, LengthUnit.INCH);

        double result = length1.divide(length2);

        assertEquals(2.0, result, EPSILON);
    }

    @Test
    void testWeightEquality() {
        Quantity<WeightUnit> weight1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> weight2 = new Quantity<>(1000.0, WeightUnit.GRAM);

        assertTrue(weight1.equals(weight2));
    }

    @Test
    void testWeightAddition() {
        Quantity<WeightUnit> weight1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> weight2 = new Quantity<>(1000.0, WeightUnit.GRAM);

        Quantity<WeightUnit> result = weight1.add(weight2);

        assertEquals(2.0, result.getValue(), EPSILON);
    }

    @Test
    void testWeightSubtraction() {
        Quantity<WeightUnit> weight1 = new Quantity<>(2.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> weight2 = new Quantity<>(500.0, WeightUnit.GRAM);

        Quantity<WeightUnit> result = weight1.subtract(weight2);

        assertEquals(1.5, result.getValue(), EPSILON);
    }

    @Test
    void testWeightDivision() {
        Quantity<WeightUnit> weight1 = new Quantity<>(2.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> weight2 = new Quantity<>(1.0, WeightUnit.KILOGRAM);

        double result = weight1.divide(weight2);

        assertEquals(2.0, result, EPSILON);
    }

    @Test
    void testVolumeEquality() {
        Quantity<VolumeUnit> volume1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> volume2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        assertTrue(volume1.equals(volume2));
    }

    @Test
    void testVolumeAddition() {
        Quantity<VolumeUnit> volume1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> volume2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> result = volume1.add(volume2);

        assertEquals(2.0, result.getValue(), EPSILON);
    }

    @Test
    void testVolumeSubtraction() {
        Quantity<VolumeUnit> volume1 = new Quantity<>(2.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> volume2 = new Quantity<>(500.0, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> result = volume1.subtract(volume2);

        assertEquals(1.5, result.getValue(), EPSILON);
    }

    @Test
    void testVolumeDivision() {
        Quantity<VolumeUnit> volume1 = new Quantity<>(2.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> volume2 = new Quantity<>(1.0, VolumeUnit.LITRE);

        double result = volume1.divide(volume2);

        assertEquals(2.0, result, EPSILON);
    }

    @Test
    void testVolumeConversion() {
        Quantity<VolumeUnit> gallon = new Quantity<>(1.0, VolumeUnit.GALLON);

        Quantity<VolumeUnit> litre = gallon.convertTo(VolumeUnit.LITRE);

        assertEquals(3.78541, litre.getValue(), 0.001);
    }
}