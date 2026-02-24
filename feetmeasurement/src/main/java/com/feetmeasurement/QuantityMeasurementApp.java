package com.feetmeasurement;

public class QuantityMeasurementApp {
    public static void main(String[] args) {
        double result = QuantityLength.convert(1.0,LengthUnit.FEET,LengthUnit.INCHES);
        System.out.println(result);
        QuantityLength length = new QuantityLength(3, LengthUnit.YARDS);
        QuantityLength inches = length.convertTo(LengthUnit.INCHES);
        System.out.println(inches);

    }
}