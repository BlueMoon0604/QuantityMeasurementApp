package com.feetmeasurement;

public class Quantity<U extends Enum<U> & IMeasurable> {

    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {
        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");
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
        double baseValue = unit.convertToBaseUnit(value);
        double converted = targetUnit.convertFromBaseUnit(baseValue);
        return new Quantity<>(converted, targetUnit);
    }

    public Quantity<U> add(Quantity<U> other) {
        if (other == null)
            throw new IllegalArgumentException();

        double base1 = unit.convertToBaseUnit(value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        double sumBase = base1 + base2;
        double result = unit.convertFromBaseUnit(sumBase);

        return new Quantity<>(result, unit);
    }

    public Quantity<U> subtract(Quantity<U> other) {
        if (other == null)
            throw new IllegalArgumentException();

        double base1 = unit.convertToBaseUnit(value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        double diffBase = base1 - base2;
        double result = unit.convertFromBaseUnit(diffBase);

        return new Quantity<>(result, unit);
    }

    public double divide(Quantity<U> other) {
        if (other == null)
            throw new IllegalArgumentException();

        double base1 = unit.convertToBaseUnit(value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        if (base2 == 0)
            throw new ArithmeticException();

        return base1 / base2;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Quantity<?> other)) return false;

        try {
            double base1 = unit.convertToBaseUnit(value);
            double base2 = ((IMeasurable) other.unit).convertToBaseUnit(other.value);
            return Math.abs(base1 - base2) < 0.0001;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Double.hashCode(unit.convertToBaseUnit(value));
    }
}