package com.spring.userservice.dto;


public class ConversionHistoryRequest {

    private String type;
    private String fromUnit;
    private String toUnit;
    private double inputValue;
    private double outputValue;

    public ConversionHistoryRequest() {
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
