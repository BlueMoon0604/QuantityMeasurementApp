package com.feetmeasurement;

public class QuantityWeight {

    private final double value;
    private final WeightUnit unit;
    public QuantityWeight(double value, WeightUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        if (Double.isNaN(value) || Double.isInfinite(value)) {
            throw new IllegalArgumentException("Invalid value");
        }
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public WeightUnit getUnit() {
        return unit;
    }

    public QuantityWeight convertTo(WeightUnit targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }
        double base = unit.convertToBaseUnit(value);
        double converted = targetUnit.convertFromBaseUnit(base);
        return new QuantityWeight(converted, targetUnit);
    }

    public QuantityWeight add(QuantityWeight other) {
        return add(other, this.unit);
    }

    public QuantityWeight add(QuantityWeight other, WeightUnit targetUnit) {
        double base1 = unit.convertToBaseUnit(value);
        double base2 = other.unit.convertToBaseUnit(other.value);
        double sum = base1 + base2;
        double result = targetUnit.convertFromBaseUnit(sum);
        return new QuantityWeight(result, targetUnit);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
        	return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
        	return false;
        }
        QuantityWeight other = (QuantityWeight) obj;

        double base1 = unit.convertToBaseUnit(value);
        double base2 = other.unit.convertToBaseUnit(other.value);
        return Math.abs(base1 - base2) < 1e-6;
    }
    @Override
    public int hashCode() {
        double base = unit.convertToBaseUnit(value);
        return Double.hashCode(base);
    }
    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
}