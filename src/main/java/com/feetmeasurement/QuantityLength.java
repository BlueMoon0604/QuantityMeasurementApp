package com.feetmeasurement;

import java.util.Objects;

public final class QuantityLength {

    private final double value;
    private final LengthUnit unit;

    private static final double EPSILON = 0.0001;

    public QuantityLength(double value, LengthUnit unit) {

        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Value must be finite");
        }
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    // UC6 – result in unit of first operand
    public QuantityLength add(QuantityLength other) {
        return add(other, this.unit);
    }

    // UC7 – explicit target unit
    public QuantityLength add(QuantityLength other, LengthUnit targetUnit) {

        if (other == null) {
            throw new IllegalArgumentException("Second operand cannot be null");
        }

        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }
        double result = addInternal(this, other, targetUnit);
        return new QuantityLength(result, targetUnit);
    }
    private static double addInternal(
            QuantityLength q1,
            QuantityLength q2,
            LengthUnit targetUnit) {

        double base1 = q1.unit.toBaseUnit(q1.value);
        double base2 = q2.unit.toBaseUnit(q2.value);
        double baseSum = base1 + base2;
        return targetUnit.fromBaseUnit(baseSum);
    }
    @Override
    public boolean equals(Object obj) {

        if (this == obj) { 
        	return true;
        }

        if (!(obj instanceof QuantityLength)) {
        	return false;
        }
        QuantityLength other = (QuantityLength) obj;
        double base1 = this.unit.toBaseUnit(this.value);
        double base2 = other.unit.toBaseUnit(other.value);
        return Math.abs(base1 - base2) < EPSILON;
    }
    @Override
    public int hashCode() {
        return Objects.hash(unit.toBaseUnit(value));
    }
    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
}