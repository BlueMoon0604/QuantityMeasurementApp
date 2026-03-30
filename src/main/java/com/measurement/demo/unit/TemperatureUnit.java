package com.measurement.demo.unit;

public enum TemperatureUnit implements IMeasurable {

    CELSIUS,
    FAHRENHEIT,
    KELVIN;

    @Override
    public double getConversionFactor() {
        return 1.0;
    }

    @Override
    public String getUnitName() {
        return name();
    }

    @Override
    public double toBaseUnit(double value) {
        return switch (this) {
            case CELSIUS -> value;
            case FAHRENHEIT -> (value - 32) * 5 / 9;
            case KELVIN -> value - 273.15;
        };
    }

    @Override
    public double fromBaseUnit(double value) {
        return switch (this) {
            case CELSIUS -> value;
            case FAHRENHEIT -> (value * 9 / 5) + 32;
            case KELVIN -> value + 273.15;
        };
    }

    @Override
    public void validateOperationSupport(String operation) {
        if (!operation.equalsIgnoreCase("CONVERT") &&
            !operation.equalsIgnoreCase("COMPARE")) {
            throw new UnsupportedOperationException(
                    "Temperature supports only CONVERT and COMPARE operations"
            );
        }
    }
}