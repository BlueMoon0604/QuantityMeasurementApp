package com.feetmeasurement;

public enum VolumeUnit implements IMeasurable {
    MILLILITRE(1.0, "Millilitre"),
    LITRE(1000.0, "Litre"),
    GALLON(3785.41, "Gallon");

    private final double factor;
    private final String name;

    VolumeUnit(double factor, String name) {
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