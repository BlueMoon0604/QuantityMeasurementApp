package com.feetmeasurement;

public class QuantityLength {

    private final double value;
    private final LengthUnit unit;

    public QuantityLength(double value, LengthUnit unit) {
        this.value = value;
        this.unit = unit;
    }
    public double convertTo(LengthUnit targetUnit) {
        double base = unit.toBase(value);
        return targetUnit.fromBase(base);
    }
    public QuantityLength add(QuantityLength other) {
        double base1 = unit.toBase(value);
        double base2 = other.unit.toBase(other.value);
        double sum = base1 + base2;
        double result = unit.fromBase(sum);
        return new QuantityLength(result, unit);
    }
    public double getValue() {
        return value;
    }
    public LengthUnit getUnit() {
        return unit;
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
        double base1 = unit.toBase(value);
        double base2 = other.unit.toBase(other.value);
        return Double.compare(base1, base2) == 0;
    }

    @Override
    public int hashCode() {
        double base = unit.toBase(value);
        return Double.hashCode(base);
    }
}