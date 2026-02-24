package com.feetmeasurement;

public enum LengthUnit {
    INCHES(1.0),
    FEET(12.0),
    YARDS(36.0),
    CENTIMETERS(0.393701);

    private final double factor;
    LengthUnit(double factor) {
        this.factor = factor;
    }
    public double toBase(double value) {
        return value * factor;
    }
    public double fromBase(double baseValue) {
        return baseValue / factor;
    }
    public double getFactor() {
        return factor;
    }
}