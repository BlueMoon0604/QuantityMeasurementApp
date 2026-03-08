package com.feetmeasurement;

public enum LengthUnit implements IMeasurable {

    INCH(1.0, "Inch"),
    FEET(12.0, "Feet"),
    YARD(36.0, "Yard"),
    CENTIMETER(0.393701, "Centimeter");

    private final double conversionFactor;
    private final String unitName;

    LengthUnit(double conversionFactor, String unitName) {
        this.conversionFactor = conversionFactor;
        this.unitName = unitName;
    }

    @Override
    public double getConversionFactor() {
        return conversionFactor;
    }

    @Override
    public String getUnitName() {
        return unitName;
    }
}