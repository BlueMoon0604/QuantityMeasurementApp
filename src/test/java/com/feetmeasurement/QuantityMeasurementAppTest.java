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
        assertEquals(24.0, q2.getValue(), 0.0001);
    }

    @Test
    void testConversion_Weight() {
        Quantity<WeightUnit> q1 = new Quantity<>(2.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> q2 = q1.convertTo(WeightUnit.GRAM);
        assertEquals(2000.0, q2.getValue(), 0.0001);
    }

    @Test
    void testConversion_Volume() {
        Quantity<VolumeUnit> q1 = new Quantity<>(1.0, VolumeUnit.GALLON);
        Quantity<VolumeUnit> q2 = q1.convertTo(VolumeUnit.LITRE);
        assertEquals(3.7854, q2.getValue(), 0.01);
    }

    @Test
    void testAddition_SameUnit_Length() {
        Quantity<LengthUnit> q1 = new Quantity<>(3.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(2.0, LengthUnit.FEET);
        Quantity<LengthUnit> result = q1.add(q2);
        assertEquals(5.0, result.getValue(), 0.0001);
    }

    @Test
    void testAddition_CrossUnit_Length() {
        Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(12.0, LengthUnit.INCH);
        Quantity<LengthUnit> result = q1.add(q2);
        assertEquals(2.0, result.getValue(), 0.0001);
    }

    @Test
    void testSubtraction_Length() {
        Quantity<LengthUnit> q1 = new Quantity<>(3.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(12.0, LengthUnit.INCH);
        Quantity<LengthUnit> result = q1.subtract(q2);
        assertEquals(2.0, result.getValue(), 0.0001);
    }

    @Test
    void testDivision_ByNonZero() {
        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(2.0, LengthUnit.FEET);
        Quantity<LengthUnit> result = q1.divide(q2);
        assertEquals(16.404199475065617, result.getValue(), 0.0001);
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
    void testTemperatureUnsupportedDivide() {
        Quantity<TemperatureUnit> temp = new Quantity<>(100.0, TemperatureUnit.CELSIUS);
        assertThrows(UnsupportedOperationException.class, () ->
                temp.divide(new Quantity<>(10.0, TemperatureUnit.CELSIUS))
        );
    }

    @Test
    void testTemperatureUnsupportedAdd() {
        Quantity<TemperatureUnit> temp = new Quantity<>(100.0, TemperatureUnit.CELSIUS);
        assertThrows(UnsupportedOperationException.class, () ->
                temp.add(new Quantity<>(10.0, TemperatureUnit.CELSIUS))
        );
    }

    @Test
    void testTemperatureEquality_CelsiusFahrenheit() {
        Quantity<TemperatureUnit> tempC = new Quantity<>(0.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> tempF = new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT);
        assertEquals(tempC, tempF);
    }
}