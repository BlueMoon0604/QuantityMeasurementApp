package com.feetmeasurement;

public enum LengthUnit implements IMeasurable {
    INCH(1.0),
    FEET(12.0),
    YARD(36.0),
    CENTIMETRE(0.393701);

    private final double conversionFactor;

    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    @Override
    public double getConversionFactor() {
        return conversionFactor;
    }

    @Override
    public String getUnitName() {
        return this.name();
    }
}