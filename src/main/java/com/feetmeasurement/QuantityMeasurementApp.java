package com.feetmeasurement;

public class QuantityMeasurementApp {
    public static void main(String[] args) {

        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);

        System.out.println(q1.add(q2, LengthUnit.FEET));
        System.out.println(q1.add(q2, LengthUnit.INCHES));
        System.out.println(q1.add(q2, LengthUnit.YARDS));

        QuantityLength q3 = new QuantityLength(5.0, LengthUnit.FEET);
        QuantityLength q4 = new QuantityLength(-2.0, LengthUnit.FEET);

        System.out.println(q3.add(q4, LengthUnit.INCHES));
    }
}