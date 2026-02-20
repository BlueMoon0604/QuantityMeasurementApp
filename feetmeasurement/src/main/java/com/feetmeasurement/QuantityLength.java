package com.feetmeasurement;

public class QuantityLength {

    private final double value;
    private final LengthUnit unit;
    public QuantityLength(double value, LengthUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        this.value = value;
        this.unit = unit;
    }
    private double toInches() {
        return unit.toInches(value);
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
        return Double.compare(this.toInches(), other.toInches()) == 0;
    }
}
