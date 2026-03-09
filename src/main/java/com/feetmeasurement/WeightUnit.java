package com.feetmeasurement;

public enum WeightUnit implements IMeasurable {
    GRAM(1.0),
    KILOGRAM(1000.0),
    TONNE(1_000_000.0);

    private final double conversionFactor;

    WeightUnit(double conversionFactor) {
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