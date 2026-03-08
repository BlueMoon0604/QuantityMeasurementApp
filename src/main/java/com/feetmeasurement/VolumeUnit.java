package com.feetmeasurement;

public enum VolumeUnit implements IMeasurable {

    MILLILITRE(1.0, "Millilitre"),
    LITRE(1000.0, "Litre"),
    GALLON(3785.41, "Gallon");

    private final double conversionFactor;
    private final String unitName;

    VolumeUnit(double conversionFactor, String unitName) {
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