package com.feetmeasurement;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        QuantityLength l1 = new QuantityLength(1, LengthUnit.FEET);
        QuantityLength l2 = new QuantityLength(12, LengthUnit.INCHES);
        System.out.println(l1.equals(l2));

        QuantityLength l3 = new QuantityLength(1, LengthUnit.FEET);
        QuantityLength l4 = new QuantityLength(2, LengthUnit.INCHES);
        
        QuantityLength lengthSum = l3.add(l4);
        System.out.println(lengthSum.convertTo(LengthUnit.INCHES));

        QuantityWeight w1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight w2 = new QuantityWeight(1000.0, WeightUnit.GRAM);
        System.out.println(w1.equals(w2));

        QuantityWeight w3 = new QuantityWeight(2.0, WeightUnit.POUND);
        System.out.println(w3.convertTo(WeightUnit.KILOGRAM));

        QuantityWeight weightSum = w1.add(w2);
        System.out.println(weightSum);

        QuantityWeight weightSum2 = w1.add(w2, WeightUnit.GRAM);
        System.out.println(weightSum2);
    }
}