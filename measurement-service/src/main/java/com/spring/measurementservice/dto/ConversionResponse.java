package com.spring.measurementservice.dto;

public class ConversionResponse {

    private String type;
    private String fromUnit;
    private String toUnit;
    private double inputValue;
    private double outputValue;

    public ConversionResponse() {
    }

    public ConversionResponse(String type, String fromUnit, String toUnit, double inputValue, double outputValue) {
        this.type = type;
        this.fromUnit = fromUnit;
        this.toUnit = toUnit;
        this.inputValue = inputValue;
        this.outputValue = outputValue;
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

    public double getInputValue() {
        return inputValue;
    }

    public double getOutputValue() {
        return outputValue;
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

    public void setInputValue(double inputValue) {
        this.inputValue = inputValue;
    }

    public void setOutputValue(double outputValue) {
        this.outputValue = outputValue;
    }
}