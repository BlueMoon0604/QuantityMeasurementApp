package com.feetmeasurement;

public class QuantityMeasurementApp {
    public static void main(String[] args) {
        Quantity<LengthUnit> length1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> length2 = new Quantity<>(12.0, LengthUnit.INCH);
        System.out.println("length1 == length2? " + length1.equals(length2));
        System.out.println("Converted: " + length1.convertTo(LengthUnit.INCH));
        System.out.println("Addition: " + length1.add(length2));
        System.out.println("Subtraction: " + length1.subtract(length2));
        System.out.println("Division: " + length1.divide(new Quantity<>(6.0, LengthUnit.INCH)));

        Quantity<WeightUnit> weight1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> weight2 = new Quantity<>(1000.0, WeightUnit.GRAM);
        System.out.println("weight1 == weight2? " + weight1.equals(weight2));
        System.out.println("Weight Addition: " + weight1.add(weight2));

        Quantity<VolumeUnit> volume1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> volume2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        System.out.println("volume1 == volume2? " + volume1.equals(volume2));
        System.out.println("Volume Addition: " + volume1.add(volume2));

        Quantity<VolumeUnit> gallon = new Quantity<>(1.0, VolumeUnit.GALLON);
        System.out.println("1 Gallon in Litres: " + gallon.convertTo(VolumeUnit.LITRE));

        // Temperature examples
        Quantity<TemperatureUnit> tempC = new Quantity<>(0.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> tempF = new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT);
        System.out.println("0°C == 32°F? " + tempC.equals(tempF));

        try {
            tempC.add(new Quantity<>(10.0, TemperatureUnit.CELSIUS));
        } catch (UnsupportedOperationException e) {
            System.out.println("Addition on temperature: " + e.getMessage());
        }
    }
}