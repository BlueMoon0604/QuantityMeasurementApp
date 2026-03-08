package com.feetmeasurement;

public enum LengthUnit implements IMeasurable {

    INCH(0.0254, "Inch"),
    FOOT(0.3048, "Foot"),
    YARD(0.9144, "Yard"),
    CENTIMETER(0.01, "Centimeter");

    private final double factor;
    private final String name;

    LengthUnit(double factor, String name) {
        this.factor = factor;
        this.name = name;
    }

    public double getConversionFactor() {
        return factor;
    }

    public String getUnitName() {
        return name;
    }
}