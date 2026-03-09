package com.feetmeasurement;

public enum LengthUnit implements IMeasurable {
    INCH(1.0, "Inch"),
    FEET(12.0, "Feet"),
    YARD(36.0, "Yard"),
    CENTIMETER(0.393701, "Centimeter");

    private final double factor;
    private final String name;

    LengthUnit(double factor, String name) {
        this.factor = factor;
        this.name = name;
    }

    @Override
    public double getConversionFactor() {
        return factor;
    }

    @Override
    public String getUnitName() {
        return name;
    }
}