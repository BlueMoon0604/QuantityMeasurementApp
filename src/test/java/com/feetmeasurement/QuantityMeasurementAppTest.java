package com.feetmeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    void testLengthEquality() {

        Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> q2 = new Quantity<>(12.0, LengthUnit.INCHES);

        assertEquals(q1, q2);
    }

    @Test
    void testLengthAddition() {

        Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> q2 = new Quantity<>(12.0, LengthUnit.INCHES);

        Quantity<LengthUnit> result = q1.add(q2, LengthUnit.FEET);

        assertEquals(2.0, result.getValue());
    }

    @Test
    void testWeightEquality() {

        Quantity<WeightUnit> q1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> q2 = new Quantity<>(1000.0, WeightUnit.GRAM);

        assertEquals(q1, q2);
    }

    @Test
    void testWeightAddition() {

        Quantity<WeightUnit> q1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> q2 = new Quantity<>(1000.0, WeightUnit.GRAM);

        Quantity<WeightUnit> result = q1.add(q2, WeightUnit.KILOGRAM);

        assertEquals(2.0, result.getValue());
    }

    @Test
    void testCrossCategoryComparison() {

        Quantity<LengthUnit> l = new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<WeightUnit> w = new Quantity<>(1.0, WeightUnit.KILOGRAM);

        assertNotEquals(l, w);
    }
}