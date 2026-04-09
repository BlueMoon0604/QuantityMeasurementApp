package com.spring.measurementservice.dto;

public class ConversionRequest {

    private String type;
    private String fromUnit;
    private String toUnit;
    private double value;

    public ConversionRequest() {
    }

    public String getType() {
        return type;
    }

    public String getFromUnit() {
        return fromUnit;
    }

    public String getToUnit() {
        return toUnit;
    }

    public double getValue() {
        return value;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setFromUnit(String fromUnit) {
        this.fromUnit = fromUnit;
    }

    public void setToUnit(String toUnit) {
        this.toUnit = toUnit;
    }

    public void setValue(double value) {
        this.value = value;
    }
}