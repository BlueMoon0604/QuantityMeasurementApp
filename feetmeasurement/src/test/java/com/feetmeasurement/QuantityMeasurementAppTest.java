package com.feetmeasurement;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    private final double EPSILON = 0.000001;


    @Test
    void testConversion_FeetToInches() {

        double result =
                QuantityLength.convert(
                        1,
                        LengthUnit.FEET,
                        LengthUnit.INCHES);

        assertEquals(12.0, result, EPSILON);
    }


    @Test
    void testConversion_InchesToFeet() {

        double result =
                QuantityLength.convert(
                        24,
                        LengthUnit.INCHES,
                        LengthUnit.FEET);

        assertEquals(2.0, result, EPSILON);
    }


    @Test
    void testConversion_YardsToInches() {

        double result =
                QuantityLength.convert(
                        1,
                        LengthUnit.YARDS,
                        LengthUnit.INCHES);

        assertEquals(36.0, result, EPSILON);
    }


    @Test
    void testConversion_InchesToYards() {

        double result =
                QuantityLength.convert(
                        72,
                        LengthUnit.INCHES,
                        LengthUnit.YARDS);

        assertEquals(2.0, result, EPSILON);
    }


    @Test
    void testConversion_CMToInches() {

        double result =
                QuantityLength.convert(
                        2.54,
                        LengthUnit.CENTIMETERS,
                        LengthUnit.INCHES);

        assertEquals(1.0, result, 0.01);
    }


    @Test
    void testConversion_FeetToYards() {

        double result =
                QuantityLength.convert(
                        6,
                        LengthUnit.FEET,
                        LengthUnit.YARDS);

        assertEquals(2.0, result, EPSILON);
    }


    @Test
    void testConversion_RoundTrip() {

        double original = 5;

        double converted =
                QuantityLength.convert(
                        original,
                        LengthUnit.FEET,
                        LengthUnit.INCHES);

        double back =
                QuantityLength.convert(
                        converted,
                        LengthUnit.INCHES,
                        LengthUnit.FEET);

        assertEquals(original, back, EPSILON);
    }


    @Test
    void testConversion_Zero() {

        double result =
                QuantityLength.convert(
                        0,
                        LengthUnit.FEET,
                        LengthUnit.INCHES);

        assertEquals(0, result);
    }


    @Test
    void testConversion_Negative() {

        double result =
                QuantityLength.convert(
                        -1,
                        LengthUnit.FEET,
                        LengthUnit.INCHES);

        assertEquals(-12, result);
    }


    @Test
    void testConversion_InvalidUnit() {

        assertThrows(
                IllegalArgumentException.class,
                () -> QuantityLength.convert(
                        1,
                        null,
                        LengthUnit.FEET));
    }


    @Test
    void testConversion_InvalidValue() {

        assertThrows(
                IllegalArgumentException.class,
                () -> QuantityLength.convert(
                        Double.NaN,
                        LengthUnit.FEET,
                        LengthUnit.INCHES));
    }


    @Test
    void testConversion_SameUnit() {

        double result =
                QuantityLength.convert(
                        5,
                        LengthUnit.FEET,
                        LengthUnit.FEET);

        assertEquals(5, result);
    }

}