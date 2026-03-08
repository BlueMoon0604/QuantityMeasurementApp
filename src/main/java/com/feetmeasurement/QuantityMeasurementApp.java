package com.feetmeasurement;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        System.out.println("------ UC1 : Inch to Inch Equality ------");
        Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.INCH);
        Quantity<LengthUnit> q2 = new Quantity<>(1.0, LengthUnit.INCH);
        System.out.println(q1.equals(q2));

        System.out.println("------ UC2 : Inch to Feet Equality ------");
        Quantity<LengthUnit> q3 = new Quantity<>(12.0, LengthUnit.INCH);
        Quantity<LengthUnit> q4 = new Quantity<>(1.0, LengthUnit.FOOT);
        System.out.println(q3.equals(q4));

        System.out.println("------ UC3 : Feet to Feet Equality ------");
        Quantity<LengthUnit> q5 = new Quantity<>(3.0, LengthUnit.FOOT);
        Quantity<LengthUnit> q6 = new Quantity<>(3.0, LengthUnit.FOOT);
        System.out.println(q5.equals(q6));


        System.out.println("------ UC4 : Feet to Yard Equality ------");
        Quantity<LengthUnit> q7 = new Quantity<>(1.0, LengthUnit.YARD);
        System.out.println(q5.equals(q7));


        System.out.println("------ UC5 : Length Conversion ------");
        Quantity<LengthUnit> q8 = new Quantity<>(1.0, LengthUnit.FOOT);
        System.out.println(q8.convertTo(LengthUnit.INCH));


        System.out.println("------ UC6 : Centimeter Conversion ------");
        Quantity<LengthUnit> q9 = new Quantity<>(100.0, LengthUnit.CENTIMETER);
        System.out.println(q9.convertTo(LengthUnit.FOOT));


        System.out.println("------ UC7 : Gram to Gram Equality ------");
        Quantity<WeightUnit> w1 = new Quantity<>(1000.0, WeightUnit.GRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(1000.0, WeightUnit.GRAM);
        System.out.println(w1.equals(w2));


        System.out.println("------ UC8 : Gram to Kilogram Equality ------");
        Quantity<WeightUnit> w3 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        System.out.println(w1.equals(w3));


        System.out.println("------ UC9 : Weight Conversion ------");
        System.out.println(w3.convertTo(WeightUnit.GRAM));


        System.out.println("------ UC10 : Addition Using Generic Quantity ------");
        Quantity<LengthUnit> l1 = new Quantity<>(1.0, LengthUnit.FOOT);
        Quantity<LengthUnit> l2 = new Quantity<>(12.0, LengthUnit.INCH);
        System.out.println(l1.add(l2));


        System.out.println("------ UC11 : Volume Equality ------");
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        System.out.println(v1.equals(v2));

        Quantity<VolumeUnit> v3 = new Quantity<>(1.0, VolumeUnit.GALLON);
        System.out.println(v3.convertTo(VolumeUnit.LITRE));
        System.out.println(v1.add(v2));

    }
}