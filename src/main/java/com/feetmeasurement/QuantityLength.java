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

    /**
     * Adds another QuantityLength.
     * Result is returned in the unit of the first operand.
     */
    public QuantityLength add(QuantityLength other) {

        if (other == null) {
            throw new IllegalArgumentException("Second operand cannot be null");
        }

        // Convert both to base unit (FEET)
        double base1 = this.unit.toBaseUnit(this.value);
        double base2 = other.unit.toBaseUnit(other.value);

        // Add
        double baseSum = base1 + base2;

        // Convert back to unit of first operand
        double resultValue = this.unit.fromBaseUnit(baseSum);

        return new QuantityLength(resultValue, this.unit);
    }

    /**
     * Static overloaded add method
     */
    public static QuantityLength add(
            double value1, LengthUnit unit1,
            double value2, LengthUnit unit2) {

        return new QuantityLength(value1, unit1)
                .add(new QuantityLength(value2, unit2));
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (!(obj instanceof QuantityLength)) return false;

        QuantityLength other = (QuantityLength) obj;

        // Compare using base unit for accuracy
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