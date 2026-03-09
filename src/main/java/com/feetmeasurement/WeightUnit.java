package com.feetmeasurement;

public enum WeightUnit implements IMeasurable {
    GRAM(1.0, "Gram"),
    KILOGRAM(1000.0, "Kilogram"),
    TONNE(1000000.0, "Tonne");

    private final double factor;
    private final String name;

    WeightUnit(double factor, String name) {
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