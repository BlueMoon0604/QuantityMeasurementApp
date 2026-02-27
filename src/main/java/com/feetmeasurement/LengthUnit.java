package com.feetmeasurement;

public enum LengthUnit {

    FEET(1.0),
    INCHES(1.0 / 12.0),
    YARDS(3.0),
    CENTIMETERS(0.0328084); // 1 cm = 0.0328084 feet

    private final double conversionFactorToFeet;

    LengthUnit(double conversionFactorToFeet) {
        this.conversionFactorToFeet = conversionFactorToFeet;
    }

    // Convert given value to base unit (FEET)
    public double toBaseUnit(double value) {
        return value * conversionFactorToFeet;
    }

    // Convert base unit (FEET) value to this unit
    public double fromBaseUnit(double baseValue) {
        return baseValue / conversionFactorToFeet;
    }
}