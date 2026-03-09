package com.feetmeasurement;

public class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {
        if (unit == null) throw new IllegalArgumentException("Unit cannot be null");
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }

    // Convert to another unit of same category
    public Quantity<U> convertTo(U targetUnit) {
        if (!unit.getClass().equals(targetUnit.getClass()))
            throw new IllegalArgumentException("Cannot convert between different categories");
        double baseValue = unit.convertToBaseUnit(value);
        double convertedValue = targetUnit.convertFromBaseUnit(baseValue);
        return new Quantity<>(convertedValue, targetUnit);
    }

    public Quantity<U> add(Quantity<U> other) {

        if (other == null)
            throw new IllegalArgumentException("Cannot add null");

        if (!unit.supportsArithmetic())
            throw new UnsupportedOperationException("Addition not supported for this unit");

        double base1 = unit.convertToBaseUnit(value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        double sumBase = base1 + base2;

        double result = unit.convertFromBaseUnit(sumBase);

        return new Quantity<>(result, unit);
    }
    public Quantity<U> subtract(Quantity<U> other) {
        validateArithmetic(other, "subtraction");
        double diff = unit.convertToBaseUnit(value) - other.unit.convertToBaseUnit(other.value);
        return new Quantity<>(unit.convertFromBaseUnit(diff), unit);
    }

    public Quantity<U> divide(Quantity<U> other) {
        if (other == null)
            throw new IllegalArgumentException("Cannot divide by null");

        if (!unit.supportsArithmetic())
            throw new UnsupportedOperationException("Division not supported");

        if (other.getValue() == 0)
            throw new ArithmeticException("Division by zero");

        double base1 = unit.convertToBaseUnit(value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        double resultBase = base1 / base2;

        double result = unit.convertFromBaseUnit(resultBase);

        return new Quantity<>(result, unit);
    }
    private void validateArithmetic(Quantity<U> other, String operation) {
        if (other == null) throw new IllegalArgumentException("Operand cannot be null");
        if (!unit.getClass().equals(other.unit.getClass()))
            throw new IllegalArgumentException("Cannot operate across different categories");
        unit.validateOperationSupport(operation);
        other.unit.validateOperationSupport(operation);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Quantity)) return false;

        Quantity<?> other = (Quantity<?>) obj;
        if (!unit.getClass().equals(other.unit.getClass())) return false;

        double thisBase = unit.convertToBaseUnit(value);
        double otherBase = other.unit.convertToBaseUnit(other.getValue());
        return Math.abs(thisBase - otherBase) < 0.0001; // epsilon
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", value, unit.getUnitName());
    }
}