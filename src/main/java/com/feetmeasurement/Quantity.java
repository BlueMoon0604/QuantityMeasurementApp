package com.feetmeasurement;

public class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {

        if (unit == null) {
            throw new IllegalArgumentException();
        }

        if (Double.isNaN(value) || Double.isInfinite(value)) {
            throw new IllegalArgumentException();
        }

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }

    public Quantity<U> convertTo(U targetUnit) {

        double base = unit.convertToBaseUnit(value);

        double converted = targetUnit.convertFromBaseUnit(base);

        double rounded = Math.round(converted * 100.0) / 100.0;

        return new Quantity<>(rounded, targetUnit);
    }

    public Quantity<U> add(Quantity<U> other) {
        return add(other, this.unit);
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit) {

        double base1 = unit.convertToBaseUnit(value);

        double base2 = other.unit.convertToBaseUnit(other.value);

        double sum = base1 + base2;

        double result = targetUnit.convertFromBaseUnit(sum);

        double rounded = Math.round(result * 100.0) / 100.0;

        return new Quantity<>(rounded, targetUnit);
    }

    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        Quantity<?> other = (Quantity<?>) obj;

        if (unit.getClass() != other.unit.getClass()) return false;

        double base1 = unit.convertToBaseUnit(value);

        double base2 = other.unit.convertToBaseUnit(other.value);

        return Double.compare(base1, base2) == 0;
    }

    public int hashCode() {

        double base = unit.convertToBaseUnit(value);

        return Double.hashCode(base);
    }

    public String toString() {

        return "Quantity(" + value + ", " + unit.getUnitName() + ")";
    }
}