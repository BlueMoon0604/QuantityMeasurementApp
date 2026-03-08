package com.feetmeasurement;

public enum VolumeUnit implements IMeasurable {

    LITRE(1.0, "Litre"),
    MILLILITRE(0.001, "Millilitre"),
    GALLON(3.78541, "Gallon");

    private final double factor;
    private final String name;

    VolumeUnit(double factor, String name) {
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