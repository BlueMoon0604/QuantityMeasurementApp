package com.feetmeasurement;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        Quantity<LengthUnit> length1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> length2 = new Quantity<>(12.0, LengthUnit.INCH);

        System.out.println(length1.equals(length2));

        Quantity<LengthUnit> converted = length1.convertTo(LengthUnit.INCH);
        System.out.println(converted.getValue() + " " + converted.getUnit());

        Quantity<LengthUnit> added = length1.add(length2);
        System.out.println(added.getValue() + " " + added.getUnit());

        Quantity<LengthUnit> subtracted = length1.subtract(length2);
        System.out.println(subtracted.getValue() + " " + subtracted.getUnit());

        double division = length1.divide(new Quantity<>(6.0, LengthUnit.INCH));
        System.out.println(division);

        Quantity<WeightUnit> weight1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> weight2 = new Quantity<>(1000.0, WeightUnit.GRAM);

        System.out.println(weight1.equals(weight2));

        Quantity<WeightUnit> weightAdded = weight1.add(weight2);
        System.out.println(weightAdded.getValue() + " " + weightAdded.getUnit());

        Quantity<VolumeUnit> volume1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> volume2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        System.out.println(volume1.equals(volume2));

        Quantity<VolumeUnit> volumeAdded = volume1.add(volume2);
        System.out.println(volumeAdded.getValue() + " " + volumeAdded.getUnit());

        Quantity<VolumeUnit> gallon = new Quantity<>(1.0, VolumeUnit.GALLON);
        Quantity<VolumeUnit> litre = gallon.convertTo(VolumeUnit.LITRE);

        System.out.println(litre.getValue() + " " + litre.getUnit());
    }
}