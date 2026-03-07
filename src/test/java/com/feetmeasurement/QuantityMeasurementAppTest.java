package com.feetmeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    void oneFeetShouldEqualTwelveInches() {
        QuantityLength feet = new QuantityLength(1, LengthUnit.FEET);
        QuantityLength inches = new QuantityLength(12, LengthUnit.INCHES);
        assertEquals(feet, inches);
    }

    @Test
    void threeFeetShouldEqualOneYard() {
        QuantityLength feet = new QuantityLength(3, LengthUnit.FEET);
        QuantityLength yard = new QuantityLength(1, LengthUnit.YARDS);
        assertEquals(feet, yard);
    }

    @Test
    void additionOfFeetAndInches() {
        QuantityLength feet = new QuantityLength(1, LengthUnit.FEET);
        QuantityLength inches = new QuantityLength(2, LengthUnit.INCHES);

        QuantityLength result = feet.add(inches);

        assertEquals(14, result.convertTo(LengthUnit.INCHES));
    }

    @Test
    void conversionFeetToInches() {
        QuantityLength feet = new QuantityLength(1, LengthUnit.FEET);
        assertEquals(12, feet.convertTo(LengthUnit.INCHES));
    }

    @Test
    void conversionYardToFeet() {
        QuantityLength yard = new QuantityLength(1, LengthUnit.YARDS);
        assertEquals(3, yard.convertTo(LengthUnit.FEET));
    }
}