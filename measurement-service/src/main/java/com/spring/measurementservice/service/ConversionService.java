package com.spring.measurementservice.service;

import com.spring.measurementservice.dto.ConversionRequest;
import com.spring.measurementservice.dto.ConversionResponse;
import org.springframework.stereotype.Service;

@Service
public class ConversionService {

    public ConversionResponse convert(ConversionRequest request) {

        String type = request.getType().toLowerCase();
        String from = request.getFromUnit().toLowerCase();
        String to = request.getToUnit().toLowerCase();
        double value = request.getValue();

        double result;

        switch (type) {
            case "length":
                result = convertLength(from, to, value);
                break;
            case "weight":
                result = convertWeight(from, to, value);
                break;
            case "temperature":
                result = convertTemperature(from, to, value);
                break;
            case "volume":
                result = convertVolume(from, to, value);
                break;
            default:
                throw new RuntimeException("Invalid measurement type");
        }

        return new ConversionResponse(type, from, to, value, result);
    }

    private double convertLength(String from, String to, double value) {
        double metres;

        switch (from) {
            case "metre":
            case "metres":
            case "m":
                metres = value;
                break;
            case "centimetre":
            case "centimetres":
            case "cm":
                metres = value / 100;
                break;
            case "kilometre":
            case "kilometres":
            case "km":
                metres = value * 1000;
                break;
            case "inch":
            case "inches":
                metres = value * 0.0254;
                break;
            case "foot":
            case "feet":
            case "ft":
                metres = value * 0.3048;
                break;
            default:
                throw new RuntimeException("Invalid fromUnit for length");
        }

        switch (to) {
            case "metre":
            case "metres":
            case "m":
                return metres;
            case "centimetre":
            case "centimetres":
            case "cm":
                return metres * 100;
            case "kilometre":
            case "kilometres":
            case "km":
                return metres / 1000;
            case "inch":
            case "inches":
                return metres / 0.0254;
            case "foot":
            case "feet":
            case "ft":
                return metres / 0.3048;
            default:
                throw new RuntimeException("Invalid toUnit for length");
        }
    }

    private double convertWeight(String from, String to, double value) {
        double grams;

        switch (from) {
            case "gram":
            case "grams":
            case "g":
                grams = value;
                break;
            case "kilogram":
            case "kilograms":
            case "kg":
                grams = value * 1000;
                break;
            case "tonne":
            case "tonnes":
                grams = value * 1000000;
                break;
            default:
                throw new RuntimeException("Invalid fromUnit for weight");
        }

        switch (to) {
            case "gram":
            case "grams":
            case "g":
                return grams;
            case "kilogram":
            case "kilograms":
            case "kg":
                return grams / 1000;
            case "tonne":
            case "tonnes":
                return grams / 1000000;
            default:
                throw new RuntimeException("Invalid toUnit for weight");
        }
    }

    private double convertTemperature(String from, String to, double value) {
        if (from.equals(to)) {
            return value;
        }

        if ((from.equals("c") || from.equals("celsius")) && (to.equals("f") || to.equals("fahrenheit"))) {
            return (value * 9 / 5) + 32;
        }

        if ((from.equals("f") || from.equals("fahrenheit")) && (to.equals("c") || to.equals("celsius"))) {
            return (value - 32) * 5 / 9;
        }

        if ((from.equals("c") || from.equals("celsius")) && (to.equals("k") || to.equals("kelvin"))) {
            return value + 273.15;
        }

        if ((from.equals("k") || from.equals("kelvin")) && (to.equals("c") || to.equals("celsius"))) {
            return value - 273.15;
        }

        if ((from.equals("f") || from.equals("fahrenheit")) && (to.equals("k") || to.equals("kelvin"))) {
            return (value - 32) * 5 / 9 + 273.15;
        }

        if ((from.equals("k") || from.equals("kelvin")) && (to.equals("f") || to.equals("fahrenheit"))) {
            return (value - 273.15) * 9 / 5 + 32;
        }

        throw new RuntimeException("Invalid temperature conversion");
    }

    private double convertVolume(String from, String to, double value) {
        double litres;

        switch (from) {
            case "litre":
            case "litres":
            case "l":
                litres = value;
                break;
            case "millilitre":
            case "millilitres":
            case "ml":
                litres = value / 1000;
                break;
            case "gallon":
            case "gallons":
                litres = value * 3.78541;
                break;
            default:
                throw new RuntimeException("Invalid fromUnit for volume");
        }

        switch (to) {
            case "litre":
            case "litres":
            case "l":
                return litres;
            case "millilitre":
            case "millilitres":
            case "ml":
                return litres * 1000;
            case "gallon":
            case "gallons":
                return litres / 3.78541;
            default:
                throw new RuntimeException("Invalid toUnit for volume");
        }
    }
}