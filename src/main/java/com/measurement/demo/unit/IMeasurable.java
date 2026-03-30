package com.measurement.demo.unit;

public interface IMeasurable {

    double getConversionFactor();

    String getUnitName();

    double toBaseUnit(double value);

    double fromBaseUnit(double value);

    void validateOperationSupport(String operation);
}