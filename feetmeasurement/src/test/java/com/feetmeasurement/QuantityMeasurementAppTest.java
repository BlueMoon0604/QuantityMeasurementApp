package com.feetmeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {
    @Test
    public void testFeetEquality_SameValue() {
        assertTrue(QuantityMeasurementApp.compareFeet(1.0, 1.0));
    }
    @Test
    public void testFeetEquality_DifferentValue() {

        assertFalse(QuantityMeasurementApp.compareFeet(1.0, 2.0));
    }
    @Test
    public void testInchesEquality_SameValue() {

        assertTrue(QuantityMeasurementApp.compareInches(1.0, 1.0));
    }
    @Test
    public void testInchesEquality_DifferentValue() {

        assertFalse(QuantityMeasurementApp.compareInches(1.0, 2.0));
    }
    @Test
    public void testFeetEquality_NullComparison() {
        Feet f = new Feet(1.0);
        assertFalse(f.equals(null));
    }
    @Test
    public void testInchesEquality_SameReference() {
        Inches i = new Inches(1.0);
        assertTrue(i.equals(i));
    }
}


