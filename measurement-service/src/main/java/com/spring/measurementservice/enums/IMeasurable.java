package com.spring.measurementservice.enums;

public interface IMeasurable {

    double getConversionFactor();

    String getUnitName();

    double toBaseUnit(double value);

    double fromBaseUnit(double value);

    void validateOperationSupport(String operation);
}