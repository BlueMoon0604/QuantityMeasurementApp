package com.feetmeasurement;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);

        QuantityLength result1 = q1.add(q2);
        System.out.println(result1);  // Quantity(2.0, FEET)

        QuantityLength result2 = q2.add(q1);
        System.out.println(result2);  // Quantity(24.0, INCHES)

        QuantityLength result3 =
                new QuantityLength(1.0, LengthUnit.YARDS)
                        .add(new QuantityLength(3.0, LengthUnit.FEET));

        System.out.println(result3);  // Quantity(2.0, YARDS)

        QuantityLength result4 =
                new QuantityLength(2.54, LengthUnit.CENTIMETERS)
                        .add(new QuantityLength(1.0, LengthUnit.INCHES));

        System.out.println(result4);  // ~5.08 CENTIMETERS
    }
}