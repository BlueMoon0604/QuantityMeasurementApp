package com.feetmeasurement;

public enum WeightUnit implements IMeasurable {

    GRAM(1.0, "Gram"),
    KILOGRAM(1000.0, "Kilogram"),
    TONNE(1000000.0, "Tonne");

    private final double conversionFactor;
    private final String unitName;

    WeightUnit(double conversionFactor, String unitName) {
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