package com.feetmeasurement;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        QuantityLength q1 = new QuantityLength(1, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12, LengthUnit.INCHES);
        System.out.println(q1.equals(q2));

        QuantityLength q3 = new QuantityLength(3, LengthUnit.FEET);
        QuantityLength q4 = new QuantityLength(1, LengthUnit.YARDS);
        System.out.println(q3.equals(q4));

        QuantityLength q5 = new QuantityLength(1, LengthUnit.FEET);
        QuantityLength q6 = new QuantityLength(2, LengthUnit.INCHES);
        QuantityLength result = q5.add(q6);
        System.out.println(result.convertTo(LengthUnit.INCHES));
    }
}