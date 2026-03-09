package com.feetmeasurement;

public interface IMeasurable {

    double getConversionFactor();

    default double convertToBaseUnit(double value) {
        return value * getConversionFactor();
    }

    default double convertFromBaseUnit(double baseValue) {
        return baseValue / getConversionFactor();
    }

    String getUnitName();

    default void validateOperationSupport(String operation) {
        // Default: all units support arithmetic
    }

    default boolean supportsArithmetic() {
        return true;
    }
}