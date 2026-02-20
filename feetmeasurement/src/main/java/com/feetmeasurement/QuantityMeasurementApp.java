package com.feetmeasurement;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength q2 = new QuantityLength(3.0, LengthUnit.FEET);
        System.out.println(q1.equals(q2));
        QuantityLength q3 = new QuantityLength(1.0, LengthUnit.CENTIMETERS);
        QuantityLength q4 =new QuantityLength(0.393701, LengthUnit.INCHES);
        System.out.println(q3.equals(q4));

    }
}