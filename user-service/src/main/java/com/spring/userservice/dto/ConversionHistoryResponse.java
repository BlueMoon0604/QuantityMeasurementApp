package com.spring.userservice.dto;

import java.time.LocalDateTime;

public class ConversionHistoryResponse {

    private Long id;
    private Long userId;
    private String type;
    private String fromUnit;
    private String toUnit;
    private double inputValue;
    private double outputValue;
    private LocalDateTime timestamp;

    public ConversionHistoryResponse() {
    }

    public ConversionHistoryResponse(Long id, Long userId, String type, String fromUnit, String toUnit,
                                     double inputValue, double outputValue, LocalDateTime timestamp) {
        this.id = id;
        this.userId = userId;
        this.type = type;
        this.fromUnit = fromUnit;
        this.toUnit = toUnit;
        this.inputValue = inputValue;
        this.outputValue = outputValue;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
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

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}