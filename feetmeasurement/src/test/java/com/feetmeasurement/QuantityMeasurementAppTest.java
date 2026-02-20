package com.feetmeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {
    @Test
    void testEquality_YardToYard_SameValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.YARDS);
        assertTrue(q1.equals(q2));
    }
    @Test
    void testEquality_YardToYard_DifferentValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.YARDS);

        QuantityLength q2 = new QuantityLength(2.0, LengthUnit.YARDS);
        assertFalse(q1.equals(q2));
    }
    @Test
    void testEquality_YardToFeet() {
        QuantityLength yard = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength feet = new QuantityLength(3.0, LengthUnit.FEET);
        assertTrue(yard.equals(feet));
    }
    @Test
    void testEquality_FeetToYard() {
        QuantityLength feet = new QuantityLength(3.0, LengthUnit.FEET);
        QuantityLength yard = new QuantityLength(1.0, LengthUnit.YARDS);
        assertTrue(feet.equals(yard));
    }
    @Test
    void testEquality_YardToInches() {
        QuantityLength yard = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength inches = new QuantityLength(36.0, LengthUnit.INCHES);
        assertTrue(yard.equals(inches));
    }
    @Test
    void testEquality_CMToCM() {

        QuantityLength cm1 = new QuantityLength(2.0, LengthUnit.CENTIMETERS);

        QuantityLength cm2 = new QuantityLength(2.0, LengthUnit.CENTIMETERS);
        assertTrue(cm1.equals(cm2));
    }
    @Test
    void testEquality_CMToInches() {

        QuantityLength cm = new QuantityLength(1.0, LengthUnit.CENTIMETERS);

        QuantityLength inches = new QuantityLength(0.393701, LengthUnit.INCHES);
        assertTrue(cm.equals(inches));
    }
    @Test
    void testEquality_CMToFeet_NotEqual() {

        QuantityLength cm = new QuantityLength(1.0, LengthUnit.CENTIMETERS);

        QuantityLength feet = new QuantityLength(1.0, LengthUnit.FEET);
        assertFalse(cm.equals(feet));
    }
    @Test
    void testEquality_Transitive() {
        QuantityLength yard = new QuantityLength(1.0, LengthUnit.YARDS);

        QuantityLength feet = new QuantityLength(3.0, LengthUnit.FEET);
        QuantityLength inches = new QuantityLength(36.0, LengthUnit.INCHES);
        assertTrue(yard.equals(feet));
        assertTrue(feet.equals(inches));
        assertTrue(yard.equals(inches));
    }
    @Test
    void testEquality_SameReference() {

        QuantityLength yard = new QuantityLength(1.0, LengthUnit.YARDS);
        assertTrue(yard.equals(yard));
    }
    @Test
    void testEquality_WithNull() {

        QuantityLength yard = new QuantityLength(1.0, LengthUnit.YARDS);
        assertFalse(yard.equals(null));
    }
    @Test
    void testEquality_NullUnit() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new QuantityLength(1.0, null)
        );
    }
    @Test
    void testEquality_ComplexScenario() {

        QuantityLength yard = new QuantityLength(2.0, LengthUnit.YARDS);
        QuantityLength feet = new QuantityLength(6.0, LengthUnit.FEET);

        QuantityLength inches = new QuantityLength(72.0, LengthUnit.INCHES);
        assertTrue(yard.equals(feet));
        assertTrue(feet.equals(inches));
        assertTrue(yard.equals(inches));
    }

}