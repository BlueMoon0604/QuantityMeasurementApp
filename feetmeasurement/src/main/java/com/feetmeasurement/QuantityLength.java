package com.feetmeasurement;

public class QuantityLength {
    private final double value;
    private final LengthUnit unit;
    public QuantityLength(double value, LengthUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid value");
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
    private double toBase() {
        return unit.toBase(value);
    }
    public static double convert(double value,LengthUnit source, LengthUnit target) {
        if (source == null || target == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid value");
        }
        double base = source.toBase(value);
        return target.fromBase(base);
    }
    public QuantityLength convertTo(LengthUnit target) {
        double converted = convert(this.value, this.unit, target);
        return new QuantityLength(converted, target);
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
        return Double.compare(this.toBase(),other.toBase()) == 0;
    }
    public String toString() {
        return value + " " + unit;
    }

}