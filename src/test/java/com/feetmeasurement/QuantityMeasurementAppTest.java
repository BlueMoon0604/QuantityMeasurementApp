package com.feetmeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    double EPSILON = 0.0001;

    @Test
    void testUC1_InchToInchEquality() {
        Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.INCH);
        Quantity<LengthUnit> q2 = new Quantity<>(1.0, LengthUnit.INCH);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testUC2_InchToFeetEquality() {
        Quantity<LengthUnit> q1 = new Quantity<>(12.0, LengthUnit.INCH);
        Quantity<LengthUnit> q2 = new Quantity<>(1.0, LengthUnit.FOOT);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testUC3_FeetToFeetEquality() {
        Quantity<LengthUnit> q1 = new Quantity<>(3.0, LengthUnit.FOOT);
        Quantity<LengthUnit> q2 = new Quantity<>(3.0, LengthUnit.FOOT);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testUC4_FeetToYardEquality() {
        Quantity<LengthUnit> q1 = new Quantity<>(3.0, LengthUnit.FOOT);
        Quantity<LengthUnit> q2 = new Quantity<>(1.0, LengthUnit.YARD);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testUC5_LengthConversion() {
        Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.FOOT);

        Quantity<LengthUnit> result = q1.convertTo(LengthUnit.INCH);

        assertEquals(12.0, result.getValue(), EPSILON);
    }

    @Test
    void testUC6_CentimeterConversion() {
        Quantity<LengthUnit> q1 = new Quantity<>(100.0, LengthUnit.CENTIMETER);

        Quantity<LengthUnit> result = q1.convertTo(LengthUnit.FOOT);

        assertEquals(3.2808, result.getValue(), 0.01);
    }

    @Test
    void testUC7_GramToGramEquality() {
        Quantity<WeightUnit> w1 = new Quantity<>(1000.0, WeightUnit.GRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(1000.0, WeightUnit.GRAM);

        assertTrue(w1.equals(w2));
    }

    @Test
    void testUC8_GramToKilogramEquality() {
        Quantity<WeightUnit> w1 = new Quantity<>(1000.0, WeightUnit.GRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(1.0, WeightUnit.KILOGRAM);

        assertTrue(w1.equals(w2));
    }

    @Test
    void testUC9_WeightConversion() {
        Quantity<WeightUnit> w1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> result = w1.convertTo(WeightUnit.GRAM);

        assertEquals(1000.0, result.getValue(), EPSILON);
    }

    @Test
    void testUC10_Addition_Length() {
        Quantity<LengthUnit> l1 = new Quantity<>(1.0, LengthUnit.FOOT);
        Quantity<LengthUnit> l2 = new Quantity<>(12.0, LengthUnit.INCH);

        Quantity<LengthUnit> result = l1.add(l2);

        assertEquals(2.0, result.getValue(), EPSILON);
    }

    @Test
    void testUC11_VolumeEquality() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        assertTrue(v1.equals(v2));
    }

    @Test
    void testUC11_VolumeConversion() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.GALLON);

        Quantity<VolumeUnit> result = v1.convertTo(VolumeUnit.LITRE);

        assertEquals(3.78541, result.getValue(), 0.001);
    }

    @Test
    void testUC11_VolumeAddition() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> result = v1.add(v2);

        assertEquals(2.0, result.getValue(), EPSILON);
    }

    @Test
    void testCrossCategoryComparison() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<LengthUnit> l1 = new Quantity<>(1.0, LengthUnit.FOOT);

        assertFalse(v1.equals(l1));
    }

}