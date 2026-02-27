package com.feetmeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {
    private static final double EPSILON = 0.0001;
    @Test
    void testAddition_ExplicitTargetUnit_Feet() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);
        QuantityLength result = q1.add(q2, LengthUnit.FEET);
        assertEquals(new QuantityLength(2.0, LengthUnit.FEET), result);
    }
    @Test
    void testAddition_ExplicitTargetUnit_Inches() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);
        QuantityLength result = q1.add(q2, LengthUnit.INCHES);
        assertEquals(new QuantityLength(24.0, LengthUnit.INCHES), result);
    }
    @Test
    void testAddition_ExplicitTargetUnit_Yards() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);
        QuantityLength result = q1.add(q2, LengthUnit.YARDS);
        assertEquals(0.6667, result.getValue(), EPSILON);
    }

    @Test
    void testAddition_ExplicitTargetUnit_Centimeters() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.INCHES);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.INCHES);
        QuantityLength result = q1.add(q2, LengthUnit.CENTIMETERS);
        assertEquals(5.08, result.getValue(), EPSILON);
    }
    @Test
    void testAddition_ExplicitTargetUnit_Commutativity() {
        QuantityLength a = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength b = new QuantityLength(12.0, LengthUnit.INCHES);
        assertEquals(a.add(b, LengthUnit.YARDS),b.add(a, LengthUnit.YARDS));
    }
    @Test
    void testAddition_ExplicitTargetUnit_WithZero() {
        QuantityLength q1 = new QuantityLength(5.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(0.0, LengthUnit.INCHES);
        QuantityLength result = q1.add(q2, LengthUnit.YARDS);
        assertEquals(1.6667, result.getValue(), EPSILON);
    }
    @Test
    void testAddition_ExplicitTargetUnit_NegativeValues() {
        QuantityLength q1 = new QuantityLength(5.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(-2.0, LengthUnit.FEET);
        QuantityLength result = q1.add(q2, LengthUnit.INCHES);
        assertEquals(36.0, result.getValue(), EPSILON);
    }
    @Test
    void testAddition_ExplicitTargetUnit_NullTargetUnit() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);
        assertThrows(IllegalArgumentException.class,() -> q1.add(q2, null));
    }
    @Test
    void testAddition_ExplicitTargetUnit_LargeToSmallScale() {
        QuantityLength q1 = new QuantityLength(1000.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(500.0, LengthUnit.FEET);
        QuantityLength result = q1.add(q2, LengthUnit.INCHES);
        assertEquals(18000.0, result.getValue(), EPSILON);
    }
    @Test
    void testAddition_ExplicitTargetUnit_SmallToLargeScale() {
        QuantityLength q1 = new QuantityLength(12.0, LengthUnit.INCHES);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);
        QuantityLength result = q1.add(q2, LengthUnit.YARDS);
        assertEquals(0.6667, result.getValue(), EPSILON);
    }
}